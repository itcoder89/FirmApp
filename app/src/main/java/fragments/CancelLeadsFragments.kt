package fragments

import Interfaces.Apicall
import Interfaces.OnResponse
import adapter.CancelLeadsAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kodpartner.R
import com.social.ekchat.Interfaces.UniverSelObjct
import connection.CheckNetwork
import connection.MyDialog
import model.CancelLeadsData
import utils.CustomDialogue
import utils.LocalStorage

class CancelLeadsFragments : Fragment(), OnResponse<UniverSelObjct> {

    private var cancelLeadsAdapter: CancelLeadsAdapter? = null
    private var layoutManager: LinearLayoutManager? = null
    private var recyclerView: RecyclerView? = null
    private var tvTodayLeads: TextView? = null
    private var tvThisMonths: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentView =
            inflater.inflate(R.layout.completed_leads_list_layout, container, false)
        recyclerView = fragmentView.findViewById<View>(R.id.recyclerView) as RecyclerView
        tvTodayLeads = fragmentView.findViewById<View>(R.id.tvTodayLeads) as TextView
        tvThisMonths = fragmentView.findViewById<View>(R.id.tvThisMonths) as TextView

        tvTodayLeads!!.setOnClickListener {
            Apicall(activity!!).getallCancelLeadsFilter(this,"partner-cancel", LocalStorage.getCustomerID(activity!!),"today")
        }
        tvThisMonths!!.setOnClickListener {
            Apicall(activity!!).getallCancelLeadsFilter(this,"partner-cancel", LocalStorage.getCustomerID(activity!!),"month")
        }
        if (CheckNetwork.isConnected(activity!!)) {
            Apicall(activity!!).getallCancelLeads(this,"partner-cancel", LocalStorage.getCustomerID(activity!!))
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
                    "partner-cancel" -> {
                        val cancelLeadsData = response.response as CancelLeadsData
                        Log.e("partner-completed"," "+cancelLeadsData.isStatus+"")
                        cancelLeadsAdapter = CancelLeadsAdapter(activity)
                        recyclerView!!.adapter = cancelLeadsAdapter
                        recyclerView!!.setHasFixedSize(false)
                        cancelLeadsAdapter!!.addData(cancelLeadsData.data)
                        cancelLeadsAdapter!!.notifyDataSetChanged()
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