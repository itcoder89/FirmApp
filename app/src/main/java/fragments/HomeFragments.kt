package fragments

import Interfaces.Apicall
import Interfaces.OnResponse
import activity.AllPendingLeadsActivity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.kodpartner.R
import com.social.ekchat.Interfaces.UniverSelObjct
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_main.*
import model.DashboardData
import utils.CustomDialogue
import utils.LocalStorage


class HomeFragments: Fragment(), OnResponse<UniverSelObjct> {

    private var tvAllPendingLeads: TextView? = null
    private var profile_image: CircleImageView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentView =
            inflater.inflate(R.layout.activity_main, container, false)//activity_main
            Apicall(activity!!).getDashboardData(this,"getDashboardData",LocalStorage.getCustomerID(activity!!))

            tvAllPendingLeads = fragmentView.findViewById<View>(R.id.tvAllPendingLeads) as TextView
            profile_image = fragmentView.findViewById<View>(R.id.profile_image) as CircleImageView

            tvAllPendingLeads!!.setOnClickListener {
                startActivity(Intent(activity!!, AllPendingLeadsActivity::class.java))
            }

        if(LocalStorage.getCustomerImage(activity).equals("")){
            val path: Uri = Uri.parse("android.resource://com.kodpartner/" + R.mipmap.ic_applogo)
            Picasso
                .with(activity!!)
                .load(path)
                .into(profile_image);
        }else{
            Picasso
                .with(activity!!)
                .load(LocalStorage.getCustomerImage(activity))
                .into(profile_image);
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