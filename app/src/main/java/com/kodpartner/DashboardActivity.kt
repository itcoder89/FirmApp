package com.kodpartner

import activity.*
import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.*
import android.content.pm.PackageManager
import android.location.Location
import android.net.Uri
import android.os.Bundle
import android.os.Looper
import android.preference.PreferenceManager
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.akexorcist.googledirection.BuildConfig
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.material.snackbar.Snackbar
import dialoge.ShowDialog
import fragments.*
import kotlinx.android.synthetic.main.activity_track_order.*
import kotlinx.android.synthetic.main.dash_top_header_layout.*
import kotlinx.android.synthetic.main.dashboard_layout.*
import kotlinx.android.synthetic.main.nav_menu_layout.*
import utils.LocalStorage
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat

class DashboardActivity : AppCompatActivity(),View.OnClickListener {

    //private val TAG: String = TrackLocation::class.java.getSimpleName()
    private val REQUEST_PERMISSIONS_REQUEST_CODE = 34
    private val REQUEST_CHECK_SETTINGS = 0x1
    private val UPDATE_INTERVAL_IN_MILLISECONDS: Long = 10000
    private val FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = UPDATE_INTERVAL_IN_MILLISECONDS / 2

    // Keys for storing activity state in the Bundle.
    private val KEY_REQUESTING_LOCATION_UPDATES = "requesting-location-updates"
    private val KEY_LOCATION = "location"

    private var mFusedLocationClient: FusedLocationProviderClient? = null
    private var mSettingsClient: SettingsClient? = null
    private var mLocationRequest: LocationRequest? = null
    private var mLocationSettingsRequest: LocationSettingsRequest? = null
    private var mLocationCallback: LocationCallback? = null
    private var mCurrentLocation: Location? = null
    private val mLocation: Button? = null
    private var mRequestingLocationUpdates: Boolean? = null
    private var updateLat: Double? = null
    private var updateLng: Double? = null
    private var strAddress: String? = null
    private var btnsetlocation: Button? = null
    var mMapView: MapView? = null
    private var googleMap: GoogleMap? = null
    var initialMapLoad = false

    private var mFragmentManager: FragmentManager? = null
    private var mFragmentTransaction: FragmentTransaction? = null
    private val TAG = "DashboardActivity"

    var headertitle=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_layout)

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        mSettingsClient = LocationServices.getSettingsClient(this)
        mRequestingLocationUpdates = false

        updateValuesFromBundle(savedInstanceState)
        createLocationCallback()
        createLocationRequest()
        buildLocationSettingsRequest()
        startLocationUpdates()
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
            //tvFragmentTitle.text=LocalStorage.getFirmName(this@DashboardActivity)
            tvFragmentTitle.text="Welcome"
            LocalStorage.setCheckLastFragment(this,"dashboard")
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
        ll_AboutApp.setOnClickListener{
            startActivity(Intent(this, AboutApp::class.java))
            drawerLayout.closeDrawers()
        }
        ll_new_leads.setOnClickListener{
            LocalStorage.setCheckLastFragment(this,"newleads")
            tvFragmentTitle.text="New Leads"
            val newLeadsFragments = NewLeadsFragments()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, newLeadsFragments)
                .commit()
            drawerLayout.closeDrawers()
        }
        ll_reschedule_leads.setOnClickListener{
            LocalStorage.setCheckLastFragment(this,"rescheduleleads")
            tvFragmentTitle.text="Reschedule Leads"
            val rescheduleListFragments = RescheduleListFragments()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, rescheduleListFragments)
                .commit()
            drawerLayout.closeDrawers()
        }
        ll_open_leads.setOnClickListener{
            LocalStorage.setCheckLastFragment(this,"openleads")
            tvFragmentTitle.text="Open Leads"
            val openLeadsFragments = OpenLeadsFragments()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, openLeadsFragments)
                .commit()
            drawerLayout.closeDrawers()
        }
        ll_onhold_leads.setOnClickListener{
            LocalStorage.setCheckLastFragment(this,"onhold")
            tvFragmentTitle.text="On-Hold Leads"
            val onHoldListFragments = OnHoldListFragments()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, onHoldListFragments)
                .commit()
            drawerLayout.closeDrawers()
        }
        ll_recomplaints.setOnClickListener{
            LocalStorage.setCheckLastFragment(this,"recomplaints")
            tvFragmentTitle.text="Recomplaints"
            val recomplaintsFragments = RecomplaintsFragments()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, recomplaintsFragments)
                .commit()
            drawerLayout.closeDrawers()
        }
        ll_all_pending_leads.setOnClickListener{
            LocalStorage.setCheckLastFragment(this,"allpending")
            tvFragmentTitle.text="All Pending Leads"
            val allPendingLeadsFragments = AllPendingLeadsFragments()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, allPendingLeadsFragments)
                .commit()
            drawerLayout.closeDrawers()
        }

        ll_expert_list.setOnClickListener{
            LocalStorage.setCheckLastFragment(this,"expertlist")
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
            LocalStorage.setCheckLastFragment(this,"completed")
            tvFragmentTitle.text="Completed Leads"
            val completedLeadsFragments = CompletedLeadsFragments()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, completedLeadsFragments)
                .commit()
            drawerLayout.closeDrawers()
        }
        ll_cancel_leads.setOnClickListener{
            LocalStorage.setCheckLastFragment(this,"cancelleads")
            tvFragmentTitle.text="Cancel Leads"
            val completedLeadsFragments = CancelLeadsFragments()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, completedLeadsFragments)
                .commit()
            drawerLayout.closeDrawers()
        }
        ll_working_leads.setOnClickListener{
            LocalStorage.setCheckLastFragment(this,"workingleads")
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
            LocalStorage.setCheckLastFragment(this,"ratelist")
            tvFragmentTitle.text="Rate List"
            val rateListFragment = RateListFragment()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, rateListFragment)
                .commit()
            drawerLayout.closeDrawers()
        }
        ll_wallet_summary.setOnClickListener{
            LocalStorage.setCheckLastFragment(this,"walletsummary")
            tvFragmentTitle.text="Wallet Summary"
            val walletSummary = WalletSummary()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, walletSummary)
                .commit()
            drawerLayout.closeDrawers()
        }
        ll_pending_feedback_leads.setOnClickListener{
            LocalStorage.setCheckLastFragment(this,"feedbacklist")
            tvFragmentTitle.text="Pending Feedback List"
            val pendingFeedbackLeadsFragments = PendingFeedbackLeadsFragments()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, pendingFeedbackLeadsFragments)
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
                editor.remove("setCustomerImage")
                editor.remove("setCheckLastFragment")
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
        if(LocalStorage.getCheckLastFragment(this).equals("dashboard")){
            ShowDialog.showDialog(this)
        }else{
            LocalStorage.setCheckLastFragment(this,"dashboard")
            val homeFragments = HomeFragments()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerView, homeFragments)
                .commit()
            drawerLayout.closeDrawers()
        }
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


    private fun updateValuesFromBundle(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            // Update the value of mRequestingLocationUpdates from the Bundle
            if (savedInstanceState.keySet()
                    .contains(KEY_REQUESTING_LOCATION_UPDATES)
            ) {
                mRequestingLocationUpdates = savedInstanceState.getBoolean(
                    KEY_REQUESTING_LOCATION_UPDATES
                )
            }

            // Update the value of mCurrentLocation from the Bundle
            if (savedInstanceState.keySet()
                    .contains(KEY_LOCATION)
            ) {
                // Since KEY_LOCATION was found in the Bundle, we can be sure that mCurrentLocation
                // is not null.
                mCurrentLocation =
                    savedInstanceState.getParcelable(KEY_LOCATION)
            }
            updateUI()
        }
    }

    @SuppressLint("RestrictedApi")
    private fun createLocationRequest() {
        mLocationRequest = LocationRequest()
        mLocationRequest!!.setInterval(UPDATE_INTERVAL_IN_MILLISECONDS)
        mLocationRequest!!.setFastestInterval(FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS)
        mLocationRequest!!.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
    }

    private fun createLocationCallback() {
        mLocationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                super.onLocationResult(locationResult)
                mCurrentLocation = locationResult.lastLocation
                updateLocationUI()
            }
        }
    }

    private fun buildLocationSettingsRequest() {
        val builder = LocationSettingsRequest.Builder()
        builder.addLocationRequest(mLocationRequest!!)
        mLocationSettingsRequest = builder.build()
    }

    fun locationButtonHandler(view: View?) {
        if (!mRequestingLocationUpdates!!) {
            mRequestingLocationUpdates = true
            startLocationUpdates()
        }
    }

    private fun startLocationUpdates() {
        // Begin by checking if the device has the necessary location settings.
        mSettingsClient!!.checkLocationSettings(mLocationSettingsRequest)
            .addOnSuccessListener(this) {
                Log.i(
                    TAG,
                    "All location settings are satisfied."
                )
                mFusedLocationClient!!.requestLocationUpdates(
                    mLocationRequest,
                    mLocationCallback, Looper.myLooper()
                )
                updateUI()
            }
            .addOnFailureListener(this) { e ->
                val statusCode = (e as ApiException).statusCode
                when (statusCode) {
                    LocationSettingsStatusCodes.RESOLUTION_REQUIRED -> {
                        Log.i(
                            TAG,
                            "Location settings are not satisfied. Attempting to upgrade " +
                                    "location settings "
                        )
                        try {
                            // Show the dialog by calling startResolutionForResult(), and check the
                            // result in onActivityResult().
                            val rae = e as ResolvableApiException
                            rae.startResolutionForResult(
                                this@DashboardActivity,
                                REQUEST_CHECK_SETTINGS
                            )
                        } catch (sie: IntentSender.SendIntentException) {
                            Log.i(
                                TAG,
                                "PendingIntent unable to execute request."
                            )
                        }
                    }
                    LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE -> {
                        val errorMessage =
                            "Location settings are inadequate, and cannot be " +
                                    "fixed here. Fix in Settings."
                        Log.e(
                            TAG,
                            errorMessage
                        )
                        Toast.makeText(
                            this@DashboardActivity,
                            errorMessage,
                            Toast.LENGTH_LONG
                        ).show()
                        mRequestingLocationUpdates = false
                    }
                }
                updateUI()
            }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_CHECK_SETTINGS -> when (resultCode) {
                Activity.RESULT_OK -> {
                    Log.i(
                        TAG,
                        "User agreed to make required location settings changes."
                    )
                    startLocationUpdates()
                }
                Activity.RESULT_CANCELED -> {
                    Log.i(
                        TAG,
                        "User chose not to make required location settings changes."
                    )
                    Toast.makeText(this, "Permission denied! Please enable GPS", Toast.LENGTH_SHORT)
                        .show()
                    mRequestingLocationUpdates = false
                    updateUI()
                }
            }
        }
    }

    private fun updateUI() {
        updateLocationUI()
    }

    private fun updateLocationUI() {
        try {
            if (mCurrentLocation != null) {
               // Log.e("currentlocation","lat " + mCurrentLocation!!.getLatitude().toString())
               // Log.e("currentlocation","lng " + mCurrentLocation!!.getLongitude().toString())
                updateLat = mCurrentLocation!!.getLatitude()
                updateLng = mCurrentLocation!!.getLongitude()
                LocalStorage.setLatitude(this@DashboardActivity, mCurrentLocation!!.getLatitude().toString())
                LocalStorage.setLongitude(this@DashboardActivity, mCurrentLocation!!.getLongitude().toString())
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onPause() {
        super.onPause()
        // Remove location updates to save battery.
        stopLocationUpdates()
    }

    //Removes location updates from the FusedLocationApi.
    private fun stopLocationUpdates() {
        if (!mRequestingLocationUpdates!!) {
            Log.d(
                TAG,
                "stopLocationUpdates: updates never requested, no-op."
            )
            return
        }
        // It is a good practice to remove location requests when the activity is in a paused or
        // stopped state. Doing so helps battery performance and is especially
        // recommended in applications that request frequent location updates.
        mFusedLocationClient!!.removeLocationUpdates(mLocationCallback)
            .addOnCompleteListener(
                this
            ) { mRequestingLocationUpdates = false }
    }

    override fun onResume() {
        super.onResume()
        try {
            tvFragmentTitle.text="Welcome"
            // Within {@code onPause()}, we remove location updates. Here, we resume receiving
            // location updates if the user has requested them.
            if (mRequestingLocationUpdates!! && checkPermissions()) {
                startLocationUpdates()
            } else if (!checkPermissions()) {
                requestPermissions()
            }
            updateUI()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    //Stores activity data in the Bundle.
    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.putBoolean(
            KEY_REQUESTING_LOCATION_UPDATES,
            mRequestingLocationUpdates!!
        )
        savedInstanceState.putParcelable(
            KEY_LOCATION,
            mCurrentLocation
        )
        super.onSaveInstanceState(savedInstanceState)
    }

    private fun showSnackbar(
        mainTextStringId: Int, actionStringId: Int,
        listener: View.OnClickListener
    ) {
        Snackbar.make(
            findViewById(android.R.id.content),
            getString(mainTextStringId),
            Snackbar.LENGTH_INDEFINITE
        )
            .setAction(getString(actionStringId), listener).show()
    }

    private fun checkPermissions(): Boolean {
        val permissionState: Int = ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
        return permissionState == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermissions() {
        val shouldProvideRationale =
            ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        // Provide an additional rationale to the user. This would happen if the user denied the
        // request previously, but didn't check the "Don't ask again" checkbox.
        if (shouldProvideRationale) {
            Log.e(
                TAG,
                "Displaying permission rationale to provide additional context."
            )
            showSnackbar(
                R.string.permission_rationale,
                android.R.string.ok, View.OnClickListener {
                    // Request permission
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                        REQUEST_PERMISSIONS_REQUEST_CODE
                    )
                })
        } else {
            Log.e(TAG, "Requesting permission")
            // Request permission. It's possible this can be auto answered if device policy
            // sets the permission in a given state or the user denied the permission
            // previously and checked "Never ask again".
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_PERMISSIONS_REQUEST_CODE
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String?>,
        grantResults: IntArray
    ) {
        Log.i(TAG, "onRequestPermissionResult")
        if (requestCode == REQUEST_PERMISSIONS_REQUEST_CODE) {
            if (grantResults.size <= 0) { // If user interaction was interrupted, the permission request is cancelled and you
                // receive empty arrays.
                Log.i(TAG, "User interaction was cancelled.")
            } else if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (mRequestingLocationUpdates!!) {
                    Log.i(
                        TAG,
                        "Permission granted, updates requested, starting location updates"
                    )
                    startLocationUpdates()
                }
            } else { // Permission denied.
                // Notify the user via a SnackBar that they have rejected a core permission for the
                // app, which makes the Activity useless. In a real app, core permissions would
                // typically be best requested during a welcome-screen flow.
                // Additionally, it is important to remember that a permission might have been
                // rejected without asking the user for permission (device policy or "Never ask
                // again" prompts). Therefore, a user interface affordance is typically implemented
                // when permissions are denied. Otherwise, your app could appear unresponsive to
                // touches or interactions which have required permissions.
                showSnackbar(
                    R.string.permission_denied_explanation,
                    R.string.settings, View.OnClickListener {
                        // Build intent that displays the App settings screen.
                        val intent = Intent()
                        intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                        val uri = Uri.fromParts(
                            "package",
                            BuildConfig.APPLICATION_ID, null
                        )
                        intent.data = uri
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        startActivity(intent)
                    })
            }
        }
    }

}