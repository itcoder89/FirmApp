package utils;

import android.content.Context;
import android.preference.PreferenceManager;

public class LocalStorage {

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
}
