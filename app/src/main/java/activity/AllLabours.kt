package activity

import Interfaces.Apicall
import Interfaces.ItemAdapterClick
import Interfaces.ItemAdapterClick2
import Interfaces.OnResponse
import adapter.AllPendingLeadsListAdapter
import adapter.LabourListAdapter
import adapter.PartLabourListAdapter
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kodpartner.R
import com.social.ekchat.Interfaces.UniverSelObjct
import kotlinx.android.synthetic.main.comman_top_header.*
import model.GetPartListByOrderIdData
import model.SaveOrderPartData
import utils.CustomDialogue
import utils.LocalStorage

class AllLabours : AppCompatActivity(), OnResponse<UniverSelObjct>, ItemAdapterClick,
    ItemAdapterClick2 {

    private var layoutManager: LinearLayoutManager? = null
    private var layoutManager1: LinearLayoutManager? = null
    private var tvViewLabour: TextView? = null
    private var tvViewPartLabour: TextView? = null
    private var recyViewLabourLIst: RecyclerView? = null
    private var recyViewPartLabourLIst: RecyclerView? = null
    var getPartListByOrderIdData: GetPartListByOrderIdData? = null

    private var partLabourListAdapter: PartLabourListAdapter? = null
    private var labourListAdapter: LabourListAdapter? = null
    var order_id=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.all_part_list_layout)
        order_id = intent.getStringExtra("order_id")
        tvViewLabour = findViewById<View>(R.id.tvViewLabour) as TextView
        tvViewPartLabour = findViewById<View>(R.id.tvViewPartLabour) as TextView
        recyViewLabourLIst = findViewById<View>(R.id.recyViewLabourLIst) as RecyclerView
        recyViewPartLabourLIst = findViewById<View>(R.id.recyViewPartLabourLIst) as RecyclerView

        Apicall(this).getPartListByOrderID(this,"get-rate-card-by-order-id",
            LocalStorage.getCustomerID(this),order_id)


        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyViewLabourLIst!!.layoutManager = layoutManager

        layoutManager1 = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyViewPartLabourLIst!!.layoutManager = layoutManager1

        tvViewLabour!!.setOnClickListener {
            recyViewLabourLIst!!.visibility=View.VISIBLE
            recyViewPartLabourLIst!!.visibility=View.GONE

        }
        tvViewPartLabour!!.setOnClickListener {
            recyViewLabourLIst!!.visibility=View.GONE
            recyViewPartLabourLIst!!.visibility=View.VISIBLE
        }
        tvTitle.text="Labour List"
        iv_back.setOnClickListener{
            finish()
        }
    }

    override fun onSucess(response: UniverSelObjct?) {
        when (response!!.methodname) {
            "get-rate-card-by-order-id" -> {
                getPartListByOrderIdData = response.response as GetPartListByOrderIdData
                Log.e("get-part-order-id", " " + getPartListByOrderIdData!!.message)
                labourListAdapter = LabourListAdapter(this,this)
                recyViewLabourLIst!!.adapter = labourListAdapter
                recyViewLabourLIst!!.setHasFixedSize(false)
                labourListAdapter!!.addData(getPartListByOrderIdData!!.data.labour)
                labourListAdapter!!.notifyDataSetChanged()

                partLabourListAdapter = PartLabourListAdapter(this,this)
                recyViewPartLabourLIst!!.adapter = partLabourListAdapter
                recyViewPartLabourLIst!!.setHasFixedSize(false)
                partLabourListAdapter!!.addData(getPartListByOrderIdData!!.data.partlabour)
                partLabourListAdapter!!.notifyDataSetChanged()
            }
            "save-order-part" -> {
                val saveOrderPartData = response.response as SaveOrderPartData
                Log.e("partner-part-services","size- "+saveOrderPartData.message)
                Toast.makeText(this,""+saveOrderPartData.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onError(error: String?) {
        CustomDialogue.showcustomblank(this, "Alert", error.toString())
    }

    override fun onClick(pos: Int) {
        Log.e("PartLabourClick","pos "+pos)
        Apicall(this).saveOrderPart(this,
            "save-order-part",
            LocalStorage.getCustomerID(this),
            order_id,
            getPartListByOrderIdData!!.data.partlabour[pos].id.toString(),
            getPartListByOrderIdData!!.data.partlabour[pos].amount)
    }

    override fun onLabourClick(pos: Int) {
        Log.e("onLabourClick","pos "+pos)
        Apicall(this).saveOrderPart(this,"save-order-part",
            LocalStorage.getCustomerID(this),
            order_id,
            getPartListByOrderIdData!!.data.labour[pos].id.toString(),
            getPartListByOrderIdData!!.data.labour[pos].labour)
    }
}