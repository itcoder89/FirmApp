package activity

import Interfaces.Apicall
import Interfaces.OnResponse
import adapter.*
import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kodpartner.R
import com.social.ekchat.Interfaces.UniverSelObjct
import kotlinx.android.synthetic.main.comman_top_header.*
import kotlinx.android.synthetic.main.move_to_working_layout.*
import model.GetMoreFaultsData
import model.ServiceListForRateData
import model.SubServiceData
import utils.CustomDialogue
import utils.LocalStorage

class MoveToWorking : AppCompatActivity(), OnResponse<UniverSelObjct>,AdapterView.OnItemSelectedListener {
    private var rv_fault_list: RecyclerView? = null
    private var faultListAdapter: FaultListAdapter? = null
    var city_id: String = ""
    var order_id: String = ""
    var subservice_id: String = ""
    var serviceID: String = ""
    var booking_dt: String = ""
    var subspinner: Spinner? = null
    private var layoutManager: LinearLayoutManager? = null
    private var customAdapter: CustomAdapter? = null
    private var subCustomAdapter: SubCustomAdapter? = null
    var serviceListForRateData: ServiceListForRateData? = null
    //var getMoreFaultsData: GetMoreFaultsData? = null
    var subServiceData: SubServiceData? = null
    var lst: List<ServiceListForRateData.DataBean>? = null
    var subServicelst: List<SubServiceData.DataBean>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.move_to_working_layout)
        city_id = intent.getStringExtra("city_id")
        order_id = intent.getStringExtra("service_id")
        booking_dt = intent.getStringExtra("booking_dt")

        rv_fault_list = findViewById<View>(R.id.rv_fault_list) as RecyclerView
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_fault_list!!.layoutManager = layoutManager


        faultListAdapter = FaultListAdapter(this)
        rv_fault_list!!.adapter = faultListAdapter
        rv_fault_list!!.setHasFixedSize(false)
      //  recomplaintsListAdapter!!.addData(recomplaintsListData.data)
        faultListAdapter!!.notifyDataSetChanged()
        Apicall(this)
            .getServiceListForRate(this,"partner-part-assigned-services", LocalStorage.getCustomerID(this))

        tvServiceId.text="Service ID-"+order_id
        tvBookingDateTime.text="Booking Date & Time\n"+booking_dt
        tvTitle.text="Move To Working"
        iv_back.setOnClickListener { finish() }
        tvAddMoreFault.setOnClickListener {
            customDialogBox()
        }
    }

    private var layoutManager1: LinearLayoutManager? = null
    private var recyclerView: RecyclerView? = null
    private var addFaultsAdapter: AddFaultsAdapter? = null
    fun customDialogBox() {
        val review_dialog = Dialog(
            this,
            R.style.Theme_Dialog
        )
        review_dialog.setContentView(R.layout.custom_popup_taguser_list_layout)
        review_dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        this.getWindow().setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        review_dialog.setCancelable(true)
        review_dialog.setCanceledOnTouchOutside(true)

        val spinner = review_dialog.findViewById<View>(com.kodpartner.R.id.spinner) as Spinner
        subspinner = review_dialog.findViewById<View>(com.kodpartner.R.id.subspinner) as Spinner
        recyclerView = review_dialog.findViewById<View>(R.id.recyclerView) as RecyclerView

        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.layoutManager = layoutManager


        customAdapter = CustomAdapter(
            this,
            lst,
            R.layout.view_services_item_layout
        )
        spinner.setAdapter(customAdapter)
        spinner.onItemSelectedListener = this
        // Spinner click listener
        subspinner!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
            override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                // On selecting a spinner item
                val item = parent!!.getItemAtPosition(position).toString()
                // Showing selected spinner item
                //Toast.makeText(parent.context, "Selected: $item", Toast.LENGTH_LONG).show()
                subservice_id=subServiceData!!.data[position].idsubservice
                Log.e("onItemSubSerSelected","item "+subServiceData!!.data[position].name)
                callmorefaults()


            }
        }
        review_dialog.show()
    }

    private fun callmorefaults() {
        Apicall(this)
            .getMoreFaults(this,"get-more-faults",
                LocalStorage.getCustomerID(this),serviceID,subservice_id)
    }


    override fun onSucess(response: UniverSelObjct?) {
        try {
            if (response!!.status == "true") {
                when (response.methodname) {
                    "partner-part-assigned-services" -> {
                        serviceListForRateData = response.response as ServiceListForRateData
                        Log.e("partner-part-services","size- "+serviceListForRateData!!.data.size+"")
                        lst=serviceListForRateData!!.data
                    }
                    "get-more-faults" -> {
                        val getMoreFaultsData = response.response as GetMoreFaultsData
                        Log.e("getMoreFaultsData","size- "+getMoreFaultsData!!.data.size+"")
                        addFaultsAdapter = AddFaultsAdapter(this)
                        recyclerView!!.adapter = addFaultsAdapter
                        recyclerView!!.setHasFixedSize(false)
                        addFaultsAdapter!!.addData(getMoreFaultsData.data)
                        addFaultsAdapter!!.notifyDataSetChanged()
                    }
                    "partner-sub-services" -> {
                        subServiceData = response.response as SubServiceData
                        Log.e("partner-sub-services","size- "+subServiceData!!.data.size+"")
                        subServicelst=subServiceData!!.data
                        //sub services list
                       // if(subServiceData != null) {
                        subCustomAdapter = SubCustomAdapter(
                            this,
                            subServicelst,
                            R.layout.view_services_item_layout
                        )
                        subspinner!!.setAdapter(subCustomAdapter)
                        //}
                    }
                }
            }
        }catch (e:Exception){

        }
    }

    override fun onError(error: String?) {
        CustomDialogue.showcustomblank(this!!, "Alert", error.toString())
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        val item = parent!!.getItemAtPosition(position).toString()
        Log.e("onItemServiceSelected","item "+serviceListForRateData!!.data[position].idservice)
        serviceID=serviceListForRateData!!.data[position].idservice
        Apicall(this)
            .getSubservice(this,"partner-sub-services",
                LocalStorage.getCustomerID(this),serviceListForRateData!!.data[position].idservice)
    }
}