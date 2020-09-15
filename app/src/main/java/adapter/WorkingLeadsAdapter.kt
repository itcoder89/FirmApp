package adapter

import Interfaces.*
import activity.MoveToWorking
import activity.TrackLocation
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.recyclerview.widget.RecyclerView
import android.widget.*
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.FragmentActivity
import com.afollestad.materialdialogs.MaterialDialog
import com.kodpartner.DashboardActivity
import com.kodpartner.R
import com.social.ekchat.Interfaces.UniverSelObjct
import model.CancelByData
import model.RescheduleData
import model.WorkCloseData
import model.WorkingLeadsData
import retrofit.AppGlobal
import utils.LocalStorage
import java.text.DecimalFormat
import kotlin.collections.ArrayList


class WorkingLeadsAdapter(var cxt: FragmentActivity?,var mListner : ItemAdapterClick,
                          var mListner1 : ItemAdapterClick2,var mListnerhold : ItemOnHoldAdapterClick) :
    RecyclerView.Adapter<WorkingLeadsAdapter.ViewHolder>(), OnResponse<UniverSelObjct> {

    var feedData: ArrayList<WorkingLeadsData.DataBean>? = ArrayList()
    var isTouched = false
    var isOfficeTouched = false
    var onItemClick: ((pos: Int, view: View) -> Unit)? = null
    var strPaymentType = ""

    fun addData(listItems: List<WorkingLeadsData.DataBean>) {
        if (this.feedData != null) {
            var size = this.feedData!!.size
            this.feedData!!.addAll(listItems)
            var sizeNew = this.feedData!!.size
            notifyItemRangeChanged(size, sizeNew)
        } else {
            var size = 0
            this.feedData!!.addAll(listItems)
            var sizeNew = this.feedData!!.size
            notifyItemRangeChanged(size, sizeNew)
        }
    }

    fun clearData() {
        feedData!!.clear()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // create a new view
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.working_leads_item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder,position: Int) {

        holder.tvUnit.text = "Unit "+feedData!![position].unit
        holder.tvFault.text = ""+feedData!![position].fault
        holder.tvServiceId.text = "Service ID - "+feedData!![position].order_id
        val form = DecimalFormat("0.00")
        holder.tvServiceAmount.text = "Service Amount "+form.format(feedData!![position].amount.toDouble()) + ""
       // holder.tvAddress.text = feedData!![position].customerDetails.address+""
        if(feedData!![position].address.isNullOrBlank())
            holder.tvAddress.text = feedData!![position].customerDetails.address+""
        else
            holder.tvAddress.text = feedData!![position].street+" "+feedData!![position].address
        holder.tvVisitDateTime.setText("Visit Date & Time "+feedData!![position].service_date+" "+feedData!![position].service_time)
        holder.tvCustomerName.setText("Customer Name \n"+feedData!![position].customerDetails.firstname)
        holder.tvCustomerMobile.setText("Mobile No \n"+feedData!![position].customerDetails.contact_no)

        if(feedData!![position].isEstimateSentFlag == true)
            holder.tvMoveToClose.visibility=View.VISIBLE
        else
            holder.tvMoveToClose.visibility=View.GONE

        holder.tvCancel.setOnClickListener{
            mListner.onClick(position)

        }
        holder.tvMoveToClose.setOnClickListener{
            //mListner1.onLabourClick(position)
            showCloseDialoge(feedData!![position].order_id,cxt!!,feedData!![position].extraWorkAmount,feedData!![position].extra_work_details,
                feedData!![position].amount.toFloat())
        }
        holder.tvOnHold.setOnClickListener{
            mListnerhold.onHoldClick(position)

        }
        holder.tvMoveToWorking.setOnClickListener{
            LocalStorage.setRedirectWorking(cxt!!,"false")
            val intent = Intent(cxt, MoveToWorking::class.java)
            intent.putExtra("city_id",feedData!![position].idcity )
            intent.putExtra("service_id",feedData!![position].order_id )
            intent.putExtra("booking_dt",feedData!![position].service_date )
            intent.putExtra("extra_amount",feedData!![position].extraWorkAmount )
            intent.putExtra("reason",feedData!![position].extra_work_details)
            cxt!!.startActivity(intent)
        }
        holder.btnViewMap.setOnClickListener{
            /*val intent = Intent(cxt, TrackLocation::class.java)
            intent.putExtra("lat_code",feedData!![position].lat_code )
            intent.putExtra("lng_code",feedData!![position].lng_code )
            cxt!!.startActivity(intent)*/
            val uri ="http://maps.google.com/maps?f=d&hl=en&saddr=" + LocalStorage.getLatitude(cxt!!)  + "," +  LocalStorage.getLongitude(cxt!!) + "&daddr=" + feedData!![position].lat_code + "," + feedData!![position].lng_code
            val intent =  Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            intent.setPackage("com.google.android.apps.maps");
            cxt!!.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return feedData!!.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var tvServiceAmount: TextView
        var tvServiceId: TextView
        var tvAddress: TextView
        //var tvBookingDateTime: TextView
        var tvCustomerName: TextView
        var tvCustomerMobile: TextView
        var tvCancel: TextView
        var tvUnit: TextView
        var tvFault: TextView
        var tvMoveToClose: TextView
        var tvOnHold: TextView
        var tvMoveToWorking: TextView
        var tvVisitDateTime: TextView
        var btnViewMap: Button

        init {
            tvServiceAmount = itemView.findViewById<View>(R.id.tvServiceAmount) as TextView
            tvServiceId = itemView.findViewById<View>(R.id.tvServiceId) as TextView
            tvAddress = itemView.findViewById<View>(R.id.tvAddress) as TextView
           // tvBookingDateTime = itemView.findViewById<View>(R.id.tvBookingDateTime) as TextView
            tvCustomerName = itemView.findViewById<View>(R.id.tvCustomerName) as TextView
            tvCustomerMobile = itemView.findViewById<View>(R.id.tvCustomerMobile) as TextView
            tvCancel = itemView.findViewById<View>(R.id.tvCancel) as TextView
            tvUnit = itemView.findViewById<View>(R.id.tvUnit) as TextView
            tvFault = itemView.findViewById<View>(R.id.tvFault) as TextView
            tvMoveToClose = itemView.findViewById<View>(R.id.tvMoveToClose) as TextView
            tvOnHold = itemView.findViewById<View>(R.id.tvOnHold) as TextView
            tvMoveToWorking = itemView.findViewById<View>(R.id.tvMoveToWorking) as TextView
            tvVisitDateTime = itemView.findViewById<View>(R.id.tvVisitDateTime) as TextView
            btnViewMap = itemView.findViewById<View>(R.id.btnViewMap) as Button
            //tvRescheduledLeads = itemView.findViewById<View>(R.id.tvRescheduledLeads) as TextView
        }
    }



    override fun onSucess(response: UniverSelObjct?) {
        try {
            if (response!!.status == "true") {
                when (response.methodname) {
                    "cancel-by-partner" -> {
                        val cancelByData = response.response as CancelByData
                        Log.e("partner-openleads", " " + cancelByData.message + "")

                    }
                    "rescheduler" -> {
                        val rescheduleData = response.response as RescheduleData
                        Log.e("rescheduler", " " + rescheduleData.message + "")

                    }
                    "closed-partner-booking" -> {
                        val workCloseData = response.response as WorkCloseData
                        Log.e("closed-partner-booking","size- "+workCloseData.message)
                        AppGlobal.showToast(cxt!!,workCloseData.message)
                        cxt!!.startActivity(Intent(cxt!!, DashboardActivity::class.java))
                        //activity!!.finish()
                    }
                }
            }
        }catch (e:Exception){e.printStackTrace()}


    }

    override fun onError(error: String?) {

    }

    fun showCloseDialoge(order_id: String,cxt: Context,extra_amount:Float,reason:String,amount:Float) {
        val dialog = Dialog(cxt)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.custom_close_popup)
        dialog.setCanceledOnTouchOutside(false)
        val edEnterCustomerOTP = dialog.findViewById<View>(R.id.edEnterCustomerOTP) as EditText
        val tvReason = dialog.findViewById<View>(R.id.tvReason) as TextView
        val tvExtraAmount = dialog.findViewById<View>(R.id.tvExtraAmount) as TextView
        val tvFinalAmount = dialog.findViewById<View>(R.id.tvFinalAmount) as TextView
        val tvNo = dialog.findViewById<View>(R.id.tvNo) as TextView
        val tvYesCancel =  dialog.findViewById<View>(R.id.tvYesCancel) as TextView
        val swtHome =  dialog.findViewById<View>(R.id.swtHome) as SwitchCompat
        val swtOffice =  dialog.findViewById<View>(R.id.swtOffice) as SwitchCompat
        var sum=0f
        tvReason.text="Extra work details \n"+reason
        tvExtraAmount.text=AppGlobal.setTwoDecimalValue(extra_amount).toString()
        edEnterCustomerOTP.setText(AppGlobal.setTwoDecimalValue(amount).toString())
        tvFinalAmount.text=edEnterCustomerOTP.text.toString().trim()
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
                    //sum=extra_amount+s.toString().toFloat()
                    sum=s.toString().toFloat()
                    tvFinalAmount.text=sum.toString()
                }else{
                    sum=0f
                    tvFinalAmount.text=sum.toString()
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
            /*if(edEnterCustomerOTP.text.toString().equals("")){
                AppGlobal.showToast(cxt!!,"Please enter received amount")
            }else*/ if(strPaymentType.equals("")){
                AppGlobal.showToast(cxt!!,"Please select payment mode")
            }else{
                //AppGlobal.showToast(activity!!,"call api")
                var amount=0f
                if(edEnterCustomerOTP.text.toString().length > 0){
                    amount=tvFinalAmount.text.toString().toFloat()
                }else{
                    amount=extra_amount
                }
                //AppGlobal.showToast(cxt!!,amount.toString())
                Apicall(cxt)
                    .workClose(this,"closed-partner-booking",
                        LocalStorage.getCustomerID(cxt!!),
                        order_id,
                        amount.toString(),
                        strPaymentType
                    )
                dialog.dismiss()
            }

        }
        dialog.show()
    }

    /*fun bottomSheetDiloge(message:Int,idsatuts:String) {
        val mBottomSheetDialog = BottomSheetDialog(cxt!!)
        var sheetView:View? = null

        sheetView = cxt!!.layoutInflater.inflate(R.layout.time_date_slot_resedule, null)
        val txt_1 = sheetView.findViewById<View>(R.id.txt_1) as TextView
        val txt_2 = sheetView.findViewById<View>(R.id.txt_2) as TextView
        val txt_3 = sheetView.findViewById<View>(R.id.txt_3) as TextView
        val txt_4 = sheetView.findViewById<View>(R.id.txt_4) as TextView
        val txt_5 = sheetView.findViewById<View>(R.id.txt_5) as TextView
        val txt_6 = sheetView.findViewById<View>(R.id.txt_6) as TextView
        val txt_7 = sheetView.findViewById<View>(R.id.txt_7) as TextView

        val txt_time1 = sheetView.findViewById<View>(R.id.txt_time1) as TextView
        val txt_time2 = sheetView.findViewById<View>(R.id.txt_time2) as TextView
        val txt_time3 = sheetView.findViewById<View>(R.id.txt_time3) as TextView
        val edt_feedback_msg = sheetView.findViewById<View>(R.id.edt_feedback_msg) as EditText
        val btn_confirm = sheetView.findViewById<View>(R.id.btn_confirm) as Button

        btn_confirm.setOnClickListener {

            val date = subServiceData!!.data[0].date

            if(select_time.equals("")){
                select_time = subServiceData!!.data[0].time[0]
            }

            if(select_date.equals("")){
                select_date = subServiceData!!.data[0].date
            }

            val inputPattern = "yyyy-MM-dd";
            val outputPattern = "dd-MMM";
            var inputFormat =  SimpleDateFormat(inputPattern);
            val outputFormat =  SimpleDateFormat(outputPattern);

            var date1: Date? = null;
            var str : String?= null;

            try {
                date1 = inputFormat.parse(select_date);
                str = outputFormat.format(date1);
            } catch (e: ParseException) {
                e.printStackTrace();
            }

            Apicall(cxt!!).rescheduleBooking(this,"reschedule",feedData!![message].order_id,edt_feedback_msg.text.toString(),select_date!!,select_time!!,idsatuts)
            mBottomSheetDialog.dismiss()
        }

        val arraytext = ArrayList<TextView>()
        arraytext.add(txt_1)
        arraytext.add(txt_2)
        arraytext.add(txt_3)
        arraytext.add(txt_4)
        arraytext.add(txt_5)
        arraytext.add(txt_6)
        arraytext.add(txt_7)
        var count = 0
        for (item in subServiceData!!.data){

            val date = subServiceData!!.data[count].date

            val inputPattern = "yyyy-MM-dd";
            val outputPattern = "dd";
            var inputFormat =  SimpleDateFormat(inputPattern);
            val outputFormat =  SimpleDateFormat(outputPattern);

            var date1: Date? = null;
            var str : String?= null;

            try {
                date1 = inputFormat.parse(date);
                str = outputFormat.format(date1);
            } catch (e: ParseException) {
                e.printStackTrace();
            }

            arraytext[count].setText(str)
            count++
        }

        setTimetext(txt_time1,txt_time2,txt_time3,0,txt_1,txt_2,txt_3,txt_4,txt_5,txt_6,txt_7)
        select_date = subServiceData!!.data[0].date
        txt_1.setOnClickListener {
            select_date = subServiceData!!.data[0].date
            setTimetext(txt_time1,txt_time2,txt_time3,0,txt_1,txt_2,txt_3,txt_4,txt_5,txt_6,txt_7)
        }
        txt_2.setOnClickListener {
            select_date = subServiceData!!.data[1].date
            setTimetext(txt_time1,txt_time2,txt_time3,1,txt_1,txt_2,txt_3,txt_4,txt_5,txt_6,txt_7)
        }
        txt_3.setOnClickListener {
            select_date = subServiceData!!.data[2].date
            setTimetext(txt_time1,txt_time2,txt_time3,2,txt_1,txt_2,txt_3,txt_4,txt_5,txt_6,txt_7)
        }
        txt_4.setOnClickListener {
            select_date = subServiceData!!.data[3].date
            setTimetext(txt_time1,txt_time2,txt_time3,3,txt_1,txt_2,txt_3,txt_4,txt_5,txt_6,txt_7)
        }
        txt_5.setOnClickListener {
            select_date = subServiceData!!.data[4].date
            setTimetext(txt_time1,txt_time2,txt_time3,4,txt_1,txt_2,txt_3,txt_4,txt_5,txt_6,txt_7)
        }
        txt_6.setOnClickListener {
            select_date = subServiceData!!.data[5].date
            setTimetext(txt_time1,txt_time2,txt_time3,5,txt_1,txt_2,txt_3,txt_4,txt_5,txt_6,txt_7)
        }
        txt_7.setOnClickListener {
            select_date = subServiceData!!.data[6].date
            setTimetext(txt_time1,txt_time2,txt_time3,6,txt_1,txt_2,txt_3,txt_4,txt_5,txt_6,txt_7)
        }

        txt_time1.setOnClickListener {
            select_time = txt_time1.text.toString()
            txt_time1.setBackgroundColor(Color.parseColor("#F4436C"))
            txt_time2.setBackgroundColor(Color.parseColor("#FFFFFF"))
            txt_time3.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }

        txt_time2.setOnClickListener {
            select_time = txt_time2.text.toString()
            txt_time2.setBackgroundColor(Color.parseColor("#F4436C"))
            txt_time1.setBackgroundColor(Color.parseColor("#FFFFFF"))
            txt_time3.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }

        txt_time3.setOnClickListener {
            select_time = txt_time3.text.toString()
            txt_time3.setBackgroundColor(Color.parseColor("#F4436C"))
            txt_time1.setBackgroundColor(Color.parseColor("#FFFFFF"))
            txt_time2.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }

        mBottomSheetDialog.setContentView(sheetView)
        mBottomSheetDialog.show()
    }*/

}