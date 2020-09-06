package adapter

import Interfaces.Apicall
import Interfaces.ItemAdapterClick
import Interfaces.OnResponse
import activity.MoveToWorking
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
import model.*
import utils.LocalStorage
import java.text.DecimalFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class OnHoldLeadsAdapter(var cxt: FragmentActivity?,var mListner : ItemAdapterClick) :
    RecyclerView.Adapter<OnHoldLeadsAdapter.ViewHolder>(), OnResponse<UniverSelObjct> {
    var material : MaterialDialog? = null
    var feedData: ArrayList<OnHoldLeadsListData.DataBean>? = ArrayList()

    var onItemClick: ((pos: Int, view: View) -> Unit)? = null

    private var subServiceData: TimeDateSlabData? = null
    var select_date:String ? = null
    var select_time:String ? = null

    fun addData(listItems: List<OnHoldLeadsListData.DataBean>) {
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
            .inflate(R.layout.onhold_leads_item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder,position: Int) {

        holder.tvFault.text = ""+feedData!![position].fault
        holder.tvUnit.text = "Unit "+feedData!![position].unit
        holder.tvServiceId.text = "Service ID - "+feedData!![position].order_id
        val form = DecimalFormat("0.00")
        holder.tvServiceAmount.text = "Service Amount \n"+form.format(feedData!![position].amount.toDouble()) + ""
        holder.tvAddress.text = feedData!![position].customerDetails.address+""

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

       // holder.tvBookingDateTime.setText("Booking Date & Time \n"+str)
        holder.tvVisitDateTime.setText("Visit- "+feedData!![position].service_date+" "+feedData!![position].service_time)
        holder.tvCustomerName.setText("Customer Name \n"+feedData!![position].customerDetails.firstname)
        holder.tvCustomerMobile.setText("Mobile No \n"+feedData!![position].customerDetails.contact_no)

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
            val intent = Intent(cxt, MoveToWorking::class.java)
            intent.putExtra("city_id",feedData!![position].idcity )
            intent.putExtra("service_id",feedData!![position].order_id )
            intent.putExtra("booking_dt",feedData!![position].service_date )
            cxt!!.startActivity(intent)
        }
        holder.tvCancel.setOnClickListener{

            showccancel(position,cxt!!)
            //cxt.finish()
        }
        holder.tvHoldReason.setOnClickListener{
            Apicall(cxt!!).getHoldReason(this,"get-hold-reason",
                LocalStorage.getCustomerID(cxt!!),feedData!![position].order_id)
            //showccancel(position,cxt!!)
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
        var tvCustomerName: TextView
        var tvCustomerMobile: TextView
        var tvCancel: TextView
        var tvHoldReason: TextView
        var tvMoveToWorking: TextView
        var tvUnit: TextView
        var tvFault: TextView
        var tvVisitDateTime: TextView
        var btnViewMap: Button

        init {
            tvServiceAmount = itemView.findViewById<View>(R.id.tvServiceAmount) as TextView
            tvServiceId = itemView.findViewById<View>(R.id.tvServiceId) as TextView
            tvAddress = itemView.findViewById<View>(R.id.tvAddress) as TextView
            tvBookingDateTime = itemView.findViewById<View>(R.id.tvBookingDateTime) as TextView
            tvCustomerName = itemView.findViewById<View>(R.id.tvCustomerName) as TextView
            tvCustomerMobile = itemView.findViewById<View>(R.id.tvCustomerMobile) as TextView
            tvCancel = itemView.findViewById<View>(R.id.tvCancel) as TextView
            tvHoldReason = itemView.findViewById<View>(R.id.tvHoldReason) as TextView
            tvMoveToWorking = itemView.findViewById<View>(R.id.tvMoveToWorking) as TextView
            tvUnit = itemView.findViewById<View>(R.id.tvUnit) as TextView
            tvFault = itemView.findViewById<View>(R.id.tvFault) as TextView
            tvVisitDateTime = itemView.findViewById<View>(R.id.tvVisitDateTime) as TextView
            btnViewMap = itemView.findViewById<View>(R.id.btnViewMap) as Button
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
            Apicall(cxt).cancelBy(this,"cancel-by-partner",LocalStorage.getCustomerID(cxt!!),feedData!![pos].order_id,edt_feedback_msg.text.toString())
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
                        mListner.onClick(0)//refresh api
                    }
                    "get-hold-reason" -> {
                        val holdReasonData = response.response as HoldReasonData
                        Log.e("get-hold-reason", " " + holdReasonData.reason + "")
                        Toast.makeText(cxt,""+holdReasonData.reason, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }catch (e:Exception){e.printStackTrace()}


    }

    override fun onError(error: String?) {

    }
}