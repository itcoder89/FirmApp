package activity

import Interfaces.Apicall
import Interfaces.OnResponse
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kodpartner.R
import com.social.ekchat.Interfaces.UniverSelObjct
import kotlinx.android.synthetic.main.send_otp_layout.*
import model.SendOTPData
import utils.CustomDialogue

class SendOtp : AppCompatActivity(), OnResponse<UniverSelObjct> {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.send_otp_layout)

        tvSendOtp.setOnClickListener {
            Apicall(this).sendOtp(this,"sendOtp", "8619592540","+91")
        }
    }

    override fun onSucess(response: UniverSelObjct?) {
        try {
            if (response!!.status == "1") {
                when (response.methodname) {
                    "sendOtp" -> {
                        val sendOTPData = response.response as SendOTPData
                        Log.e("sendOtp"," "+sendOTPData.message+"")

                    }

                }

            }
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    override fun onError(error: String?) {
        CustomDialogue.showcustomblank(this, "Alert", error.toString())
    }
}