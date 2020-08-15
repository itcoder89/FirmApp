package adapter

import Interfaces.ItemFaultAdapterClick
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.kodpartner.R
import model.GetOrderFaultsData

class FaultListAdapter(var cxt: FragmentActivity?,var mListner : ItemFaultAdapterClick) :
    RecyclerView.Adapter<FaultListAdapter.ViewHolder>() {

    var feedData: ArrayList<GetOrderFaultsData.DataBean>? = ArrayList()
    var SelectfeedData: GetOrderFaultsData.DataBean? = null

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
       // holder.edAmount.setText(feedData!![position].amount)
        holder.tv_quantity.text = feedData!![position].qty

        if(feedData!![position].rowamount.toInt().equals("0")){
            var amount = calCulation(feedData!![position])
            holder.edAmount.setText(amount.toString())
        }else{
            holder.edAmount.setText(feedData!![position].rowamount.toString())
        }

        holder.ivRemoveItem.setOnClickListener {
            mListner.onRemoveItemClick(feedData!![position].idfault.toInt())
        }
        holder.edAmount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence,
                start: Int,
                before: Int,
                count: Int
            ) {
            }

            override fun afterTextChanged(s: Editable) {
                feedData!![position].rowamount = ""+s
                finalCalculation(feedData!!)
            }
        })

        holder.tv_add.setOnClickListener{
            count=holder.tv_quantity.text.toString().toInt()
            count++
            feedData!![position].qty = ""+count
            holder.tv_quantity.text = count.toString()
            var amount = calCulation(feedData!![position])
            feedData!![position].rowamount = ""+amount

            holder.edAmount.setText(""+amount)
            finalCalculation(feedData!!)
            notifyDataSetChanged()
            mListner.onPlusClick(feedData!![position].id,position,count,holder.edAmount.text.toString().toFloat())
        }
        holder.tv_less.setOnClickListener{
            count=holder.tv_quantity.text.toString().toInt()
            count--
            if (count > 0) {
                feedData!![position].qty = ""+count
                holder.tv_quantity.text = count.toString()
                var amount = calCulation(feedData!![position])
                feedData!![position].rowamount = ""+amount
                holder.edAmount.setText(""+amount)
                notifyDataSetChanged()
                mListner.onMinusClick(feedData!![position].id,position,count,holder.edAmount.text.toString().toFloat())
            }else{
                count=1
                holder.tv_quantity.text = count.toString()
            }

        }
    }

    private fun finalCalculation(feedData: ArrayList<GetOrderFaultsData.DataBean>) {
        var finlamount = 0
        for (i in 0 until feedData.size) {
            finlamount = finlamount + feedData!![i].rowamount.toInt()
        }
        //txt.text = finlamount
        mListner.onFinalFaultAmount(finlamount)
    }

    override fun getItemCount(): Int {
        return feedData!!.size
    }

    fun calCulation(item: GetOrderFaultsData.DataBean):Int{
        var total_amount : Int = 0
        for (x in 0 until item.qty.toInt()){
            if(x == 0){
                if(!item.qty1_rate.equals("") && !item.qty1_rate.equals("0")){
                    total_amount = total_amount + item.qty1_rate.toInt()
                }else{
                    total_amount = total_amount + item.default_amount.toInt()
                }
            }else if (x == 1){
                if(!item.qty2_rate.equals("0")){
                    total_amount = total_amount + item.qty2_rate.toInt()
                }else if (item.qty2_rate.equals("0")){
                    if(!item.qty3_rate.equals("0")){
                        total_amount = total_amount + item.qty2_rate.toInt()
                    }else if(!item.qty1_rate.equals("0")){
                        total_amount = total_amount + item.qty1_rate.toInt()
                    }else{
                        total_amount = total_amount + item.default_amount.toInt()
                    }
                }
            }else if(x > 1){

                if(!item.qty3_rate.equals("") && !item.qty3_rate.equals("0")){
                    total_amount = total_amount + item.qty3_rate.toInt()
                }else if(!item.qty2_rate.equals("") && !item.qty2_rate.equals("0")){
                    total_amount = total_amount + item.qty2_rate.toInt()
                }else if(!item.qty1_rate.equals("") && !item.qty1_rate.equals("0")){
                    total_amount = total_amount + item.qty1_rate.toInt()
                }else {
                    total_amount = total_amount + item.default_amount.toInt()
                }

            }
        }
        return total_amount

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