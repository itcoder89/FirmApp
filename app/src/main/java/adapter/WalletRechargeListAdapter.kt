package adapter

import Interfaces.Apicall
import Interfaces.OnResponse
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.*
import androidx.fragment.app.FragmentActivity
import com.afollestad.materialdialogs.MaterialDialog
import com.kodpartner.R
import com.social.ekchat.Interfaces.UniverSelObjct
import model.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class WalletRechargeListAdapter(var cxt: FragmentActivity?) :
    RecyclerView.Adapter<WalletRechargeListAdapter.ViewHolder>() {
    var material : MaterialDialog? = null
    var feedData: ArrayList<WalletSummaryListData.DataBean.PaymentSummaryBean>? = ArrayList()

    var onItemClick: ((pos: Int, view: View) -> Unit)? = null

    fun addData(listItems: List<WalletSummaryListData.DataBean.PaymentSummaryBean>) {
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
            .inflate(R.layout.wallet_summary_item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder,position: Int) {

        holder.tvOrderDate.text = ""+feedData!![position].payment_date
        holder.tvAmount.text = ""+feedData!![position].amount
        holder.tvRechargeMode.text = ""+feedData!![position].pay_sign
        holder.tvRechargeStatus.text = ""+feedData!![position].pay_type
        if(feedData!![position].transaction_number.isNullOrBlank())
            holder.tvtrnsid.text = "--"
        else
            holder.tvtrnsid.text = ""+feedData!![position].transaction_number

    }

    override fun getItemCount(): Int {
        return feedData!!.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var tvOrderDate: TextView
        var tvAmount: TextView
        var tvRechargeMode: TextView
        var tvRechargeStatus: TextView
        var tvtrnsid: TextView


        init {
            tvOrderDate = itemView.findViewById<View>(R.id.tvOrderDate) as TextView
            tvAmount = itemView.findViewById<View>(R.id.tvAmount) as TextView
            tvRechargeMode = itemView.findViewById<View>(R.id.tvRechargeMode) as TextView
            tvRechargeStatus = itemView.findViewById<View>(R.id.tvRechargeStatus) as TextView
            tvtrnsid = itemView.findViewById<View>(R.id.tvtrnsid) as TextView

        }
    }
}