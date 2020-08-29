package fragments

import Interfaces.Apicall
import Interfaces.OnResponse
import adapter.AllPendingLeadsListAdapter
import adapter.PendingFeedbackLeadsAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kodpartner.R
import com.social.ekchat.Interfaces.UniverSelObjct
import connection.CheckNetwork
import connection.MyDialog
import model.PendingFeedbackListData
import model.PendingLeadsData
import utils.CustomDialogue
import utils.LocalStorage

class PendingFeedbackLeadsFragments : Fragment(), OnResponse<UniverSelObjct> {

    private var pendingFeedbackLeadsAdapter: PendingFeedbackLeadsAdapter? = null
    private var layoutManager: LinearLayoutManager? = null
    private var recyclerView: RecyclerView? = null
    private var tvAllLeads: TextView? = null
    private var tvTodayLeads: TextView? = null
    private var tvTommorrowLeads: TextView? = null
    private var lltopheaderview: LinearLayout?=null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentView =
            inflater.inflate(R.layout.all_pending_list_layout, container, false)
        lltopheaderview = fragmentView.findViewById<View>(R.id.lltopheaderview) as LinearLayout
        lltopheaderview!!.visibility=View.GONE
        recyclerView = fragmentView.findViewById<View>(R.id.recyclerView) as RecyclerView

        tvAllLeads = fragmentView.findViewById<View>(R.id.tvAllLeads) as TextView
        tvTodayLeads = fragmentView.findViewById<View>(R.id.tvTodayLeads) as TextView
        tvTommorrowLeads = fragmentView.findViewById<View>(R.id.tvTommorrowLeads) as TextView

        /*tvAllLeads!!.setOnClickListener {
            Apicall(activity!!).getallPendingLeadsFilter(this,"partner-all-pending-leads", LocalStorage.getCustomerID(activity!!),"today")
        }
        tvTodayLeads!!.setOnClickListener {
            Apicall(activity!!).getallPendingLeadsFilter(this,"partner-all-pending-leads", LocalStorage.getCustomerID(activity!!),"tomorrow")
        }
        tvTommorrowLeads!!.setOnClickListener {
            Apicall(activity!!).getallPendingLeadsFilter(this,"partner-all-pending-leads", LocalStorage.getCustomerID(activity!!),"all")
        }*/
        if (CheckNetwork.isConnected(activity!!)) {
            Apicall(activity!!).pendingFeedbackList(this,"partner-pending-feedback-leads", LocalStorage.getCustomerID(activity!!))
        }else{
            MyDialog(activity!!).getNoInternetDialog().show()
        }


        layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.layoutManager = layoutManager



        return fragmentView
    }
    override fun onSucess(response: UniverSelObjct?) {
        try {
            if (response!!.status == "true") {
                when (response.methodname) {
                    "partner-pending-feedback-leads" -> {
                        val pendingFeedbackListData = response.response as PendingFeedbackListData
                        Log.e("partner-openleads"," "+pendingFeedbackListData.isStatus+"")
                        pendingFeedbackLeadsAdapter = PendingFeedbackLeadsAdapter(activity)
                        recyclerView!!.adapter = pendingFeedbackLeadsAdapter
                        recyclerView!!.setHasFixedSize(false)
                        pendingFeedbackLeadsAdapter!!.addData(pendingFeedbackListData.data)
                        pendingFeedbackLeadsAdapter!!.notifyDataSetChanged()
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

}