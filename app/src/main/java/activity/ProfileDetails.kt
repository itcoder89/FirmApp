package activity

import Interfaces.Apicall
import Interfaces.OnResponse
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kodpartner.R
import com.social.ekchat.Interfaces.UniverSelObjct
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.comman_top_header.*
import kotlinx.android.synthetic.main.profile_layout.*
import model.ProfileDetailsData
import utils.CustomDialogue
import utils.LocalStorage

class ProfileDetails : AppCompatActivity(), OnResponse<UniverSelObjct> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_layout)
        //val ss:String = intent.getStringExtra("expertid")
        Apicall(this).getProfileData(this,"partner-profile",LocalStorage.getCustomerID(this))

        iv_back.setOnClickListener {
            finish()
        }
        tvTitle.text="Profile Details"
    }

    override fun onSucess(response: UniverSelObjct?) {
        try {
            if (response!!.status == "true") {
                when (response.methodname) {
                    "partner-profile" -> {
                        val profileDetailsData = response.response as ProfileDetailsData
                        Log.e("profileDetailsData"," "+profileDetailsData.isStatus+"")
                        tvName.text=profileDetailsData.data.p_name
                        tvFatherName.text=profileDetailsData.data.p_father_name
                        tvContact.text=profileDetailsData.data.contact_no
                        tvEmail.text=profileDetailsData.data.email.toString()
                        tvAddress.text=profileDetailsData.data.p_address.toString()
                        tvAlterContact.text=profileDetailsData.data.alt_mob_no.toString()
                        tvPanno.text=profileDetailsData.data.p_pan_no.toString()
                        tvAadharNo.text=profileDetailsData.data.p_aadhar_no.toString()
                        tvFirmName.text=profileDetailsData.data.f_name.toString()
                        tvFirmUANNo.text=profileDetailsData.data.f_udhyog_no.toString()

                        LocalStorage.setCustomerImage(this,"https://kodservices.in/upload/firm_documents/"+profileDetailsData.data.p_image)
                        Picasso
                            .with(this)
                            .load("https://kodservices.in/upload/firm_documents/"+profileDetailsData.data.p_image)
                            .into(profile_image);

                        Picasso
                            .with(this)
                            .load("https://kodservices.in/upload/firm_documents/"+profileDetailsData.data.p_signature_file)
                            .into(sign_image);

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