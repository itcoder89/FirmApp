package adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.kodpartner.R
import model.PendingLeadsData
import utils.LocalStorage
import java.text.DecimalFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class AllPendingLeadsListAdapter(var cxt: FragmentActivity?) :
    RecyclerView.Adapter<AllPendingLeadsListAdapter.ViewHolder>() {

    var feedData: ArrayList<PendingLeadsData.DataBean>? = ArrayList()

    var onItemClick: ((pos: Int, view: View) -> Unit)? = null

    fun addData(listItems: List<PendingLeadsData.DataBean>) {
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
            .inflate(R.layout.all_pending_item_layout, parent, false)
        return ViewHolder(v)
    }

    private fun getDisplayText(input: String): String? {
        return input.substring(15)
    }

    override fun onBindViewHolder(holder: ViewHolder,position: Int) {

        holder.tvServiceId.text = "Service ID - "+feedData!![position].order_id
        val form = DecimalFormat("0.00")
        holder.tvServiceAmount.text = "Service Amount "+form.format(feedData!![position].amount.toDouble()) + ""
        //holder.tvAddress.text = feedData!![position].customerDetails.address+""
        holder.tvAddress.text = getDisplayText(feedData!![position].customerDetails.address)

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
        holder.tvBookingDateTime.setText("Service Date & Time \n"+feedData!![position].service_date +"-"+feedData!![position].service_time)
        holder.tvCompleteDateTime.setText("Visit- "+feedData!![position].service_date+" "+feedData!![position].service_time)
        holder.tvCustomerName.setText("Customer Name \n"+feedData!![position].customerDetails.firstname)
        holder.tvCustomerMobile.setText("Mobile \n"+feedData!![position].customerDetails.contact_no)
        holder.tvStatus.text="Current Status -"+feedData!![position].current_status
        holder.tvUnit.text="Unit "+feedData!![position].unit

        holder.btnViewMap.setOnClickListener{
           /* val intent = Intent(cxt, TrackLocation::class.java)
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
        var tvBookingDateTime: TextView
        var tvCustomerName: TextView
        var tvCustomerMobile: TextView
        var tvStatus: TextView
        var tvCompleteDateTime: TextView
        var tvUnit: TextView
        var btnViewMap: Button

        init {
            tvServiceAmount = itemView.findViewById<View>(R.id.tvServiceAmount) as TextView
            tvServiceId = itemView.findViewById<View>(R.id.tvServiceId) as TextView
            tvAddress = itemView.findViewById<View>(R.id.tvAddress) as TextView
            tvBookingDateTime = itemView.findViewById<View>(R.id.tvBookingDateTime) as TextView
            tvCustomerName = itemView.findViewById<View>(R.id.tvCustomerName) as TextView
            tvCustomerMobile = itemView.findViewById<View>(R.id.tvCustomerMobile) as TextView
            tvStatus = itemView.findViewById<View>(R.id.tvStatus) as TextView
            tvCompleteDateTime = itemView.findViewById<View>(R.id.tvCompleteDateTime) as TextView
            tvUnit = itemView.findViewById<View>(R.id.tvUnit) as TextView
            btnViewMap = itemView.findViewById<View>(R.id.btnViewMap) as Button
        }
    }

}