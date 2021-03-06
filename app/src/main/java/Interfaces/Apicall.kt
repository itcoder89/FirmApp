package Interfaces

import android.app.ProgressDialog
import android.content.Context
import android.util.Log
import android.widget.ProgressBar
import com.kodpartner.R
import com.google.gson.Gson
import com.social.ekchat.Interfaces.UniverSelObjct
import model.*
import okhttp3.MultipartBody
import retrofit.ApiRequest
import retrofit.RetrofitRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import utils.HelperDiloge
import utils.LocalStorage
import utils.SessionManager

class Apicall(activity_: Context) : ProgressBar(activity_) {

    private var mContext: Context = activity_

    fun show(progressDialog: ProgressDialog?) {
        progressDialog!!.setMessage("")
        progressDialog.show()
    }

    fun getLoginData(): LoginData {
        val loginData = SessionManager.getInstance(mContext).getSharedPreferences(mContext.getString(
            R.string.LoginData_key)
        )
        Log.e("response", loginData)
        val gson = Gson()
        val loginModel = gson.fromJson(loginData, LoginData::class.java)
        return loginModel
    }

    companion object {

        fun <T> isSettable(stuff: T?): Boolean {
            return !(stuff == null || stuff == "null")
        }
    }
    //get Login data api
    fun getLoginData(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        PhoneNumber: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getLogin(PhoneNumber,LocalStorage.getFCMToken(mContext))
            .enqueue(object : retrofit2.Callback<LoginData> {
                override fun onResponse(
                    call: retrofit2.Call<LoginData>,
                    response: Response<LoginData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,
                                response.body()!!.status.toString(),
                                response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<LoginData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun sendOtp(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        PhoneNumber: String,
        country_code: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.sendOtp(PhoneNumber,country_code)
            .enqueue(object : retrofit2.Callback<SendOTPData> {
                override fun onResponse(
                    call: retrofit2.Call<SendOTPData>,
                    response: Response<SendOTPData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,
                                response.body()!!.status.toString(),
                                response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<SendOTPData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }


    fun getDashboardData(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getDashboardData(city)
            .enqueue(object : retrofit2.Callback<DashboardData> {
                override fun onResponse(
                    call: retrofit2.Call<DashboardData>,
                    response: Response<DashboardData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<DashboardData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun pendingFeedbackList(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.pendingFeedbackList(city)
            .enqueue(object : retrofit2.Callback<PendingFeedbackListData> {
                override fun onResponse(
                    call: retrofit2.Call<PendingFeedbackListData>,
                    response: Response<PendingFeedbackListData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<PendingFeedbackListData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun getOpenLeadsData(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getOpenLeadsData(city)
            .enqueue(object : retrofit2.Callback<OpenLeadsData> {
                override fun onResponse(
                    call: retrofit2.Call<OpenLeadsData>,
                    response: Response<OpenLeadsData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<OpenLeadsData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun getHoldReason(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String,
        order_id: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getHoldReason(city,order_id)
            .enqueue(object : retrofit2.Callback<HoldReasonData> {
                override fun onResponse(
                    call: retrofit2.Call<HoldReasonData>,
                    response: Response<HoldReasonData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<HoldReasonData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun getOnHoldLeadsList(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getOnHoldLeadsList(city)
            .enqueue(object : retrofit2.Callback<OnHoldLeadsListData> {
                override fun onResponse(
                    call: retrofit2.Call<OnHoldLeadsListData>,
                    response: Response<OnHoldLeadsListData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<OnHoldLeadsListData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun getOnHoldLeadsListFilter(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String,
        lead: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getOnHoldLeadsListFilter(city,lead)
            .enqueue(object : retrofit2.Callback<OnHoldLeadsListData> {
                override fun onResponse(
                    call: retrofit2.Call<OnHoldLeadsListData>,
                    response: Response<OnHoldLeadsListData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<OnHoldLeadsListData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun getAllOpenLeadsData(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String,
        leads: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getAllOpenLeadsData(city,leads)
            .enqueue(object : retrofit2.Callback<OpenLeadsData> {
                override fun onResponse(
                    call: retrofit2.Call<OpenLeadsData>,
                    response: Response<OpenLeadsData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<OpenLeadsData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun getNewLeadsData(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getNewLeadsData(city)
            .enqueue(object : retrofit2.Callback<NewLeadsData> {
                override fun onResponse(
                    call: retrofit2.Call<NewLeadsData>,
                    response: Response<NewLeadsData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<NewLeadsData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun getRecomplaintsData(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getRecomplaintsData(city)
            .enqueue(object : retrofit2.Callback<RecomplaintsListData> {
                override fun onResponse(
                    call: retrofit2.Call<RecomplaintsListData>,
                    response: Response<RecomplaintsListData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<RecomplaintsListData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun getallCancelLeads(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getallCancelLeads(city)
            .enqueue(object : retrofit2.Callback<CancelLeadsData> {
                override fun onResponse(
                    call: retrofit2.Call<CancelLeadsData>,
                    response: Response<CancelLeadsData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<CancelLeadsData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun getallCancelLeadsFilter(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String,
        lead: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getallCancelLeadsFilter(city,lead)
            .enqueue(object : retrofit2.Callback<CancelLeadsData> {
                override fun onResponse(
                    call: retrofit2.Call<CancelLeadsData>,
                    response: Response<CancelLeadsData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<CancelLeadsData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun acceptOrders(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String,
        lead: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.acceptOrders(city,lead)
            .enqueue(object : retrofit2.Callback<AcceptLeadData> {
                override fun onResponse(
                    call: retrofit2.Call<AcceptLeadData>,
                    response: Response<AcceptLeadData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<AcceptLeadData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun removeOrderPartItem(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String,
        lead: String,
        idpart: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.removeOrderPartItem(city,lead,idpart)
            .enqueue(object : retrofit2.Callback<RemoveOrderPartData> {
                override fun onResponse(
                    call: retrofit2.Call<RemoveOrderPartData>,
                    response: Response<RemoveOrderPartData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<RemoveOrderPartData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun removeOrderFaultItem(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String,
        lead: String,
        idpart: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.removeOrderFaultItem(city,lead,idpart)
            .enqueue(object : retrofit2.Callback<RemoveOrderFaultData> {
                override fun onResponse(
                    call: retrofit2.Call<RemoveOrderFaultData>,
                    response: Response<RemoveOrderFaultData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<RemoveOrderFaultData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun getallCompletedLeads(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getallCompletedLeads(city)
            .enqueue(object : retrofit2.Callback<CompletedLeadsData> {
                override fun onResponse(
                    call: retrofit2.Call<CompletedLeadsData>,
                    response: Response<CompletedLeadsData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<CompletedLeadsData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun getallCompletedLeadsFilter(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String,
        lead: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getallCompletedLeadsFilter(city,lead)
            .enqueue(object : retrofit2.Callback<CompletedLeadsData> {
                override fun onResponse(
                    call: retrofit2.Call<CompletedLeadsData>,
                    response: Response<CompletedLeadsData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<CompletedLeadsData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }


    fun getallPendingLeads(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getallPendingLeads(city)
            .enqueue(object : retrofit2.Callback<PendingLeadsData> {
                override fun onResponse(
                    call: retrofit2.Call<PendingLeadsData>,
                    response: Response<PendingLeadsData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<PendingLeadsData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun getWalletSummary(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getWalletSummary(city)
            .enqueue(object : retrofit2.Callback<WalletSummaryData> {
                override fun onResponse(
                    call: retrofit2.Call<WalletSummaryData>,
                    response: Response<WalletSummaryData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<WalletSummaryData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }



    fun getallWorkingLeads(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getallWorkingLeads(city)
            .enqueue(object : retrofit2.Callback<WorkingLeadsData> {
                override fun onResponse(
                    call: retrofit2.Call<WorkingLeadsData>,
                    response: Response<WorkingLeadsData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<WorkingLeadsData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun getProfileData(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getProfileData(city)
            .enqueue(object : retrofit2.Callback<ProfileDetailsData> {
                override fun onResponse(
                    call: retrofit2.Call<ProfileDetailsData>,
                    response: Response<ProfileDetailsData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<ProfileDetailsData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun getRateCardData(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getRateCardData(city)
            .enqueue(object : retrofit2.Callback<RateListData> {
                override fun onResponse(
                    call: retrofit2.Call<RateListData>,
                    response: Response<RateListData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<RateListData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun getSubservice(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,city: String,service_id: String) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getSubService(city,service_id)
            .enqueue(object : retrofit2.Callback<SubServiceData> {
                override fun onResponse(
                    call: retrofit2.Call<SubServiceData>,
                    response: Response<SubServiceData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,
                                response.body()!!.status.toString(),
                                response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<SubServiceData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun getServiceListForRate(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getServiceListForRate(city)
            .enqueue(object : retrofit2.Callback<ServiceListForRateData> {
                override fun onResponse(
                    call: retrofit2.Call<ServiceListForRateData>,
                    response: Response<ServiceListForRateData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<ServiceListForRateData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun getallPendingLeadsFilter(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String,
        today: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getallPendingLeadsFilter(city,today)
            .enqueue(object : retrofit2.Callback<PendingLeadsData> {
                override fun onResponse(
                    call: retrofit2.Call<PendingLeadsData>,
                    response: Response<PendingLeadsData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<PendingLeadsData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun getExpertList(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getExpertList(city)
            .enqueue(object : retrofit2.Callback<ExpertListData> {
                override fun onResponse(
                    call: retrofit2.Call<ExpertListData>,
                    response: Response<ExpertListData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<ExpertListData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }


    fun getExpertDetailsData(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getExpertDetailsData(city)
            .enqueue(object : retrofit2.Callback<ExpertDetailsData> {
                override fun onResponse(
                    call: retrofit2.Call<ExpertDetailsData>,
                    response: Response<ExpertDetailsData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<ExpertDetailsData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun getWorkingArea(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getWorkingArea(city)
            .enqueue(object : retrofit2.Callback<WorkingAreaData> {
                override fun onResponse(
                    call: retrofit2.Call<WorkingAreaData>,
                    response: Response<WorkingAreaData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<WorkingAreaData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun partner_services_ver1(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.partner_services_ver1(city)
            .enqueue(object : retrofit2.Callback<AssignedServiceListData> {
                override fun onResponse(
                    call: retrofit2.Call<AssignedServiceListData>,
                    response: Response<AssignedServiceListData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<AssignedServiceListData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun getReschedueLeadsList(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getReschedueLeadsList(city)
            .enqueue(object : retrofit2.Callback<RescheduleLeadsData> {
                override fun onResponse(
                    call: retrofit2.Call<RescheduleLeadsData>,
                    response: Response<RescheduleLeadsData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<RescheduleLeadsData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun getWalletRechargeSummaryList(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getWalletRechargeSummaryList(city)
            .enqueue(object : retrofit2.Callback<WalletSummaryListData> {
                override fun onResponse(
                    call: retrofit2.Call<WalletSummaryListData>,
                    response: Response<WalletSummaryListData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<WalletSummaryListData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }


    fun getReschedueLeadsListFilter(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String,
        lead: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getReschedueLeadsListFilter(city,lead)
            .enqueue(object : retrofit2.Callback<RescheduleLeadsData> {
                override fun onResponse(
                    call: retrofit2.Call<RescheduleLeadsData>,
                    response: Response<RescheduleLeadsData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<RescheduleLeadsData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun closebyPartner(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        city: String,
        lead: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.closebyPartner(city,lead)
            .enqueue(object : retrofit2.Callback<CloseByPartnerData> {
                override fun onResponse(
                    call: retrofit2.Call<CloseByPartnerData>,
                    response: Response<CloseByPartnerData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<CloseByPartnerData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun getoptconfirmation(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        partnerid: String,
        orderid: String,
        idstatus: String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getoptconfirmation(partnerid,orderid,idstatus)
            .enqueue(object : retrofit2.Callback<SendSMSOTPData> {
                override fun onResponse(
                    call: retrofit2.Call<SendSMSOTPData>,
                    response: Response<SendSMSOTPData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<SendSMSOTPData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun cancelBy(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        partner_id: String,
        order_id:String,
        reason:String
    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.cancelBy(partner_id,order_id,reason)
            .enqueue(object : retrofit2.Callback<CancelByData> {
                override fun onResponse(
                    call: retrofit2.Call<CancelByData>,
                    response: Response<CancelByData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<CancelByData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun gettimeDateSlab(activity: OnResponse<UniverSelObjct>,
                        mathod: String) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getTimeDateSlab()
            .enqueue(object : Callback<TimeDateSlabData> {
                override fun onResponse(
                    call: Call<TimeDateSlabData>,
                    response: Response<TimeDateSlabData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,
                                response.body()!!.status.toString(),
                                response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: Call<TimeDateSlabData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun getAboutApp(activity: OnResponse<UniverSelObjct>,
                        mathod: String) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getAboutApp()
            .enqueue(object : Callback<AboutAppData> {
                override fun onResponse(
                    call: Call<AboutAppData>,
                    response: Response<AboutAppData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: Call<AboutAppData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }


    fun rescheduleBooking(activity: OnResponse<UniverSelObjct>,
                          mathod: String,
                          partner_id:String,
                          order_id:String,
                          visit_date:String,
                          visit_time:String){
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.rescheduleBooking(partner_id,order_id,visit_date,visit_time)
            .enqueue(object : retrofit2.Callback<RescheduleData> {
                override fun onResponse(
                    call: retrofit2.Call<RescheduleData>,
                    response: Response<RescheduleData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,
                                response.body()!!.status.toString(),
                                response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: retrofit2.Call<RescheduleData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }


    fun CreateOrder(activity: OnResponse<UniverSelObjct>,
                    mathod: String,str_data:String) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getCreateOrders(str_data)
            .enqueue(object : Callback<CreateOrderData> {
                override fun onResponse(
                    call: Call<CreateOrderData>,
                    response: Response<CreateOrderData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,
                                response.body()!!.status.toString(),
                                response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: Call<CreateOrderData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun placeOrder(activity: OnResponse<UniverSelObjct>,
                    mathod: String,str_data:String) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.placeOrder(str_data)
            .enqueue(object : Callback<OrderPlaceData> {
                override fun onResponse(
                    call: Call<OrderPlaceData>,
                    response: Response<OrderPlaceData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: Call<OrderPlaceData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun getMoreFaults(activity: OnResponse<UniverSelObjct>,
                    mathod: String,
                    partner_id:String,
                    idservice:String,
                    idsubservice:String) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getMoreFaults(partner_id,idservice,idsubservice)
            .enqueue(object : Callback<GetMoreFaultsData> {
                override fun onResponse(
                    call: Call<GetMoreFaultsData>,
                    response: Response<GetMoreFaultsData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: Call<GetMoreFaultsData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun getOrderFaults(activity: OnResponse<UniverSelObjct>,
                    mathod: String,
                    partner_id:String,
                    order_id:String) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getOrderFaults(partner_id,order_id)
            .enqueue(object : Callback<GetOrderFaultsData> {
                override fun onResponse(
                    call: Call<GetOrderFaultsData>,
                    response: Response<GetOrderFaultsData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: Call<GetOrderFaultsData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun sendEstimateValue(activity: OnResponse<UniverSelObjct>,
                    mathod: String,
                    partner_id:String,
                    order_id:String,
                    amount:String,
                    working_amount:String,
                    working_title:String
                    ) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.sendEstimateValue(partner_id,order_id,amount,working_amount,working_title)
            .enqueue(object : Callback<EstimateSentData> {
                override fun onResponse(
                    call: Call<EstimateSentData>,
                    response: Response<EstimateSentData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: Call<EstimateSentData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun getPartListByOrderID(activity: OnResponse<UniverSelObjct>,
                    mathod: String,
                    partner_id:String,
                    order_id:String) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getPartListByOrderID(partner_id,order_id)
            .enqueue(object : Callback<GetPartListByOrderIdData> {
                override fun onResponse(
                    call: Call<GetPartListByOrderIdData>,
                    response: Response<GetPartListByOrderIdData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: Call<GetPartListByOrderIdData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun getOrderPartList(activity: OnResponse<UniverSelObjct>,
                    mathod: String,
                    partner_id:String,
                    order_id:String) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.getOrderPartList(partner_id,order_id)
            .enqueue(object : Callback<GetAllSelectedPartListData> {
                override fun onResponse(
                    call: Call<GetAllSelectedPartListData>,
                    response: Response<GetAllSelectedPartListData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: Call<GetAllSelectedPartListData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun walletRecharge(activity: OnResponse<UniverSelObjct>,
                    mathod: String,
                    partner_id:String,
                       payment_status:String,
                       recharge_amount:String,
                       transaction_number:String,
                       payment_date:String) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.walletRecharge(partner_id,payment_status,recharge_amount,transaction_number,payment_date)
            .enqueue(object : Callback<RechargeWalletData> {
                override fun onResponse(
                    call: Call<RechargeWalletData>,
                    response: Response<RechargeWalletData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: Call<RechargeWalletData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun saveOrderPart(activity: OnResponse<UniverSelObjct>,
                    mathod: String,
                    partner_id:String,
                      order_id:String,
                      partid:String,
                      part_amount:String) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.saveOrderPart(partner_id,order_id,partid,part_amount)
            .enqueue(object : Callback<SaveOrderPartData> {
                override fun onResponse(
                    call: Call<SaveOrderPartData>,
                    response: Response<SaveOrderPartData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: Call<SaveOrderPartData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun workClose(activity: OnResponse<UniverSelObjct>,
                    mathod: String,
                    partner_id:String,
                      order_id:String,
                      partid:String,
                      part_amount:String) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.workClose(partner_id,order_id,partid,part_amount)
            .enqueue(object : Callback<WorkCloseData> {
                override fun onResponse(
                    call: Call<WorkCloseData>,
                    response: Response<WorkCloseData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: Call<WorkCloseData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun holdByPartner(activity: OnResponse<UniverSelObjct>,
                    mathod: String,
                    partner_id:String,
                      order_id:String,
                      hold_reason:String,
                      visit_time:String,
                      visit_date:String) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.holdByPartner(partner_id,order_id,hold_reason,visit_time,visit_date)
            .enqueue(object : Callback<HoldByPartnerData> {
                override fun onResponse(
                    call: Call<HoldByPartnerData>,
                    response: Response<HoldByPartnerData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: Call<HoldByPartnerData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun addFaultSuccess(activity: OnResponse<UniverSelObjct>,
                    mathod: String,
                    partner_id:String,
                        order_id:String,
                        idfault:String,
                        default_amount:String,
                        amount:String,
                        qty:Int,
                        description:String) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.addFaultSuccess(partner_id,order_id,idfault,default_amount,amount,qty,description)
            .enqueue(object : Callback<AddFaultSuccessData> {
                override fun onResponse(
                    call: Call<AddFaultSuccessData>,
                    response: Response<AddFaultSuccessData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: Call<AddFaultSuccessData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun updateProfile(activity: OnResponse<UniverSelObjct>,
                    mathod: String,
                    partner_id:String,
                      p_name:String,
                      p_father_name:String,
                      alt_mob_no:String,
                      p_address:String,
                      p_pan_no:String,
                      p_aadhar_no:String) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.updateProfile(partner_id,p_name,p_father_name,alt_mob_no,p_address,p_pan_no,p_aadhar_no)
            .enqueue(object : Callback<UpdateProfileData> {
                override fun onResponse(
                    call: Call<UpdateProfileData>,
                    response: Response<UpdateProfileData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: Call<UpdateProfileData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }

    fun updateProfileWithImage(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        partner_id: MultipartBody.Part,
        p_name: MultipartBody.Part,
        p_father_name: MultipartBody.Part,
        alt_mob_no: MultipartBody.Part,
        p_address: MultipartBody.Part,
        p_pan_no: MultipartBody.Part,
        p_aadhar_no: MultipartBody.Part,
        photo: MultipartBody.Part,
        signature: MultipartBody.Part) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.updateProfileWithImage(partner_id,p_name,p_father_name,alt_mob_no,p_address,p_pan_no,p_aadhar_no,photo,signature)
            .enqueue(object : Callback<UpdateProfileData> {
                override fun onResponse(
                    call: Call<UpdateProfileData>,
                    response: Response<UpdateProfileData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: Call<UpdateProfileData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }


    fun offlineRecharge(
        activity: OnResponse<UniverSelObjct>,
        mathod: String,
        partner_id: MultipartBody.Part,
        receipt_number: MultipartBody.Part,
        payment_mode: MultipartBody.Part,
        cheque_number: MultipartBody.Part,
        transaction_number: MultipartBody.Part,
        amount: MultipartBody.Part,
        cheque_bank_name: MultipartBody.Part,
        cheque_date: MultipartBody.Part,
        other_details: MultipartBody.Part,
        payment_image: MultipartBody.Part) {
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.offlineRecharge(partner_id,receipt_number,payment_mode,cheque_number,transaction_number,amount,cheque_bank_name,cheque_date,other_details,payment_image)
            .enqueue(object : Callback<OfflineRechargeData> {
                override fun onResponse(
                    call: Call<OfflineRechargeData>,
                    response: Response<OfflineRechargeData>
                ) {
                    HelperDiloge.hideProgressDialog(mContext)
                    if (response.body() == null) {
                        activity.onError(response.errorBody()!!.string())
                    } else {
                        activity.onSucess(
                            UniverSelObjct(
                                response.body()!!,
                                mathod,"true",""
                                //response.body()!!.status.toString(),""
                                //response.body()!!.message
                            )
                        )
                    }
                }

                override fun onFailure(call: Call<OfflineRechargeData>, t: Throwable) {
                    HelperDiloge.hideProgressDialog(mContext)
                    Log.e("", "")
                    activity.onError(t.message.toString())
                }
            })
    }
}