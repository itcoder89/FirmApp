package adapter

import Interfaces.Apicall
import Interfaces.ItemAdapterClick
import Interfaces.OnResponse
import activity.Dummy
import activity.MoveToWorking
import activity.TrackLocation
import android.Manifest
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.kodpartner.DashboardActivity
import com.kodpartner.R
import com.social.ekchat.Interfaces.UniverSelObjct
import model.*
import utils.LocalStorage
import java.text.DecimalFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class OpenLeadsAdapter(var cxt: FragmentActivity?,var mListner : ItemAdapterClick) :
    RecyclerView.Adapter<OpenLeadsAdapter.ViewHolder>(), OnResponse<UniverSelObjct> {
    private val REQUEST_PHONE_CALL = 100
    var feedData: ArrayList<OpenLeadsData.DataBean>? = ArrayList()

    var onItemClick: ((pos: Int, view: View) -> Unit)? = null
    var received_otp=""
    var feedID=""
    var feed_pos=0
    private var subServiceData: TimeDateSlabData? = null
    var select_date:String ? = null
    var select_time:String ? = null

    fun addData(listItems: List<OpenLeadsData.DataBean>) {
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
        getTimeDateSlot()
    }

    fun clearData() {
        feedData!!.clear()
    }

    fun getTimeDateSlot(){
        Apicall(cxt!!).gettimeDateSlab(this,"TimeDateSlot")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // create a new view
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.open_leads_item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder,position: Int) {

        holder.tvFault.text = ""+feedData!![position].fault
        holder.tvServiceId.text = "Service ID - "+feedData!![position].order_id
        val form = DecimalFormat("0.00")
        holder.tvServiceAmount.text = "Service Amount "+form.format(feedData!![position].amount.toDouble()) + ""

        if(feedData!![position].address.isNullOrBlank())
            holder.tvAddress.text = feedData!![position].customerDetails.address+""
        else
            holder.tvAddress.text = feedData!![position].street+" "+feedData!![position].address



        holder.tvVisitDateTime.setText("Visit -"+feedData!![position].service_date +" "+feedData!![position].service_time )


        val inputPattern = "yyyy-MM-dd'T'HH:mm:ss";
        val outputPattern = "dd-MM-yyyy hh:mm:ss";
        var inputFormat =  SimpleDateFormat(inputPattern);
        val outputFormat =  SimpleDateFormat(outputPattern);

        var date1: Date? = null;
        var str : String?= null;

        try {
            date1 = inputFormat.parse(feedData!![position].booking_date);
            str = outputFormat.format(date1);
        } catch (e: ParseException) {
            e.printStackTrace();
        }

        holder.tvUnit.setText("Unit "+feedData!![position].unit)
       // holder.tvBookingDateTime.setText("Booking Date & Time \n"+str)
        holder.tvCustomerName.setText("Customer Name \n"+feedData!![position].customerDetails.firstname)
        holder.tvCustomerMobile.setText("Mobile No \n"+feedData!![position].customerDetails.contact_no)
        holder.tvCustomerMobile.setOnClickListener{
            if (ContextCompat.checkSelfPermission(
                    cxt!!,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    cxt!!,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    REQUEST_PHONE_CALL
                )
            }else{
                val callIntent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+91"+ feedData!![position].customerDetails.contact_no))
                if (ActivityCompat.checkSelfPermission(
                        cxt!!,
                        Manifest.permission.CALL_PHONE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return@setOnClickListener
                }
                cxt!!.startActivity(callIntent)
            }
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
        holder.tvMoveToWorking.setOnClickListener{
            LocalStorage.setRedirectWorking(cxt,"true")
            val intent = Intent(cxt, MoveToWorking::class.java)
            intent.putExtra("city_id",feedData!![position].idcity )
            intent.putExtra("service_id",feedData!![position].order_id )
            intent.putExtra("booking_dt",feedData!![position].service_date )
            cxt!!.startActivity(intent)
        }
        holder.tvCancel.setOnClickListener{
            mListner.onClick(position)
            //showccancel(position,cxt!!)
            //cxt.finish()
        }
        holder.tvRescheduledLeads.setOnClickListener{
            feedID=feedData!![position].id.toString()
            feed_pos=position
            Apicall(cxt!!)
                .getoptconfirmation(this,"get-opt-confirmation",
                    LocalStorage.getCustomerID(cxt),
                    feedData!![position].order_id,
                    "5")

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
        var tvBookingDateTime: TextView
        var tvVisitDateTime: TextView
        var tvCustomerName: TextView
        var tvCustomerMobile: TextView
        var tvCancel: TextView
        var tvRescheduledLeads: TextView
        var tvMoveToWorking: TextView
        var tvFault: TextView
        var tvUnit: TextView
        var btnViewMap: Button

        init {
            tvServiceAmount = itemView.findViewById<View>(R.id.tvServiceAmount) as TextView
            tvServiceId = itemView.findViewById<View>(R.id.tvServiceId) as TextView
            tvAddress = itemView.findViewById<View>(R.id.tvAddress) as TextView
            tvBookingDateTime = itemView.findViewById<View>(R.id.tvBookingDateTime) as TextView
            tvVisitDateTime = itemView.findViewById<View>(R.id.tvVisitDateTime) as TextView
            tvCustomerName = itemView.findViewById<View>(R.id.tvCustomerName) as TextView
            tvCustomerMobile = itemView.findViewById<View>(R.id.tvCustomerMobile) as TextView
            tvCancel = itemView.findViewById<View>(R.id.tvCancel) as TextView
            tvRescheduledLeads = itemView.findViewById<View>(R.id.tvRescheduledLeads) as TextView
            tvMoveToWorking = itemView.findViewById<View>(R.id.tvMoveToWorking) as TextView
            tvFault = itemView.findViewById<View>(R.id.tvFault) as TextView
            tvUnit = itemView.findViewById<View>(R.id.tvUnit) as TextView
            btnViewMap = itemView.findViewById<View>(R.id.btnViewMap) as Button
        }
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
                Log.e("FeedData","id "+feedID)
                Log.e("FeedData","pos "+feed_pos)
                bottomSheetDiloge(feed_pos,feedID)
                dialog.dismiss()
            }else {
                Toast.makeText(cxt, "Invalid OTP Entered!", Toast.LENGTH_SHORT).show()
            }
        }
        dialog.show()
    }


    override fun onSucess(response: UniverSelObjct?) {
        try {
            if (response!!.status == "true") {
                when (response.methodname) {
                    "cancel-by-partner" -> {
                        val cancelByData = response.response as CancelByData
                        Log.e("partner-openleads", " " + cancelByData.message + "")

                    }
                    "get-opt-confirmation" -> {
                        val sendSMSOTPData = response.response as SendSMSOTPData
                        Log.e("sendSMSOTPData", " " + sendSMSOTPData.message + "")
                        received_otp=sendSMSOTPData.data.otp.toString()
                        Log.e("received_otp", " " + sendSMSOTPData.data.otp.toString() + "")
                        showDialoge(received_otp,cxt!!)
                    }
                    "reschedule-by-partner" -> {
                        val rescheduleData = response.response as RescheduleData
                        Log.e("reschedule-by-partner", " " + rescheduleData.message + "")
                        Toast.makeText(cxt,"Your service request has been rescheduled. Thank you.!!",Toast.LENGTH_LONG).show()
                        cxt!!.startActivity(Intent(cxt!!, DashboardActivity::class.java))
                    }
                    "TimeDateSlot" -> {
                        subServiceData = response.response as TimeDateSlabData

                        if(subServiceData!!.data.size>0){
                            select_date = subServiceData!!.data[0].date
                            select_time = subServiceData!!.data[0].time[0]

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

                        }
                    }
                }
            }
        }catch (e:Exception){e.printStackTrace()}


    }

    override fun onError(error: String?) {

    }

    fun bottomSheetDiloge(message:Int,idsatuts:String) {
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
        edt_feedback_msg.visibility=View.INVISIBLE
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

            Apicall(cxt!!).rescheduleBooking(this,"reschedule-by-partner",
                LocalStorage.getCustomerID(cxt!!),
                feedData!![message].order_id,
                select_date!!,
                select_time!!)
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
    }

    fun setTimetext(txt_time1:TextView,txt_time2:TextView,txt_time3:TextView,datepos:Int,txt_1:TextView,txt_2:TextView,txt_3:TextView,txt_4:TextView,txt_5:TextView,txt_6:TextView,txt_7:TextView){

        val arraytext = ArrayList<TextView>()
        arraytext.add(txt_1)
        arraytext.add(txt_2)
        arraytext.add(txt_3)
        arraytext.add(txt_4)
        arraytext.add(txt_5)
        arraytext.add(txt_6)
        arraytext.add(txt_7)

        txt_time1.setBackgroundColor(Color.parseColor("#F4436C"))
        txt_time2.setBackgroundColor(Color.parseColor("#FFFFFF"))
        txt_time3.setBackgroundColor(Color.parseColor("#FFFFFF"))

        if(subServiceData!!.data[datepos].time.size == 1){
            txt_time1.text = subServiceData!!.data[datepos].time[0]

        }else if(subServiceData!!.data[datepos].time.size == 2){
            txt_time1.text = subServiceData!!.data[datepos].time[0]
            txt_time2.text = subServiceData!!.data[datepos].time[1]
        }else if(subServiceData!!.data[datepos].time.size == 3){
            txt_time1.text = subServiceData!!.data[datepos].time[0]
            txt_time2.text = subServiceData!!.data[datepos].time[1]
            txt_time3.text = subServiceData!!.data[datepos].time[2]
        }

        var count = 0

        for (item in arraytext){
            if(count==datepos){
                item.setBackgroundColor(Color.parseColor("#F4436C"))
            }else{
                item.setBackgroundColor(Color.parseColor("#D6DBDF"))
            }
            count++
        }
    }


}