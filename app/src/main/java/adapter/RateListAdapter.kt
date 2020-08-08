package adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.*
import androidx.fragment.app.FragmentActivity
import com.kodpartner.R
import model.RateListData


class RateListAdapter(var cxt: FragmentActivity?) :
    RecyclerView.Adapter<RateListAdapter.ViewHolder>() {

    var feedData: ArrayList<RateListData.DataBean.LabourBean>? = ArrayList()

    var onItemClick: ((pos: Int, view: View) -> Unit)? = null

    fun addData(listItems: List<RateListData.DataBean.LabourBean>) {
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
            .inflate(R.layout.rate_item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder,position: Int) {

        holder.tvLabour.text = ""+feedData!![position].labour
        holder.tvRate.text = ""+feedData!![position].amount + ""
        holder.tvPartName.text = feedData!![position].part_name+""
        /*holder.tvBookingDateTime.setText("Booking Date & Time \n"+feedData!![position].service_date)
        holder.tvCustomerName.setText("Customer Name \n"+feedData!![position].ocustomer_name)*/

    }

    override fun getItemCount(): Int {
        return feedData!!.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var tvPartName: TextView
        var tvRate: TextView
        var tvLabour: TextView


        init {
            tvPartName = itemView.findViewById<View>(R.id.tvPartName) as TextView
            tvRate = itemView.findViewById<View>(R.id.tvRate) as TextView
            tvLabour = itemView.findViewById<View>(R.id.tvLabour) as TextView

        }
    }

}