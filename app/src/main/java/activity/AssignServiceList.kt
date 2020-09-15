package activity

import Interfaces.Apicall
import Interfaces.OnResponse
import adapter.AssignedServiceListAdapter
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kodpartner.R
import com.social.ekchat.Interfaces.UniverSelObjct
import kotlinx.android.synthetic.main.comman_top_header.*
import model.AssignedServiceListData
import utils.CustomDialogue
import utils.LocalStorage

class AssignServiceList : AppCompatActivity(), OnResponse<UniverSelObjct> {

    private var layoutManager: LinearLayoutManager? = null
    private var recyclerView: RecyclerView? = null
    private var assignedServiceListAdapter: AssignedServiceListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_layout)

        recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView

        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.layoutManager = layoutManager

        tvTitle.text="Assigned Services"

        iv_back.setOnClickListener {
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        Apicall(this).partner_services_ver1(this,"partner_services_ver1", LocalStorage.getCustomerID(this))

    }
    override fun onSucess(response: UniverSelObjct?) {
        try {
            when (response!!.methodname) {
                "partner_services_ver1" -> {
                    val assignedServiceListData = response!!.response as AssignedServiceListData
                    Log.e("assignedlist"," "+assignedServiceListData.isStatus)
                    assignedServiceListAdapter = AssignedServiceListAdapter(this)
                    recyclerView!!.adapter = assignedServiceListAdapter
                    recyclerView!!.setHasFixedSize(false)
                    assignedServiceListAdapter!!.addData(assignedServiceListData.data)
                    assignedServiceListAdapter!!.notifyDataSetChanged()
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