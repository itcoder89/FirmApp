package com.firmapp

import activity.MapActivity
import activity.ProfileDetails
import android.content.Intent
import android.os.Bundle
import android.view.View
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_layout)
        init()

    }

    private fun init() {
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
            val homeFragments = HomeFragments()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, homeFragments)
                .commit()
            drawerLayout.closeDrawers()
        }
        ll_new_leads.setOnClickListener{
            val newLeadsFragments = NewLeadsFragments()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, newLeadsFragments)
                .commit()
            drawerLayout.closeDrawers()
        }
        ll_open_leads.setOnClickListener{
            val openLeadsFragments = OpenLeadsFragments()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, openLeadsFragments)
                .commit()
            drawerLayout.closeDrawers()
        }
        ll_recomplaints.setOnClickListener{
            val recomplaintsFragments = RecomplaintsFragments()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, recomplaintsFragments)
                .commit()
            drawerLayout.closeDrawers()
        }
        ll_all_pending_leads.setOnClickListener{
            val allPendingLeadsFragments = AllPendingLeadsFragments()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, allPendingLeadsFragments)
                .commit()
            drawerLayout.closeDrawers()
        }

        ll_expert_list.setOnClickListener{
            val expertListFragments = ExpertListFragments()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, expertListFragments)
                .commit()
            drawerLayout.closeDrawers()
        }
        ll_working_area.setOnClickListener{
            startActivity(Intent(this, MapActivity::class.java))
            drawerLayout.closeDrawers()
        }
        ll_completed_leads.setOnClickListener{
            val completedLeadsFragments = CompletedLeadsFragments()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, completedLeadsFragments)
                .commit()
            drawerLayout.closeDrawers()
        }
        ll_cancel_leads.setOnClickListener{
            val completedLeadsFragments = CancelLeadsFragments()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, completedLeadsFragments)
                .commit()
            drawerLayout.closeDrawers()
        }
        ll_working_leads.setOnClickListener{
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
            val rateListFragment = RateListFragment()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, rateListFragment)
                .commit()
            drawerLayout.closeDrawers()
        }
        ll_wallet_summary.setOnClickListener{
            val walletSummary = WalletSummary()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, walletSummary)
                .commit()
            drawerLayout.closeDrawers()
        }

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