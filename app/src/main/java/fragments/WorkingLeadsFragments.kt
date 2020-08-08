package fragments

import Interfaces.Apicall
import Interfaces.OnResponse
import adapter.WorkingLeadsAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kodpartner.R
import com.social.ekchat.Interfaces.UniverSelObjct
import model.WorkingLeadsData
import utils.CustomDialogue
import utils.LocalStorage

class WorkingLeadsFragments : Fragment(), OnResponse<UniverSelObjct> {

    private var workingLeadsAdapter: WorkingLeadsAdapter? = null
    private var layoutManager: LinearLayoutManager? = null
    private var recyclerView: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentView =
            inflater.inflate(R.layout.working_leads_list_layout, container, false)
        recyclerView = fragmentView.findViewById<View>(R.id.recyclerView) as RecyclerView

        Apicall(activity!!).getallWorkingLeads(this,"partner-working", LocalStorage.getCustomerID(activity!!))


        layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.layoutManager = layoutManager



        return fragmentView
    }
    override fun onSucess(response: UniverSelObjct?) {
        try {
            if (response!!.status == "true") {
                when (response.methodname) {
                    "partner-working" -> {
                        val workingLeadsData = response.response as WorkingLeadsData
                        Log.e("partner-working"," "+workingLeadsData.isStatus+"")
                        workingLeadsAdapter = WorkingLeadsAdapter(activity)
                        recyclerView!!.adapter = workingLeadsAdapter
                        recyclerView!!.setHasFixedSize(false)
                        workingLeadsAdapter!!.addData(workingLeadsData.data)
                        workingLeadsAdapter!!.notifyDataSetChanged()
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