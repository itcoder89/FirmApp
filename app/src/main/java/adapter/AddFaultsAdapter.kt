package adapter

import Interfaces.Apicall
import Interfaces.OnResponse
import activity.TrackLocation
import android.content.Context
import android.content.Intent
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
import model.CancelByData
import model.GetMoreFaultsData
import model.RescheduleData
import model.WorkingLeadsData
import kotlin.collections.ArrayList


class AddFaultsAdapter(var cxt: FragmentActivity?) :
    RecyclerView.Adapter<AddFaultsAdapter.ViewHolder>() {
    var material : MaterialDialog? = null
    var feedData: ArrayList<GetMoreFaultsData.DataBean>? = ArrayList()

    var onItemClick: ((pos: Int, view: View) -> Unit)? = null

    fun addData(listItems: List<GetMoreFaultsData.DataBean>) {
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
            .inflate(R.layout.add_faults_item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder,position: Int) {

        holder.tvTitle.text = "Unit "+feedData!![position].name


        holder.tvAddFaults.setOnClickListener{

            //showccancel(position,cxt!!)
        }


    }

    override fun getItemCount(): Int {
        return feedData!!.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView
        var tvAddFaults: TextView

        init {
            tvTitle = itemView.findViewById<View>(R.id.tvTitle) as TextView
            tvAddFaults = itemView.findViewById<View>(R.id.tvAddFaults) as TextView
        }
    }
}