package fragments

import Interfaces.Apicall
import Interfaces.OnResponse
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
import model.OpenLeadsData
import model.RecomplaintsListData
import utils.CustomDialogue
import utils.LocalStorage

class RecomplaintsFragments : Fragment(), OnResponse<UniverSelObjct> {

    private var recomplaintsListAdapter: RecomplaintsListAdapter? = null
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
                        recomplaintsListAdapter = RecomplaintsListAdapter(activity)
                        recyclerView!!.adapter = recomplaintsListAdapter
                        recyclerView!!.setHasFixedSize(false)
                        recomplaintsListAdapter!!.addData(recomplaintsListData.data)
                        recomplaintsListAdapter!!.notifyDataSetChanged()
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