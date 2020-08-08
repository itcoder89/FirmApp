package adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.widget.LinearLayout
import android.graphics.Paint
import androidx.recyclerview.widget.GridLayoutManager
import com.afollestad.materialdialogs.MaterialDialog
import com.kodpartner.R
import model.FaultsData
import retrofit.AppGlobal
import utils.SessionManager

class CartAdapter(var cxt: Activity, var image_url: String) :
    RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    var feedData: ArrayList<FaultsData.DataBean>? = ArrayList()
    var SelectfeedData: ArrayList<FaultsData.DataBean>? = ArrayList()

    var onItemClick: ((pos: Int, view: View) -> Unit)? = null

    fun addData(listItems: ArrayList<FaultsData.DataBean>) {
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

        SelectfeedData  = SessionManager.getInstance(cxt).getCartData()

    }

    fun clearData() {
        feedData!!.clear()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // create a new view
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.child_faults_row, parent, false)//fault_item_layout
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder,position: Int) {

        for (item in SelectfeedData!!){
            if(item.idfaults.equals(feedData!![position].idfaults)){
                feedData!![position]._servicecityrates.qty = item._servicecityrates.qty
                feedData!![position]._subfaults = item._subfaults
            }
        }

        /*val adaptor = SubFaultsListGrideAdapter(cxt!!)
        holder.rv_faults_sub!!.adapter = adaptor
        adaptor!!.addData(getSectedSubFaults(feedData!![position]._subfaults))
        adaptor.notifyDataSetChanged()*/

        holder.txt_name_service.text = feedData!![position].service
        holder.txt_name_subservice.text = feedData!![position].subservice
        holder.txt_name_faults.text = feedData!![position].fault

       // holder.txt_service_name.text = feedData!![position].fault
        holder.txt_service_price.text = "₹"+feedData!![position]._servicecityrates.default_amount
        holder.txt_service_price.visibility = View.VISIBLE
        if(feedData!![position]._servicecityrates.qty1_rate !=null && !feedData!![position]._servicecityrates.qty1_rate.equals("0")){
            holder.txt_service_discount.text = "₹"+feedData!![position]._servicecityrates.qty1_rate
        }else{
            if(feedData!![position]._servicecityrates.default_amount.equals("0")){
                holder.txt_service_price.visibility = View.GONE
            }
            holder.txt_service_discount.text = ""
        }

        if(feedData!![position]._servicecityrates.qty.equals("0")){
            holder.ll_add.visibility = View.VISIBLE
            holder.ll_counter.visibility = View.GONE
        }else{
            holder.amount.text = feedData!![position]._servicecityrates.qty
            holder.ll_add.visibility = View.GONE
            holder.ll_counter.visibility = View.VISIBLE

            if(feedData!![position]._servicecityrates.qty.equals("0")){

                if(!feedData!![position]._servicecityrates.qty1_rate.equals("") && !feedData!![position]._servicecityrates.qty1_rate.equals("0")){
                    holder.txt_service_price.setPaintFlags( holder.txt_service_price.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
                    holder.txt_service_discount.visibility = View.VISIBLE
                    holder.txt_service_discount.text = "Next Price " +"₹"+feedData!![position]._servicecityrates.qty1_rate
                }else{
                    holder.txt_service_price.setPaintFlags(holder.txt_service_price.getPaintFlags() and Paint.STRIKE_THRU_TEXT_FLAG.inv())
                    holder.txt_service_discount.visibility = View.GONE
                }
            }else if(feedData!![position]._servicecityrates.qty.equals("1")){

                if(!feedData!![position]._servicecityrates.qty2_rate.equals("0")){
                    holder.txt_service_price.setPaintFlags( holder.txt_service_price.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
                    holder.txt_service_discount.visibility = View.VISIBLE
                    holder.txt_service_discount.text = "Next Price " +"₹" + feedData!![position]._servicecityrates.qty2_rate.toInt()
                }else if (feedData!![position]._servicecityrates.qty2_rate.equals("0")){
                    if(!feedData!![position]._servicecityrates.qty3_rate.equals("0")){
                        holder.txt_service_price.setPaintFlags( holder.txt_service_price.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
                        holder.txt_service_discount.visibility = View.VISIBLE
                        holder.txt_service_discount.text = "Next Price " +"₹"+ feedData!![position]._servicecityrates.qty2_rate.toInt()
                    }else if(!feedData!![position]._servicecityrates.qty1_rate.equals("0")){
                        holder.txt_service_price.setPaintFlags( holder.txt_service_price.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
                        holder.txt_service_discount.visibility = View.VISIBLE
                        holder.txt_service_discount.text = "Next Price " +"₹"+feedData!![position]._servicecityrates.qty1_rate.toInt()
                    }else{
                        holder.txt_service_price.setPaintFlags(holder.txt_service_price.getPaintFlags() and Paint.STRIKE_THRU_TEXT_FLAG.inv())
                        holder.txt_service_discount.visibility = View.GONE

                       // total_count = total_count + feedData!![position]._servicecityrates.default_amount.toInt()
                    }
                }

            }else if(feedData!![position]._servicecityrates.qty.toInt() > 1){

                if(!feedData!![position]._servicecityrates.qty3_rate.equals("") && !feedData!![position]._servicecityrates.qty3_rate.equals("0")){
                    holder.txt_service_price.setPaintFlags( holder.txt_service_price.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
                    holder.txt_service_discount.visibility = View.VISIBLE
                    holder.txt_service_discount.text = "Next Price " +"₹"+feedData!![position]._servicecityrates.qty3_rate
                }else if(!feedData!![position]._servicecityrates.qty2_rate.equals("") && !feedData!![position]._servicecityrates.qty2_rate.equals("0")){
                    holder.txt_service_price.setPaintFlags( holder.txt_service_price.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
                    holder.txt_service_discount.visibility = View.VISIBLE
                    holder.txt_service_discount.text = "Next Price " +"₹"+feedData!![position]._servicecityrates.qty2_rate
                }else if(!feedData!![position]._servicecityrates.qty1_rate.equals("") && !feedData!![position]._servicecityrates.qty1_rate.equals("0")){
                    holder.txt_service_price.setPaintFlags( holder.txt_service_price.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
                    holder.txt_service_discount.visibility = View.VISIBLE
                    holder.txt_service_discount.text = "Next Price " +"₹"+feedData!![position]._servicecityrates.qty1_rate
                }else{
                    holder.txt_service_discount.visibility = View.GONE
                    holder.txt_service_price.setPaintFlags(holder.txt_service_price.getPaintFlags() and Paint.STRIKE_THRU_TEXT_FLAG.inv())
                }
            }
        }

        holder.txt_add.setOnClickListener {
            addRemoveAliment(position,"New")
            showcustomblank(position)
        }

        holder.increase.setOnClickListener {
            addRemoveAliment(position,"Add")
            showcustomblank(position)
        }

        holder.decrease.setOnClickListener {
            addRemoveAliment(position,"remove")
        }
    }

    override fun getItemCount(): Int {
        return feedData!!.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var txt_name_subservice: TextView
        var txt_name_service: TextView
        var txt_service_price: TextView
        var txt_name_faults: TextView
        var txt_service_discount: TextView
        var increase : LinearLayout
        var decrease : LinearLayout
        var txt_add : TextView
        var amount : TextView
        var ll_add : LinearLayout
        var ll_counter : LinearLayout
        var rv_faults_sub : RecyclerView

        init {
            txt_name_subservice = itemView.findViewById<View>(R.id.txt_name_subservice) as TextView
            txt_name_service = itemView.findViewById<View>(R.id.txt_name_service) as TextView
            txt_name_faults = itemView.findViewById<View>(R.id.txt_name_faults) as TextView

            txt_service_price = itemView.findViewById<View>(R.id.txt_service_price) as TextView
            txt_service_discount = itemView.findViewById<View>(R.id.txt_service_discount) as TextView
            decrease = itemView.findViewById<View>(R.id.decrease) as LinearLayout
            increase = itemView.findViewById<View>(R.id.increase) as LinearLayout
            txt_add = itemView.findViewById<View>(R.id.txt_add) as TextView
            amount = itemView.findViewById<View>(R.id.amount) as TextView
            ll_add = itemView.findViewById<View>(R.id.ll_add) as LinearLayout
            ll_counter = itemView.findViewById<View>(R.id.ll_counter) as LinearLayout
            rv_faults_sub = itemView.findViewById<View>(R.id.rv_faults_sub) as RecyclerView

            val numberOfColumns = 2
            rv_faults_sub!!.layoutManager = GridLayoutManager(cxt, numberOfColumns)
            rv_faults_sub!!.isNestedScrollingEnabled = false
            rv_faults_sub!!.setHasFixedSize(false)
          //  adaptor!!.addData(feedData!![position]._subfaults)
           // adaptor!!.notifyDataSetChanged()
        }
    }
    private fun loadImage(imgURL: String, imgView: ImageView?) {
        AppGlobal.loadResizeImagewithPlaceHolder(cxt, imgURL, imgView, 100)
    }

    fun setData(pos: Int){

        for (item in SelectfeedData!!){
            if(item.idfaults.equals(feedData!![pos].idfaults)){
                feedData!![pos]._servicecityrates.qty = item._servicecityrates.qty
            }
        }
    }

    fun addRemoveAliment(pos:Int , tag:String){

        if(tag.equals("New")){
            feedData!![pos]._servicecityrates.qty = "1"
            SelectfeedData!!.add(feedData!![pos])

            SessionManager.getInstance(cxt).addTOCard(cxt,SelectfeedData!!)
            notifyDataSetChanged()
            //CartActivity.showHide(cxt)
            return

        }else{
            var i = 0
            for (item in SelectfeedData!!){

                if(item.idfaults.equals(feedData!![pos].idfaults)){

                    if(tag.equals("remove")){
                        if(SelectfeedData!![i]._servicecityrates.qty.equals("1")){
                            feedData!![pos]._servicecityrates.qty = "0"
                            SelectfeedData!!.removeAt(i)
                            feedData!!.removeAt(pos)

                        }else{
                            SelectfeedData!![i]._servicecityrates.qty = ""+((SelectfeedData!![i]._servicecityrates.qty).toInt() - 1)
                        }

                        SessionManager.getInstance(cxt).addTOCard(cxt,SelectfeedData!!)
                        notifyDataSetChanged()
                        //CartActivity.showHide(cxt)
                        return
                    }

                    if(tag.equals("Add")){
                        SelectfeedData!![i]._servicecityrates.qty = ""+((SelectfeedData!![i]._servicecityrates.qty).toInt() + 1)
                        SessionManager.getInstance(cxt).addTOCard(cxt,SelectfeedData!!)
                        notifyDataSetChanged()
                       // CartActivity.showHide(cxt)

                        SessionManager.getInstance(cxt).addTOCard(cxt,SelectfeedData!!)
                        notifyDataSetChanged()
                       // CartActivity.showHide(cxt)
                        return
                    }

                }
                i++
            }
        }
    }

    fun getSectedSubFaults(list:ArrayList<FaultsData.DataBean.SubfaultsBean>):ArrayList<FaultsData.DataBean.SubfaultsBean>{

       var list_new:ArrayList<FaultsData.DataBean.SubfaultsBean> = ArrayList()

        for (item in list){

            if(item.is_select.equals("1")) {
                list_new.add(item)
            }
        }

        return list_new
    }

    fun showcustomblank(position: Int) {

        /*if(feedData!![position]._subfaults.size > 0){
            val material = MaterialDialog.Builder(cxt!!)
                .customView(R.layout.city_list_diloge, true)
                .show()
            val rv_city_list = material.findViewById(R.id.rv_city_list) as RecyclerView
            val txt_header = material.findViewById(R.id.txt_header) as TextView
            val txt_faults_msg = material.findViewById(R.id.txt_faults_msg) as TextView
            val txt_faults_msgbelo = material.findViewById(R.id.txt_faults_msgbelo) as TextView

            txt_header.setText("Select Sub Faults")
            txt_faults_msg.setText("Select one of the below mentioned issues that your "+feedData!![position].service+" Might be expert")

            if(feedData!![position]._servicecityrates.default_amount.equals("0")){
                txt_faults_msgbelo.visibility = View.VISIBLE
            }else{
                txt_faults_msgbelo.visibility = View.GONE
            }

            val numberOfColumns = 2
            rv_city_list!!.layoutManager = GridLayoutManager(cxt, numberOfColumns)
            val adaptor = SubFaultsGrideAdapter(cxt!!,material)

            rv_city_list!!.adapter = adaptor
            rv_city_list!!.isNestedScrollingEnabled = false
            rv_city_list!!.setHasFixedSize(false)
            adaptor!!.addData(feedData!![position]._subfaults)
            adaptor!!.notifyDataSetChanged()

            adaptor.onItemClick = { pos, view, data ->
                material.dismiss()

                feedData!![position]._subfaults[pos].is_select = "1"

                var itemCount = 0

                for (item in SelectfeedData!!){
                    if(item.idfaults.equals(feedData!![position].idfaults)){

                        SelectfeedData!![itemCount]._subfaults[pos].is_select = "1"
                    }
                    itemCount++
                }
                SessionManager.getInstance(cxt).addTOCard(cxt,SelectfeedData!!)

                notifyDataSetChanged()

            }
        }*/
    }
}