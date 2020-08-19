package fragments

import Interfaces.Apicall
import Interfaces.ItemAdapterClick
import Interfaces.OnResponse
import adapter.RecomplaintsListAdapter
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
import model.CloseByPartnerData
import model.RecomplaintsListData
import utils.CustomDialogue
import utils.LocalStorage

class RecomplaintsFragments : Fragment(), OnResponse<UniverSelObjct>, ItemAdapterClick {

    private var recomplaintsListAdapter: RecomplaintsListAdapter? = null
    private var layoutManager: LinearLayoutManager? = null
    private var recyclerView: RecyclerView? = null
    var recomplaintsListData: RecomplaintsListData? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentView =
            inflater.inflate(R.layout.recomplaints_list_layout, container, false)
        recyclerView = fragmentView.findViewById<View>(R.id.recyclerView) as RecyclerView

        Apicall(activity!!).getRecomplaintsData(this,"partner-recomplaint", LocalStorage.getCustomerID(activity!!))


        layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.layoutManager = layoutManager



        return fragmentView
    }
    override fun onSucess(response: UniverSelObjct?) {
        try {
            if (response!!.status == "true") {
                when (response.methodname) {
                    "partner-recomplaint" -> {
                        val recomplaintsListData = response.response as RecomplaintsListData
                        Log.e("partner-openleads"," "+recomplaintsListData.isStatus+"")
                        recomplaintsListAdapter = RecomplaintsListAdapter(activity,this)
                        recyclerView!!.adapter = recomplaintsListAdapter
                        recyclerView!!.setHasFixedSize(false)
                        recomplaintsListAdapter!!.addData(recomplaintsListData.data)
                        recomplaintsListAdapter!!.notifyDataSetChanged()
                    }
                    "close-by-partner" -> {
                        val closeByPartnerData = response!!.response as CloseByPartnerData
                        Log.e("closeByPartnerData", " " + closeByPartnerData.message)
                        Toast.makeText(activity!!,""+closeByPartnerData.message, Toast.LENGTH_SHORT).show()
                        Apicall(activity!!).getRecomplaintsData(this,"partner-recomplaint", LocalStorage.getCustomerID(activity!!))
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

    override fun onClick(pos: Int) {
        showDialoge(recomplaintsListData!!.data[pos].order_id,activity!!)
    }

}