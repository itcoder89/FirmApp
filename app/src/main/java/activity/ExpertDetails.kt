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
import kotlinx.android.synthetic.main.expert_profile_layout.*
import model.ExpertDetailsData
import utils.CustomDialogue

class ExpertDetails : AppCompatActivity(), OnResponse<UniverSelObjct> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.expert_profile_layout)
        val ss:String = intent.getStringExtra("expertid")
        Apicall(this).getExpertDetailsData(this,"get-expert-details",ss)

        iv_back.setOnClickListener {
            finish()
        }
        tvTitle.text="Expert Details"
    }

    override fun onSucess(response: UniverSelObjct?) {
        try {
            if (response!!.status == "true") {
                when (response.methodname) {
                    "get-expert-details" -> {
                        val expertDetailsData = response.response as ExpertDetailsData
                        Log.e("expertDetailsData"," "+expertDetailsData.isStatus+"")
                        tvName.text=expertDetailsData.data.name
                        tvFatherName.text=expertDetailsData.data.father_name
                        tvContact.text=expertDetailsData.data.contact_no
                        tvEmail.text=expertDetailsData.data.email.toString()
                        tvAddress.text=expertDetailsData.data.address.toString()
                        tvAadharNo.text=expertDetailsData.data.aadhar_no.toString()
                        tvPanno.text=expertDetailsData.data.pan_no.toString()

                        Picasso
                            .with(this@ExpertDetails)
                            .load(expertDetailsData.img_path+expertDetailsData.data.e_image)
                            .into(profile_image);

                        Picasso
                            .with(this@ExpertDetails)
                            .load(expertDetailsData.img_path+expertDetailsData.data.signature_file)
                            .into(ivSignature);
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