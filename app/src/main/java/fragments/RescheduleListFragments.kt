package fragments

import Interfaces.Apicall
import Interfaces.OnResponse
import adapter.RescheduleLeadsAdapter
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
import model.RescheduleLeadsData
import utils.CustomDialogue
import utils.LocalStorage

class RescheduleListFragments : Fragment(), OnResponse<UniverSelObjct> {

    private var rescheduleLeadsAdapter: RescheduleLeadsAdapter? = null
    private var layoutManager: LinearLayoutManager? = null
    private var recyclerView: RecyclerView? = null
    private var tvAllLeads: TextView? = null
    private var tvTodayLeads: TextView? = null
    private var tvTommorrowLeads: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentView =
            inflater.inflate(R.layout.open_leads_list_layout, container, false)
        recyclerView = fragmentView.findViewById<View>(R.id.recyclerView) as RecyclerView
        tvAllLeads = fragmentView.findViewById<View>(R.id.tvAllLeads) as TextView
        tvTodayLeads = fragmentView.findViewById<View>(R.id.tvTodayLeads) as TextView
        tvTommorrowLeads = fragmentView.findViewById<View>(R.id.tvTommorrowLeads) as TextView

        tvAllLeads!!.setOnClickListener {
            Apicall(activity!!).getReschedueLeadsListFilter(this,"partner-reschedule", LocalStorage.getCustomerID(activity!!),"all")
        }
        tvTodayLeads!!.setOnClickListener {
            Apicall(activity!!).getReschedueLeadsListFilter(this,"partner-reschedule", LocalStorage.getCustomerID(activity!!),"today")
        }
        tvTommorrowLeads!!.setOnClickListener {
            Apicall(activity!!).getReschedueLeadsListFilter(this,"partner-reschedule", LocalStorage.getCustomerID(activity!!),"tomorrow")
        }
        if (CheckNetwork.isConnected(activity!!)) {
            Apicall(activity!!).getReschedueLeadsList(this,"partner-reschedule", LocalStorage.getCustomerID(activity!!))

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
                    "partner-reschedule" -> {
                        val rescheduleLeadsData = response.response as RescheduleLeadsData
                        Log.e("rescheduleLeadsData"," "+rescheduleLeadsData.isStatus+"")
                        rescheduleLeadsAdapter = RescheduleLeadsAdapter(activity)
                        recyclerView!!.adapter = rescheduleLeadsAdapter
                        recyclerView!!.setHasFixedSize(false)
                        rescheduleLeadsAdapter!!.addData(rescheduleLeadsData.data)
                        rescheduleLeadsAdapter!!.notifyDataSetChanged()
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