package adapter

import Interfaces.ItemAdapterClick
import Interfaces.ItemAdapterClick2
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.FragmentActivity
import com.kodpartner.R
import model.GetOrderFaultsData
import model.GetPartListByOrderIdData
import model.RecomplaintsListData


class LabourListAdapter(var cxt: FragmentActivity?,var mListner : ItemAdapterClick2) :
    RecyclerView.Adapter<LabourListAdapter.ViewHolder>() {

    var feedData: ArrayList<GetPartListByOrderIdData.DataBean.LabourBean>? = ArrayList()

    var onItemClick: ((pos: Int, view: View) -> Unit)? = null

    fun addData(listItems: List<GetPartListByOrderIdData.DataBean.LabourBean>) {
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
            .inflate(R.layout.labour_item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder,position: Int) {

        holder.tvTitle.text = ""+feedData!![position].part_name
        holder.tvRate.text = "Rate:"+feedData!![position].labour

        holder.tvAddLabour.setOnClickListener{
            mListner.onLabourClick(position)
        }

    }

    override fun getItemCount(): Int {
        return feedData!!.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView
        var tvRate: TextView
        var tvAddLabour: TextView

        init {
            tvTitle = itemView.findViewById<View>(R.id.tvTitle) as TextView
            tvRate = itemView.findViewById<View>(R.id.tvRate) as TextView
            tvAddLabour = itemView.findViewById<View>(R.id.tvAddLabour) as TextView

        }
    }

}