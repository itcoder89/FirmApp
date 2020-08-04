package utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import model.FaultsData;

public class SessionManager {

    private static final String SHARED_PREF_NAME = "useractive";
    private static Context mCtx;
    private static SessionManager mInstance;

    public SessionManager(Context context) {
        mCtx = context;
    }

    public static synchronized SessionManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SessionManager(context);
        }
        return mInstance;
    }

    public void setSharedPreferences(String status, String key) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, status);
        editor.apply();
    }

    public String getSharedPreferences(String key) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String totalData = sharedPreferences.getString(key, "");

        return totalData;
    }

    public  void clearSession() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }


    public void addTOCard(Context cxt, ArrayList<FaultsData.DataBean> data){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(data);
        editor.putString("Data", json);
        editor.apply();

    }

    public void clearCart(){
        ArrayList<FaultsData.DataBean> cleardata = new ArrayList<FaultsData.DataBean>();
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(cleardata);
        editor.putString("Data", json);
        editor.apply();

    }

    public ArrayList<FaultsData.DataBean> getCartData() {
        ArrayList<FaultsData.DataBean> data = new ArrayList<>();

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String totalData = sharedPreferences.getString("Data", "");

        Log.e("totalData",totalData);

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<FaultsData.DataBean>>() {}.getType();
        if(!totalData.equals("")){
            data = gson.fromJson(totalData, type);
        }
        return data;
    }

}
