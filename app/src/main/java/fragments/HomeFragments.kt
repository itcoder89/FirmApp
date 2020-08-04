package fragments

import Interfaces.Apicall
import Interfaces.OnResponse
import activity.AllPendingLeadsActivity
import activity.MapActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.firmapp.R
import com.social.ekchat.Interfaces.UniverSelObjct
import kotlinx.android.synthetic.main.activity_main.*
import model.DashboardData
import utils.CustomDialogue
import utils.LocalStorage
import utils.SessionManager

class HomeFragments: Fragment(), OnResponse<UniverSelObjct> {

    private var tvAllPendingLeads: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentView =
            inflater.inflate(R.layout.activity_main, container, false)//activity_main
            Apicall(activity!!).getDashboardData(this,"getDashboardData",LocalStorage.getCustomerID(activity!!))

            tvAllPendingLeads = fragmentView.findViewById<View>(R.id.tvAllPendingLeads) as TextView

            tvAllPendingLeads!!.setOnClickListener {
                startActivity(Intent(activity!!, AllPendingLeadsActivity::class.java))
            }
        return fragmentView

    }

    override fun onSucess(response: UniverSelObjct?) {
        try {
            if (response!!.status == "true") {
                when (response.methodname) {
                    "getDashboardData" -> {
                        val dashboardData = response.response as DashboardData
                        Log.e("dashboardData"," "+dashboardData.data.rating+"")
                        tvInWallet.text="Rs. "+dashboardData.data.walletAmount+"/-"
                        tvWalletAmount.text="Rs. "+dashboardData.data.walletAmount+"/-"
                        tvNewLeads.text=dashboardData.data.totalNewLeadsBooking.toString()
                        tvOpenLeads.text=dashboardData.data.totalOpenLeadsBooking.toString()
                        tvWorking.text=dashboardData.data.totalWorkingBooking.toString()
                        tvOnHold.text=dashboardData.data.totalHoldBooking.toString()
                        tvCancelled.text=dashboardData.data.totalCancelBooking.toString()
                        tvCompleted.text=dashboardData.data.totalCompleteBooking.toString()
                        tvRescheduled.text=dashboardData.data.totalRescheduleBooking.toString()
                        tvReComplaints.text=dashboardData.data.totalRecomplaintBooking.toString()
                        tvFeedbackPending.text=dashboardData.data.totalFeedbackPendingBooking.toString()
                        tvFeedbackCompleted.text=dashboardData.data.totalFeedbackCompleteBooking.toString()

                        tvFeedbycustomer.text=dashboardData.data.totalCustomerFeedback.toString()
                        tvFeedbyKOD.text=dashboardData.data.totalKodFeedback.toString()

                        tvRatings.text=dashboardData.data.rating.toString()+" *"
                        tvKODCommission.text=dashboardData.data.kodCommission+"/-"
                        tvTotalEarningAmount.text=dashboardData.data.totalEarningAmount.toString() + "/-"
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