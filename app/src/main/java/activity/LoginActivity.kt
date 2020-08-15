package activity

import Interfaces.Apicall
import Interfaces.OnResponse
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity

import com.social.ekchat.Interfaces.UniverSelObjct
import kotlinx.android.synthetic.main.login_activity.*
import android.view.View
import android.view.WindowManager
import com.google.gson.Gson

import android.util.Log
import com.kodpartner.DashboardActivity
import com.kodpartner.R
import model.LoginData
import utils.AppSignatureHelper
import utils.CustomDialogue
import utils.LocalStorage
import utils.SessionManager

class LoginActivity : AppCompatActivity() , OnResponse<UniverSelObjct> {
    override fun onSucess(response: UniverSelObjct?) {

        try {
            if (response!!.status == "1") {
                when (response.methodname) {

                    "login" -> {
                        val SubmitData = response.response as LoginData
                        //if(SubmitData.status.equals("1")){
                            val gson = Gson()
                            val dada = gson.toJson(SubmitData)
                            LocalStorage.setCustomerID(this,SubmitData.data.user.refrenceid.toString())
                            LocalStorage.setCustomerEmailID(this,SubmitData.data.user.email.toString())
                            LocalStorage.setFirmName(this,SubmitData.data.user.username.toString())
                            Log.e("userid","resID:"+ SubmitData.data.user.refrenceid.toString())
                            SessionManager.getInstance(this).setSharedPreferences(dada,getString(R.string.LoginData_key))

                            ll_login.visibility = View.GONE
                            ll_otp.visibility = View.VISIBLE
                            startTimer()

                       // }else if(SubmitData.status.equals("2")){
                            //startActivity(Intent(this,RegisterActivity::class.java).putExtra("phone",edt_phone.text.toString()))
                        //}
                    }
                }
            }else if(response.status.equals("2")){
                CustomDialogue.showcustomblank(this, "Alert", response.msg)
               /// startActivity(Intent(this,RegisterActivity::class.java).putExtra("phone",edt_phone.text.toString()))
            }else{
                CustomDialogue.showcustomblank(this, "Alert", response.msg)
            }
        }catch (e: Exception) {
            e.printStackTrace()
        }}

    override fun onError(error: String?) {
        CustomDialogue.showcustomblank(this, "Alert", error.toString())
    }
    private var cTimer: CountDownTimer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)


    //    getAppSignatures()

//        OTPManager.OTPManagerBuilder(this).setListener(object : OTPBroadcastReceiver.OTPReceiverListener {
//
//            override fun onOTPReceived(message: String) {
//                Toast.makeText(this@LoginActivity,message,Toast.LENGTH_LONG).show()
//            }
//
//            override fun onOTPTimeout() {
//
//            }
//        }).build().start()


        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.parseColor("#F4436C")
        }

        if(intent.hasExtra("from")){
            if(intent.getStringExtra("from").equals("RegisterActivity")){
                edt_phone.setText(intent.getStringExtra("phone"))
                ll_login.visibility = View.GONE
                ll_otp.visibility = View.VISIBLE
                startTimer()
            }
        }

        btn_submit.setOnClickListener{
            if(edt_phone.text.toString().length != 10){
                CustomDialogue.showcustomblank(this, "Alert", "Please Enter Right Mobile Number!")
            }else{
                Apicall(this).getLoginData(this,"login",edt_phone.text.toString())
            }
        }

        text_send_otp.setOnClickListener {
            if(text_send_otp.text.equals("Resend")){
                Apicall(this).getLoginData(this,"login",edt_phone.text.toString())
            }

        }

        btn_otp_resend.setOnClickListener {
            Apicall(this).getLoginData(this,"login",edt_phone.text.toString())
        }

        btn_otp_submit.setOnClickListener{
            if(edt_otp.text.toString().length != 4){
                CustomDialogue.showcustomblank(this, "Alert", "Please Enter Right OTP!")
            }else{
                if(Apicall(this).getLoginData().data.otp.toString().equals(edt_otp.text.toString().trim())){

                    var logindata = Apicall(this).getLoginData()

                    //logindata.data.isverify = "Y"

                    val gson = Gson()
                    val dada = gson.toJson(logindata)
                    SessionManager.getInstance(this).setSharedPreferences(dada,getString(R.string.LoginData_key))

                    startActivity(Intent(this,DashboardActivity::class.java))
                    finishAffinity()
                }else{
                    CustomDialogue.showcustomblank(this, "Alert", "Please Enter Right OTP!")
                }
            }
        }
    }

    private fun startTimer() {

        cTimer = object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                btn_otp_resend.visibility = View.GONE
                btn_otp_submit.visibility = View.VISIBLE
                text_send_otp.setText("It may take about " + millisUntilFinished / 1000 + " secs")
            }

            override fun onFinish() {
                btn_otp_resend.visibility = View.VISIBLE
                btn_otp_submit.visibility = View.GONE
                text_send_otp.setText("")
            }
        }

        (cTimer as CountDownTimer).start()
    }


    private fun getAppSignatures() {
        val appSignatureHelper = AppSignatureHelper(this)
        for (signature in appSignatureHelper.appSignatures) {
            Log.e("APPSignature", signature + "\n")
        }
    }

}