package fragments

import Interfaces.Apicall
import Interfaces.OnResponse
import adapter.ExpertListAdapter
import adapter.NewLeadsAdapter
import adapter.OpenLeadsAdapter
import adapter.RecomplaintsListAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firmapp.R
import com.social.ekchat.Interfaces.UniverSelObjct
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.new_leads_list_layout.*
import model.DashboardData
import model.ExpertListData
import model.OpenLeadsData
import model.RecomplaintsListData
import utils.CustomDialogue
import utils.LocalStorage

class ExpertListFragments : Fragment(), OnResponse<UniverSelObjct> {

    private var expertListAdapter: ExpertListAdapter? = null
    private var layoutManager: LinearLayoutManager? = null
    private var recyclerView: RecyclerView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentView =
            inflater.inflate(R.layout.recomplaints_list_layout, container, false)
        recyclerView = fragmentView.findViewById<View>(R.id.recyclerView) as RecyclerView

        Apicall(activity!!).getExpertList(this,"get-partner-expert", LocalStorage.getCustomerID(activity!!))


        layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.layoutManager = layoutManager



        return fragmentView
    }
    override fun onSucess(response: UniverSelObjct?) {
        try {
            if (response!!.status == "true") {
                when (response.methodname) {
                    "get-partner-expert" -> {
                        val expertListData = response.response as ExpertListData
                        Log.e("partner-openleads"," "+expertListData.isStatus+"")
                        expertListAdapter = ExpertListAdapter(activity)
                        recyclerView!!.adapter = expertListAdapter
                        recyclerView!!.setHasFixedSize(false)
                        expertListAdapter!!.addData(expertListData.data)
                        expertListAdapter!!.notifyDataSetChanged()
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