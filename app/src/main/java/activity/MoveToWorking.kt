package activity

import Interfaces.*
import adapter.*
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kodpartner.DashboardActivity
import com.kodpartner.R
import com.social.ekchat.Interfaces.UniverSelObjct
import kotlinx.android.synthetic.main.comman_top_header.*
import kotlinx.android.synthetic.main.custom_close_popup.*
import kotlinx.android.synthetic.main.move_to_working_layout.*
import model.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import retrofit.AppGlobal
import utils.CustomDialogue
import utils.LocalStorage
import java.util.*

class MoveToWorking : AppCompatActivity(), OnResponse<UniverSelObjct>,
    AdapterView.OnItemSelectedListener, ItemAdapterClick, ItemFaultAdapterClick,
    ItemLabourAdapterClick {
    private var rv_part_list: RecyclerView? = null
    private var rv_fault_list: RecyclerView? = null
    private var faultListAdapter: FaultListAdapter? = null
    private var savedLabourListAdapter: SavedLabourListAdapter? = null
    var received_otp: String = ""
    var city_id: String = ""
    var order_id: String = ""
    var subservice_id: String = ""
    var serviceID: String = ""
    var booking_dt: String = ""
    var extraAmount: Float = 0f
    var extraReason: String = ""
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
    var faultlist: List<GetOrderFaultsData.DataBean>? = null//working fault list
    var partlist: List<GetAllSelectedPartListData.DataBean>? = null//working fault list
    var strPaymentType = ""
    var isTouched = false
    var isOfficeTouched = false
    var sum=0f
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
        if (intent.hasExtra("extra_amount"))
            extraAmount = intent.getFloatExtra("extra_amount",0f)
        if (intent.hasExtra("reason"))
            //if(intent.hasExtra("reason") != null)
            //{
                //do here
                extraReason = intent.getStringExtra("reason")
                //values = if (intent.getStringExtra("values")==null) "" else intent.getStringExtra("values")
            ////}


        rv_part_list = findViewById<View>(R.id.rv_part_list) as RecyclerView
        rv_fault_list = findViewById<View>(R.id.rv_fault_list) as RecyclerView

        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_fault_list!!.layoutManager = layoutManager

        layoutManager2 = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_part_list!!.layoutManager = layoutManager2



        if(!extraReason.isNullOrEmpty())
            edEnterReason.setText(extraReason)

        tvServiceId.text="Service ID-"+order_id
        tvBookingDateTime.text="Booking Date & Time\n"+booking_dt
        tvTitle.text="Move To Working"
        iv_back.setOnClickListener { finish() }
        tvAddPart.visibility=View.GONE
        /*
        tvAddPart.setOnClickListener {
            val intent = Intent(this, AllLabours::class.java)
            intent.putExtra("order_id",order_id)
            startActivity(intent)
        }*/
        btnReSendOTP.setOnClickListener {
            if(!received_otp.isNullOrBlank())
                showDialoge(received_otp,this)
            else
                AppGlobal.showToast(this,"OTP not received")
        }
        tvAddMoreFault.setOnClickListener {
            Apicall(this)
                .getServiceListForRate(this,"partner-part-assigned-services", LocalStorage.getCustomerID(this))
        }


        edEnterExtraCharge.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence,
                start: Int,
                before: Int,
                count: Int
            ) {
            }

            override fun afterTextChanged(s: Editable) {
                if (!TextUtils.isEmpty(s)) {
                    sum=edEnterEstimate.text.toString().toFloat()+s.toString().toFloat()
                    tvGrandTotal.text="Grand Total: "+sum.toString()
                    edEnterEstimate.setText(tvGrandTotal.text.toString())
                }else{
                    tvGrandTotal.text="Grand Total: "+edEnterEstimate.text.toString()
                    edEnterEstimate.setText(tvGrandTotal.text.toString())
                }
            }
        })
        btnSubmitOrder.setOnClickListener {
           // Log.e("finalcalculation","sum:"+(edEnterEstimate.text.toString().toFloat()+edEnterExtraCharge.text.toString().toFloat()).toString())
            //Log.e("finalcalculation","extra:"+edEnterExtraCharge.text.toString().trim())
            //Log.e("finalcalculation","reason:"+edEnterReason.text.toString().trim())

            Apicall(this)
                .sendEstimateValue(this,"send-order-estimate",
                    LocalStorage.getCustomerID(this),
                    order_id,
                    (edEnterEstimate.text.toString().toFloat()+edEnterExtraCharge.text.toString().toFloat()).toString(),
                    edEnterExtraCharge.text.toString().trim(),
                    edEnterReason.text.toString().trim())
        }
    }


    private fun callSubmitAPI() {
        //fault list json prepare
        Log.e("arrCartCount", "on-plus-size:" + faultlist!!.size)
        val jsonArray = JSONArray()
        for (i in faultlist!!.indices) {
            val student1 = JSONObject()
            try {
                student1.put("id", faultlist!!.get(i).idfault)
                student1.put("amount", faultlist!!.get(i).rowamount)
                student1.put("quantity", faultlist!!.get(i).qty)
            } catch (e: JSONException) {
                // TODO Auto-generated catch block
                e.printStackTrace()
            }
            jsonArray.put(student1)
        }
        Log.e("JSONArray", "arr:$jsonArray")

        //prepare part json array list

        Log.e("arrCartCount", "on-plus-size:" + partlist!!.size)
        val jsonArray2 = JSONArray()
        for (i in partlist!!.indices) {
            val student1 = JSONObject()
            try {
                student1.put("id", partlist!!.get(i).idpart)
                student1.put("amount", partlist!!.get(i).row_amount)
                student1.put("quantity", partlist!!.get(i).qty)
            } catch (e: JSONException) {
                // TODO Auto-generated catch block
                e.printStackTrace()
            }
            jsonArray2.put(student1)
        }
        Log.e("jsonArray2", "arr:$jsonArray2")


        var mainjsonOBj = JSONObject()

        mainjsonOBj.put("partner_id",LocalStorage.getCustomerID(this))
        mainjsonOBj.put("order_id", order_id)
        mainjsonOBj.put("total_fault",tvFaultTotalAmount.text.toString())
        mainjsonOBj.put("total_part", tvPartTotalAmount.text.toString())
        mainjsonOBj.put("total_estimate",tvTotalEstimateAmount.text.toString())
        mainjsonOBj.put("fault_list",jsonArray)
        mainjsonOBj.put("part_list",jsonArray2)
        Log.e("CreateOrderRequest",mainjsonOBj.toString())

        Apicall(this).placeOrder(this,"save-complete-work",mainjsonOBj.toString())

        /*Toast.makeText(this,"final submit"+
                "Order Id "+order_id+
                " Total Fault "+tvFaultTotalAmount.text.toString()+
                " Total Part "+tvPartTotalAmount.text.toString()+
                " Total Estimate "+tvTotalEstimateAmount.text.toString(),
            Toast.LENGTH_SHORT).show()*/
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
                        faultlist=getOrderFaultsData!!.data
                        faultListAdapter = FaultListAdapter(this,this)
                        rv_fault_list!!.adapter = faultListAdapter
                        rv_fault_list!!.setHasFixedSize(false)
                        faultListAdapter!!.addData(getOrderFaultsData!!.data)
                        faultListAdapter!!.notifyDataSetChanged()


                        var sum=0
                        for (i in 0 until getOrderFaultsData!!.data.size) {
                            var amount =calCulation(getOrderFaultsData!!.data[i])
                            getOrderFaultsData!!.data[i].rowamount = ""+amount
                            //getOrderFaultsData!!.data[i].idfault = ""+amount
                            //sum=sum+getOrderFaultsData!!.data[i].amount.toInt()
                        }
                        tvFaultTotalAmount.text=""+finalCalculation(getOrderFaultsData!!.data!!)
//                        tvFaultTotalAmount.text=sum.toString()
                        Apicall(this)
                            .getOrderPartList(this,"get-order-part", LocalStorage.getCustomerID(this),order_id)
                    }
                    "get-order-part" -> {
                        getAllSelectedPartListData = response.response as GetAllSelectedPartListData
                        Log.e("get-order-part","size- "+getAllSelectedPartListData!!.message)
                        //Toast.makeText(this,""+getOrderFaultsData.message,Toast.LENGTH_SHORT).show()
                        partlist=getAllSelectedPartListData!!.data
                        savedLabourListAdapter = SavedLabourListAdapter(this,this)
                        rv_part_list!!.adapter = savedLabourListAdapter
                        rv_part_list!!.setHasFixedSize(false)
                        savedLabourListAdapter!!.addData(getAllSelectedPartListData!!.data)
                        savedLabourListAdapter!!.notifyDataSetChanged()

                        var sum2=0
                        for (i in 0 until getAllSelectedPartListData!!.data.size) {

                            sum2=sum2+getAllSelectedPartListData!!.data[i].amount.toInt()
                         //   getAllSelectedPartListData!!.data[i].row_amount = ""+sum2
                        }
                        tvPartTotalAmount.text=sum2.toString()
                        //tvTotalEstimateAmount.text = "Total Estimate Amount "+(tvFaultTotalAmount.text.toString().toInt() + tvPartTotalAmount.text.toString().toInt()).toString()+"/-"
                        tvTotalEstimateAmount.text =(tvFaultTotalAmount.text.toString().toFloat() + tvPartTotalAmount.text.toString().toFloat()).toString()
                        edEnterEstimate.setText(tvTotalEstimateAmount.text.toString().trim())

                        if(!extraAmount.toString().isNullOrEmpty()) {
                            edEnterExtraCharge.setText(extraAmount.toString())
                            tvGrandTotal.text="Grand Total: "+(edEnterEstimate.text.toString().toFloat()+edEnterExtraCharge.text.toString().toFloat()).toString()
                        }
                    }
                    "remove-order-part" -> {
                        val removeOrderPartData = response.response as RemoveOrderPartData
                        Log.e("remove-order-part","size- "+removeOrderPartData.message)
                        //Toast.makeText(this,""+removeOrderPartData.message,Toast.LENGTH_SHORT).show()
                        if(removeOrderPartData.isStatus == true)
                            Apicall(this).getOrderFaults(this,"get-order-faults", LocalStorage.getCustomerID(this),order_id)
                        else
                            Toast.makeText(this,""+removeOrderPartData.message,Toast.LENGTH_SHORT).show()
                    }
                    "remove-order-faults" -> {
                        val removeOrderFaultData = response.response as RemoveOrderFaultData
                        Log.e("remove-order-faults","size- "+removeOrderFaultData.message)
                        if(removeOrderFaultData.isStatus == true)
                            Apicall(this).getOrderFaults(this,"get-order-faults", LocalStorage.getCustomerID(this),order_id)
                        else
                            Toast.makeText(this,""+removeOrderFaultData.message,Toast.LENGTH_SHORT).show()
                    }
                    "add-more-faults-inorder" -> {
                        val addFaultSuccessData = response.response as AddFaultSuccessData
                        Log.e("partner-part-services","size- "+addFaultSuccessData.message)
                        Toast.makeText(this,""+addFaultSuccessData.message,Toast.LENGTH_SHORT).show()
                    }
                    "send-order-estimate" -> {
                        val estimateSentData = response.response as EstimateSentData
                        Log.e("send-order-estimate","size- "+estimateSentData.message)
                        Log.e("send-order-estimate","received_otp "+estimateSentData.data.otp)
                        Toast.makeText(this,""+estimateSentData.message,Toast.LENGTH_SHORT).show()
                        if(estimateSentData.isStatus == true)
                            btnReSendOTP.visibility=View.VISIBLE
                        else
                            btnReSendOTP.visibility=View.GONE

                        received_otp=estimateSentData.data.otp.toString()
                    }
                    "save-complete-work" -> {
                        val orderPlaceData = response.response as OrderPlaceData
                        Log.e("save-complete-work","size- "+orderPlaceData.message)
                        Toast.makeText(this,""+orderPlaceData.message,Toast.LENGTH_SHORT).show()
                        //showCloseDialoge(order_id,this)
                        startActivity(Intent(this, DashboardActivity::class.java))
                        finish()
                    }
                    "closed-partner-booking" -> {
                        val workCloseData = response.response as WorkCloseData
                        Log.e("closed-partner-booking","size- "+workCloseData.message)
                        Toast.makeText(this,""+workCloseData.message,Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, DashboardActivity::class.java))
                        finish()
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

    override fun onPlusClick(faultid: Int,pos: Int, quantity: Int,total_amount:Float) {
        Log.e("onPlusClick","pos "+pos + "qty "+quantity +" faultid "+faultid)
        var flag = false
        var lastsum=tvFaultTotalAmount.text.toString()
        tvFaultTotalAmount.text=""+(total_amount)
        //update final estimate amount
        tvTotalEstimateAmount.text =(tvFaultTotalAmount.text.toString().toFloat() + tvPartTotalAmount.text.toString().toFloat()).toString()
        edEnterEstimate.setText(tvTotalEstimateAmount.text.toString().trim())
        for (i in 0 until faultlist!!.size) {
            if(faultlist!![i].idfault.toInt() == faultid) {
                faultlist!![i].qty=quantity.toString()
            }
        }
        Log.e("arrCartCount", "on-plus-size:" + faultlist!!.size)
    }

    override fun onMinusClick(faultid: Int,pos: Int, quantity: Int,total_amount:Float) {
        Log.e("onMinusClick","pos "+pos + "qty "+quantity)
        var lastsum=tvFaultTotalAmount.text.toString()
        tvFaultTotalAmount.text=""+(total_amount).toString()
        //update final estimate amount
        tvTotalEstimateAmount.text =(tvFaultTotalAmount.text.toString().toFloat() + tvPartTotalAmount.text.toString().toFloat()).toString()
        edEnterEstimate.setText(tvTotalEstimateAmount.text.toString().trim())
        for (i in 0 until faultlist!!.size) {
            if(faultlist!![i].idfault.toInt() == faultid) {
                faultlist!![i].qty=quantity.toString()
            }
        }
        Log.e("arrCartCount", "on-minus-size:" + faultlist!!.size)
    }

    override fun onRemoveItemClick(id: Int) {
        showRemoveItemDialoge(id,this,"falut")
    }

    override fun onFinalFaultAmount(amnt: Int) {
        tvFaultTotalAmount.text=""+(amnt )
        tvTotalEstimateAmount.text =(tvFaultTotalAmount.text.toString().toFloat() + tvPartTotalAmount.text.toString().toFloat()).toString()
        edEnterEstimate.setText(tvTotalEstimateAmount.text.toString().trim())
    }

    override fun onFinalPartAmount(amnt: Int) {
        tvPartTotalAmount.text=""+(amnt )
        tvTotalEstimateAmount.text =(tvFaultTotalAmount.text.toString().toFloat() + tvPartTotalAmount.text.toString().toFloat()).toString()
        edEnterEstimate.setText(tvTotalEstimateAmount.text.toString().trim())
        tvGrandTotal.text="Grand Total: "+(edEnterEstimate.text.toString().toFloat()+edEnterExtraCharge.text.toString().toFloat()).toString()

    }

    override fun onPlusPartItemClick(partid: Int,pos: Int, quantity: Int,total_amount:Float) {
        var lastsum=tvPartTotalAmount.text.toString()
        tvPartTotalAmount.text=""+(total_amount)
        tvTotalEstimateAmount.text =(tvFaultTotalAmount.text.toString().toFloat() + tvPartTotalAmount.text.toString().toFloat()).toString()
        edEnterEstimate.setText(tvTotalEstimateAmount.text.toString().trim())
        for (i in 0 until partlist!!.size) {
            if(partlist!![i].idpart.toInt() == partid) {
                partlist!![i].qty=quantity.toString()
            }
        }
        Log.e("arrCartCount", "on-plus-size:" + partlist!!.size)
    }

    override fun onMinusPartItemClick(partid: Int,pos: Int, quantity: Int,total_amount:Float) {
        Log.e("onMinusClick","pos "+pos + "qty "+quantity)
        var lastsum=tvPartTotalAmount.text.toString()
        tvPartTotalAmount.text=""+(total_amount).toString()
        tvTotalEstimateAmount.text =(tvFaultTotalAmount.text.toString().toFloat() + tvPartTotalAmount.text.toString().toFloat()).toString()
        edEnterEstimate.setText(tvTotalEstimateAmount.text.toString().trim())
        for (i in 0 until partlist!!.size) {
            if(partlist!![i].idpart.toInt() == partid) {
                partlist!![i].qty=quantity.toString()
            }
        }
        Log.e("arrCartCount", "on-minus-size:" + partlist!!.size)
    }

    override fun onRemmovePartItemClick(id: Int) {
        showRemoveItemDialoge(id,this,"part")
    }

    fun showDialoge(cust_otp: String,cxt: Context) {
        val dialog = Dialog(cxt)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.custom_resend_otp_popup)
        dialog.setCanceledOnTouchOutside(false)
        val edEnterCustomerOTP = dialog.findViewById<View>(R.id.edEnterCustomerOTP) as EditText
        val tvNo = dialog.findViewById<View>(R.id.tvNo) as TextView
        val tvYesCancel =
            dialog.findViewById<View>(R.id.tvYesCancel) as TextView
        tvNo.setOnClickListener { dialog.dismiss() }
        tvYesCancel.setOnClickListener {
            if(edEnterCustomerOTP.text.toString().equals(cust_otp)) {
                callSubmitAPI()
            }/*else if(){

            }*/else {
                Toast.makeText(this, "Invalid OTP Entered!", Toast.LENGTH_SHORT).show()
            }
            dialog.dismiss()
        }
        dialog.show()
    }

    fun showCloseDialoge(order_id: String,cxt: Context)

    {
        val dialog = Dialog(cxt)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.custom_close_popup)
        dialog.setCanceledOnTouchOutside(false)
        val edEnterCustomerOTP = dialog.findViewById<View>(R.id.edEnterCustomerOTP) as EditText
        val tvNo = dialog.findViewById<View>(R.id.tvNo) as TextView
        val tvYesCancel =  dialog.findViewById<View>(R.id.tvYesCancel) as TextView
        val swtHome =  dialog.findViewById<View>(R.id.swtHome) as SwitchCompat
        val swtOffice =  dialog.findViewById<View>(R.id.swtOffice) as SwitchCompat

        swtHome.setOnTouchListener(View.OnTouchListener { view, motionEvent ->
            isTouched = true
            false
        })
        swtHome.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isTouched) {
                isTouched = false
                if (isChecked) {
                    strPaymentType = "COD"
                    swtOffice.setChecked(false)
                } else {
                    //sch_homedelivery.setChecked(true)
                }
            }
        })
        swtOffice.setOnTouchListener(View.OnTouchListener { view, motionEvent ->
            isOfficeTouched = true
            false
        })
        swtOffice.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isOfficeTouched) {
                isOfficeTouched = false
                if (isChecked) {
                    strPaymentType = "Online"
                    swtHome.setChecked(false)
                } else {
                    //sch_homedelivery.setChecked(true)
                }
            }
        })

        tvNo.setOnClickListener { dialog.dismiss() }
        tvYesCancel.setOnClickListener {
            if(edEnterCustomerOTP.text.toString().equals("Please enter received amount")){
                AppGlobal.showToast(this,"")
            }else if(strPaymentType.equals("")){
                AppGlobal.showToast(this,"Please select payment mode")
            }else{
                Apicall(cxt)
                    .workClose(this,"closed-partner-booking",
                        LocalStorage.getCustomerID(this),
                        order_id,
                        edEnterCustomerOTP.text.toString(),
                        strPaymentType
                    )
            }
            dialog.dismiss()
        }
        dialog.show()
    }



    //Remove Item From List Dialoge
    fun showRemoveItemDialoge(_id: Int,cxt: Context,type:String) {
        val dialog = Dialog(cxt)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.custom_remove_popup)
        dialog.setCanceledOnTouchOutside(false)
        val tvNo = dialog.findViewById<View>(R.id.tvNo) as TextView
        val tvYesCancel =
            dialog.findViewById<View>(R.id.tvYesCancel) as TextView
        tvNo.setOnClickListener { dialog.dismiss() }
        tvYesCancel.setOnClickListener {
            //Log.e("acceptOrderParam","ptnr_id: "+LocalStorage.getCustomerID(cxt)+" order_id:"+order_id)
            if(type.equals("part")){
                Apicall(cxt).removeOrderPartItem(this,"remove-order-part",
                    LocalStorage.getCustomerID(cxt),
                    order_id,
                    _id.toString())
            }else{
                Apicall(cxt).removeOrderFaultItem(this,"remove-order-faults",
                    LocalStorage.getCustomerID(cxt),
                    order_id,
                    _id.toString())
            }
            dialog.dismiss()
        }
        dialog.show()
    }

    fun calCulation(item: GetOrderFaultsData.DataBean):Int{
        var total_amount : Int = 0
        for (x in 0 until item.qty.toInt()){
            if(x == 0){
                if(!item.qty1_rate.equals("") && !item.qty1_rate.equals("0")){
                    total_amount = total_amount + item.qty1_rate.toInt()
                }else{
                    total_amount = total_amount + item.default_amount.toInt()
                }
            }else if (x == 1){
                if(!item.qty2_rate.equals("0")){
                    total_amount = total_amount + item.qty2_rate.toInt()
                }else if (item.qty2_rate.equals("0")){
                    if(!item.qty3_rate.equals("0")){
                        total_amount = total_amount + item.qty2_rate.toInt()
                    }else if(!item.qty1_rate.equals("0")){
                        total_amount = total_amount + item.qty1_rate.toInt()
                    }else{
                        total_amount = total_amount + item.default_amount.toInt()
                    }
                }
            }else if(x > 1){

                if(!item.qty3_rate.equals("") && !item.qty3_rate.equals("0")){
                    total_amount = total_amount + item.qty3_rate.toInt()
                }else if(!item.qty2_rate.equals("") && !item.qty2_rate.equals("0")){
                    total_amount = total_amount + item.qty2_rate.toInt()
                }else if(!item.qty1_rate.equals("") && !item.qty1_rate.equals("0")){
                    total_amount = total_amount + item.qty1_rate.toInt()
                }else {
                    total_amount = total_amount + item.default_amount.toInt()
                }

            }
        }
        return total_amount

    }

    private fun finalCalculation(feedData: List<GetOrderFaultsData.DataBean>):Int {
        var finlamount = 0
        for (i in 0 until feedData.size) {
            finlamount = finlamount + feedData!![i].rowamount.toInt()
        }
        return  finlamount
    }
}