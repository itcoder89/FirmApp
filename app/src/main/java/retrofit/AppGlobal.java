package retrofit;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Patterns;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.kodpartner.BuildConfig;
import com.kodpartner.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppGlobal {

    private static final String PREFS_NAME = "settings";
    private static final Lock lock = new ReentrantLock();
    private static final String TAG = AppGlobal.class.getSimpleName();
    private static final NavigableMap<Long, String> suffixes = new TreeMap<>();
    private static ProgressDialog progressDialog;
    private static final Pattern pattern = Pattern.compile("[\\-0-9]+");
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.US);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
    private static final SimpleDateFormat dateFormatChatList = new SimpleDateFormat("dd MMM", Locale.US);
    private static Dialog dialog;

    public static final String AUTH_KEY = "Bearer ";

    static {
        suffixes.put(1_000L, "k");
        suffixes.put(1_000_000L, "M");
        suffixes.put(1_000_000_000L, "G");
        suffixes.put(1_000_000_000_000L, "T");
        suffixes.put(1_000_000_000_000_000L, "P");
        suffixes.put(1_000_000_000_000_000_000L, "E");
    }

    /**
     * Display Toast
     *
     * @param context
     * @param message
     */
    public static void showToast(Context context, String message) {
        if (context != null)
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showToastLong(Context context, String message) {
        if (context != null)
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }


    public static void showProgressDialog(Context context, String msg) {
        showProgressDialog(context);
    }
    public static void showProgressDialog(Context context) {
        if (!((Activity) context).isFinishing()) {
            WeakReference<Context> weakActivity = new WeakReference<>(context);
            progressDialog = ProgressDialog.show(weakActivity.get(), null, null, false, false);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                Objects.requireNonNull(progressDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
            progressDialog.setContentView(R.layout.progress_bar);
        }
    }
    /**
     * Hide Progress Dialog
     *
     * @param context
     */
    public static void hideProgressDialog(Context context) {
        try {
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        } catch (Exception ex) {
            AppGlobal.printLog(ex.getMessage());
        }
    }

    /**
     * check Network Connection
     *
     * @param context
     * @return
     */
    public static boolean isNetwork(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert cm != null;
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public static void clearPreference(Context context) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.clear();
        editor.apply();
    }



    public static Typeface getGothamBook(Context context) {
        return Typeface.createFromAsset(context.getAssets(),
                "GothamBook.ttf");
    }


    /**
     * Store String to Preference
     *
     * @param c
     * @param value
     * @param key
     * @return
     */
    static public void setStringPreference(Context c, String value, String key) {
        SharedPreferences settings = c.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, AppGlobal.validateString(value));
        editor.apply();
    }

    /**
     * get String from Preference
     *
     * @param c
     * @param key
     * @return
     */
    static public String getStringPreference(Context c, String key) {
        SharedPreferences settings = c.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return settings.getString(key, "");
    }

    /**
     * Store integer to Preference.
     *
     * @param c
     * @param value
     * @param key
     * @return
     */
    static public boolean setIntegerPreference(Context c, int value, String key) {
        SharedPreferences settings = c.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(key, value);
        return editor.commit();
    }

    /**
     * get Integer from Preference
     *
     * @param c
     * @param key
     * @return
     */
    static public int getIntegerPreference(Context c, String key) {
        SharedPreferences settings = c.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return settings.getInt(key, -1);
    }

    /**
     * Store boolean to Preference
     *
     * @param c
     * @param value
     * @param key
     * @return
     */
    static public boolean setBooleanPreference(Context c, Boolean value, String key) {
        SharedPreferences settings = c.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }

    /**
     * get boolean from Preference
     *
     * @param c
     * @param key
     * @return
     */
    static public Boolean getBooleanPreference(Context c, String key) {
        SharedPreferences settings = c.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return settings.getBoolean(key, false);
    }

//    public static byte[] bitmapToByteArray(Bitmap bitmap) {
//        ByteArrayOutputStream stream1 = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream1);
//        return stream1.toByteArray();
//    }
//
//    public static String convertBitmapToBase64(Bitmap imgBitmap) {
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        imgBitmap.compress(Bitmap.CompressFormat.PNG, 100,
//                byteArrayOutputStream);
//        byte[] byteArray = byteArrayOutputStream.toByteArray();
//        String encoded = Base64.encodeToString(byteArray, Base64.DEFAULT);
//        return encoded;
//    }

    static public Boolean getBooleanPreferenceForChatFeed(Context c, String key) {
        SharedPreferences settings = c.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return settings.getBoolean(key, true);
    }

    /**
     * Hide Keyboard
     *
     * @param mContext
     */
    public static void hideKeyboard(Context mContext) {
        try {
            InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(((Activity) mContext).getWindow().getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            AppGlobal.printLog(e);
        }
    }

    /**
     * Convert dp to PIx
     *
     * @param res
     * @param dp
     * @return
     */
    public static int dpToPx(Resources res, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, res.getDisplayMetrics());

    }

    public static boolean isStringValid(String value) {
        return null != value && value.trim().length() > 0;
    }

    public static double validateDouble(String value) {
        if (isStringValid(value)) {
            try {
                return Double.parseDouble(value);
            } catch (NumberFormatException e) {
                return 0.0;
            }
        }
        return 0.0;
    }

    /**
     * convert to string value
     *
     * @param value string value
     * @return converted value in integer, default is 0
     */
    public static String validateString(String value) {
        if (isStringValid(value)) {
            return value;
        }
        return "";
    }

    /**
     * check string value able to convert as integer
     *
     * @param value ineteger string
     * @return converted value in integer, default is 0
     */
    public static Integer validateInteger(String value) {
        if (isStringValid(value)) {
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                AppGlobal.printLog(e);
            } catch (Exception e) {
                AppGlobal.printLog(e);
            }
        }
        return 0;
    }

    //set two decimal point funcation
    @SuppressLint("DefaultLocale")
    public static String setTwoDecimalValue(Float value){
        String s="0";
        try {
            s = String.format("%.2f", value);
            return s;
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        return s;
    }

    /**
     * check given email address is correct or not
     *
     * @param target
     * @return
     */
    public static boolean isValidEmail(CharSequence target) {
        try {
            if (target == null) {
                return false;
            } else {
                return Patterns.EMAIL_ADDRESS.matcher(target).matches();
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isValidMobileNumber(String stringToValidate) {
        if (stringToValidate != null && stringToValidate.length() == 10) {
            return true;
        }
        return false;
    }

    public static void printLog(String message) {
        if (BuildConfig.DEBUG) {
            Log.e(message, message);
        }
    }

    public static void printLog(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, message);
        }
    }

    public static void printLogInfo(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.i(tag, message);
        }
    }

    public static void printLogVerbose(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.v(tag, message);
        }
    }

    public static void printLogError(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, message);
        }
    }

    public static void printLogDebug(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, message);
        }
    }

    public static void printLog(Exception e) {
        if (BuildConfig.DEBUG) {
            e.printStackTrace();
        }
    }

    public static void printLog(String tag, Exception e) {
        if (BuildConfig.DEBUG) {
            e.printStackTrace();
            Log.e(tag, "" + e.getMessage());
        }
    }


    public static void noInternet(Context context) {
//        showAlertDialog(context, context.getString(R.string.msg_no_network));
        showAlertDialog(context, "Alert", context.getString(R.string.msg_no_network));
    }

    public static void closeNoInternetDlg() {
        try {
            if (dialog != null) {
                dialog.dismiss();
                dialog = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void showAlertDialog(Context context, String title, String message) {
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);

        LayoutInflater mInflater = LayoutInflater.from(context);
        View dialogView = mInflater.inflate(R.layout.dialog_app_ok, null);
        dialog.setContentView(dialogView);
        Button btnDialog1 = dialog.findViewById(R.id.btnDialog1);
        TextView tvTitle = dialog.findViewById(R.id.tvTitle);
        TextView tvMessage = dialog.findViewById(R.id.tvMessage);
        tvMessage.setVisibility(View.VISIBLE);
        tvTitle.setText(title);
        tvMessage.setText(message);
        btnDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialog != null)
                    dialog.dismiss();
            }
        });
        Window window = dialog.getWindow();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(window.getAttributes());
        int displayWidth = context.getResources().getDisplayMetrics().widthPixels;
        layoutParams.width = (int) (displayWidth * 0.85);
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(layoutParams);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    public static void showAlertDialog(Context context, String title) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        LayoutInflater mInflater = LayoutInflater.from(context);
        View dialogView = mInflater.inflate(R.layout.dialog_app_ok, null);
        dialog.setContentView(dialogView);
        Button btnDialog1 = dialog.findViewById(R.id.btnDialog1);
        TextView tvTitle = dialog.findViewById(R.id.tvTitle);
        //tvTitle.setMovementMethod(new ScrollingMovementMethod());
        tvTitle.setText(title);
        btnDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        Window window = dialog.getWindow();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(window.getAttributes());
        int displayWidth = context.getResources().getDisplayMetrics().widthPixels;
        layoutParams.width = (int) (displayWidth * 0.85);
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(layoutParams);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    public static String capitalizeFirstCharacterOfString(String capString) {
        StringBuffer capBuffer = new StringBuffer();
        Matcher capMatcher = Pattern.compile("([a-z])([a-z]*)", Pattern.CASE_INSENSITIVE).matcher(capString);
        while (capMatcher.find()) {
            if (TextUtils.isEmpty(capBuffer.toString())) {
                capMatcher.appendReplacement(capBuffer, capMatcher.group(1).toUpperCase() + capMatcher.group(2).toLowerCase());
            } else {
                capMatcher.appendReplacement(capBuffer, capMatcher.group(1).toLowerCase() + capMatcher.group(2).toLowerCase());
            }
        }
        return capMatcher.appendTail(capBuffer).toString();
    }

    public static String capitalizeFirstCharacterOfWord(String capString) {
        StringBuffer capBuffer = new StringBuffer();
        Matcher capMatcher = Pattern.compile("([a-z])([a-z]*)", Pattern.CASE_INSENSITIVE).matcher(capString);
        while (capMatcher.find()) {
            capMatcher.appendReplacement(capBuffer, capMatcher.group(1).toUpperCase() + capMatcher.group(2).toLowerCase());
        }
        return capMatcher.appendTail(capBuffer).toString();
    }

    public static String appendCommaIfNot(String value) {
        if (isStringValid(value)) {
            if (!value.contains(",")) {
                value = value + ", ";
            }
        } else {
            return "";
        }
        return value;
    }

    public static String appendDotIfNot(String value) {
        if (isStringValid(value)) {
            if (!value.contains(".")) {
                value = value + ". ";
            }
        } else {
            return "";
        }
        return value;
    }

    public static String removeCommaFromLast(String value) {
        if (isStringValid(value) && value.charAt(value.length() - 1) == ',') {
            value = value.substring(0, value.length() - 1);
        }
        return value;
    }


    public static void openWebPage(Context mContext, String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(mContext.getPackageManager()) != null) {
            mContext.startActivity(intent);
        }
    }

    public static int getScreenWidth(@NonNull Context context) {
        Point size = new Point();
        ((Activity) context).getWindowManager().getDefaultDisplay().getSize(size);
        return size.x;
    }

    public static int getScreenHeight(@NonNull Context context) {
        Point size = new Point();
        ((Activity) context).getWindowManager().getDefaultDisplay().getSize(size);
        return size.y;
    }

    public static int dp2px(Context context, int dp) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        display.getMetrics(displaymetrics);
        return (int) (dp * displaymetrics.density + 0.5f);
    }

    /**
     * Check if this device has a ic_camera
     */
    public static boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }

    public static String parseIntToString(String value) {
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return null;
    }

    public static String formatTime(long milliSeconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return validateString(timeFormat.format(calendar.getTime()));
    }


    public static String formatDate(long milliSeconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return validateString(dateFormat.format(calendar.getTime()));
    }

    public static String formatDateForChatList(long milliSeconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return validateString(dateFormatChatList.format(calendar.getTime()));
    }


    public static Bitmap decodeSampledBitmapFromResource(byte[] data, int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        //options.inPurgeable = true;
        BitmapFactory.decodeByteArray(data, 0, data.length, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(data, 0, data.length, options);
    }

    public static Bitmap decodeSampledBitmapFromResource(String picturePath, int reqWidth, int reqHeight) {
        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(picturePath, options);
        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(picturePath, options);
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;
            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

    public static void loadOriginalImage(Context mContext, String imageUrl, ImageView imageView) {
        Glide.with(mContext).load(imageUrl).into(imageView);
    }

    public static void loadResizeImage(Context mContext, String imageUrl, ImageView imageView, int size) {
        try {
            Glide.with(mContext).load(imageUrl)
                    .apply(new RequestOptions().override(size, size).centerCrop())
                    .into(imageView);
        } catch (Exception ex) {
            AppGlobal.printLog(ex);
        }
    }

    public static void loadResizeImage(Context mContext, String imageUrl, ImageView imageView, int width, int height) {
        try {

//            CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(mContext);
//            circularProgressDrawable.setStrokeWidth(5f);
//            circularProgressDrawable.setCenterRadius(30f);loadProfilePic
//            circularProgressDrawable.start();

            //R.drawable.post_placeholder

            Glide.with(mContext).load(imageUrl)
                    .apply(new RequestOptions()).into(imageView);
        } catch (Exception ex) {
            AppGlobal.printLog(ex);
        }
    }


    public static void loadResizeImage(Context mContext, String imageUrl, ImageView imageView, int size, String tt) {
        try {
            Glide.with(mContext)
                    .load(imageUrl)
                    .apply(new RequestOptions().override(size, size))
                    .into(imageView);
        } catch (Exception ex) {
            AppGlobal.printLog(ex);
        }
    }

    public static void loadResizeImagewithPlaceHolder(Context mContext, String imageUrl, ImageView imageView, int size) {
        try {
            Glide.with(mContext)
                    .load(imageUrl)
                    .apply(new RequestOptions().override(size, size).centerCrop().dontAnimate())
                    .into(imageView);
        } catch (Exception ex) {
            AppGlobal.printLog(ex);
        }
    }

    public static void loadProfilePic(Context mContext, String imageUrl, ImageView imageView, int size) {
        try {
            Glide.with(mContext)
                    .load(imageUrl).diskCacheStrategy(DiskCacheStrategy.ALL)
                    .apply(new RequestOptions())
                    .into(imageView);
        } catch (Exception ex) {
            AppGlobal.printLog(ex);
        }
    }

    public static void loadResizeImagewithPlaceHolder(final Context mContext, String imageUrl, final ImageView imageView, int size, final boolean isCircular) {
        try {
            Glide.with(mContext).asBitmap().load(imageUrl)
                    .apply(new RequestOptions().dontAnimate().override(size, size).centerCrop())
                    .into(new BitmapImageViewTarget(imageView) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                            RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);
                    circularBitmapDrawable.setCircular(isCircular);
                    imageView.setImageDrawable(circularBitmapDrawable);
                }
            });
        } catch (Exception ex) {
            AppGlobal.printLog(ex);
        }
    }


    public static void loadImageInBG(final Context mContext, String imageUrl) {

        Glide.with(mContext).load(imageUrl).downloadOnly(-1, -1);
    }





    public static boolean isValidPost(String valueString) {
        if (AppGlobal.isStringValid(valueString) && valueString.matches(".*\\w.*")) {
            return true;
        } else {
            return false;
        }
    }

    public static void clearAllSharedPreference(Context c) {
        SharedPreferences settings = c.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.clear();
        editor.commit();
    }

    public static int getCameraPhotoOrientation(Context context, Uri imageUri, String imagePath) {
        int rotate = 0;
        try {
            context.getContentResolver().notifyChange(imageUri, null);
            File imageFile = new File(imagePath);

            ExifInterface exif = new ExifInterface(imageFile.getAbsolutePath());
            int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);

            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_270:
                    rotate = 270;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    rotate = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_90:
                    rotate = 90;
                    break;
            }
            AppGlobal.printLog("Exif orientation: " + orientation);
            AppGlobal.printLog("Rotate value: " + rotate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rotate;
    }

    public static int getImageRotation(final File imageFile) {

        ExifInterface exif = null;
        int exifRotation = 0;

        try {
            exif = new ExifInterface(imageFile.getPath());
            exifRotation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (exif == null)
            return 0;
        else
            return exifToDegrees(exifRotation);
    }

    private static int exifToDegrees(int rotation) {
        if (rotation == ExifInterface.ORIENTATION_ROTATE_90)
            return 90;
        else if (rotation == ExifInterface.ORIENTATION_ROTATE_180)
            return 180;
        else if (rotation == ExifInterface.ORIENTATION_ROTATE_270)
            return 270;

        return 0;
    }

    public static Bitmap getBitmapRotatedByDegree(Bitmap bitmap, int rotationDegree) {
        Matrix matrix = new Matrix();
        matrix.preRotate(rotationDegree);

        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static String getAppVersion(Context context) {
        String version = "";
        PackageInfo pInfo;
        try {
            pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return version;
    }

    public static String getHashTags(Context context, String text) {
        Pattern MY_PATTERN = Pattern.compile("#(\\w+|\\W+)");
        Matcher mat = MY_PATTERN.matcher(text);
        String hashtags = "";
        while (mat.find()) {
            hashtags += "#" + mat.group(1) + ",";
        }
        if (!hashtags.equals(""))
            hashtags = hashtags.substring(0, hashtags.length() - 1);
        return hashtags;
    }


    public static void extractDB() {
        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();

            if (sd.canWrite()) {
                String currentDBPath = "/data/data/com.app.ekchat/databases/chat_database.db3";
                String backupDBPath = "ekchat_backup.db3";
                File currentDB = new File(currentDBPath);
                File backupDB = new File(sd, backupDBPath);

                if (currentDB.exists()) {
                    FileChannel src = new FileInputStream(currentDB).getChannel();
                    FileChannel dst = new FileOutputStream(backupDB).getChannel();
                    dst.transferFrom(src, 0, src.size());
                    src.close();
                    dst.close();
                }
            }
        } catch (Exception e) {
            printLog(e);
        }
    }

    public static String format(long value) {
        //Long.MIN_VALUE == -Long.MIN_VALUE so we need an adjustment here
        if (value == Long.MIN_VALUE) return format(Long.MIN_VALUE + 1);
        if (value < 0) return "-" + format(-value);
        if (value < 1000) return Long.toString(value); //deal with easy case

        Map.Entry<Long, String> e = suffixes.floorEntry(value);
        Long divideBy = e.getKey();
        String suffix = e.getValue();

        long truncated = value / (divideBy / 10); //the number part of the output times 10
        boolean hasDecimal = truncated < 100 && (truncated / 10d) != (truncated / 10);
        return hasDecimal ? (truncated / 10d) + suffix : (truncated / 10) + suffix;
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        StringBuffer response = new StringBuffer();
        while ((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }
        rd.close();
        AppGlobal.printLog("response String" + response.toString());
        return response.toString();
    }

    public static Animation inFromRightAnimation() {

        Animation inFromRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, +10.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromRight.setDuration(500);
        // inFromRight.setRepeatCount(1);
        inFromRight.setInterpolator(new AccelerateInterpolator());
        return inFromRight;
    }

    public static Animation outToLeftAnimation() {
        Animation outtoLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        outtoLeft.setDuration(500);
        outtoLeft.setInterpolator(new AccelerateInterpolator());
        return outtoLeft;
    }

    public static Animation inFromLeftAnimation() {
        Animation inFromLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromLeft.setDuration(500);
        inFromLeft.setInterpolator(new AccelerateInterpolator());
        return inFromLeft;
    }

    public static Animation outToRightAnimation() {
        Animation outtoRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        outtoRight.setDuration(500);
        outtoRight.setInterpolator(new AccelerateInterpolator());
        return outtoRight;
    }


    /* public static void resolveDatbaseVulnerabilities() {
         SQLiteDatabase db = null;
         try {
             int accessMode = SQLiteDatabase.OPEN_READONLY;
             SQLiteDatabase.CursorFactory cusrsorFactory = null;
             db = SQLiteDatabase.openDatabase(MyApplication.applicationContext.getDatabasePath("chat_database.db3").getPath(),
                     cusrsorFactory,
                     accessMode);
         } catch (Exception e) {
             e.printStackTrace();
         }
         if (db != null) {
             db.close();
         }
     }*/

    public static int getTranslationInDpBasedOnDeviceHeight(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        AppGlobal.printLog(TAG, "Device Height : " + height);
        height = height / 24;
        return height;
    }

    /**
     * convert ArrayList<String> to string
     *
     * @param selectedArraylistOptions
     * @return
     */
    public static String convertArraylistToString(ArrayList<String> selectedArraylistOptions) {
        String convertedStrings;
        if (selectedArraylistOptions.size() == 0) {
            convertedStrings = "";
        } else {
            convertedStrings = selectedArraylistOptions.toString();
            convertedStrings = convertedStrings.replace("[", "");
            convertedStrings = convertedStrings.replace("]", "");
        }
        return convertedStrings;
    }

    /**
     * convert  ArrayList<Int> to string
     *
     * @param selectedArraylistOptions
     * @return
     */
    public static String convertIntArraylistToString(ArrayList<Integer> selectedArraylistOptions) {
        String convertedStrings;
        if (selectedArraylistOptions.size() == 0) {
            convertedStrings = "";
        } else {
            convertedStrings = selectedArraylistOptions.toString();
            convertedStrings = convertedStrings.replace("[", "");
            convertedStrings = convertedStrings.replace("]", "");
        }
        return convertedStrings;
    }

    /**
     * convert simple string to String ArrayList
     *
     * @param stringData
     * @return
     */
    public static ArrayList<String> convertStringToArrayList(String stringData) {
        ArrayList<String> listData = new ArrayList<>();
        if (!TextUtils.isEmpty(stringData)) {
            stringData = stringData.replace(" ", "");
            listData = new ArrayList<>(Arrays.asList(stringData.split(",")));
        }
        return listData;

    }

    public static class FourDigitCardFormatWatcher implements TextWatcher {

        // Change this to what you want... ' ', '-' etc..
        private static final char space = ' ';

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            // Remove spacing char
            // Remove all spacing char
            int pos = 0;
            while (pos < s.length()) {
                if (space == s.charAt(pos) && (((pos + 1) % 5) != 0 || pos + 1 == s.length())) {
                    s.delete(pos, pos + 1);
                } else {
                    pos++;
                }
            }

            // Insert char where needed.
            pos = 4;
            while (pos < s.length()) {
                final char c = s.charAt(pos);
                // Only if its a digit where there should be a space we insert a space
                if ("0123456789".indexOf(c) >= 0) {
                    s.insert(pos, "" + space);
                }
                pos += 5;
            }
        }
    }

    public static void setCursorColor(EditText view, @ColorInt int color) {
        try {
            // Get the cursor resource id
            Field field = TextView.class.getDeclaredField("mCursorDrawableRes");
            field.setAccessible(true);
            int drawableResId = field.getInt(view);

            // Get the editor
            field = TextView.class.getDeclaredField("mEditor");
            field.setAccessible(true);
            Object editor = field.get(view);

            // Get the drawable and set a color filter
            Drawable drawable = ContextCompat.getDrawable(view.getContext(), drawableResId);
            drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
            Drawable[] drawables = {drawable, drawable};

            // Set the drawables
            field = editor.getClass().getDeclaredField("mCursorDrawableRes");
            field.setAccessible(true);
            field.set(editor, drawables);
        } catch (Exception ignored) {
            AppGlobal.printLog(ignored);
        }
    }


}
