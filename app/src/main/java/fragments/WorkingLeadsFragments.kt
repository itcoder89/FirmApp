package fragments

import Interfaces.Apicall
import Interfaces.ItemAdapterClick
import Interfaces.ItemAdapterClick2
import Interfaces.OnResponse
import adapter.WorkingLeadsAdapter
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
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
import model.CancelByData
import model.WorkCloseData
import model.WorkingLeadsData
import retrofit.AppGlobal
import utils.CustomDialogue
import utils.LocalStorage

class WorkingLeadsFragments : Fragment(), OnResponse<UniverSelObjct>, ItemAdapterClick,
    ItemAdapterClick2 {

    private var workingLeadsAdapter: WorkingLeadsAdapter? = null
    private var layoutManager: LinearLayoutManager? = null
    private var recyclerView: RecyclerView? = null
    private var workingLeadsData: WorkingLeadsData? = null
    var material : MaterialDialog? = null
    var strPaymentType = ""
    var isTouched = false
    var isOfficeTouched = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentView =
            inflater.inflate(R.layout.working_leads_list_layout, container, false)
        recyclerView = fragmentView.findViewById<View>(R.id.recyclerView) as RecyclerView

        Apicall(activity!!).getallWorkingLeads(this,"partner-working", LocalStorage.getCustomerID(activity!!))


        layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.layoutManager = layoutManager



        return fragmentView
    }
    override fun onSucess(response: UniverSelObjct?) {
        try {
            if (response!!.status == "true") {
                when (response.methodname) {
                    "partner-working" -> {
                        workingLeadsData = response.response as WorkingLeadsData
                        Log.e("partner-working"," "+workingLeadsData!!.isStatus+"")
                        workingLeadsAdapter = WorkingLeadsAdapter(activity,this,this)
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

        }
    }

    override fun onLabourClick(pos: Int) {
        showCloseDialoge(workingLeadsData!!.data[pos].order_id,activity!!)
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
            if(edEnterCustomerOTP.text.toString().equals("Please enter received amount")){
                AppGlobal.showToast(activity!!,"")
            }else if(strPaymentType.equals("")){
                AppGlobal.showToast(activity!!,"Please select payment mode")
            }else{
                Apicall(cxt)
                    .workClose(this,"closed-partner-booking",
                        LocalStorage.getCustomerID(activity!!),
                        order_id,
                        edEnterCustomerOTP.text.toString(),
                        strPaymentType
                    )
            }
            dialog.dismiss()
        }
        dialog.show()
    }

}