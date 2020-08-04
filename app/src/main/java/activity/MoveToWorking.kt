package activity

import Interfaces.Apicall
import Interfaces.OnResponse
import adapter.CustomAdapter
import adapter.FaultListAdapter
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firmapp.R
import com.social.ekchat.Interfaces.UniverSelObjct
import kotlinx.android.synthetic.main.comman_top_header.*
import kotlinx.android.synthetic.main.move_to_working_layout.*
import model.ServiceListForRateData
import utils.CustomDialogue
import utils.LocalStorage

class MoveToWorking : AppCompatActivity(), OnResponse<UniverSelObjct> {
    private var rv_fault_list: RecyclerView? = null
    private var faultListAdapter: FaultListAdapter? = null
    var city_id: String = ""
    var service_id: String = ""
    var booking_dt: String = ""
    private var layoutManager: LinearLayoutManager? = null
    private var customAdapter: CustomAdapter? = null
    var serviceListForRateData: ServiceListForRateData? = null
    var lst: List<ServiceListForRateData.DataBean>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.move_to_working_layout)
        city_id = intent.getStringExtra("city_id")
        service_id = intent.getStringExtra("service_id")
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

        tvServiceId.text="Service ID-"+service_id
        tvBookingDateTime.text="Booking Date & Time\n"+booking_dt
        tvTitle.text="Move To Working"
        iv_back.setOnClickListener { finish() }
        tvAddMoreFault.setOnClickListener {
            customDialogBox()
        }
    }


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

        val spinner = review_dialog.findViewById<View>(com.firmapp.R.id.spinner) as Spinner

        customAdapter = CustomAdapter(
            this,
            lst,
            R.layout.view_services_item_layout
        )
        spinner.setAdapter(customAdapter)

        // Spinner click listener
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                // On selecting a spinner item
                val item = parent!!.getItemAtPosition(position).toString()
                // Showing selected spinner item
                //Toast.makeText(parent.context, "Selected: $item", Toast.LENGTH_LONG).show()
                Log.e("onItemSelected","item "+serviceListForRateData!!.data[position].idservice)
            }

        }
        /*val recyclerView =
            review_dialog.findViewById<View>(R.id.recyTagUserList) as RecyclerView
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = mLayoutManager
        val companyTagUseradapter: com.vouch.adapter.UserEventsHostedListAdapter.CompanyTagUseradapter =
            com.vouch.adapter.UserEventsHostedListAdapter.CompanyTagUseradapter(
                activity,
                arrEventList.get(pos).getParticipents()
            )
        recyclerView.adapter = companyTagUseradapter*/
        review_dialog.show()
    }

    fun AllServicesGet(city_id:String){
        //Apicall(this).getSubservice(this,"subServices",city_id,""+data!!._services.id)
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
                }
            }
        }catch (e:Exception){

        }
    }

    override fun onError(error: String?) {
        CustomDialogue.showcustomblank(this!!, "Alert", error.toString())
    }
}