package fragments

import Interfaces.Apicall
import Interfaces.OnResponse
import adapter.NewLeadsAdapter
import adapter.WalletSummaryAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firmapp.R
import com.social.ekchat.Interfaces.UniverSelObjct
import kotlinx.android.synthetic.main.wallet_summary_list_layout.*
import model.NewLeadsData
import model.WalletSummaryData
import utils.CustomDialogue
import utils.LocalStorage

class WalletSummary  : Fragment(), OnResponse<UniverSelObjct> {

    private var walletSummaryAdapter: WalletSummaryAdapter? = null
    private var layoutManager: LinearLayoutManager? = null
    private var recyclerView: RecyclerView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentView =
            inflater.inflate(R.layout.wallet_summary_list_layout, container, false)
        recyclerView = fragmentView.findViewById<View>(R.id.recyclerView) as RecyclerView
        Apicall(activity!!).getWalletSummary(this,"partner-wallet-summary", LocalStorage.getCustomerID(activity!!))
        layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.layoutManager = layoutManager

        return fragmentView;

    }
    override fun onSucess(response: UniverSelObjct?) {
        try {
                when (response!!.methodname) {
                    "partner-wallet-summary" -> {
                        val walletSummaryData = response!!.response as WalletSummaryData
                        Log.e("partner-newleads"," "+walletSummaryData.isStatus+"")
                        if(walletSummaryData.isStatus == false){
                            Toast.makeText(activity,""+walletSummaryData.message,Toast.LENGTH_SHORT).show()
                            walletSummaryAdapter!!.clearData()
                            walletSummaryAdapter!!.notifyDataSetChanged()
                        }else{
                            tvWalletBalance.text="Wallet Balance \nRs "+walletSummaryData.data.walletBalance.toString()+"/-"
                            tvTotalEarning.text=walletSummaryData.data.totalEarningAmount.toString()+"/-"
                            tvTotalCommission.text=walletSummaryData.data.kodCommision.toString()+"/-"
                            tvTotalRecharge.text=walletSummaryData.data.totalRechargeAmnt.toString()+"/-"

                           walletSummaryAdapter = WalletSummaryAdapter(activity)
                           recyclerView!!.adapter = walletSummaryAdapter
                           recyclerView!!.setHasFixedSize(false)
                            walletSummaryAdapter!!.addData(walletSummaryData.data.paymentSummary)
                            walletSummaryAdapter!!.notifyDataSetChanged()
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