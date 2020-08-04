package fragments

import Interfaces.Apicall
import Interfaces.OnResponse
import adapter.NewLeadsAdapter
import adapter.OpenLeadsAdapter
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
import kotlinx.android.synthetic.main.new_leads_list_layout.*
import model.NewLeadsData
import model.OpenLeadsData
import utils.CustomDialogue
import utils.LocalStorage

class NewLeadsFragments : Fragment(), OnResponse<UniverSelObjct> {

    private var newLeadsAdapter: NewLeadsAdapter? = null
    private var layoutManager: LinearLayoutManager? = null
    private var recyclerView: RecyclerView? = null
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
                        val newLeadsData = response.response as NewLeadsData
                        Log.e("partner-newleads"," "+newLeadsData.isStatus+"")
                        newLeadsAdapter = NewLeadsAdapter(activity)
                        recyclerView!!.adapter = newLeadsAdapter
                        recyclerView!!.setHasFixedSize(false)
                        newLeadsAdapter!!.addData(newLeadsData.data)
                        newLeadsAdapter!!.notifyDataSetChanged()
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