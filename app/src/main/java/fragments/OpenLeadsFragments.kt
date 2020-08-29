package fragments

import Interfaces.Apicall
import Interfaces.ItemAdapterClick
import Interfaces.OnResponse
import adapter.OpenLeadsAdapter
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.materialdialogs.MaterialDialog
import com.kodpartner.R
import com.social.ekchat.Interfaces.UniverSelObjct
import connection.CheckNetwork
import connection.MyDialog
import model.CancelByData
import model.OpenLeadsData
import retrofit.AppGlobal
import utils.CustomDialogue
import utils.LocalStorage

class OpenLeadsFragments : Fragment(), OnResponse<UniverSelObjct>, ItemAdapterClick {

    private var openLeadsAdapter: OpenLeadsAdapter? = null
    private var layoutManager: LinearLayoutManager? = null
    private var recyclerView: RecyclerView? = null
    private var tvAllLeads: TextView? = null
    private var tvTodayLeads: TextView? = null
    private var tvTommorrowLeads: TextView? = null
    var material : MaterialDialog? = null
    var openLeadsData: OpenLeadsData? = null
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
            Apicall(activity!!).getAllOpenLeadsData(this,"partner-openleads", LocalStorage.getCustomerID(activity!!),"all")
        }
        tvTodayLeads!!.setOnClickListener {
            Apicall(activity!!).getAllOpenLeadsData(this,"partner-openleads", LocalStorage.getCustomerID(activity!!),"today")
        }
        tvTommorrowLeads!!.setOnClickListener {
            Apicall(activity!!).getAllOpenLeadsData(this,"partner-openleads", LocalStorage.getCustomerID(activity!!),"tomorrow")
        }
        if (CheckNetwork.isConnected(activity!!)) {
            Apicall(activity!!).getOpenLeadsData(this,"partner-openleads", LocalStorage.getCustomerID(activity!!))
        }else{
            MyDialog(activity!!).getNoInternetDialog().show()
        }


        layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.layoutManager = layoutManager



        return fragmentView
    }
    override fun onSucess(response: UniverSelObjct?) {
        try {
            if (response!!.status == "true") {
                when (response.methodname) {
                    "partner-openleads" -> {
                        openLeadsData = response.response as OpenLeadsData
                        Log.e("partner-openleads"," "+openLeadsData!!.isStatus+"")
                        if(openLeadsData!!.isStatus == false){
                            Toast.makeText(activity!!,"No Data found!", Toast.LENGTH_SHORT).show()
                        }else{
                            openLeadsAdapter = OpenLeadsAdapter(activity,this)
                            recyclerView!!.adapter = openLeadsAdapter
                            recyclerView!!.setHasFixedSize(false)
                            openLeadsAdapter!!.addData(openLeadsData!!.data)
                            openLeadsAdapter!!.notifyDataSetChanged()
                        }
                    }
                    "cancel-by-partner" -> {
                        val cancelByData = response.response as CancelByData
                        Log.e("partner-openleads", " " + cancelByData.message + "")
                        AppGlobal.showToast(activity!!,cancelByData.message)
                        Apicall(activity!!).getOpenLeadsData(this,"partner-openleads", LocalStorage.getCustomerID(activity!!))
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

    override fun onClick(pos: Int) {
        showccancel(pos,activity!!)
    }

    fun showccancel(pos: Int,cxt: Context) {
        material = MaterialDialog.Builder(cxt)
            .customView(R.layout.cancel_booking_layout, true)
            .show()
        val btn_done = material!!.findViewById(R.id.btn_done) as Button
        val edt_feedback_msg = material!!.findViewById(R.id.edt_feedback_msg) as EditText

        btn_done.setOnClickListener {
            material!!.dismiss()
            Apicall(cxt).cancelBy(this,"cancel-by-partner",
                LocalStorage.getCustomerID(activity!!),
                openLeadsData!!.data[pos].order_id,
                edt_feedback_msg.text.toString())

        }
    }

}