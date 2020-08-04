package adapter

import activity.TrackLocation
import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.*
import androidx.fragment.app.FragmentActivity
import com.firmapp.R
import model.OpenLeadsData
import model.PendingLeadsData
import model.RecomplaintsListData


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

    override fun onBindViewHolder(holder: ViewHolder,position: Int) {

        holder.tvServiceId.text = "Service ID - "+feedData!![position].order_id
        holder.tvServiceAmount.text = "Service Amount "+feedData!![position].amount + "/-"
        holder.tvAddress.text = feedData!![position].address+" - Map Link"
        holder.tvBookingDateTime.setText("Booking Date & Time \n"+feedData!![position].service_date)
        holder.tvCustomerName.setText("Customer Name \n"+feedData!![position].ocustomer_name)

        if(feedData!![position].idstatus.toInt() == 1){
            holder.tvStatus.text="Current Status - Pending"
        }else if(feedData!![position].idstatus.toInt() == 2){
            holder.tvStatus.text="Current Status - Assigned"
        }else if(feedData!![position].idstatus.toInt() == 3){
            holder.tvStatus.text="Current Status - Working"
        }else if(feedData!![position].idstatus.toInt() == 4){
            holder.tvStatus.text="Current Status - On Hold"
        }else if(feedData!![position].idstatus.toInt() == 5){
            holder.tvStatus.text="Current Status - Schedule"
        }else if(feedData!![position].idstatus.toInt() == 6){
            holder.tvStatus.text="Current Status - Cancelled"
        }else if(feedData!![position].idstatus.toInt() == 7){
            holder.tvStatus.text="Current Status - Closed"
        }else if(feedData!![position].idstatus.toInt() == 8){
            holder.tvStatus.text="Current Status - Call Not Connected"
        }else if(feedData!![position].idstatus.toInt() == 9){
            holder.tvStatus.text="Current Status - Re-Complaint"
        }
        holder.tvAddress.setOnClickListener{
            val intent = Intent(cxt, TrackLocation::class.java)
            intent.putExtra("lat_code",feedData!![position].lat_code )
            intent.putExtra("lng_code",feedData!![position].lng_code )
            cxt!!.startActivity(intent)
            cxt!!.finish()
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

        init {
            tvServiceAmount = itemView.findViewById<View>(R.id.tvServiceAmount) as TextView
            tvServiceId = itemView.findViewById<View>(R.id.tvServiceId) as TextView
            tvAddress = itemView.findViewById<View>(R.id.tvAddress) as TextView
            tvBookingDateTime = itemView.findViewById<View>(R.id.tvBookingDateTime) as TextView
            tvCustomerName = itemView.findViewById<View>(R.id.tvCustomerName) as TextView
            tvCustomerMobile = itemView.findViewById<View>(R.id.tvCustomerMobile) as TextView
            tvStatus = itemView.findViewById<View>(R.id.tvStatus) as TextView
        }
    }

}