package activity

import Interfaces.Apicall
import Interfaces.OnResponse
import adapter.WalletRechargeListAdapter
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kodpartner.R
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import com.social.ekchat.Interfaces.UniverSelObjct
import kotlinx.android.synthetic.main.comman_top_header.*
import kotlinx.android.synthetic.main.wallet_recharge_layout.*
import model.RechargeWalletData
import model.ServiceListForRateData
import model.WalletSummaryListData
import org.json.JSONObject
import retrofit.AppGlobal
import utils.CustomDialogue
import utils.LocalStorage
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

        Apicall(this)
            .getWalletRechargeSummaryList(this,"partner-wallet-summary",LocalStorage.getCustomerID(this))

        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.layoutManager = layoutManager

        AppGlobal.hideKeyboard(this)


        iv_back.setOnClickListener(this)
        btnSubmitRecharge.setOnClickListener(this)
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
            if (response!!.status == "true") {
                when (response.methodname) {
                    "partner-wallet-summary" -> {
                        val walletSummaryListData = response.response as WalletSummaryListData
                        Log.e("walletSummaryListData","")
                        val form = DecimalFormat("0.00")
                        tvWalletBalance.text="Wallet Balance \nRs."+form.format(walletSummaryListData.data.walletBalance.toString())+""
                        walletRechargeListAdapter = WalletRechargeListAdapter(this)
                        recyclerView!!.adapter = walletRechargeListAdapter
                        recyclerView!!.setHasFixedSize(false)
                        walletRechargeListAdapter!!.addData(walletSummaryListData.data.paymentSummary)
                        walletRechargeListAdapter!!.notifyDataSetChanged()
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
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    override fun onError(error: String?) {
        CustomDialogue.showcustomblank(this!!, "Alert", error.toString())
    }


}