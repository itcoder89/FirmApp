package activity

import Interfaces.Apicall
import Interfaces.OnResponse
import adapter.WalletRechargeListAdapter
import android.Manifest
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kodpartner.R
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import com.social.ekchat.Interfaces.UniverSelObjct
import kotlinx.android.synthetic.main.comman_top_header.*
import kotlinx.android.synthetic.main.custom_offline_recharge_popup.*
import kotlinx.android.synthetic.main.wallet_recharge_layout.*
import kotlinx.android.synthetic.main.wallet_recharge_layout.edEnterAmount
import model.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import org.json.JSONObject
import pl.aprilapps.easyphotopicker.DefaultCallback
import pl.aprilapps.easyphotopicker.EasyImage
import retrofit.AppGlobal
import utils.CustomDialogue
import utils.LocalStorage
import utils.RetrofitUtils
import java.io.File
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

class WalletRecharge : AppCompatActivity(), PaymentResultListener,View.OnClickListener,
    OnResponse<UniverSelObjct> {

    private var walletRechargeListAdapter: WalletRechargeListAdapter? = null
    private var layoutManager: LinearLayoutManager? = null
    private var recyclerView: RecyclerView? = null
    var rzorid=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wallet_recharge_layout)
        recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView
        /*
         To ensure faster loading of the Checkout form,
          call this method as early as possible in your checkout flow.
         */
        Checkout.preload(applicationContext)

        tvTitle.text="Wallet/Recharge"



        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.layoutManager = layoutManager

 //       AppGlobal.hideKeyboard(this)


        iv_back.setOnClickListener(this)
        btnSubmitRecharge.setOnClickListener(this)
        btnOfflineRecharge.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        Apicall(this)
            .getWalletRechargeSummaryList(this,"partner-wallet-summary",LocalStorage.getCustomerID(this))
    }

    override fun onPaymentError(code: Int, response: String?) {
        try {
            Log.e("onPaymentError", "code:$code response=$response")
            Toast.makeText(this, "Payment failed: $code $response", Toast.LENGTH_SHORT)
                .show()
        } catch (e: java.lang.Exception) {
            Log.e("TAG","Exception in onPaymentError",e)
        }
    }

    override fun onPaymentSuccess(razorpayPaymentID: String?) {
        try {
            Log.e("onPaymentSuccess", ":$razorpayPaymentID")
            rzorid=razorpayPaymentID.toString()
            Toast.makeText(this, "Payment Successful: " + razorpayPaymentID, Toast.LENGTH_SHORT).show();
            callWalletRechargeAPI()
        } catch (e: Exception) {
            Log.e("TAG","Exception in onPaymentSuccess",e)
        }
    }

    private fun callWalletRechargeAPI() {
        val today = Date()
        val format = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
        var currDate = format.format(today)
        println(currDate)
        Log.e("TodayDate", "currDate $currDate")
        Apicall(this)
            .walletRecharge(this,"wallet-recharge-by-partner",
                LocalStorage.getCustomerID(this),"success",edEnterAmount.text.toString().trim(),rzorid,currDate)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_back -> {
                finish()
            }
            R.id.btnOfflineRecharge -> {
                startActivity(Intent(this, OfflineRecharge::class.java))
            }
            R.id.btnSubmitRecharge -> {
                if(edEnterAmount.text.toString().length > 0)
                    startPayment()
                else
                    Toast.makeText(this,"please enter amount",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun startPayment() {
        /*
          You need to pass current activity in order to let Razorpay create CheckoutActivity
         */
        //final Activity activity = this;
        val co = Checkout()
        try {
            val options = JSONObject()
            options.put("name", LocalStorage.getCustomerEmailID(this))
            options.put("description", "payment for wallet recharge")
            //You can omit the image option to fetch the image from dashboard
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png")
            options.put("currency", "INR")
            val b = Math.round(edEnterAmount.text.toString().toFloat() * 100).toInt()
            options.put("amount", b)
            val preFill = JSONObject()
            preFill.put("email", LocalStorage.getCustomerEmailID(this))
            preFill.put("contact", "")
            options.put("prefill", preFill)
            Log.e("OrderPlaceReq", options.toString())
            co.open(this@WalletRecharge, options)
        } catch (e: java.lang.Exception) {
            Log.e("OrderPlaceReq", "error " + e.message)
            showDialoges(e.message)
            e.printStackTrace()
        }

    }

    fun showDialoges(content: String?) {
        val dialog = Dialog(this@WalletRecharge)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.custom_show_msg_popup)
        dialog.setCanceledOnTouchOutside(false)
        val tvtitle = dialog.findViewById<View>(R.id.tvtitle) as TextView
        val tvContent = dialog.findViewById<View>(R.id.tvContent) as TextView
        val tvOK = dialog.findViewById<View>(R.id.tvOK) as TextView
        tvtitle.text = "Message"
        tvContent.text = content
        tvOK.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }

    override fun onSucess(response: UniverSelObjct?) {
        try {
            //if (response!!.status == "true") {
                when (response!!.methodname) {
                    "partner-wallet-summary" -> {
                        val walletRechargeSummaryData = response.response as WalletSummaryListData
                        Log.e("walletRechaSummData","isStatus "+walletRechargeSummaryData.isStatus)
                        if(walletRechargeSummaryData.isStatus == false){
                            AppGlobal.showToast(this,walletRechargeSummaryData.message)
                        }else{
                            val form = DecimalFormat("0.00")
                            tvWalletBalance.text="Wallet Balance \nRs."+AppGlobal.setTwoDecimalValue(walletRechargeSummaryData.data.walletBalance)+""
                            walletRechargeListAdapter = WalletRechargeListAdapter(this)
                            recyclerView!!.adapter = walletRechargeListAdapter
                            recyclerView!!.setHasFixedSize(false)
                            walletRechargeListAdapter!!.addData(walletRechargeSummaryData.data.paymentSummary)
                            walletRechargeListAdapter!!.notifyDataSetChanged()
                        }
                    }
                    "wallet-recharge-by-partner" -> {
                        val rechargeWalletData = response.response as RechargeWalletData
                        Log.e("rechargeWalletData",""+rechargeWalletData.message)
                        Toast.makeText(this,""+rechargeWalletData.message,Toast.LENGTH_SHORT).show()
                        Apicall(this)
                            .getWalletRechargeSummaryList(this,
                                "partner-wallet-summary",
                                LocalStorage.getCustomerID(this))
                    }

                }
            //}
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    override fun onError(error: String?) {
        Log.e("onError","error "+error)
       // CustomDialogue.showcustomblank(this!!, "Alert", error.toString())
    }


   /* fun showOfflineRechargeDialoge(cxt: Context) {
        val dialog = Dialog(cxt)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.custom_offline_recharge_popup)
        dialog.setCanceledOnTouchOutside(false)
        val edEnterReceiptNo = dialog.findViewById<View>(R.id.edEnterReceiptNo) as EditText
        val et_other_info = dialog.findViewById<View>(R.id.et_other_info) as EditText
        val edEnterCheckNo = dialog.findViewById<View>(R.id.edEnterCheckNo) as EditText
        val edEnterTransactionNo = dialog.findViewById<View>(R.id.edEnterTransactionNo) as EditText
        val edEnterAmount = dialog.findViewById<View>(R.id.edEnterAmount) as EditText
        val edEnterCheckBankName = dialog.findViewById<View>(R.id.edEnterCheckBankName) as EditText

        val tvSetChequeDate = dialog.findViewById<View>(R.id.tvSetChequeDate) as TextView
        val tvNo = dialog.findViewById<View>(R.id.tvNo) as TextView
        val tvYesCancel =  dialog.findViewById<View>(R.id.tvYesCancel) as TextView
        val spinner =  dialog.findViewById<View>(R.id.spinner) as Spinner
        val ivUploadProof =  dialog.findViewById<View>(R.id.ivUploadProof) as ImageView
        val paymentmode = resources.getStringArray(R.array.paymentmode)

        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, paymentmode)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    Toast.makeText(this@WalletRecharge,
                        getString(R.string.selected_item) + " " +
                                "" + paymentmode[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }


        tvSetChequeDate.setOnClickListener {
            val myDateListener =
                DatePickerDialog.OnDateSetListener { arg0, year, monthOfYear, dayOfMonth ->
                    Log.e(
                        "onDateSet()",
                        "arg0 = [$arg0], year = [$year], monthOfYear = [$monthOfYear], dayOfMonth = [$dayOfMonth]"
                    )
                    tvSetChequeDate.setText(
                        year.toString() + "-" + monthOfYear + "-"
                                + dayOfMonth
                    )
                    strChequeDate=tvSetChequeDate.text.toString()
                }

            val calendar = Calendar.getInstance()
            val mYear = calendar[Calendar.YEAR]
            val mMonth = calendar[Calendar.MONTH]
            val mDay = calendar[Calendar.DAY_OF_MONTH]

            val dpDialog =
                DatePickerDialog(this, myDateListener, mYear, mMonth, mDay)
            dpDialog.datePicker.maxDate = calendar.timeInMillis

            dpDialog.show()
        }
        ivUploadProof.setOnClickListener { selectImage() }
        tvNo.setOnClickListener { dialog.dismiss() }
        tvYesCancel.setOnClickListener {
            if(et_other_info.text.toString().length <= 0){
                AppGlobal.showToast(this,"Please enter other info")
            }else if(edEnterReceiptNo.text.toString().length <= 0){
                AppGlobal.showToast(this,"please enter receipt no")
            }else if(edEnterCheckNo.text.toString().length <= 0){
                AppGlobal.showToast(this,"please enter cheque no")
            }else if(edEnterTransactionNo.text.toString().length <= 0){
                AppGlobal.showToast(this,"please enter transaction no")
            }else if(edEnterAmount.text.toString().length <= 0){
                AppGlobal.showToast(this,"please enter amount")
            }else if(edEnterCheckBankName.text.toString().length <= 0){
                AppGlobal.showToast(this,"please enter cheque bank name")
            }else{
                //Log.e("request","order_id"+order_id+" reason "+et_other_info.text.toString()+" time "+strTime+" date "+strDateTime)
                val partner_id = MultipartBody.Part.createFormData("partner_id",LocalStorage.getCustomerID(this))
                val receipt_no = MultipartBody.Part.createFormData("receipt_number",edEnterReceiptNo.text.toString().trim())
                val other_info = MultipartBody.Part.createFormData("other_details",et_other_info.text.toString().trim())
                val trns_no = MultipartBody.Part.createFormData("transaction_number",edEnterTransactionNo.text.toString().trim())
                val cheque_no = MultipartBody.Part.createFormData("cheque_number",edEnterCheckNo.text.toString().trim())
                val amount = MultipartBody.Part.createFormData("amount",edEnterAmount.text.toString().trim())
                val cheque_bank_name = MultipartBody.Part.createFormData("cheque_bank_name",edEnterCheckBankName.text.toString().trim())
                val payment_mode = MultipartBody.Part.createFormData("payment_mode","cash")
                val cheque_date = MultipartBody.Part.createFormData("cheque_date",strChequeDate)

                if (imgUrl != null) {
                    Log.e("file",imgUrl!!.getAbsolutePath());
                    val type: String = RetrofitUtils.getMimeType(this, Uri.fromFile(imgUrl))
                    if (type == null) {
                        Log.e("filetype", "Nothing to do")
                    }
                    val body = RetrofitUtils.createFilePart(
                        "profile_image",
                        imgUrl!!.getAbsolutePath(),
                        MediaType.parse("profile_image")
                    )
                    Apicall(cxt)
                        .offlineRecharge(this,"partner-offline-recharge",
                            partner_id,
                            receipt_no,
                            payment_mode,
                            cheque_no,
                            trns_no,
                            amount,
                            cheque_bank_name,
                            cheque_date,
                            other_info,
                            body)
                }
            }
            dialog.dismiss()
        }
        dialog.show()
    }*/


}