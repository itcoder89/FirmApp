package fragments

import Interfaces.Apicall
import Interfaces.OnResponse
import adapter.CompletedLeadsAdapter
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
import model.CompletedLeadsData
import utils.CustomDialogue
import utils.LocalStorage

class CompletedLeadsFragments : Fragment(), OnResponse<UniverSelObjct> {

    private var completedLeadsAdapter: CompletedLeadsAdapter? = null
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
            Apicall(activity!!).getallCompletedLeadsFilter(this,"partner-completed", LocalStorage.getCustomerID(activity!!),"today")
        }
        tvThisMonths!!.setOnClickListener {
            Apicall(activity!!).getallCompletedLeadsFilter(this,"partner-completed", LocalStorage.getCustomerID(activity!!),"month")
        }
        Apicall(activity!!).getallCompletedLeads(this,"partner-completed", LocalStorage.getCustomerID(activity!!))


        layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.layoutManager = layoutManager



        return fragmentView
    }
    override fun onSucess(response: UniverSelObjct?) {
        try {
            if (response!!.status == "true") {
                when (response.methodname) {
                    "partner-completed" -> {
                        val completedLeadsData = response.response as CompletedLeadsData
                        Log.e("partner-completed"," "+completedLeadsData.isStatus+"")
                        completedLeadsAdapter = CompletedLeadsAdapter(activity)
                        recyclerView!!.adapter = completedLeadsAdapter
                        recyclerView!!.setHasFixedSize(false)
                        completedLeadsAdapter!!.addData(completedLeadsData.data)
                        completedLeadsAdapter!!.notifyDataSetChanged()
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