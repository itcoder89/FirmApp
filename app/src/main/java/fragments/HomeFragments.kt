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
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.kodpartner.R
import com.social.ekchat.Interfaces.UniverSelObjct
import com.squareup.picasso.Picasso
import connection.CheckNetwork
import connection.MyDialog
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_main.*
import model.DashboardData
import retrofit.AppGlobal
import utils.CustomDialogue
import utils.LocalStorage
import java.text.DecimalFormat


class HomeFragments: Fragment(), OnResponse<UniverSelObjct> {

    private var ll_new_leads: LinearLayout? = null
    private var ll_open_leads: LinearLayout? = null
    private var ll_onhold_leads: LinearLayout? = null
    private var ll_cancel_leads: LinearLayout? = null
    private var ll_completed_leads: LinearLayout? = null
    private var ll_recomplaints: LinearLayout? = null
    private var ll_working_leads: LinearLayout? = null
    private var ll_reschedule_leads: LinearLayout? = null

    private var tvHomeFragment: TextView? = null
    private var tvAllPendingLeads: TextView? = null
    private var tvFirmName: TextView? = null
    private var profile_image: CircleImageView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentView =
            inflater.inflate(R.layout.activity_main, container, false)//activity_main
            if (CheckNetwork.isConnected(activity!!)) {
                Apicall(activity!!).getDashboardData(this,"getDashboardData",LocalStorage.getCustomerID(activity!!))
            }else{
                MyDialog(activity!!).getNoInternetDialog().show()
            }

            ll_new_leads = fragmentView.findViewById<View>(R.id.ll_new_leads) as LinearLayout
            ll_open_leads = fragmentView.findViewById<View>(R.id.ll_open_leads) as LinearLayout
            ll_onhold_leads = fragmentView.findViewById<View>(R.id.ll_onhold_leads) as LinearLayout
            ll_cancel_leads = fragmentView.findViewById<View>(R.id.ll_cancel_leads) as LinearLayout
            ll_completed_leads = fragmentView.findViewById<View>(R.id.ll_completed_leads) as LinearLayout
            ll_recomplaints = fragmentView.findViewById<View>(R.id.ll_recomplaints) as LinearLayout
            ll_working_leads = fragmentView.findViewById<View>(R.id.ll_working_leads) as LinearLayout
            ll_reschedule_leads = fragmentView.findViewById<View>(R.id.ll_reschedule_leads) as LinearLayout


            tvAllPendingLeads = fragmentView.findViewById<View>(R.id.tvAllPendingLeads) as TextView
            tvHomeFragment = fragmentView.findViewById<View>(R.id.tvHomeFragment) as TextView
           // tvFirmName = fragmentView.findViewById<View>(R.id.tvFirmName) as TextView
            profile_image = fragmentView.findViewById<View>(R.id.profile_image) as CircleImageView

            //tvFirmName!!.text=LocalStorage.getFirmName(activity!!)
            tvHomeFragment!!.setOnClickListener {
                if (CheckNetwork.isConnected(activity!!)) {
                    Apicall(activity!!).getDashboardData(this,"getDashboardData",LocalStorage.getCustomerID(activity!!))
                }else{
                    MyDialog(activity!!).getNoInternetDialog().show()
                }
            }
            tvAllPendingLeads!!.setOnClickListener {
                startActivity(Intent(activity!!, AllPendingLeadsActivity::class.java))
            }
            ll_new_leads!!.setOnClickListener {
                LocalStorage.setCheckLastFragment(activity!!,"newleads")
                val intent = Intent()
                intent.action = "start.fragment.action.replacetitle"
                intent.putExtra("title", "New Leads")
                activity!!.sendBroadcast(intent)
                val newLeadsFragments = NewLeadsFragments()
                activity!!.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.containerView, newLeadsFragments)
                    .commit()
            }
            ll_open_leads!!.setOnClickListener {
                LocalStorage.setCheckLastFragment(activity!!,"openleads")
                val intent = Intent()
                intent.action = "start.fragment.action.replacetitle"
                intent.putExtra("title", "Open Leads")
                activity!!.sendBroadcast(intent)
                val newLeadsFragments = OpenLeadsFragments()
                activity!!.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.containerView, newLeadsFragments)
                    .commit()
            }
            ll_working_leads!!.setOnClickListener {
                LocalStorage.setCheckLastFragment(activity!!,"workingleads")
                val intent = Intent()
                intent.action = "start.fragment.action.replacetitle"
                intent.putExtra("title", "Working Leads")
                activity!!.sendBroadcast(intent)
                val workingLeadsFragments = WorkingLeadsFragments()
                activity!!.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.containerView, workingLeadsFragments)
                    .commit()
            }
            ll_reschedule_leads!!.setOnClickListener {
                LocalStorage.setCheckLastFragment(activity!!,"rescheduleleads")
                val intent = Intent()
                intent.action = "start.fragment.action.replacetitle"
                intent.putExtra("title", "Reschedule Leads")
                activity!!.sendBroadcast(intent)
                val rescheduleListFragments = RescheduleListFragments()
                activity!!.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.containerView, rescheduleListFragments)
                    .commit()
            }
            ll_onhold_leads!!.setOnClickListener {
                LocalStorage.setCheckLastFragment(activity!!,"onhold")
                val intent = Intent()
                intent.action = "start.fragment.action.replacetitle"
                intent.putExtra("title", "On-Hold Leads")
                activity!!.sendBroadcast(intent)
                val newLeadsFragments = OnHoldListFragments()
                activity!!.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.containerView, newLeadsFragments)
                    .commit()
            }

            ll_cancel_leads!!.setOnClickListener {
                LocalStorage.setCheckLastFragment(activity!!,"cancelleads")
                val intent = Intent()
                intent.action = "start.fragment.action.replacetitle"
                intent.putExtra("title", "Cancel Leads")
                activity!!.sendBroadcast(intent)
                val newLeadsFragments = CancelLeadsFragments()
                activity!!.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.containerView, newLeadsFragments)
                    .commit()
            }
            ll_completed_leads!!.setOnClickListener {
                LocalStorage.setCheckLastFragment(activity!!,"completed")
                val intent = Intent()
                intent.action = "start.fragment.action.replacetitle"
                intent.putExtra("title", "Completed Leads")
                activity!!.sendBroadcast(intent)
                val newLeadsFragments = CompletedLeadsFragments()
                activity!!.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.containerView, newLeadsFragments)
                    .commit()
            }
            ll_recomplaints!!.setOnClickListener {
                LocalStorage.setCheckLastFragment(activity!!,"recomplaints")
                val intent = Intent()
                intent.action = "start.fragment.action.replacetitle"
                intent.putExtra("title", "Recomplaints")
                activity!!.sendBroadcast(intent)
                val fragment = RecomplaintsFragments()
                activity!!.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.containerView, fragment)
                    .commit()
            }

        /*if(LocalStorage.getCustomerImage(activity).equals("")){
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
        }*/
        return fragmentView
    }

    override fun onSucess(response: UniverSelObjct?) {
        try {
            if (response!!.status == "true") {
                when (response.methodname) {
                    "getDashboardData" -> {
                        val dashboardData = response.response as DashboardData
                        Log.e("dashboardData"," "+dashboardData.data.rating+"")
                        tvInWallet.text="Rs. "+AppGlobal.setTwoDecimalValue(dashboardData.data.walletAmount)

                        //tvWalletAmount.text=""+dashboardData.data.walletAmount
                        tvWalletAmount.text=": "+AppGlobal.setTwoDecimalValue(dashboardData.data.walletAmount)
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

                        tvRatings.text="Rating: "+dashboardData.data.rating.toString()+" "
                        tvKODCommission.text=AppGlobal.setTwoDecimalValue(dashboardData.data.kodCommission)+""
                        tvTotalEarningAmount.text=AppGlobal.setTwoDecimalValue(dashboardData.data.totalEarningAmount) + ""
                        tvTotalRecharge.text=AppGlobal.setTwoDecimalValue(dashboardData.data.totalRechargeAmount) + ""
                        LocalStorage.setFirmName(activity!!,dashboardData.data.f_name)
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