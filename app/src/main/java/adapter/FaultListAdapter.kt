package adapter

import Interfaces.ItemFaultAdapterClick
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.kodpartner.R
import model.GetOrderFaultsData


class FaultListAdapter(var cxt: FragmentActivity?,var mListner : ItemFaultAdapterClick) :
    RecyclerView.Adapter<FaultListAdapter.ViewHolder>() {

    var feedData: ArrayList<GetOrderFaultsData.DataBean>? = ArrayList()

    var onItemClick: ((pos: Int, view: View) -> Unit)? = null
    var count = 0
    fun addData(listItems: List<GetOrderFaultsData.DataBean>) {
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

        holder.tvTitle.text = ""+feedData!![position].fault
        holder.tvAmount.text = "Amount Rs."+feedData!![position].amount
        holder.tv_quantity.text = "1"

        holder.tv_add.setOnClickListener{
            count=holder.tv_quantity.text.toString().toInt()
            count++
            holder.tv_quantity.text = count.toString()
            mListner.onPlusClick(position,1,feedData!![position].amount.toFloat())

        }
        holder.tv_less.setOnClickListener{
            count=holder.tv_quantity.text.toString().toInt()
            count--
            holder.tv_quantity.text = count.toString()
            if (count > 0) {
                mListner.onMinusClick(position,1,feedData!![position].amount.toFloat())
            }else{
                count=1
                holder.tv_quantity.text = count.toString()
            }

        }
    }

    override fun getItemCount(): Int {
        return feedData!!.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView
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

        }
    }

}