package activity

import Interfaces.Apicall
import Interfaces.OnResponse
import android.Manifest
import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.google.gson.Gson
import com.kodpartner.R
import com.social.ekchat.Interfaces.UniverSelObjct
import com.yalantis.ucrop.UCrop
import kotlinx.android.synthetic.main.comman_top_header.*
import kotlinx.android.synthetic.main.edit_profile_layout.*
import model.ProfileDetailsData
import model.UpdateProfileData
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit.AppDelegates
import utils.CustomDialogue
import utils.LocalStorage
import java.io.File
import java.io.FileNotFoundException
import java.io.InputStream
import java.util.*

class EditProfile : AppCompatActivity(), OnResponse<UniverSelObjct>, View.OnClickListener {


    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.iv_back -> {
                finish()
            }
            R.id.imvEditImage -> {
                if (checkPermission()) {
                    showPopmenu()
                } else {
                    requestPermission()
                }
            }
            R.id.imvEditImage1 -> {
                if (checkPermission()) {
                    showPopmenu()
                } else {
                    requestPermission()
                }
            }
            R.id.tvSaveDetailChangebg -> {
                if (validate()) {

                   /* Apicall(this).updateProfile(this,
                        "update-partner-profile",
                        LocalStorage.getCustomerID(this),
                        et_PName.text.toString().trim(),
                        et_PFatherName.text.toString().trim(),
                        et_AltrNo.text.toString().trim(),
                        et_PAddress.text.toString().trim(),
                        et_PanNo.text.toString().trim(),
                        et_AdharNo.text.toString().trim())*/

                    /*val loginRequest = HashMap<String, String>()
                    loginRequest["partner_id"] = LocalStorage.getCustomerID(this)
                    loginRequest["p_name"] =  et_PName.text.toString().trim()
                    loginRequest["p_father_name"] = et_PFatherName.text.toString().trim()
                    loginRequest["alt_mob_no"] = et_AltrNo.text.toString().trim()
                    loginRequest["p_address"] =  et_PAddress.text.toString().trim()
                    loginRequest["p_pan_no"] = et_PanNo.text.toString().trim()
                    loginRequest["p_aadhar_no"] = et_AdharNo.text.toString().trim()*/

                    val partner_id = MultipartBody.Part.createFormData("partner_id",LocalStorage.getCustomerID(this))
                    val p_name = MultipartBody.Part.createFormData("p_name",et_PName.text.toString().trim())
                    val p_father_name = MultipartBody.Part.createFormData("p_father_name",et_PFatherName.text.toString().trim())
                    val alt_mob_no = MultipartBody.Part.createFormData("alt_mob_no",et_AltrNo.text.toString().trim())
                    val p_address = MultipartBody.Part.createFormData("p_address",et_PAddress.text.toString().trim())
                    val p_pan_no = MultipartBody.Part.createFormData("p_pan_no", et_PanNo.text.toString().trim())
                    val p_aadhar_no = MultipartBody.Part.createFormData("p_aadhar_no", et_AdharNo.text.toString().trim())
                    ///var response= LoginResponse()

                    if (imageFile != null) {
                        val requestFile =
                            RequestBody.create(MediaType.parse("multipart/form-data"), imageFile!!)
                        val userImg = MultipartBody.Part.createFormData(
                            "profile_image",
                            imageFile!!.getName(),
                            requestFile
                        )
                        val userImg1 = MultipartBody.Part.createFormData(
                            "signature_file",
                            imageFile!!.getName(),
                            requestFile
                        )
                        Apicall(this).updateProfileNew(this,
                            "update-partner-profile",
                            partner_id,
                            p_name,
                            p_father_name,
                            alt_mob_no,
                            p_address,
                            p_pan_no,
                            p_aadhar_no,
                            userImg,
                            userImg1)
                    }

                }
            }
            R.id.cameradialogbtn -> {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                imageFile = File(
                    Environment.getExternalStorageDirectory(),
                    "HereIsFood" + System.currentTimeMillis() + ".jpg"
                )
                outputFileUri = Uri.fromFile(imageFile)
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    outputFileUri = FileProvider.getUriForFile(
                        this,
                        getPackageName() + ".provider",
                        imageFile!!
                    )
                } else {
                    outputFileUri = Uri.fromFile(imageFile)
                }
                Log.d("TAG", "outputFileUri intent$outputFileUri")
                intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri)
                startActivityForResult(intent, 0)
                dialog!!.cancel()

            }
            R.id.gallerydialogbtn -> {
                val intent = Intent(Intent.ACTION_PICK)
                intent.type = "image/*"
                startActivityForResult(intent, 1)
                dialog!!.cancel()
            }
            R.id.canceldialogbtn -> {
                dialog!!.cancel()
            }
            R.id.btnCrop -> {
                val root = Environment.getExternalStorageDirectory().toString()
                val myDir = File("$root/HereIsFood")
                if (!myDir.exists())
                    myDir.mkdirs()
                val destination = Uri.fromFile(
                    File(
                        myDir,
                        System.currentTimeMillis().toString() + "cropped.jpeg"
                    )
                )

                val options = UCrop.Options()
                options.setToolbarColor(resources.getColor(R.color.gray))
                options.setStatusBarColor(resources.getColor(R.color.gray))
                options.setFreeStyleCropEnabled(true)
                options.setShowCropFrame(true)
                UCrop.of(outputFileUri!!, destination)
                    .withOptions(options)
                    .withMaxResultSize(1080, 1080)
                    .start(this as Activity, UCrop.REQUEST_CROP)
//                UCrop.of(outputFileUri, destination)
//                        .withAspectRatio(16, 9)
//                        .withMaxResultSize(1080, 1080)
//                        .start(Objects.requireNonNull(getActivity()), UCrop.REQUEST_CROP);
                if (cropDialog != null && cropDialog!!.isShowing()) {
                    cropDialog!!.cancel()
                }
            }
            R.id.btnUseOrignal -> {
                if (cropDialog != null && cropDialog!!.isShowing()) {
                    cropDialog!!.cancel()
                }
                if (imageBitmap != null) {
                    img_user.setImageBitmap(imageBitmap)
                }
            }
        }
    }

    var result: ProfileDetailsData.DataBean? = null

    private var dialog: Dialog? = null
    private var cropDialog: Dialog? = null
    private var outputFileUri: Uri? = null
    private var imageFile: File? = null
    private var imageBitmap: Bitmap? = null
    private var selectedImagePath: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_profile_layout)
        if (intent.hasExtra("result"))
            result = intent.getParcelableExtra("result")



        iv_back.setOnClickListener(this)
        tvSaveDetailChangebg.setOnClickListener(this)
        imvEditImage1.setOnClickListener(this)
        imvEditImage.setOnClickListener(this)
        et_PName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence,
                start: Int,
                before: Int,
                count: Int
            ) {
            }

            override fun afterTextChanged(s: Editable) {
                if (!TextUtils.isEmpty(s)) {
                    til_Name.setError(null);
                }
            }
        })

        et_PFatherName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence,
                start: Int,
                before: Int,
                count: Int
            ) {
            }

            override fun afterTextChanged(s: Editable) {
                if (!TextUtils.isEmpty(s)) {
                    til_FLastName.setError(null);
                }
            }
        })

        et_AltrNo.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence,
                start: Int,
                before: Int,
                count: Int
            ) {
            }

            override fun afterTextChanged(s: Editable) {
                if (!TextUtils.isEmpty(s)) {
                    til_AlterNo.setError(null);
                }
            }
        })

        et_PAddress.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence,
                start: Int,
                before: Int,
                count: Int
            ) {
            }

            override fun afterTextChanged(s: Editable) {
                if (!TextUtils.isEmpty(s)) {
                    tt_address.setError(null);
                }
            }
        })

        et_PanNo.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence,
                start: Int,
                before: Int,
                count: Int
            ) {
            }

            override fun afterTextChanged(s: Editable) {
                if (!TextUtils.isEmpty(s)) {
                    tt_pan_no.setError(null);
                }
            }
        })

        et_AdharNo.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence,
                start: Int,
                before: Int,
                count: Int
            ) {
            }

            override fun afterTextChanged(s: Editable) {
                if (!TextUtils.isEmpty(s)) {
                    tt_adharno.setError(null);
                }
            }
        })


        tvTitle.text="Update Profile"

        if (result != null)
            initData(result!!)
    }

    private fun initData(result: ProfileDetailsData.DataBean) {

        if (!result.p_name.isNullOrEmpty())
            et_PName.setText(result.p_name)

        if (!result.p_father_name.isNullOrEmpty())
            et_PFatherName.setText(result.p_father_name)

        if (!result.alt_mob_no.isNullOrEmpty())
            et_AltrNo.setText(result.alt_mob_no)

        if (!result.p_address.isNullOrEmpty())
            et_PAddress.setText(result.p_address)

        if (!result.p_pan_no.isNullOrEmpty())
            et_PanNo.setText(result.p_pan_no)

        if (!result.p_aadhar_no.isNullOrEmpty())
            et_AdharNo.setText(result.p_aadhar_no)
    }

    override fun onSucess(response: UniverSelObjct?) {
        try {
            if (response!!.status == "true") {
                when (response.methodname) {
                    "update-partner-profile" -> {
                        val updateProfileData = response.response as UpdateProfileData
                        Log.e("updateProfileData"," "+updateProfileData.isStatus+"")
                        Toast.makeText(this, "" + updateProfileData.message, Toast.LENGTH_SHORT).show()
                        finish()
                        /*tvName.text=expertDetailsData.data.name
                        tvFatherName.text=expertDetailsData.data.father_name
                        tvContact.text=expertDetailsData.data.contact_no
                        tvEmail.text=expertDetailsData.data.email.toString()
                        tvAddress.text=expertDetailsData.data.address.toString()*/
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


    private fun validate(): Boolean {
        if (et_PName.text.toString().isEmpty()) {
            til_Name.error = getString(R.string.empty_p_name)
            til_Name.requestFocus()
            return false
        }
        til_Name.isErrorEnabled = false

        if (et_PFatherName.text.toString().isEmpty()) {
            til_FLastName.error = getString(R.string.empty_pfathername)
            til_FLastName.requestFocus()
            return false
        }
        til_FLastName.isErrorEnabled = false

        if (et_AltrNo.text.toString().isEmpty()) {
            til_AlterNo.error = getString(R.string.empty_alterno)
            til_AlterNo.requestFocus()
            return false
        }
        til_AlterNo.isErrorEnabled = false

        if (et_PAddress.text.toString().isEmpty()) {
            tt_address.error = getString(R.string.empty_address)
            tt_address.requestFocus()
            return false
        }
        tt_address.isErrorEnabled = false

        if (et_PanNo.text.toString().isEmpty()) {
            tt_pan_no.error = getString(R.string.empty_pan_no)
            tt_pan_no.requestFocus()
            return false
        }
        tt_pan_no.isErrorEnabled = false

        if (et_AdharNo.text.toString().isEmpty()) {
            tt_adharno.error = getString(R.string.empty_adhar)
            tt_adharno.requestFocus()
            return false
        }
        tt_adharno.isErrorEnabled = false

        return true
    }


    private fun checkPermission(): Boolean {
        val FirstPermissionResult = ContextCompat.checkSelfPermission(
            Objects.requireNonNull(this).getApplicationContext(),
            Manifest.permission.CAMERA
        )
        val SecondPermissionResult = ContextCompat.checkSelfPermission(
            this.getApplicationContext(),
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        val ThirdPermissionResult = ContextCompat.checkSelfPermission(
            this.getApplicationContext(),
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
        //        int ForthPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), ACCESS_FINE_LOCATION);
        return FirstPermissionResult == PackageManager.PERMISSION_GRANTED &&
                SecondPermissionResult == PackageManager.PERMISSION_GRANTED && ThirdPermissionResult == PackageManager.PERMISSION_GRANTED /*&& ForthPermissionResult == PackageManager.PERMISSION_GRANTED*/
    }

    val RequestPermissionCode = 1
    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            Objects.requireNonNull(this),
            arrayOf<String>(
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ),
            RequestPermissionCode
        )
    }

    private fun showPopmenu() {
        dialog = Dialog(this, R.style.AppTheme)
        dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog!!.setContentView(R.layout.cameradialog)
        Objects.requireNonNull<Window>(dialog!!.getWindow())
            .setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.trans_black)))
        val mCamerabtn = dialog!!.findViewById(R.id.cameradialogbtn) as AppCompatButton
        val mGallerybtn = dialog!!.findViewById(R.id.gallerydialogbtn) as AppCompatButton
        val btnCancel = dialog!!.findViewById(R.id.canceldialogbtn) as AppCompatButton
        dialog!!.getWindow()!!.setLayout(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        mCamerabtn.setOnClickListener(this)
        mGallerybtn.setOnClickListener(this)
        btnCancel.setOnClickListener(this)
        dialog!!.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        try {
            when (requestCode) {
                0 -> {
                    Objects.requireNonNull(this)
                    if (resultCode == Activity.RESULT_OK) {
                        Log.d("TAG", "outputFileUri RESULT_OK$outputFileUri")
                        if (outputFileUri != null) {
                            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                var ims: InputStream? = null
                                try {
                                    ims = this.getContentResolver()
                                        .openInputStream(outputFileUri!!)
                                } catch (e: FileNotFoundException) {
                                    e.printStackTrace()
                                }

                                imageBitmap = BitmapFactory.decodeStream(ims)
                            } else {
                                imageBitmap = AppDelegates.decodeSampledBitmapFromUri(
                                    outputFileUri!!,
                                    img_user.getWidth(),
                                    img_user.getHeight(),
                                    this
                                )
                            }
                            if (imageBitmap != null) {
                                if (imageFile != null) {
                                    selectedImagePath =
                                        imageFile!!.getAbsolutePath()// outputFileUri.getPath().
                                    imageBitmap =
                                        AppDelegates.rotateImageBitmap(
                                            selectedImagePath!!,
                                            imageBitmap!!
                                        )
                                    // imageFile = Util.compressImage(Env.currentActivity, imageFile);
                                }

                                if (imageBitmap != null)
                                    cropPopmenu(imageBitmap)
                            }
                        }
                    }
                }
                1 -> {
                    Objects.requireNonNull(this)
                    if (resultCode == Activity.RESULT_OK) {
                        outputFileUri = data!!.data
                        try {
                            selectedImagePath =
                                AppDelegates.getRealPathFromURI(this, outputFileUri!!)
                            imageFile = File(Objects.requireNonNull<String>(selectedImagePath))
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }

                        Log.d("TAG", "data$outputFileUri")
                        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            var ims: InputStream? = null
                            try {
                                ims = this.getContentResolver()
                                    .openInputStream(outputFileUri!!)
                            } catch (e: FileNotFoundException) {
                                e.printStackTrace()
                            }

                            imageBitmap = BitmapFactory.decodeStream(ims)
                        } else {
                            imageBitmap = AppDelegates.decodeSampledBitmapFromUri(
                                outputFileUri!!,
                                img_user.getWidth(),
                                img_user.getHeight(),
                                this
                            )
                        }
                        if (imageBitmap != null) {
                            if (imageFile != null) {
                                selectedImagePath =
                                    imageFile!!.getAbsolutePath()// outputFileUri.getPath().
                                imageBitmap = AppDelegates.rotateImageBitmap(
                                    selectedImagePath!!,
                                    imageBitmap!!
                                )
                                // imageFile = Util.compressImage(Env.currentActivity, imageFile);
                            }
                            if (imageBitmap != null)
                                cropPopmenu(imageBitmap)
                        }
                    }
                }

                else -> {
                }
            }
            if (resultCode == Activity.RESULT_OK && requestCode == UCrop.REQUEST_CROP) {
                outputFileUri = UCrop.getOutput(data!!)
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    var ims: InputStream? = null
                    try {
                        ims = this.getContentResolver().openInputStream(outputFileUri!!)
                    } catch (e: FileNotFoundException) {
                        e.printStackTrace()
                    }

                    imageBitmap = BitmapFactory.decodeStream(ims)
                } else {
                    imageBitmap = AppDelegates.decodeSampledBitmapFromUri(
                        outputFileUri!!,
                        img_user.getWidth(),
                        img_user.getHeight(),
                        this
                    )
                }
                if (imageBitmap != null) {
                    if (imageFile != null) {
                        selectedImagePath =
                            AppDelegates.getRealPathFromURI(this, outputFileUri!!)
                        imageBitmap =
                            AppDelegates.rotateImageBitmap(selectedImagePath!!, imageBitmap!!)
                    }
                    if (imageBitmap != null) {
                        img_user.setImageBitmap(imageBitmap)
                        imageFile = File(selectedImagePath)
                        //  imageFile = Util.compressImage(Env.currentActivity, imageFile);
                    }
                }
            } else if (resultCode == UCrop.RESULT_ERROR) {
                val cropError = UCrop.getError(data!!)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }


    }


    private fun cropPopmenu(mBitmap: Bitmap?) {
        try {
            cropDialog = Dialog(this, R.style.AppTheme)
            cropDialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
            cropDialog!!.setContentView(R.layout.crop_dialog)
            Objects.requireNonNull<Window>(cropDialog!!.getWindow())
                .setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.trans_black)))
            val imvImage = cropDialog!!.findViewById(R.id.imvImage) as AppCompatImageView
            if (mBitmap != null) {
                imvImage.setImageBitmap(mBitmap)
            }
            val btnUseOrignal = cropDialog!!.findViewById(R.id.btnUseOrignal) as AppCompatButton
            val btnCrop = cropDialog!!.findViewById(R.id.btnCrop) as AppCompatButton
            cropDialog!!.getWindow()!!.setLayout(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
            btnUseOrignal.setOnClickListener(this)
            btnCrop.setOnClickListener(this)
            cropDialog!!.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}