package activity

import Interfaces.Apicall
import Interfaces.OnResponse
import adapter.AllPendingLeadsListAdapter
import adapter.NewLeadsAdapter
import adapter.OpenLeadsAdapter
import adapter.RecomplaintsListAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firmapp.R
import com.social.ekchat.Interfaces.UniverSelObjct
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.comman_top_header.*
import kotlinx.android.synthetic.main.new_leads_list_layout.*
import model.DashboardData
import model.OpenLeadsData
import model.PendingLeadsData
import model.RecomplaintsListData
import utils.CustomDialogue
import utils.LocalStorage

class AllPendingLeadsActivity : AppCompatActivity(), OnResponse<UniverSelObjct> {

    private var allPendingLeadsListAdapter: AllPendingLeadsListAdapter? = null
    private var layoutManager: LinearLayoutManager? = null
    private var recyclerView: RecyclerView? = null
    private var tvAllLeads: TextView? = null
    private var tvTodayLeads: TextView? = null
    private var tvTommorrowLeads: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.all_pending_list_activity_layout)

        recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView

        tvAllLeads = findViewById<View>(R.id.tvAllLeads) as TextView
        tvTodayLeads = findViewById<View>(R.id.tvTodayLeads) as TextView
        tvTommorrowLeads = findViewById<View>(R.id.tvTommorrowLeads) as TextView


        tvAllLeads!!.setOnClickListener {
            Apicall(this).getallPendingLeadsFilter(this,"partner-all-pending-leads", LocalStorage.getCustomerID(this),"today")
        }
        tvTodayLeads!!.setOnClickListener {
            Apicall(this).getallPendingLeadsFilter(this,"partner-all-pending-leads", LocalStorage.getCustomerID(this),"tomorrow")
        }
        tvTommorrowLeads!!.setOnClickListener {
            Apicall(this).getallPendingLeadsFilter(this,"partner-all-pending-leads", LocalStorage.getCustomerID(this),"all")
        }

        Apicall(this).getallPendingLeads(this,"partner-all-pending-leads", LocalStorage.getCustomerID(this))

        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.layoutManager = layoutManager

        tvTitle.text="Pending Leads"
        iv_back.setOnClickListener {
            finish()
        }
    }

    override fun onSucess(response: UniverSelObjct?) {
        try {
            if (response!!.status == "true") {
                when (response.methodname) {
                    "partner-all-pending-leads" -> {
                        val pendingLeadsData = response.response as PendingLeadsData
                        Log.e("partner-openleads"," "+pendingLeadsData.isStatus+"")
                        allPendingLeadsListAdapter = AllPendingLeadsListAdapter(this)
                        recyclerView!!.adapter = allPendingLeadsListAdapter
                        recyclerView!!.setHasFixedSize(false)
                        allPendingLeadsListAdapter!!.addData(pendingLeadsData.data)
                        allPendingLeadsListAdapter!!.notifyDataSetChanged()
                    }

                }

            }
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    override fun onError(error: String?) {
        CustomDialogue.showcustomblank(this, "Alert", error.toString())
    }

}