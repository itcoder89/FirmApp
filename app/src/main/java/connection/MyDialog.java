package connection;


import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;

import com.kodpartner.R;


/**
 * Created by wscubetech on 16/10/15.
 */
public class MyDialog
{

    Activity act;

    public MyDialog(Activity act)
    {
        this.act = act;
    }

    public Dialog getMyDialog(int layout)
    {
        Dialog d = new Dialog(act, R.style.ProgressBarTheme);
        d.getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        d.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        d.setContentView(layout);
        return d;
    }


    public Dialog getProgressDialog()
    {
        Dialog dialog = new Dialog(act);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_progress);
        dialog.setCancelable(false);
        ProgressBar pbHeaderProgress = (ProgressBar) dialog.findViewById(R.id.avloadingIndicatorView);

        pbHeaderProgress.getIndeterminateDrawable().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);


        return dialog;
    }


    public Dialog getNoInternetDialog()
    {
        final Dialog dialog = new Dialog(act);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_internet);
        dialog.setCancelable(true);

        Button btnRetry = (Button) dialog.findViewById(R.id.btnRetry);

        btnRetry.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dialog.dismiss();
            }
        });


        return dialog;
    }


}
