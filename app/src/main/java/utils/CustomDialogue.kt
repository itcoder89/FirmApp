package utils

import android.app.Activity
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import com.afollestad.materialdialogs.MaterialDialog
import com.firmapp.DashboardActivity
import com.firmapp.R

class CustomDialogue {
    companion object {
        fun showcustomblank(context: Activity, title: String, message: String) {
            val material = MaterialDialog.Builder(context)
                .customView(R.layout.blank_value_error, true)
                .show()
            val btncncl = material.findViewById(R.id.retry) as Button
            val tv_titel = material.findViewById(R.id.title) as TextView
            val tv_message = material.findViewById(R.id.msg) as TextView
            tv_titel.text = title
            tv_message.text = message

            btncncl.setOnClickListener {
                material.cancel()
            }

        }

        fun showCustomBlankWithFinish(context: Activity, title: String, message: String) {
            val material = MaterialDialog.Builder(context)
                .customView(R.layout.blank_value_error, true)
                .show()
            val btncncl = material.findViewById(R.id.retry) as Button
            val tv_titel = material.findViewById(R.id.title) as TextView
            val tv_message = material.findViewById(R.id.msg) as TextView
            tv_titel.text = title
            tv_message.text = message

            btncncl.setOnClickListener {
                material.cancel()
                context.startActivity(Intent(context, DashboardActivity::class.java))
                context.finishAffinity()
                //val intent =  Intent(context, TabActivity::class.java)
                //context.startActivity(intent)
               // context.finishAffinity()
            }
        }
    }
}