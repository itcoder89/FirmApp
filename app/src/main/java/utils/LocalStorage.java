package utils;

import android.content.Context;
import android.preference.PreferenceManager;

public class LocalStorage {

    public static void setFirstTimeLogin(Context context, String key) {
        android.content.SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        android.content.SharedPreferences.Editor prefsEditor = mPrefs.edit();
        prefsEditor.putString("setFirstTimeLogin", key);
        prefsEditor.commit();
    }

    public static String getFirstTimeLogin(Context context) {
        android.content.SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        return mPrefs.getString("setFirstTimeLogin", "false");
    }
    public static void setCustomerID(Context context, String key) {
        android.content.SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        android.content.SharedPreferences.Editor prefsEditor = mPrefs.edit();
        prefsEditor.putString("setCustomerID", key);
        prefsEditor.commit();
    }

    public static String getCustomerID(Context context) {
        android.content.SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        return mPrefs.getString("setCustomerID", "false");
    }
    public static void setCustomerEmailID(Context context, String key) {
        android.content.SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        android.content.SharedPreferences.Editor prefsEditor = mPrefs.edit();
        prefsEditor.putString("setCustomerEmailID", key);
        prefsEditor.commit();
    }

    public static String getCustomerEmailID(Context context) {
        android.content.SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        return mPrefs.getString("setCustomerEmailID", "");
    }
    public static void setFirmName(Context context, String key) {
        android.content.SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        android.content.SharedPreferences.Editor prefsEditor = mPrefs.edit();
        prefsEditor.putString("setFirmName", key);
        prefsEditor.commit();
    }

    public static String getFirmName(Context context) {
        android.content.SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        return mPrefs.getString("setFirmName", "");
    }
    public static void setCustomerImage(Context context, String key) {
        android.content.SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        android.content.SharedPreferences.Editor prefsEditor = mPrefs.edit();
        prefsEditor.putString("setCustomerImage", key);
        prefsEditor.commit();
    }

    public static String getCustomerImage(Context context) {
        android.content.SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        return mPrefs.getString("setCustomerImage", "");
    }
    public static void setCheckLastFragment(Context context, String key) {
        android.content.SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        android.content.SharedPreferences.Editor prefsEditor = mPrefs.edit();
        prefsEditor.putString("setCheckLastFragment", key);
        prefsEditor.commit();
    }

    public static String getCheckLastFragment(Context context) {
        android.content.SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        return mPrefs.getString("setCheckLastFragment", "dashboard");
    }
    public static void setFCMToken(Context context, String key) {
        android.content.SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        android.content.SharedPreferences.Editor prefsEditor = mPrefs.edit();
        prefsEditor.putString("setFCMToken", key);
        prefsEditor.commit();
    }

    public static String getFCMToken(Context context) {
        android.content.SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        return mPrefs.getString("setFCMToken", "token not generated");
    }
    public static void setLatitude(Context context, String key) {
        android.content.SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        android.content.SharedPreferences.Editor prefsEditor = mPrefs.edit();
        prefsEditor.putString("setLatitude", key);
        prefsEditor.commit();
    }

    public static String getLatitude(Context context) {
        android.content.SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        return mPrefs.getString("setLatitude", "0.0");
    }
    public static void setLongitude(Context context, String key) {
        android.content.SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        android.content.SharedPreferences.Editor prefsEditor = mPrefs.edit();
        prefsEditor.putString("setLongitude", key);
        prefsEditor.commit();
    }

    public static String getLongitude(Context context) {
        android.content.SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        return mPrefs.getString("setLongitude", "0.0");
    }
    public static void setRedirectWorking(Context context, String key) {
        android.content.SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        android.content.SharedPreferences.Editor prefsEditor = mPrefs.edit();
        prefsEditor.putString("setRedirectWorking", key);
        prefsEditor.commit();
    }

    public static String getRedirectWorking(Context context) {
        android.content.SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        return mPrefs.getString("setRedirectWorking", "false");
    }
}
