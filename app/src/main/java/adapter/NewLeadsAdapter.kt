package adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.*
import androidx.fragment.app.FragmentActivity
import com.firmapp.R
import model.NewLeadsData


class NewLeadsAdapter(var cxt: FragmentActivity?) :
    RecyclerView.Adapter<NewLeadsAdapter.ViewHolder>() {

    var feedData: ArrayList<NewLeadsData.DataBean>? = ArrayList()

    var onItemClick: ((pos: Int, view: View) -> Unit)? = null

    fun addData(listItems: List<NewLeadsData.DataBean>) {
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
            .inflate(R.layout.new_leads_item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder,position: Int) {

        holder.tvServiceAmount.text = "Service Amount "+feedData!![position].amount + "/-"
        holder.tvAddress.text = feedData!![position].address
        holder.tvBookingDateTime.text = feedData!![position].service_date +", "+ feedData!![position].service_time
       // holder.txt_coupon_validupto.text = feedData!![position].validupto

       /* holder.btn_apply.setOnClickListener{

            CartActivity.coupon_code = feedData!![position].couponcode
            CartActivity.coupon_discount = feedData!![position].amount
            Toast.makeText(cxt,"Applied Successfully!!",Toast.LENGTH_LONG).show()
            cxt.finish()
        }*/
    }

    override fun getItemCount(): Int {
        return feedData!!.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var tvBookingDateTime: TextView
        var tvServiceAmount: TextView
        var tvAddress: TextView

        init {
            tvBookingDateTime = itemView.findViewById<View>(R.id.tvBookingDateTime) as TextView
            tvServiceAmount = itemView.findViewById<View>(R.id.tvServiceAmount) as TextView
            tvAddress = itemView.findViewById<View>(R.id.tvAddress) as TextView
        }
    }

}