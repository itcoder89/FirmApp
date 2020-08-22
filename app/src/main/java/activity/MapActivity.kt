package activity

import Interfaces.Apicall
import Interfaces.OnResponse
import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.IntentSender.SendIntentException
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.net.Uri
import android.os.Bundle
import android.os.Looper
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.afollestad.materialdialogs.BuildConfig
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.material.snackbar.Snackbar
import com.kodpartner.R
import com.social.ekchat.Interfaces.UniverSelObjct
import kotlinx.android.synthetic.main.comman_top_header.*
import kotlinx.android.synthetic.main.current_location_layout.*
import model.WorkingAreaData
import utils.CustomDialogue
import utils.LocalStorage
import java.util.*

class MapActivity : AppCompatActivity(),View.OnClickListener,OnMapReadyCallback,
    OnResponse<UniverSelObjct> {

    private val TAG: String = MapActivity::class.java.getSimpleName()
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
    private var dupdateLat: Double? = null
    private var dupdateLng: Double? = null
    private var strAddress: String? = null
    private var btnsetlocation: Button? = null
    var mMapView: MapView? = null
    private var googleMap: GoogleMap? = null
    var initialMapLoad = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.current_location_layout)
        mMapView = findViewById(R.id.mapView) as MapView
        mMapView!!.onCreate(savedInstanceState)
        mMapView!!.onResume() // needed to get the map to display immediately

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        mSettingsClient = LocationServices.getSettingsClient(this)
        mRequestingLocationUpdates = false
        /*
        This is called before initializing the map because the map needs permissions(the cause of the crash)
        */
        /*if (Build.VERSION.SDK_INT == Build.VERSION_CODES.M ) {
            checkPermission();
        }*/
        /*updateValuesFromBundle(savedInstanceState)
        createLocationCallback()
        createLocationRequest()
        buildLocationSettingsRequest()
        startLocationUpdates()*/
        Apicall(this).getWorkingArea(this,"partner-working-area", LocalStorage.getCustomerID(this))
        init()

    }

    private fun init() {
        iv_back.setOnClickListener {
            finish()
        }
        tvCurrentLocation.setOnClickListener {
            val uri ="http://maps.google.com/maps?f=d&hl=en&saddr=" + updateLat.toString() + "," + updateLng.toString() + "&daddr=" + dupdateLat.toString() + "," + dupdateLng
            val intent =  Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            intent.setPackage("com.google.android.apps.maps");
            //startActivity(Intent.createChooser(intent, "Select an application"))
            startActivity(intent)
        }
        tvTitle.text="Working Area Details"
        //btnsetlocation = findViewById(R.id.btnsetlocation) as Button
      //  tvCurrentLocation = findViewById(R.id.tvCurrentLocation) as TextView
      //  tvHeaderName = findViewById(R.id.tvHeaderName) as TextView
        //iv_back = findViewById(R.id.iv_back) as ImageView
        //ivDragMarker = findViewById(R.id.ivDragMarker) as ImageView
        /*tvHeaderName.setText("Set Location")
        iv_back.setOnClickListener(this)*/
       // btnsetlocation.setOnClickListener(this)
        mMapView!!.getMapAsync(this)
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
                                this@MapActivity,
                                REQUEST_CHECK_SETTINGS
                            )
                        } catch (sie: SendIntentException) {
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
                            this@MapActivity,
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
                if (initialMapLoad == false) {
                    initialMapLoad = true
                    //Log.e(TAG, "current location");
                    Log.e("currentlocation","lat " + mCurrentLocation!!.getLatitude().toString())
                    Log.e("currentlocation","lng " + mCurrentLocation!!.getLongitude().toString())
                    updateLat = mCurrentLocation!!.getLatitude()
                    updateLng = mCurrentLocation!!.getLongitude()
                    val coordinates = LatLng(mCurrentLocation!!.getLatitude(),mCurrentLocation!!.getLongitude())
                   // drawCircle(coordinates)
                   /* val coordinates = LatLng(mCurrentLocation!!.getLatitude(),mCurrentLocation!!.getLongitude())
                    // For zooming automatically to the location of the marker
                    val cameraPosition =
                        CameraPosition.Builder().target(coordinates).zoom(18f).build()
                    googleMap!!.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))*/
                    /*LocalStorage.setLatitude(
                        this@CurrentLocationActivity,
                        mCurrentLocation.getLatitude().toString()
                    )
                    LocalStorage.setLongitude(
                        this@CurrentLocationActivity,
                        mCurrentLocation.getLongitude().toString()
                    )*/
                    //drawCircle(coordinates)
                    strAddress = getCompleteAddressString(
                        mCurrentLocation!!.getLatitude(),
                        mCurrentLocation!!.getLongitude()
                    )
                    //tvCurrentLocation.setText(strAddress)
                }
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

    override fun onClick(p0: View?) {


    }

    override fun onMapReady(map: GoogleMap?) {
        googleMap = map
        // googleMap.setMyLocationEnabled(true);
        // googleMap.setMyLocationEnabled(true);
        Log.e("onMapReady", "ready!")
        googleMap!!.setOnCameraIdleListener {
            val latLng = googleMap!!.cameraPosition.target
            Log.e("onCameraIdle", "latitude " + latLng.latitude)
            Log.e("onCameraIdle", "longitude " + latLng.longitude)
            updateLat = latLng.latitude
            updateLng = latLng.longitude
            //LocalStorage.setLatitude(this@CurrentLocationActivity, latLng.latitude.toString())
            //LocalStorage.setLongitude(this@CurrentLocationActivity, latLng.longitude.toString())
            /*if (latLng.latitude != 0.0 && latLng.longitude != 0.0) {
                strAddress = getCompleteAddressString(latLng.latitude, latLng.longitude)
                tvCurrentLocation.setText(strAddress)
            }*/
        }
    }

    private fun getCompleteAddressString(
        LATITUDE: Double,
        LONGITUDE: Double
    ): String? {
        var strAdd = ""
        val geocoder = Geocoder(this, Locale.getDefault())
        try {
            val addresses =
                geocoder.getFromLocation(LATITUDE, LONGITUDE, 1)
            if (addresses != null) {
                val returnedAddress = addresses[0]
                val strReturnedAddress = StringBuilder("")
                for (i in 0..returnedAddress.maxAddressLineIndex) {
                    strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n")
                }
                strReturnedAddress.append(returnedAddress.postalCode).append("\n")
                /*LocalStorage.setPincode(
                    this@MapActivity,
                    returnedAddress.postalCode
                )*/
                strReturnedAddress.append(returnedAddress.locality).append("\n")
                strAdd = strReturnedAddress.toString()
                Log.w("Myloctionaddress", strReturnedAddress.toString())
            } else {
                Log.w("Myloctionaddress", "No Address returned!")
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            Log.w("Myloctionaddress", "Canont get Address!")
        }
        return strAdd
    }

    private fun drawCircle(point: LatLng,radius:Double) {
        // Instantiating CircleOptions to draw a circle around the marker
        val circleOptions = CircleOptions()
        // Specifying the center of the circle
        circleOptions.center(point)
        // Radius of the circle
        //circleOptions.radius(50.0)
        circleOptions.radius(radius)
        // Border color of the circle
        //circleOptions.strokeColor(Color.BLACK)
        // Fill color of the circle
        circleOptions.fillColor(0x30ff0000)
        // Border width of the circle
        circleOptions.strokeWidth(0f)
        // Adding the circle to the GoogleMap
        googleMap!!.addCircle(circleOptions)
    }

    override fun onSucess(response: UniverSelObjct?) {
        try {
            if (response!!.status == "true") {
                when (response.methodname) {
                    "partner-working-area" -> {
                        val workingAreaData = response.response as WorkingAreaData
                        Log.e("expertDetailsData"," "+workingAreaData.isStatus+"")
                        dupdateLat=workingAreaData.data.lat_codes
                        dupdateLng=workingAreaData.data.lng_codes
                        tvCurrentLocation.text="Working Area\n"+workingAreaData.data.f_city_name

                        val coordinates = LatLng(workingAreaData.data.lat_codes.toDouble(),workingAreaData.data.lng_codes.toDouble())
                        // For zooming automatically to the location of the marker
                        val cameraPosition =
                            CameraPosition.Builder().target(coordinates).zoom(18f).build()
                        googleMap!!.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
                        drawCircle(coordinates,workingAreaData.data.working_radius)
                    }

                }

            }
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    override fun onError(error: String?) {
        CustomDialogue.showcustomblank(this, "Alert", error.toString())
    }


}