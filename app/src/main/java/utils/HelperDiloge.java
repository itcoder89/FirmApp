package utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;

import com.firmapp.BuildConfig;
import com.firmapp.R;

import java.lang.ref.WeakReference;
import java.util.Objects;

public class HelperDiloge {
    private static ProgressDialog progressDialog;
    public static void showProgressDialog(Context context) {
        if (!((Activity) context).isFinishing()) {
            WeakReference<Context> weakActivity = new WeakReference<>(context);
            progressDialog = ProgressDialog.show(context, null, null, false, false);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                Objects.requireNonNull(progressDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
            progressDialog.setContentView(R.layout.progress_bar);
        }
    }

    public static void printLog(String message) {
        if (BuildConfig.DEBUG) {
            Log.e("COD", message);
        }
    }

    public static void hideProgressDialog(Context context) {
        try {
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        } catch (Exception ex) {
            HelperDiloge.printLog(ex.getMessage());
        }
    }

    public static boolean isNetwork(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }


}
