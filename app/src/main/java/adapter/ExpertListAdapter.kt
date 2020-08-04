package adapter

import activity.ExpertDetails
import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.*
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentActivity
import com.firmapp.R
import com.squareup.picasso.Picasso
import model.ExpertListData
import model.OpenLeadsData
import model.RecomplaintsListData


class ExpertListAdapter(var cxt: FragmentActivity?) :
    RecyclerView.Adapter<ExpertListAdapter.ViewHolder>() {

    var feedData: ArrayList<ExpertListData.DataBean>? = ArrayList()

    var onItemClick: ((pos: Int, view: View) -> Unit)? = null

    fun addData(listItems: List<ExpertListData.DataBean>) {
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
            .inflate(R.layout.expert_item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tvName.text = feedData!![position].name
        holder.tvContact.text = feedData!![position].contact_no

        if (!feedData!![position].image.isNullOrBlank())
            Picasso
                .with(cxt)
                .load(feedData!![position].image)
                .into(holder.ivPhoto);
        holder.llViewDetails.setOnClickListener {
            val intent = Intent(cxt, ExpertDetails::class.java)
            intent.putExtra("expertid",feedData!![position].expert_id )
            cxt!!.startActivity(intent)
            cxt!!.finish()
        }
    }

    override fun getItemCount(): Int {
        return feedData!!.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var tvName: TextView
        var tvContact: TextView
        var ivPhoto: ImageView
        var llViewDetails: LinearLayout


        init {
            tvName = itemView.findViewById<View>(R.id.tvName) as TextView
            tvContact = itemView.findViewById<View>(R.id.tvContact) as TextView
            ivPhoto = itemView.findViewById<View>(R.id.ivPhoto) as ImageView
            llViewDetails = itemView.findViewById<View>(R.id.llViewDetails) as LinearLayout
        }
    }

}