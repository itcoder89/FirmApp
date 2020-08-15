package com.kodpartner

import activity.LoginActivity
import activity.MapActivity
import activity.ProfileDetails
import activity.WalletRecharge
import android.content.*
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import dialoge.ShowDialog
import fragments.*
import kotlinx.android.synthetic.main.dash_top_header_layout.*
import kotlinx.android.synthetic.main.dashboard_layout.*
import kotlinx.android.synthetic.main.nav_menu_layout.*
import utils.LocalStorage

class DashboardActivity : AppCompatActivity(),View.OnClickListener {

    private var mFragmentManager: FragmentManager? = null
    private var mFragmentTransaction: FragmentTransaction? = null
    private val TAG = "DashboardActivity"

    var headertitle=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_layout)
        getData()
        init()

    }

    fun getData() {
        val mBroadcastReceiverPost = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                try {
                    headertitle = intent.getStringExtra("title")
                    Log.e("mBroadcastReceiverPost", "headertitle$headertitle")
                    tvFragmentTitle.text=headertitle
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        this
        this.registerReceiver(
            mBroadcastReceiverPost,
            IntentFilter("start.fragment.action.replacetitle")
        )
    }

    private fun init() {
        LocalStorage.setFirstTimeLogin(this,"true")
        /**
         * Lets inflate the very first fragment
         * Here , we are inflating the TabFragment as the first Fragment
         */
        mFragmentManager = supportFragmentManager
        mFragmentTransaction = mFragmentManager!!.beginTransaction()
        mFragmentTransaction!!.replace(R.id.containerView, HomeFragments()).commit()

        tvEmailID.text=LocalStorage.getCustomerEmailID(this)
        nav_img.setOnClickListener(homeOnclickListener)

        ll_dashboard.setOnClickListener{
            tvFragmentTitle.text="KOD Services"
            val homeFragments = HomeFragments()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, homeFragments)
                .commit()
            drawerLayout.closeDrawers()
        }
        ll_wallet_recharge.setOnClickListener{
            startActivity(Intent(this, WalletRecharge::class.java))
            drawerLayout.closeDrawers()
        }
        ll_new_leads.setOnClickListener{
            tvFragmentTitle.text="New Leads"
            val newLeadsFragments = NewLeadsFragments()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, newLeadsFragments)
                .commit()
            drawerLayout.closeDrawers()
        }
        ll_open_leads.setOnClickListener{
            tvFragmentTitle.text="Open Leads"
            val openLeadsFragments = OpenLeadsFragments()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, openLeadsFragments)
                .commit()
            drawerLayout.closeDrawers()
        }
        ll_onhold_leads.setOnClickListener{
            tvFragmentTitle.text="On-Hold Leads"
            val onHoldListFragments = OnHoldListFragments()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, onHoldListFragments)
                .commit()
            drawerLayout.closeDrawers()
        }
        ll_recomplaints.setOnClickListener{
            tvFragmentTitle.text="Recomplaints"
            val recomplaintsFragments = RecomplaintsFragments()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, recomplaintsFragments)
                .commit()
            drawerLayout.closeDrawers()
        }
        ll_all_pending_leads.setOnClickListener{
            tvFragmentTitle.text="All Pending Leads"
            val allPendingLeadsFragments = AllPendingLeadsFragments()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, allPendingLeadsFragments)
                .commit()
            drawerLayout.closeDrawers()
        }

        ll_expert_list.setOnClickListener{
            tvFragmentTitle.text="Expert List"
            val expertListFragments = ExpertListFragments()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, expertListFragments)
                .commit()
            drawerLayout.closeDrawers()
        }
        ll_working_area.setOnClickListener{
            startActivity(Intent(this, MapActivity::class.java))//SendOtp  ,MapActivity
            drawerLayout.closeDrawers()
        }
        ll_completed_leads.setOnClickListener{
            tvFragmentTitle.text="Completed Leads"
            val completedLeadsFragments = CompletedLeadsFragments()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, completedLeadsFragments)
                .commit()
            drawerLayout.closeDrawers()
        }
        ll_cancel_leads.setOnClickListener{
            tvFragmentTitle.text="Cancel Leads"
            val completedLeadsFragments = CancelLeadsFragments()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, completedLeadsFragments)
                .commit()
            drawerLayout.closeDrawers()
        }
        ll_working_leads.setOnClickListener{
            tvFragmentTitle.text="Working Leads"
            val workingLeadsFragments = WorkingLeadsFragments()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, workingLeadsFragments)
                .commit()
            drawerLayout.closeDrawers()
        }
        ll_profile.setOnClickListener{
            startActivity(Intent(this, ProfileDetails::class.java))
            drawerLayout.closeDrawers()
        }
        ll_rate_list.setOnClickListener{
            tvFragmentTitle.text="Rate List"
            val rateListFragment = RateListFragment()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, rateListFragment)
                .commit()
            drawerLayout.closeDrawers()
        }
        ll_wallet_summary.setOnClickListener{
            tvFragmentTitle.text="Wallet Summary"
            val walletSummary = WalletSummary()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, walletSummary)
                .commit()
            drawerLayout.closeDrawers()
        }
        ll_logout.setOnClickListener {
            logout()
        }

    }

    /*
     **
     *** Logout Functionality.
     **
     */
    private fun logout() {
        val alertDialogBuilder: AlertDialog.Builder = androidx.appcompat.app.AlertDialog.Builder(this)
        alertDialogBuilder.setCancelable(false)
        alertDialogBuilder.setMessage("Are you sure you want to logout?")
            .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, id ->
                val sharedPreferences = PreferenceManager
                    .getDefaultSharedPreferences(this@DashboardActivity)
                val editor = sharedPreferences.edit()
                editor.remove("setFirstTimeLogin")
                editor.remove("setCustomerID")
                editor.remove("setCustomerEmailID")
                // editor.remove("fcm");
                editor.commit()
                Log.e("prefrences", "remove")
                val i =
                    Intent(this@DashboardActivity, LoginActivity::class.java)
                startActivity(i)
                finish()
            })
            .setNegativeButton("No",
                DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })
        val alertDialog: AlertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    override fun onBackPressed() {
        ShowDialog.showDialog(this)
    }

    var homeOnclickListener =
        View.OnClickListener {
            if (drawerLayout.isDrawerOpen(shitstuff!!)) {
                drawerLayout.closeDrawer(shitstuff)
            } else {
                try {
                    //tvHeaderName.setText(LocalStorage.getFullName(DashBoardMainActivity.this));
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                drawerLayout.openDrawer(shitstuff)
            }
        }

    override fun onClick(view: View?) {
    }


}