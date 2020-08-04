package activity

import Interfaces.Apicall
import android.app.TabActivity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.firmapp.DashboardActivity
import com.firmapp.R
import utils.SessionManager


class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long=3000 // 3 sec
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }

        Handler().postDelayed({
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            if (SessionManager.getInstance(this).getSharedPreferences(getString(R.string.LoginData_key)).equals("")) {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            } else {
                /*if(Apicall(this).getLoginData().data.isverify.equals("")){
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }else{*/
                   val intent = Intent(this, DashboardActivity::class.java)
                    //val intent = Intent(this, HelpCenterWebView::class.java)
                   // val intent = Intent(this, VideoListActivity::class.java)
                    startActivity(intent)
               // }
            }
            finish()
        }, SPLASH_TIME_OUT)
    }
}