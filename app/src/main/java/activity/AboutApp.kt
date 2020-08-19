package activity

import Interfaces.Apicall
import Interfaces.OnResponse
import android.os.Bundle
import android.text.Html
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kodpartner.R
import com.social.ekchat.Interfaces.UniverSelObjct
import kotlinx.android.synthetic.main.about_app_layout.*
import kotlinx.android.synthetic.main.comman_top_header.*
import model.AboutAppData
import utils.LocalStorage

class AboutApp: AppCompatActivity(), OnResponse<UniverSelObjct> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_app_layout)

        iv_back.setOnClickListener{
            finish()
        }
        tvTitle.text="About us"
        Apicall(this)
            .getAboutApp(this,"about-this-app")
    }
    override fun onSucess(response: UniverSelObjct?) {
        try {
            if (response!!.status == "true") {
                when (response.methodname) {
                    "about-this-app" -> {
                        var aboutAppData = response.response as AboutAppData
                        Log.e("about-this-app", "size- " + aboutAppData!!.message)
                        //Toast.makeText(this,""+getOrderFaultsData.message,Toast.LENGTH_SHORT).show()
                        tvAboutus.text= Html.fromHtml(aboutAppData.data.aboutus)
                    }
                }
            }
        }catch (e:Exception){
            e.printStackTrace()
        }


    }

    override fun onError(error: String?) {
        TODO("Not yet implemented")
    }


}