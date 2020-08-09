package adapter

import Interfaces.ItemAdapterClick2
import Interfaces.ItemFaultAdapterClick
import Interfaces.ItemLabourAdapterClick
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.FragmentActivity
import com.kodpartner.R
import model.GetAllSelectedPartListData
import model.GetOrderFaultsData
import model.RecomplaintsListData


class SavedLabourListAdapter(var cxt: FragmentActivity?, var mListner : ItemLabourAdapterClick) :
    RecyclerView.Adapter<SavedLabourListAdapter.ViewHolder>() {

    var feedData: ArrayList<GetAllSelectedPartListData.DataBean>? = ArrayList()

    var onItemClick: ((pos: Int, view: View) -> Unit)? = null
    var count = 0
    fun addData(listItems: List<GetAllSelectedPartListData.DataBean>) {
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

        holder.tvTitle.text = ""+feedData!![position].name
        holder.edAmount.setText(feedData!![position].amount)
        holder.tv_quantity.text = "1"

        holder.tv_add.setOnClickListener{
            count=holder.tv_quantity.text.toString().toInt()
            count++
            holder.tv_quantity.text = count.toString()
            //mListner.onPlusPartItemClick(feedData!![position].id,position,count,feedData!![position].amount.toFloat())
            mListner.onPlusPartItemClick(feedData!![position].id,position,count,holder.edAmount.text.toString().toFloat())
        }
        holder.tv_less.setOnClickListener{
            count=holder.tv_quantity.text.toString().toInt()
            count--
            holder.tv_quantity.text = count.toString()
            if (count > 0) {
                //mListner.onMinusPartItemClick(feedData!![position].id,position,count,feedData!![position].amount.toFloat())
                mListner.onMinusPartItemClick(feedData!![position].id,position,count,holder.edAmount.text.toString().toFloat())
            }else{
                count=1
                holder.tv_quantity.text = count.toString()
            }
        }
        holder.ivRemoveItem.setOnClickListener {
            mListner.onRemmovePartItemClick(feedData!![position].idpart.toInt())
        }
    }

    override fun getItemCount(): Int {
        return feedData!!.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView
        var edAmount: EditText
        var tv_quantity: TextView
        var tv_add: TextView
        var tv_less: TextView
        var ivRemoveItem: ImageView

        init {
            tvTitle = itemView.findViewById<View>(R.id.tvTitle) as TextView
            edAmount = itemView.findViewById<View>(R.id.edAmount) as EditText
            tv_quantity = itemView.findViewById<View>(R.id.tv_quantity) as TextView
            tv_add = itemView.findViewById<View>(R.id.tv_add) as TextView
            tv_less = itemView.findViewById<View>(R.id.tv_less) as TextView
            ivRemoveItem = itemView.findViewById<View>(R.id.ivRemoveItem) as ImageView

        }
    }

}