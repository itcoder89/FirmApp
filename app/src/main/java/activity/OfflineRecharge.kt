package activity

import Interfaces.Apicall
import Interfaces.OnResponse
import android.Manifest
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kodpartner.R
import com.social.ekchat.Interfaces.UniverSelObjct
import kotlinx.android.synthetic.main.comman_top_header.*
import kotlinx.android.synthetic.main.custom_offline_recharge_popup.*
import model.OfflineRechargeData
import okhttp3.MediaType
import okhttp3.MultipartBody
import pl.aprilapps.easyphotopicker.DefaultCallback
import pl.aprilapps.easyphotopicker.EasyImage
import retrofit.AppGlobal
import utils.LocalStorage
import utils.RetrofitUtils
import java.io.File
import java.util.*

class OfflineRecharge  : AppCompatActivity(),
    OnResponse<UniverSelObjct> {
    var strChequeDate=""
    var strSelectPMode=""
    var picker: TimePickerDialog? = null
    private val MY_CAMERA_REQUEST_CODE = 100
    private var imgUrl: File? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_offline_recharge_popup)
        inital()
    }

    private fun inital() {
        tvTitle.text="Offline Recharge"
        iv_back.setOnClickListener {
            finish()
        }
        val paymentmode = resources.getStringArray(R.array.paymentmode)

        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, paymentmode)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    strSelectPMode=paymentmode[position]
                   /* Toast.makeText(this@OfflineRecharge,
                        getString(R.string.selected_item) + " " +
                                "" + paymentmode[position], Toast.LENGTH_SHORT).show()*/
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }


        tvSetChequeDate.setOnClickListener {
            val myDateListener =
                DatePickerDialog.OnDateSetListener { arg0, year, monthOfYear, dayOfMonth ->
                    Log.e(
                        "onDateSet()",
                        "arg0 = [$arg0], year = [$year], monthOfYear = [$monthOfYear], dayOfMonth = [$dayOfMonth]"
                    )
                    tvSetChequeDate.setText(
                        year.toString() + "-" + monthOfYear + "-"
                                + dayOfMonth
                    )
                    strChequeDate=tvSetChequeDate.text.toString()
                }

            val calendar = Calendar.getInstance()
            val mYear = calendar[Calendar.YEAR]
            val mMonth = calendar[Calendar.MONTH]
            val mDay = calendar[Calendar.DAY_OF_MONTH]

            val dpDialog =
                DatePickerDialog(this, myDateListener, mYear, mMonth, mDay)
            dpDialog.datePicker.maxDate = calendar.timeInMillis

            dpDialog.show()
        }
        ivUploadProof.setOnClickListener { selectImage() }
        tvNo.setOnClickListener { finish() }
        tvYesCancel.setOnClickListener {
            if (et_other_info.text.toString().length <= 0) {
                AppGlobal.showToast(this, "Please enter other info")
            } else if (edEnterReceiptNo.text.toString().length <= 0) {
                AppGlobal.showToast(this, "please enter receipt no")
            } else if (edEnterCheckNo.text.toString().length <= 0) {
                AppGlobal.showToast(this, "please enter cheque no")
            } else if (edEnterTransactionNo.text.toString().length <= 0) {
                AppGlobal.showToast(this, "please enter transaction no")
            } else if (edEnterAmount.text.toString().length <= 0) {
                AppGlobal.showToast(this, "please enter amount")
            } else if (edEnterCheckBankName.text.toString().length <= 0) {
                AppGlobal.showToast(this, "please enter cheque bank name")
            } else {
                //Log.e("request","order_id"+order_id+" reason "+et_other_info.text.toString()+" time "+strTime+" date "+strDateTime)
                val partner_id = MultipartBody.Part.createFormData(
                    "partner_id",
                    LocalStorage.getCustomerID(this)
                )
                val receipt_no = MultipartBody.Part.createFormData(
                    "receipt_number",
                    edEnterReceiptNo.text.toString().trim()
                )
                val other_info = MultipartBody.Part.createFormData(
                    "other_details",
                    et_other_info.text.toString().trim()
                )
                val trns_no = MultipartBody.Part.createFormData(
                    "transaction_number",
                    edEnterTransactionNo.text.toString().trim()
                )
                val cheque_no = MultipartBody.Part.createFormData(
                    "cheque_number",
                    edEnterCheckNo.text.toString().trim()
                )
                val amount = MultipartBody.Part.createFormData(
                    "amount",
                    edEnterAmount.text.toString().trim()
                )
                val cheque_bank_name = MultipartBody.Part.createFormData(
                    "cheque_bank_name",
                    edEnterCheckBankName.text.toString().trim()
                )
                val payment_mode = MultipartBody.Part.createFormData("payment_mode", strSelectPMode)
                val cheque_date = MultipartBody.Part.createFormData("cheque_date", strChequeDate)

                if (imgUrl != null) {
                    Log.e("file", imgUrl!!.getAbsolutePath());
                    val type: String = RetrofitUtils.getMimeType(this, Uri.fromFile(imgUrl))
                    if (type == null) {
                        Log.e("filetype", "Nothing to do")
                    }
                    val body = RetrofitUtils.createFilePart(
                        "profile_image",
                        imgUrl!!.getAbsolutePath(),
                        MediaType.parse("profile_image")
                    )
                    Apicall(this)
                        .offlineRecharge(
                            this, "partner-offline-recharge",
                            partner_id,
                            receipt_no,
                            payment_mode,
                            cheque_no,
                            trns_no,
                            amount,
                            cheque_bank_name,
                            cheque_date,
                            other_info,
                            body
                        )
                }
            }
        }

    }



    override fun onSucess(response: UniverSelObjct?) {
        try {
            //if (response!!.status == "true") {
            when (response!!.methodname) {
                "partner-offline-recharge" -> {
                    val offlineRechargeData = response.response as OfflineRechargeData
                    Log.e("offlineRechargeData",""+offlineRechargeData.message)
                    Toast.makeText(this,""+offlineRechargeData.message,Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }catch (e:Exception){e.printStackTrace()}
    }

    override fun onError(error: String?) {
        TODO("Not yet implemented")
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        EasyImage.handleActivityResult(
            requestCode,
            resultCode,
            data,
            this@OfflineRecharge,
            object : DefaultCallback() {
                override fun onImagePickerError(
                    e: java.lang.Exception,
                    source: EasyImage.ImageSource,
                    type: Int
                ) {
                    //Some error handling
                    e.printStackTrace()
                }

                override fun onImagePicked(
                    imageFile: File,
                    source: EasyImage.ImageSource,
                    type: Int
                ) {
                    if (type == 100) {
                        imgUrl = File(imageFile.absolutePath)
                        Log.e("imgUrl", "100:$imgUrl")
                        Glide.with(this@OfflineRecharge)
                            .load(imageFile.absolutePath)
                            .apply(RequestOptions())
                            .into(ivUploadProof!!)
                    } else {
                        imgUrl = File(imageFile.absolutePath)
                        Log.e("imgUrl", "200:$imgUrl")
                        //200:/data/user/0/com.kodpartner/cache/EasyImage/ecb0a786-a8b4-4cb4-a948-123405b05e2c.jpg
                        Glide.with(this@OfflineRecharge)
                            .load(imageFile.absolutePath)
                            .apply(RequestOptions())
                            .into(ivUploadProof!!)
                    }
                }

                override fun onCanceled(source: EasyImage.ImageSource, type: Int) {
                    //Cancel handling, you might wanna remove taken photo if it was canceled
                    if (source == EasyImage.ImageSource.CAMERA) {
                        val photoFile =
                            EasyImage.lastlyTakenButCanceledPhoto(this@OfflineRecharge)
                        photoFile?.delete()
                    }
                }
            })
    }
    /*Upload Event Image */
    private fun selectImage() {
        if (ContextCompat.checkSelfPermission(this@OfflineRecharge, Manifest.permission.CAMERA)
            !== PackageManager.PERMISSION_GRANTED
        ) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(
                    arrayOf(Manifest.permission.CAMERA),
                    MY_CAMERA_REQUEST_CODE
                )
            }
        }
        val options =
            arrayOf<CharSequence>("Take Photo", "Choose from Gallery", "Cancel")
        val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(this@OfflineRecharge)
        builder.setTitle("Add Photo!")
        builder.setItems(options, DialogInterface.OnClickListener { dialog, item ->
            try {
                if (options[item] == "Take Photo") {
                    //  EasyImage.openCamera(getActivity(), 100);
                    EasyImage.openCamera(this@OfflineRecharge, 100)
                    //EasyImage.openCamera(getFragmentManager().findFragmentById(R.id.containerView), 100);
                } else if (options[item] == "Choose from Gallery") {
                    EasyImage.openGallery(this@OfflineRecharge, 200)
                    //  EasyImage.openGallery(getFragmentManager().findFragmentById(R.id.containerView), 200);
                } else if (options[item] == "Cancel") {
                    dialog.dismiss()
                }
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        })
        builder.show()
    }
}