package adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.FragmentActivity
import com.kodpartner.R
import model.RecomplaintsListData


class FaultListAdapter(var cxt: FragmentActivity?) :
    RecyclerView.Adapter<FaultListAdapter.ViewHolder>() {

    var feedData: ArrayList<RecomplaintsListData.DataBean>? = ArrayList()

    var onItemClick: ((pos: Int, view: View) -> Unit)? = null

    fun addData(listItems: List<RecomplaintsListData.DataBean>) {
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
            .inflate(R.layout.fault_item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder,position: Int) {

       /* holder.tvServiceId.text = "Service ID - "+feedData!![position].order_id
        holder.tvServiceAmount.text = "Total Amount "+feedData!![position].amount + "/-"
        holder.tvAddress.text = feedData!![position].address+" - Map Link"
        holder.tvBookingDateTime.setText("Booking Date & Time \n"+feedData!![position].service_date)
        holder.tvCustomerName.setText("Customer Name \n"+feedData!![position].ocustomer_name)

        holder.tvAddress.setOnClickListener{
            val intent = Intent(cxt, TrackLocation::class.java)
            intent.putExtra("lat_code",feedData!![position].lat_code )
            intent.putExtra("lng_code",feedData!![position].lng_code )
            cxt!!.startActivity(intent)
            cxt!!.finish()
        }*/
    }

    override fun getItemCount(): Int {
       // return feedData!!.size
        return 3
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        /*var tvTitle: TextView
        var tvAmount: TextView
        var tv_quantity: TextView
        var tv_add: TextView
        var tv_less: TextView

        init {
            tvTitle = itemView.findViewById<View>(R.id.tvTitle) as TextView
            tvAmount = itemView.findViewById<View>(R.id.tvAmount) as TextView
            tv_quantity = itemView.findViewById<View>(R.id.tv_quantity) as TextView
            tv_add = itemView.findViewById<View>(R.id.tv_add) as TextView
            tv_less = itemView.findViewById<View>(R.id.tv_less) as TextView
        }*/
    }

}