package adapter

import Interfaces.Apicall
import Interfaces.ItemAdapterClick
import Interfaces.OnResponse
import android.app.Dialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.kodpartner.R
import com.social.ekchat.Interfaces.UniverSelObjct
import model.AcceptLeadData
import model.NewLeadsData
import retrofit.AppGlobal
import utils.LocalStorage
import java.text.DecimalFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class NewLeadsAdapter(var cxt: FragmentActivity?,var mListner : ItemAdapterClick) :
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
        try {
            holder.tvOrderId.text = "Order ID-"+feedData!![position].order_id + ""
            holder.tvUnit.text = "Unit "+feedData!![position].unit + ""
          //  val form = DecimalFormat("0.00")
            holder.tvServiceAmount.text = "Service Amount "+AppGlobal.setTwoDecimalValue(feedData!![position].amount.toFloat()) + ""
            holder.tvCommission.text = "Commission "+AppGlobal.setTwoDecimalValue(feedData!![position].commission.toFloat()) + ""
            holder.tvFault.text = ""+feedData!![position].fault + ""
            if(feedData!![position].address.isNullOrBlank())
                holder.tvAddress.text = feedData!![position].customerDetails.address+""
            else
                holder.tvAddress.text = feedData!![position].street+" "+feedData!![position].address
            //holder.tvAddress.text = feedData!![position].customerDetails.address
            //holder.tvBookingDateTime.text = feedData!![position].service_date +", "+ feedData!![position].service_time
            //holder.tvBookingDateTime.text = feedData!![position].booking_date
            holder.tvAcceptJobs.setOnClickListener{
                mListner.onClick(position)
            }
        }catch (e:Exception){e.printStackTrace()}
    }

    override fun getItemCount(): Int {
        return feedData!!.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
       // var tvBookingDateTime: TextView
        var tvServiceAmount: TextView
        var tvAddress: TextView
        var tvAcceptJobs: TextView
        var tvCommission: TextView
        var tvFault: TextView
        var tvUnit: TextView
        var tvOrderId: TextView

        init {
            tvAcceptJobs = itemView.findViewById<View>(R.id.tvAcceptJobs) as TextView
            //tvBookingDateTime = itemView.findViewById<View>(R.id.tvBookingDateTime) as TextView
            tvServiceAmount = itemView.findViewById<View>(R.id.tvServiceAmount) as TextView
            tvAddress = itemView.findViewById<View>(R.id.tvAddress) as TextView
            tvCommission = itemView.findViewById<View>(R.id.tvCommission) as TextView
            tvFault = itemView.findViewById<View>(R.id.tvFault) as TextView
            tvUnit = itemView.findViewById<View>(R.id.tvUnit) as TextView
            tvOrderId = itemView.findViewById<View>(R.id.tvOrderId) as TextView
        }
    }

}