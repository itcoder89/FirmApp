package fragments

import Interfaces.Apicall
import Interfaces.ItemAdapterClick
import Interfaces.OnResponse
import adapter.NewLeadsAdapter
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kodpartner.R
import com.social.ekchat.Interfaces.UniverSelObjct
import model.AcceptLeadData
import model.NewLeadsData
import utils.CustomDialogue
import utils.LocalStorage

class NewLeadsFragments : Fragment(), OnResponse<UniverSelObjct>, ItemAdapterClick {

    private var newLeadsAdapter: NewLeadsAdapter? = null
    private var layoutManager: LinearLayoutManager? = null
    private var recyclerView: RecyclerView? = null
    var newLeadsData: NewLeadsData? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentView =
            inflater.inflate(R.layout.new_leads_list_layout, container, false)
        recyclerView = fragmentView.findViewById<View>(R.id.recyclerView) as RecyclerView
       // Apicall(activity!!).getNewLeadsData(this,"partner-newleads", LocalStorage.getCustomerID(activity!!))
        Apicall(activity!!).getNewLeadsData(this,"partner-newleads",LocalStorage.getCustomerID(activity!!))
        layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.layoutManager = layoutManager
        return fragmentView
    }

    override fun onSucess(response: UniverSelObjct?) {
        try {
            if (response!!.status == "true") {
                when (response.methodname) {
                    "partner-newleads" -> {
                        newLeadsData = response.response as NewLeadsData
                        Log.e("partner-newleads"," "+newLeadsData!!.isStatus+"")
                        newLeadsAdapter = NewLeadsAdapter(activity,this)
                        recyclerView!!.adapter = newLeadsAdapter
                        recyclerView!!.setHasFixedSize(false)
                        newLeadsAdapter!!.addData(newLeadsData!!.data)
                        newLeadsAdapter!!.notifyDataSetChanged()
                    }
                    "partner-accept-leads" -> {
                        val acceptLeadData = response!!.response as AcceptLeadData
                        Log.e("partner-openleads", " " + acceptLeadData.message)
                        Toast.makeText(activity!!,""+acceptLeadData.message, Toast.LENGTH_SHORT).show()
                        Apicall(activity!!).getNewLeadsData(this,"partner-newleads",LocalStorage.getCustomerID(activity!!))
                    }
                }
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    override fun onError(error: String?) {
        CustomDialogue.showcustomblank(activity!!, "Alert", error.toString())
    }

    override fun onClick(pos: Int) {
        Log.e("NewLeadPos",":"+pos)
        showDialoge(newLeadsData!!.data[pos].order_id,activity!!)
    }

    fun showDialoge(order_id: String,cxt: Context) {
        val dialog = Dialog(cxt)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.custom_cancel_order_popup)
        dialog.setCanceledOnTouchOutside(false)
        val tvNo = dialog.findViewById<View>(R.id.tvNo) as TextView
        val tvYesCancel =
            dialog.findViewById<View>(R.id.tvYesCancel) as TextView
        tvNo.setOnClickListener { dialog.dismiss() }
        tvYesCancel.setOnClickListener {
            Log.e("acceptOrderParam","ptnr_id: "+LocalStorage.getCustomerID(cxt)+" order_id:"+order_id)
            Apicall(cxt).acceptOrders(this,"partner-accept-leads",LocalStorage.getCustomerID(cxt),order_id)
            dialog.dismiss()
        }
        dialog.show()
    }
}