package adapter

import Interfaces.Apicall
import Interfaces.OnResponse
import activity.TrackLocation
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.*
import androidx.fragment.app.FragmentActivity
import com.afollestad.materialdialogs.MaterialDialog
import com.kodpartner.R
import com.social.ekchat.Interfaces.UniverSelObjct
import model.CancelByData
import model.CompletedLeadsData
import model.RescheduleData
import retrofit.AppGlobal
import utils.LocalStorage
import java.text.DecimalFormat
import kotlin.collections.ArrayList


class CompletedLeadsAdapter(var cxt: FragmentActivity?) :
    RecyclerView.Adapter<CompletedLeadsAdapter.ViewHolder>(), OnResponse<UniverSelObjct> {
    var material : MaterialDialog? = null
    var feedData: ArrayList<CompletedLeadsData.DataBean>? = ArrayList()

    var onItemClick: ((pos: Int, view: View) -> Unit)? = null

    fun addData(listItems: List<CompletedLeadsData.DataBean>) {
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
            .inflate(R.layout.completed_leads_item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder,position: Int) {

        holder.tvServiceId.text = "Service ID - "+feedData!![position].order_id
        val form = DecimalFormat("0.00")
        holder.tvServiceAmount.text = "Total Amount "+form.format(feedData!![position].amount.toDouble()) + ""
        holder.tvCommission.text = "Commission Rs."+AppGlobal.setTwoDecimalValue(feedData!![position].commision.toFloat())
        //holder.tvAddress.text = feedData!![position].customerDetails.address
        /*if(feedData!![position].address.isNullOrBlank())
            holder.tvAddress.text = feedData!![position].customerDetails.address+""
        else
            holder.tvAddress.text = feedData!![position].street+" "+feedData!![position].address*/
        holder.tvBookingDateTime.setText("Booking Date & Time \n"+feedData!![position].booking_date)
        holder.tvCloseDateTime.setText("Close Date & Time "+feedData!![position].completed_date)
        holder.tvCustomerName.setText("Customer Name \n"+feedData!![position].customerDetails.firstname)
        holder.tvCustomerMobile.setText("Warrenty Days "+feedData!![position].warrenty_day)
        holder.tvDescription.setText(feedData!![position].fault)
        if(feedData!![position].rating != null)
            holder.tvFeedbackbyCustomer.setText("Feedback by customer - "+feedData!![position].rating)
        else
            holder.tvFeedbackbyCustomer.setText("Feedback by customer - 0.0")

        /*holder.btnViewMap.setOnClickListener{
            *//*val intent = Intent(cxt, TrackLocation::class.java)
            intent.putExtra("lat_code",feedData!![position].lat_code )
            intent.putExtra("lng_code",feedData!![position].lng_code )
            cxt!!.startActivity(intent)*//*
            val uri ="http://maps.google.com/maps?f=d&hl=en&saddr=" + LocalStorage.getLatitude(cxt!!) + "," + LocalStorage.getLongitude(cxt!!) + "&daddr=" + feedData!![position].lat_code + "," + feedData!![position].lng_code
            val intent =  Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            intent.setPackage("com.google.android.apps.maps");
            cxt!!.startActivity(intent)
        }*/
    }

    override fun getItemCount(): Int {
        return feedData!!.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var tvServiceAmount: TextView
        var tvServiceId: TextView
       // var tvAddress: TextView
        var tvBookingDateTime: TextView
        var tvCustomerName: TextView
        var tvCustomerMobile: TextView
        var tvCloseDateTime: TextView

        var tvDescription: TextView
        var tvFeedbackbyCustomer: TextView
        var tvFeedbackbykod: TextView
        var tvCommission: TextView
        //var btnViewMap: Button
        init {
            tvServiceAmount = itemView.findViewById<View>(R.id.tvServiceAmount) as TextView
            tvServiceId = itemView.findViewById<View>(R.id.tvServiceId) as TextView
          //  tvAddress = itemView.findViewById<View>(R.id.tvAddress) as TextView
            tvBookingDateTime = itemView.findViewById<View>(R.id.tvBookingDateTime) as TextView
            tvCustomerName = itemView.findViewById<View>(R.id.tvCustomerName) as TextView
            tvCustomerMobile = itemView.findViewById<View>(R.id.tvCustomerMobile) as TextView
            tvCloseDateTime = itemView.findViewById<View>(R.id.tvCloseDateTime) as TextView
            tvDescription = itemView.findViewById<View>(R.id.tvDescription) as TextView
            tvFeedbackbyCustomer = itemView.findViewById<View>(R.id.tvFeedbackbyCustomer) as TextView
            tvFeedbackbykod = itemView.findViewById<View>(R.id.tvFeedbackbykod) as TextView
            tvCommission = itemView.findViewById<View>(R.id.tvCommission) as TextView
            //btnViewMap = itemView.findViewById<View>(R.id.btnViewMap) as Button
            //tvRescheduledLeads = itemView.findViewById<View>(R.id.tvRescheduledLeads) as TextView
        }
    }

    fun showccancel(pos: Int,cxt:Context) {
        material = MaterialDialog.Builder(cxt)
            .customView(R.layout.cancel_booking_layout, true)
            .show()
        val btn_done = material!!.findViewById(R.id.btn_done) as Button
        val edt_feedback_msg = material!!.findViewById(R.id.edt_feedback_msg) as EditText

        btn_done.setOnClickListener {
            //Apicall(cxt).cancelBy(this,"cancel-by-partner",feedData!![pos].customerDetails.user_id,feedData!![pos].order_id,edt_feedback_msg.text.toString())
            Apicall(cxt).cancelBy(this,"cancel-by-partner",
                LocalStorage.getCustomerID(cxt!!),feedData!![pos].order_id,edt_feedback_msg.text.toString())
            material!!.dismiss()
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
                }
            }
        }catch (e:Exception){e.printStackTrace()}


    }

    override fun onError(error: String?) {

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