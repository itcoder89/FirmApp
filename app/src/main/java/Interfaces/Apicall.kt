package Interfaces

import android.app.ProgressDialog
import android.content.Context
import android.util.Log
import android.widget.ProgressBar
import com.kodpartner.R
import com.google.gson.Gson
import com.social.ekchat.Interfaces.UniverSelObjct
import model.*
import retrofit.ApiRequest
import retrofit.RetrofitRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import utils.HelperDiloge
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

        weservices.getLogin(PhoneNumber)
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


    fun rescheduleBooking(activity: OnResponse<UniverSelObjct>,
                          mathod: String,id:String,feedback_message:String,service_date:String,service_time:String,idstatus:String){
        HelperDiloge.showProgressDialog(mContext)
        val weservices = RetrofitRequest.getRetrofitInstance().create(ApiRequest::class.java)

        weservices.rescheduleBooking(""+getLoginData().data.user.id,id,feedback_message,service_date,service_time,idstatus)
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
}