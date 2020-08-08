package fragments

import Interfaces.Apicall
import Interfaces.OnResponse
import adapter.CustomAdapter
import adapter.RateListAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kodpartner.R
import com.social.ekchat.Interfaces.UniverSelObjct
import model.RateListData
import model.ServiceListForRateData
import utils.CustomDialogue
import utils.LocalStorage


class RateListFragment : Fragment(), OnResponse<UniverSelObjct>, AdapterView.OnItemSelectedListener {

    var lst: List<ServiceListForRateData.DataBean>? = null
    var ratelist: List<RateListData.DataBean.LabourBean>? = null
    var spinner: Spinner? = null
    var serviceListForRateData: ServiceListForRateData? = null
    private var recyclerView: RecyclerView? = null
    private var customAdapter: CustomAdapter? = null
    private var rateListAdapter: RateListAdapter? = null
    private var layoutManager: LinearLayoutManager? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentView =
            inflater.inflate(R.layout.rate_list_layout, container, false)
        recyclerView = fragmentView.findViewById<View>(R.id.recyclerView) as RecyclerView
        Apicall(activity!!).getServiceListForRate(this,"partner-part-assigned-services", LocalStorage.getCustomerID(activity!!))


        layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.layoutManager = layoutManager


        spinner = fragmentView.findViewById<View>(com.kodpartner.R.id.spinner) as Spinner
        // Spinner click listener
        spinner!!.onItemSelectedListener = this
        /*val categories: MutableList<String> =
            ArrayList()
        categories.add("Item 1")
        categories.add("Item 2")
        categories.add("Item 3")
        categories.add("Item 4")
        categories.add("Item 5")
        categories.add("Item 6")
        val dataAdapter: ArrayAdapter<String> =
            ArrayAdapter<String>(activity!!, android.R.layout.simple_spinner_item, categories)
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = dataAdapter*/



        return fragmentView
    }

    override fun onSucess(response: UniverSelObjct?) {
        try {
            if (response!!.status == "true") {
                when (response.methodname) {
                    "get-rate-card-by-service-id" ->{
                        val rateListData = response.response as RateListData
                        Log.e("get-rate-service-id"," "+rateListData.isStatus+"")
                        if(rateListData.isStatus == false){
                            Toast.makeText(activity!!,""+rateListData.message,Toast.LENGTH_SHORT).show()
                            rateListAdapter!!.clearData()
                            rateListAdapter!!.notifyDataSetChanged()
                        }else{
                            ratelist=rateListData.data.labour
                            rateListAdapter = RateListAdapter(activity)
                            recyclerView!!.adapter = rateListAdapter
                            recyclerView!!.setHasFixedSize(false)
                            rateListAdapter!!.addData(rateListData.data.labour)
                            rateListAdapter!!.notifyDataSetChanged()
                        }
                    }
                    "partner-part-assigned-services" -> {
                        serviceListForRateData = response.response as ServiceListForRateData
                        Log.e("partner-part-services","size- "+serviceListForRateData!!.data.size+"")
                        lst=serviceListForRateData!!.data
                        customAdapter = CustomAdapter(
                            activity,
                            lst,
                            R.layout.view_services_item_layout
                        )
                        spinner!!.setAdapter(customAdapter)
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

    override fun onItemSelected(
        parent: AdapterView<*>,
        view: View?,
        position: Int,
        id: Long
    ) {
        // On selecting a spinner item
        val item = parent.getItemAtPosition(position).toString()
        // Showing selected spinner item
        //Toast.makeText(parent.context, "Selected: $item", Toast.LENGTH_LONG).show()
        Log.e("onItemSelected","item "+serviceListForRateData!!.data[position].idservice)
        Apicall(activity!!).getRateCardData(this,"get-rate-card-by-service-id", serviceListForRateData!!.data[position].idservice)
    }

    override fun onNothingSelected(arg0: AdapterView<*>?) {
        // TODO Auto-generated method stub
    }
}