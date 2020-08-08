package retrofit;



import model.AcceptLeadData;
import model.CancelByData;
import model.CancelLeadsData;
import model.CloseByPartnerData;
import model.CompletedLeadsData;
import model.CreateOrderData;
import model.DashboardData;
import model.ExpertDetailsData;
import model.ExpertListData;
import model.GetMoreFaultsData;
import model.HoldReasonData;
import model.LoginData;
import model.NewLeadsData;
import model.OnHoldLeadsListData;
import model.OpenLeadsData;
import model.PendingLeadsData;
import model.ProfileDetailsData;
import model.RateListData;
import model.RechargeWalletData;
import model.RecomplaintsListData;
import model.RescheduleData;
import model.RescheduleLeadsData;
import model.SendOTPData;
import model.ServiceListForRateData;
import model.SubServiceData;
import model.TimeDateSlabData;
import model.WalletSummaryData;
import model.WalletSummaryListData;
import model.WorkingAreaData;
import model.WorkingLeadsData;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiRequest {

    @POST("api/auth/sendOtp")//http://3.20.147.34/cloudkitchen/api/auth/sendOtp
    @FormUrlEncoded
    Call<SendOTPData> sendOtp(@Field("mobile") String mobile,@Field("country_code") String country_code);

    @POST("api/partner-login")
    @FormUrlEncoded
    Call<LoginData> getLogin(@Field("contact_no") String phone);

    @GET("api/partner-dashboard")
    Call<DashboardData> getDashboardData(@Query("partner_id") String query);

    @GET("api/get-hold-reason")
    Call<HoldReasonData> getHoldReason(@Query("partner_id") String query, @Query("order_id") String lead);

    @GET("api/partner-on-hold")
    Call<OnHoldLeadsListData> getOnHoldLeadsList(@Query("partner_id") String query);

    @GET("api/partner-on-hold")
    Call<OnHoldLeadsListData> getOnHoldLeadsListFilter(@Query("partner_id") String query,@Query("lead") String lead);

    @GET("api/partner-openleads")
    Call<OpenLeadsData> getOpenLeadsData(@Query("partner_id") String query);

    @GET("api/partner-openleads")
    Call<OpenLeadsData> getAllOpenLeadsData(@Query("partner_id") String query,@Query("lead") String lead);

    @GET("api/partner-newleads")
    Call<NewLeadsData> getNewLeadsData(@Query("partner_id") String query);

    @GET("api/partner-recomplaint")
    Call<RecomplaintsListData> getRecomplaintsData(@Query("partner_id") String query);

    @GET("api/partner-cancel")
    Call<CancelLeadsData> getallCancelLeads(@Query("partner_id") String query);

    @GET("api/partner-cancel")
    Call<CancelLeadsData> getallCancelLeadsFilter(@Query("partner_id") String query,@Query("lead") String lead);

    @GET("api/partner-accept-leads")
    Call<AcceptLeadData> acceptOrders(@Query("partner_id") String query, @Query("order_id") String lead);

    @GET("api/partner-completed")
    Call<CompletedLeadsData> getallCompletedLeads(@Query("partner_id") String query);

    @GET("api/partner-completed")
    Call<CompletedLeadsData> getallCompletedLeadsFilter(@Query("partner_id") String query,@Query("lead") String lead);

    @GET("api/partner-working")
    Call<WorkingLeadsData> getallWorkingLeads(@Query("partner_id") String query);

    @GET("api/partner-profile")
    Call<ProfileDetailsData> getProfileData(@Query("partner_id") String query);

    @GET("api/partner-sub-services")
    Call<SubServiceData> getSubService(@Query("partner_id") String partner_id, @Query("idservice") String idservice);

    @GET("api/partner-part-assigned-services")
    Call<ServiceListForRateData> getServiceListForRate(@Query("partner_id") String query);

    @GET("api/get-rate-card-by-service-id")
    Call<RateListData> getRateCardData(@Query("service_id") String query);

    @GET("api/partner-all-pending-leads")
    Call<PendingLeadsData> getallPendingLeads(@Query("partner_id") String query);

    @GET("api/partner-wallet-summary")
    Call<WalletSummaryData> getWalletSummary(@Query("partner_id") String query);

    @GET("api/partner-all-pending-leads")
    Call<PendingLeadsData> getallPendingLeadsFilter(@Query("partner_id") String query,@Query("lead") String today);

    @GET("api/get-partner-expert")
    Call<ExpertListData> getExpertList(@Query("partner_id") String query);

    @GET("api/get-expert-details")
    Call<ExpertDetailsData> getExpertDetailsData(@Query("idexpert") String query);

    @GET("api/partner-working-area")
    Call<WorkingAreaData> getWorkingArea(@Query("partner_id") String query);

    @GET("api/partner-reschedule")
    Call<RescheduleLeadsData> getReschedueLeadsList(@Query("partner_id") String query);

    @GET("api/partner-wallet-summary")
    Call<WalletSummaryListData> getWalletRechargeSummaryList(@Query("partner_id") String query);

    @GET("api/close-by-partner")
    Call<CloseByPartnerData> closebyPartner(@Query("partner_id") String query,@Query("order_id") String order_id);

    @GET("api/partner-reschedule")
    Call<RescheduleLeadsData> getReschedueLeadsListFilter(@Query("partner_id") String query,@Query("lead") String lead);

    @POST("api/cancel-by-partner")
    @FormUrlEncoded
    Call<CancelByData> cancelBy(@Field("partner_id") String partner_id, @Field("order_id") String order_id, @Field("reason") String reason);

    @POST("api/reschedule-booking")
    @FormUrlEncoded
    Call<RescheduleData> rescheduleBooking(@Field("user_id") String user_id, @Field("id") String id, @Field("message") String message, @Field("service_date") String service_date, @Field("service_time") String service_time, @Field("statusid") String idstatus);

    @GET("api/get-time-laps")
    Call<TimeDateSlabData> getTimeDateSlab();

    @POST("api/create-orders")
    @FormUrlEncoded
    Call<CreateOrderData> getCreateOrders(@Field("order_response") String data);

    @POST("api/get-more-faults")
    @FormUrlEncoded
    Call<GetMoreFaultsData> getMoreFaults(@Field("partner_id") String partner_id,@Field("idservice") String idservice,@Field("idsubservice") String idsubservice);

    @POST("api/wallet-recharge-by-partner")
    @FormUrlEncoded
    Call<RechargeWalletData> walletRecharge(@Field("partner_id") String partner_id, @Field("payment_status") String payment_status,
                                            @Field("recharge_amount") String recharge_amount,
                                            @Field("transaction_number") String transaction_number,
                                            @Field("payment_date") String payment_date);
}
