package adapter

import Interfaces.Apicall
import Interfaces.OnResponse
import activity.TrackLocation
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.recyclerview.widget.RecyclerView
import android.widget.*
import androidx.fragment.app.FragmentActivity
import com.kodpartner.R
import com.social.ekchat.Interfaces.UniverSelObjct
import model.CloseByPartnerData
import model.RecomplaintsListData
import utils.LocalStorage
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class RecomplaintsListAdapter(var cxt: FragmentActivity?) :
    RecyclerView.Adapter<RecomplaintsListAdapter.ViewHolder>(), OnResponse<UniverSelObjct> {

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
            .inflate(R.layout.recomplaints_item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder,position: Int) {

        holder.tvFault.text = ""+feedData!![position].fault
        holder.tvUnit.text = "Unit "+feedData!![position].unit
        holder.tvServiceId.text = "Service ID - "+feedData!![position].order_id
        holder.tvServiceAmount.text = "Total Amount "+feedData!![position].amount + "/-"
        holder.tvAddress.text = feedData!![position].customerDetails.address+" - Map Link"



        holder.tvBookingDateTime.setText("Booking Date & Time \n"+feedData!![position].service_date)
        holder.tvCustomerName.setText("Customer Name \n"+feedData!![position].customerDetails.firstname)
        holder.tvCustomerMobile.setText("Mobile \n"+feedData!![position].customerDetails.contact_no)
        holder.tvCompleteDateTime.setText("Revisit -"+feedData!![position].service_date+" "+feedData!![position].service_time)

        val inputPattern = "yyyy-MM-dd'T'HH:mm:ss";
        val outputPattern = "dd-MM-yyyy hh:mm:ss";
        var inputFormat =  SimpleDateFormat(inputPattern);
        val outputFormat =  SimpleDateFormat(outputPattern);

        var date1: Date? = null;
        var str : String?= null;

        try {
            date1 = inputFormat.parse(feedData!![position].booking_date);
            str = outputFormat.format(date1);
        } catch (e: ParseException) {
            e.printStackTrace();
        }
        holder.tvBookingDateTime.setText("Booking Date & Time \n"+str)

        holder.tvAddress.setOnClickListener{
            val intent = Intent(cxt, TrackLocation::class.java)
            intent.putExtra("lat_code",feedData!![position].lat_code )
            intent.putExtra("lng_code",feedData!![position].lng_code )
            cxt!!.startActivity(intent)
           // cxt!!.finish()
        }

        holder.tvClose.setOnClickListener{
            showDialoge(feedData!![position].order_id,cxt!!)
        }
    }

    override fun getItemCount(): Int {
        return feedData!!.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var tvServiceAmount: TextView
        var tvServiceId: TextView
        var tvAddress: TextView
        var tvBookingDateTime: TextView
        var tvCustomerName: TextView
        var tvCustomerMobile: TextView
        var tvCompleteDateTime: TextView
        var tvFault: TextView
        var tvUnit: TextView
        var tvClose: TextView

        init {
            tvServiceAmount = itemView.findViewById<View>(R.id.tvServiceAmount) as TextView
            tvServiceId = itemView.findViewById<View>(R.id.tvServiceId) as TextView
            tvAddress = itemView.findViewById<View>(R.id.tvAddress) as TextView
            tvBookingDateTime = itemView.findViewById<View>(R.id.tvBookingDateTime) as TextView
            tvCustomerName = itemView.findViewById<View>(R.id.tvCustomerName) as TextView
            tvCustomerMobile = itemView.findViewById<View>(R.id.tvCustomerMobile) as TextView
            tvCompleteDateTime = itemView.findViewById<View>(R.id.tvCompleteDateTime) as TextView
            tvFault = itemView.findViewById<View>(R.id.tvFault) as TextView
            tvUnit = itemView.findViewById<View>(R.id.tvUnit) as TextView
            tvClose = itemView.findViewById<View>(R.id.tvClose) as TextView
        }
    }


    override fun onSucess(response: UniverSelObjct?) {
        try {
            //if (response!!.status == "true") {
            when (response!!.methodname) {
                "close-by-partner" -> {
                    val closeByPartnerData = response!!.response as CloseByPartnerData
                    Log.e("closeByPartnerData", " " + closeByPartnerData.message)
                    Toast.makeText(cxt,""+closeByPartnerData.message,Toast.LENGTH_SHORT).show()
                }

            }
            //}
        }catch (e:Exception){e.printStackTrace()}


    }

    override fun onError(error: String?) {

    }



    fun showDialoge(order_id: String,cxt: Context) {
        val dialog = Dialog(cxt)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.custom_cancel_order_popup)
        dialog.setCanceledOnTouchOutside(false)
        val tvUpdateContent = dialog.findViewById<View>(R.id.tvUpdateContent) as TextView
        val tvNo = dialog.findViewById<View>(R.id.tvNo) as TextView
        val tvYesCancel =
            dialog.findViewById<View>(R.id.tvYesCancel) as TextView

        tvUpdateContent.text="Are you sure you want to close this order?"
        tvNo.setOnClickListener { dialog.dismiss() }
        tvYesCancel.setOnClickListener {
            Log.e("acceptOrderParam","ptnr_id: "+ LocalStorage.getCustomerID(cxt)+" order_id:"+order_id)
            Apicall(cxt).closebyPartner(this,"close-by-partner",
                LocalStorage.getCustomerID(cxt),order_id)
            dialog.dismiss()
        }
        dialog.show()
    }

}