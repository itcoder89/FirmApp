package activity

import Interfaces.*
import adapter.*
import android.app.Dialog
import android.content.Intent
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
import com.kodpartner.R
import com.social.ekchat.Interfaces.UniverSelObjct
import kotlinx.android.synthetic.main.comman_top_header.*
import kotlinx.android.synthetic.main.move_to_working_layout.*
import model.*
import utils.CustomDialogue
import utils.LocalStorage

class MoveToWorking : AppCompatActivity(), OnResponse<UniverSelObjct>,
    AdapterView.OnItemSelectedListener, ItemAdapterClick, ItemFaultAdapterClick,
    ItemLabourAdapterClick {
    private var rv_part_list: RecyclerView? = null
    private var rv_fault_list: RecyclerView? = null
    private var faultListAdapter: FaultListAdapter? = null
    private var savedLabourListAdapter: SavedLabourListAdapter? = null
    var city_id: String = ""
    var order_id: String = ""
    var subservice_id: String = ""
    var serviceID: String = ""
    var booking_dt: String = ""
    var subspinner: Spinner? = null
    private var layoutManager: LinearLayoutManager? = null
    private var layoutManager2: LinearLayoutManager? = null
    private var customAdapter: CustomAdapter? = null
    private var subCustomAdapter: SubCustomAdapter? = null
    var serviceListForRateData: ServiceListForRateData? = null
    var getOrderFaultsData: GetOrderFaultsData? = null
    var getAllSelectedPartListData: GetAllSelectedPartListData? = null
    var subServiceData: SubServiceData? = null
    var getMoreFaultsData: GetMoreFaultsData? = null
    var lst: List<ServiceListForRateData.DataBean>? = null
    var subServicelst: List<SubServiceData.DataBean>? = null
    var count=0


    override fun onResume() {
        super.onResume()
        Apicall(this).getOrderFaults(this,"get-order-faults", LocalStorage.getCustomerID(this),order_id)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.move_to_working_layout)
        city_id = intent.getStringExtra("city_id")
        order_id = intent.getStringExtra("service_id")
        booking_dt = intent.getStringExtra("booking_dt")

        rv_part_list = findViewById<View>(R.id.rv_part_list) as RecyclerView
        rv_fault_list = findViewById<View>(R.id.rv_fault_list) as RecyclerView

        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_fault_list!!.layoutManager = layoutManager

        layoutManager2 = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_part_list!!.layoutManager = layoutManager2


        tvServiceId.text="Service ID-"+order_id
        tvBookingDateTime.text="Booking Date & Time\n"+booking_dt
        tvTitle.text="Move To Working"
        iv_back.setOnClickListener { finish() }
        tvAddPart.setOnClickListener {
            val intent = Intent(this, AllLabours::class.java)
            intent.putExtra("order_id",order_id)
            startActivity(intent)
        }
        tvAddMoreFault.setOnClickListener {
            Apicall(this)
                .getServiceListForRate(this,"partner-part-assigned-services", LocalStorage.getCustomerID(this))
        }
        btnSubmitOrder.setOnClickListener {
            callSubmitAPI()

        }
    }

    private fun callSubmitAPI() {

        Toast.makeText(this,"final submit"+
                "Order Id "+order_id+
                " Total Fault "+tvFaultTotalAmount.text.toString()+
                " Total Part "+tvPartTotalAmount.text.toString()+
                " Total Estimate "+tvTotalEstimateAmount.text.toString(),
            Toast.LENGTH_SHORT).show()
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
                    "get-order-faults" -> {
                        getOrderFaultsData = response.response as GetOrderFaultsData
                        Log.e("get-order-faults","size- "+getOrderFaultsData!!.message)
                        //Toast.makeText(this,""+getOrderFaultsData.message,Toast.LENGTH_SHORT).show()
                        faultListAdapter = FaultListAdapter(this,this)
                        rv_fault_list!!.adapter = faultListAdapter
                        rv_fault_list!!.setHasFixedSize(false)
                        faultListAdapter!!.addData(getOrderFaultsData!!.data)
                        faultListAdapter!!.notifyDataSetChanged()
                        var sum=0
                        for (i in 0 until getOrderFaultsData!!.data.size) {
                            sum=sum+getOrderFaultsData!!.data[i].amount.toInt()
                        }
                        tvFaultTotalAmount.text=sum.toString()
                        Apicall(this)
                            .getOrderPartList(this,"get-order-part", LocalStorage.getCustomerID(this),order_id)
                    }
                    "get-order-part" -> {
                        getAllSelectedPartListData = response.response as GetAllSelectedPartListData
                        Log.e("get-order-part","size- "+getAllSelectedPartListData!!.message)
                        //Toast.makeText(this,""+getOrderFaultsData.message,Toast.LENGTH_SHORT).show()
                        savedLabourListAdapter = SavedLabourListAdapter(this,this)
                        rv_part_list!!.adapter = savedLabourListAdapter
                        rv_part_list!!.setHasFixedSize(false)
                        savedLabourListAdapter!!.addData(getAllSelectedPartListData!!.data)
                        savedLabourListAdapter!!.notifyDataSetChanged()

                        var sum2=0
                        for (i in 0 until getAllSelectedPartListData!!.data.size) {
                            sum2=sum2+getAllSelectedPartListData!!.data[i].amount.toInt()
                        }
                        tvPartTotalAmount.text=sum2.toString()
                        //tvTotalEstimateAmount.text = "Total Estimate Amount "+(tvFaultTotalAmount.text.toString().toInt() + tvPartTotalAmount.text.toString().toInt()).toString()+"/-"
                        tvTotalEstimateAmount.text =(tvFaultTotalAmount.text.toString().toFloat() + tvPartTotalAmount.text.toString().toFloat()).toString()
                    }
                    "add-more-faults-inorder" -> {
                        val addFaultSuccessData = response.response as AddFaultSuccessData
                        Log.e("partner-part-services","size- "+addFaultSuccessData.message)
                        Toast.makeText(this,""+addFaultSuccessData.message,Toast.LENGTH_SHORT).show()
                    }
                    "partner-part-assigned-services" -> {
                        serviceListForRateData = response.response as ServiceListForRateData
                        Log.e("partner-part-services","size- "+serviceListForRateData!!.data.size+"")
                        lst=serviceListForRateData!!.data
                        customDialogBox()
                    }
                    "get-more-faults" -> {
                        getMoreFaultsData = response.response as GetMoreFaultsData
                        Log.e("getMoreFaultsData","size- "+getMoreFaultsData!!.data.size+"")
                        addFaultsAdapter = AddFaultsAdapter(this,this)
                        recyclerView!!.adapter = addFaultsAdapter
                        recyclerView!!.setHasFixedSize(false)
                        addFaultsAdapter!!.addData(getMoreFaultsData!!.data)
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

    override fun onClick(pos: Int) {
        var count = 0
        Apicall(this)
            .addFaultSuccess(this,
                "add-more-faults-inorder",
                LocalStorage.getCustomerID(this),
                order_id,
                getMoreFaultsData!!.data[pos].id.toString(),
                getMoreFaultsData!!.data[pos].fault_rate.toString(),
                getMoreFaultsData!!.data[pos].fault_rate.toString(),
                1,
                getMoreFaultsData!!.data[pos].name
            )

    }

    override fun onPlusClick(pos: Int, quantity: Int,total_amount:Float) {
        //count = quantity
       // count++
        Log.e("onPlusClick","pos "+pos + "qty "+count)
        var lastsum=tvFaultTotalAmount.text.toString()
        tvFaultTotalAmount.text=""+(total_amount + lastsum.toFloat()).toString()

        //update final estimate amount
        tvTotalEstimateAmount.text =(tvFaultTotalAmount.text.toString().toFloat() + tvPartTotalAmount.text.toString().toFloat()).toString()
    }

    override fun onMinusClick(pos: Int, quantity: Int,total_amount:Float) {
        //count = quantity
        //count--
        Log.e("onMinusClick","pos "+pos + "qty "+quantity)
        var lastsum=tvFaultTotalAmount.text.toString()
        tvFaultTotalAmount.text=""+(lastsum.toFloat() - total_amount).toString()

        //update final estimate amount
        tvTotalEstimateAmount.text =(tvFaultTotalAmount.text.toString().toFloat() + tvPartTotalAmount.text.toString().toFloat()).toString()
    }

    override fun onPlusPartItemClick(pos: Int, quantity: Int,total_amount:Float) {
        var lastsum=tvPartTotalAmount.text.toString()
        tvPartTotalAmount.text=""+(total_amount + lastsum.toFloat()).toString()

        tvTotalEstimateAmount.text =(tvFaultTotalAmount.text.toString().toFloat() + tvPartTotalAmount.text.toString().toFloat()).toString()
    }

    override fun onMinusPartItemClick(pos: Int, quantity: Int,total_amount:Float) {
        Log.e("onMinusClick","pos "+pos + "qty "+quantity)
        var lastsum=tvPartTotalAmount.text.toString()
        tvPartTotalAmount.text=""+(lastsum.toFloat() - total_amount).toString()

        tvTotalEstimateAmount.text =(tvFaultTotalAmount.text.toString().toFloat() + tvPartTotalAmount.text.toString().toFloat()).toString()
    }
}