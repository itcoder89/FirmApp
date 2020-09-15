package fragments

import Interfaces.*
import adapter.WorkingLeadsAdapter
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.*
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.materialdialogs.MaterialDialog
import com.kodpartner.DashboardActivity
import com.kodpartner.R
import com.social.ekchat.Interfaces.UniverSelObjct
import connection.CheckNetwork
import connection.MyDialog
import kotlinx.android.synthetic.main.custom_close_popup.*
import kotlinx.android.synthetic.main.custom_on_hold_popup.*
import model.*
import retrofit.AppGlobal
import utils.CustomDialogue
import utils.LocalStorage
import java.util.*

class WorkingLeadsFragments : Fragment(), OnResponse<UniverSelObjct>, ItemAdapterClick,
    ItemAdapterClick2, ItemOnHoldAdapterClick {
    var picker: TimePickerDialog? = null
    private var workingLeadsAdapter: WorkingLeadsAdapter? = null
    private var layoutManager: LinearLayoutManager? = null
    private var recyclerView: RecyclerView? = null
    private var workingLeadsData: WorkingLeadsData? = null
    var material : MaterialDialog? = null
    var strPaymentType = ""
    var strTime = ""
    var strDateTime = ""
    var isTouched = false
    var isOfficeTouched = false
    var finalAmount=""
    var received_otp=""
    var orderId=""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentView =
            inflater.inflate(R.layout.working_leads_list_layout, container, false)
        recyclerView = fragmentView.findViewById<View>(R.id.recyclerView) as RecyclerView
        LocalStorage.setRedirectWorking(activity!!,"false")



        layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.layoutManager = layoutManager



        return fragmentView
    }

    override fun onResume() {
        super.onResume()
        if (CheckNetwork.isConnected(activity!!)) {
            Apicall(activity!!).getallWorkingLeads(this,"partner-working", LocalStorage.getCustomerID(activity!!))
        }else{
            MyDialog(activity!!).getNoInternetDialog().show()
        }
    }
    override fun onSucess(response: UniverSelObjct?) {
        try {
            if (response!!.status == "true") {
                when (response.methodname) {
                    "partner-working" -> {
                        workingLeadsData = response.response as WorkingLeadsData
                        Log.e("partner-working"," "+workingLeadsData!!.isStatus+"")
                        //tvFinalAmount.text=workingLeadsData.data[]
                        workingLeadsAdapter = WorkingLeadsAdapter(activity,this,this,this)
                        recyclerView!!.adapter = workingLeadsAdapter
                        recyclerView!!.setHasFixedSize(false)
                        workingLeadsAdapter!!.addData(workingLeadsData!!.data)
                        workingLeadsAdapter!!.notifyDataSetChanged()
                    }
                    "cancel-by-partner" -> {
                        val cancelByData = response.response as CancelByData
                        Log.e("partner-openleads", " " + cancelByData.message + "")
                        AppGlobal.showToast(activity!!,cancelByData.message)
                        Apicall(activity!!).getallWorkingLeads(this,"partner-working", LocalStorage.getCustomerID(activity!!))
                    }
                    "hold-by-partner" -> {
                        val holdByPartnerData = response.response as HoldByPartnerData
                        Log.e("holdByPartnerData", " " + holdByPartnerData.message + "")
                        AppGlobal.showToast(activity!!,holdByPartnerData.message)
                        Apicall(activity!!).getallWorkingLeads(this,"partner-working", LocalStorage.getCustomerID(activity!!))
                    }
                    "get-opt-confirmation" -> {
                        val sendSMSOTPData = response.response as SendSMSOTPData
                        Log.e("sendSMSOTPData", " " + sendSMSOTPData.message + "")
                        //AppGlobal.showToast(activity!!,sendSMSOTPData.message)
                        received_otp=sendSMSOTPData.data.otp.toString()
                        Log.e("received_otp", " " + sendSMSOTPData.data.otp.toString() + "")
                        showDialoge(received_otp,activity!!)
                    }
                    "closed-partner-booking" -> {
                        val workCloseData = response.response as WorkCloseData
                        Log.e("closed-partner-booking","size- "+workCloseData.message)
                        AppGlobal.showToast(activity!!,workCloseData.message)
                        startActivity(Intent(activity!!, DashboardActivity::class.java))
                        //activity!!.finish()
                    }
                }

            }
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    override fun onError(error: String?) {
        CustomDialogue.showcustomblank(activity!!, "Alert", error.toString())
    }

    override fun onClick(pos: Int) {
        showccancel(pos,activity!!)
    }

    fun showccancel(pos: Int,cxt: Context) {
        material = MaterialDialog.Builder(cxt)
            .customView(R.layout.cancel_booking_layout, true)
            .show()
        val btn_done = material!!.findViewById(R.id.btn_done) as Button
        val edt_feedback_msg = material!!.findViewById(R.id.edt_feedback_msg) as EditText

        btn_done.setOnClickListener {

            Apicall(cxt).cancelBy(this,"cancel-by-partner",
                LocalStorage.getCustomerID(activity!!),
                workingLeadsData!!.data[pos].order_id,
                edt_feedback_msg.text.toString())
            material!!.dismiss()

        }
    }

    override fun onLabourClick(pos: Int) {
       // showCloseDialoge(workingLeadsData!!.data[pos].order_id,activity!!)
    }

    fun showCloseDialoge(order_id: String,cxt: Context) {
        val dialog = Dialog(cxt)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.custom_close_popup)
        dialog.setCanceledOnTouchOutside(false)
        val edEnterCustomerOTP = dialog.findViewById<View>(R.id.edEnterCustomerOTP) as EditText
        val tvNo = dialog.findViewById<View>(R.id.tvNo) as TextView
        val tvYesCancel =  dialog.findViewById<View>(R.id.tvYesCancel) as TextView
        val swtHome =  dialog.findViewById<View>(R.id.swtHome) as SwitchCompat
        val swtOffice =  dialog.findViewById<View>(R.id.swtOffice) as SwitchCompat


        edEnterCustomerOTP.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence,
                start: Int,
                before: Int,
                count: Int
            ) {
            }

            override fun afterTextChanged(s: Editable) {
                if (!TextUtils.isEmpty(s)) {

                }
            }
        })
        swtHome.setOnTouchListener(View.OnTouchListener { view, motionEvent ->
            isTouched = true
            false
        })
        swtHome.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isTouched) {
                isTouched = false
                if (isChecked) {
                    strPaymentType = "COD"
                    swtOffice.setChecked(false)
                } else {
                    //sch_homedelivery.setChecked(true)
                }
            }
        })
        swtOffice.setOnTouchListener(View.OnTouchListener { view, motionEvent ->
            isOfficeTouched = true
            false
        })
        swtOffice.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isOfficeTouched) {
                isOfficeTouched = false
                if (isChecked) {
                    strPaymentType = "Online"
                    swtHome.setChecked(false)
                } else {
                    //sch_homedelivery.setChecked(true)
                }
            }
        })

        tvNo.setOnClickListener { dialog.dismiss() }
        tvYesCancel.setOnClickListener {
            if(edEnterCustomerOTP.text.toString().equals("")){
                AppGlobal.showToast(activity!!,"Please enter received amount")
            }else if(strPaymentType.equals("")){
                AppGlobal.showToast(activity!!,"Please select payment mode")
            }else{
                //AppGlobal.showToast(activity!!,"call api")
                Apicall(cxt)
                    .workClose(this,"closed-partner-booking",
                        LocalStorage.getCustomerID(activity!!),
                        order_id,
                        edEnterCustomerOTP.text.toString(),
                        strPaymentType
                    )
                dialog.dismiss()
            }

        }
        dialog.show()
    }

    override fun onHoldClick(pos: Int) {
        //call send sms api
        orderId=workingLeadsData!!.data[pos].order_id
        Apicall(activity!!)
            .getoptconfirmation(this,"get-opt-confirmation",
                LocalStorage.getCustomerID(activity),
                workingLeadsData!!.data[pos].order_id,
                "4")
    }

    fun showDialoge(cust_otp: String,cxt: Context) {
        val dialog = Dialog(cxt)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.custom_resend_otp_popup)
        dialog.setCanceledOnTouchOutside(false)
        val edEnterCustomerOTP = dialog.findViewById<View>(R.id.edEnterCustomerOTP) as EditText
        val tvNo = dialog.findViewById<View>(R.id.tvNo) as TextView
        val tvYesCancel =
            dialog.findViewById<View>(R.id.tvYesCancel) as TextView
        tvNo.setOnClickListener { dialog.dismiss() }
        tvYesCancel.setOnClickListener {
            if(edEnterCustomerOTP.text.toString().equals(cust_otp)) {
                //showOnHoldDialoge(workingLeadsData!!.data[pos].order_id,activity!!)
                showOnHoldDialoge(orderId,activity!!)
                dialog.dismiss()
            }else {
                Toast.makeText(activity, "Invalid OTP Entered!", Toast.LENGTH_SHORT).show()
            }
        }
        dialog.show()
    }

    fun showOnHoldDialoge(order_id: String,cxt: Context) {
        val dialog = Dialog(cxt)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.custom_on_hold_popup)
        dialog.setCanceledOnTouchOutside(false)
        val et_reason = dialog.findViewById<View>(R.id.et_reason) as EditText
        val tvSetVisitTime = dialog.findViewById<View>(R.id.tvSetVisitTime) as TextView
        val tvSetVisitDate = dialog.findViewById<View>(R.id.tvSetVisitDate) as TextView
        val tvNo = dialog.findViewById<View>(R.id.tvNo) as TextView
        val tvYesCancel =  dialog.findViewById<View>(R.id.tvYesCancel) as TextView

        tvSetVisitTime.setOnClickListener {

            val cldr = Calendar.getInstance()
            val hour = cldr[Calendar.HOUR_OF_DAY]
            val minutes = cldr[Calendar.MINUTE]
            // time picker dialog
            picker = TimePickerDialog(
                activity!!,
                TimePickerDialog.OnTimeSetListener { tp, sHour, sMinute -> //  edtOpenTime.setText(String.format("%02d:%02d",sHour,sMinute));
                    val isPM = sHour >= 12
                    tvSetVisitTime.setText(
                        String.format(
                            "%02d:%02d %s",
                            if (sHour == 12 || sHour == 0) 12 else sHour % 12,
                            sMinute,
                            if (isPM) "PM" else "AM"
                        )
                    )
                    //getInputValueFromTime()
                    strTime=tvSetVisitTime.text.toString()
                }, hour, minutes, false
            )
            picker!!.show()
        }
        tvSetVisitDate.setOnClickListener {
            val myDateListener =
                DatePickerDialog.OnDateSetListener { arg0, year, monthOfYear, dayOfMonth ->
                    Log.e(
                        "onDateSet()",
                        "arg0 = [$arg0], year = [$year], monthOfYear = [$monthOfYear], dayOfMonth = [$dayOfMonth]"
                    )
                    tvSetVisitDate.setText(
                        year.toString() + "-" + monthOfYear + "-"
                                + dayOfMonth
                    )
                    //getInputValueFromDate()
                    strDateTime=tvSetVisitDate.text.toString()
                }

            val calendar = Calendar.getInstance()
            val mYear = calendar[Calendar.YEAR]
            val mMonth = calendar[Calendar.MONTH]
            val mDay = calendar[Calendar.DAY_OF_MONTH]

            val dpDialog =
                DatePickerDialog(activity!!, myDateListener, mYear, mMonth, mDay)
            dpDialog.datePicker.maxDate = calendar.timeInMillis

            dpDialog.show()
        }
        tvNo.setOnClickListener { dialog.dismiss() }
        tvYesCancel.setOnClickListener {
            if(et_reason.text.toString().length <= 0){
                AppGlobal.showToast(activity,"Please enter other info")
            }else if(strTime.equals("")){
                AppGlobal.showToast(activity,"please select visit time")
            }else if(strDateTime.equals("")){
                AppGlobal.showToast(activity,"please select visit date")
            }else{
                Log.e("request","order_id"+order_id+" reason "+et_reason.text.toString()+" time "+strTime+" date "+strDateTime)
                //AppGlobal.showToast(activity,"call api")
                Apicall(cxt)
                    .holdByPartner(this,"hold-by-partner",
                        LocalStorage.getCustomerID(activity),
                        order_id,
                        et_reason.text.toString(),
                        strTime,
                        strDateTime)
            }
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun getInputValueFromTime() {

    }

    private fun getInputValueFromDate() {

    }

}