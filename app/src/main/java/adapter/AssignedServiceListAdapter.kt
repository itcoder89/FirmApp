package adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.*
import androidx.fragment.app.FragmentActivity
import com.kodpartner.R
import model.AssignedServiceListData
import model.RateListData


class AssignedServiceListAdapter(var cxt: FragmentActivity?) :
    RecyclerView.Adapter<AssignedServiceListAdapter.ViewHolder>() {

    var feedData: ArrayList<AssignedServiceListData.DataBean>? = ArrayList()

    var onItemClick: ((pos: Int, view: View) -> Unit)? = null

    fun addData(listItems: List<AssignedServiceListData.DataBean>) {
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
            .inflate(R.layout.assigned_service_item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder,position: Int) {

        holder.tvServiceName.text = ""+feedData!![position].name+" >> "+feedData!![position].subservice_name+" >> "+feedData!![position].fault_name
        holder.tvRate1.text = feedData!![position].rates[0].qty1_rate.toString()
        holder.tvRate2.text = feedData!![position].rates[0].qty2_rate.toString()
        holder.tvRate3.text = feedData!![position].rates[0].qty3_rate.toString()

        holder.tvComm1.text = ""+feedData!![position].rates[0].qty1_commision + ""
        holder.tvComm2.text = ""+feedData!![position].rates[0].qty2_commision + ""
        holder.tvComm3.text = ""+feedData!![position].rates[0].qty3_commision + ""

    }

    override fun getItemCount(): Int {
        return feedData!!.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var tvServiceName: TextView
        var tvRate2: TextView
        var tvRate3: TextView
        var tvRate1: TextView
        var tvComm3: TextView
        var tvComm2: TextView
        var tvComm1: TextView


        init {
            tvServiceName = itemView.findViewById<View>(R.id.tvServiceName) as TextView
            tvRate2 = itemView.findViewById<View>(R.id.tvRate2) as TextView
            tvRate3 = itemView.findViewById<View>(R.id.tvRate3) as TextView
            tvRate1 = itemView.findViewById<View>(R.id.tvRate1) as TextView
            tvComm3 = itemView.findViewById<View>(R.id.tvComm3) as TextView
            tvComm2 = itemView.findViewById<View>(R.id.tvComm2) as TextView
            tvComm1 = itemView.findViewById<View>(R.id.tvComm1) as TextView

        }
    }

}