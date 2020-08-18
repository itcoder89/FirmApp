package adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.*
import androidx.fragment.app.FragmentActivity
import com.kodpartner.R
import model.WalletSummaryData
import java.text.DecimalFormat


class WalletSummaryAdapter(var cxt: FragmentActivity?) :
    RecyclerView.Adapter<WalletSummaryAdapter.ViewHolder>() {

    var feedData: ArrayList<WalletSummaryData.DataBean.PaymentSummaryBean>? = ArrayList()

    var onItemClick: ((pos: Int, view: View) -> Unit)? = null

    fun addData(listItems: List<WalletSummaryData.DataBean.PaymentSummaryBean>) {
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
            .inflate(R.layout.account_summary_item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder,position: Int) {


        if(feedData!![position].pay_type.equals("commision"))
            holder.tvRechargeType.text = "Commission"+" ("+ feedData!![position].transaction_type+")"
        else
            holder.tvRechargeType.text = feedData!![position].pay_type+" ("+ feedData!![position].transaction_type+")"
        holder.tvDateTime.text = feedData!![position].payment_date.toString()
        val form = DecimalFormat("0.00")
        holder.tvAmount.text = form.format(feedData!![position].amount.toDouble())+""

        if(feedData!![position].pay_sign.equals("dr")){
            holder.tvRecharge.text = "Deduct"
        }else{
            holder.tvRecharge.text = "Added"
        }
    }

    override fun getItemCount(): Int {
        return feedData!!.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var tvRechargeType: TextView
        var tvRecharge: TextView
        var tvDateTime: TextView
        var tvAmount: TextView

        init {
            tvRecharge = itemView.findViewById<View>(R.id.tvRecharge) as TextView
            tvRechargeType = itemView.findViewById<View>(R.id.tvRechargeType) as TextView
            tvDateTime = itemView.findViewById<View>(R.id.tvDateTime) as TextView
            tvAmount = itemView.findViewById<View>(R.id.tvAmount) as TextView
        }
    }

}