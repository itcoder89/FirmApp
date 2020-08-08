package fragments

import Interfaces.Apicall
import Interfaces.OnResponse
import adapter.OnHoldLeadsAdapter
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
import model.OnHoldLeadsListData
import utils.CustomDialogue
import utils.LocalStorage

class OnHoldListFragments : Fragment(), OnResponse<UniverSelObjct> {

    private var onHoldLeadsAdapter: OnHoldLeadsAdapter? = null
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
            Apicall(activity!!).getOnHoldLeadsListFilter(this,"partner-on-hold", LocalStorage.getCustomerID(activity!!),"all")
        }
        tvTodayLeads!!.setOnClickListener {
            Apicall(activity!!).getOnHoldLeadsListFilter(this,"partner-on-hold", LocalStorage.getCustomerID(activity!!),"today")
        }
        tvTommorrowLeads!!.setOnClickListener {
            Apicall(activity!!).getOnHoldLeadsListFilter(this,"partner-on-hold", LocalStorage.getCustomerID(activity!!),"tomorrow")
        }
        Apicall(activity!!).getOnHoldLeadsList(this,"partner-on-hold", LocalStorage.getCustomerID(activity!!))


        layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.layoutManager = layoutManager



        return fragmentView
    }
    override fun onSucess(response: UniverSelObjct?) {
        try {
            if (response!!.status == "true") {
                when (response.methodname) {
                    "partner-on-hold" -> {
                        val onHoldLeadsListData = response.response as OnHoldLeadsListData
                        Log.e("partner-on-hold"," "+onHoldLeadsListData.isStatus+"")
                        onHoldLeadsAdapter = OnHoldLeadsAdapter(activity)
                        recyclerView!!.adapter = onHoldLeadsAdapter
                        recyclerView!!.setHasFixedSize(false)
                        onHoldLeadsAdapter!!.addData(onHoldLeadsListData.data)
                        onHoldLeadsAdapter!!.notifyDataSetChanged()
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