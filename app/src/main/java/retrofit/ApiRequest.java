package retrofit;



import model.CancelByData;
import model.CancelLeadsData;
import model.CompletedLeadsData;
import model.DashboardData;
import model.ExpertDetailsData;
import model.ExpertListData;
import model.LoginData;
import model.NewLeadsData;
import model.OpenLeadsData;
import model.PendingLeadsData;
import model.ProfileDetailsData;
import model.RateListData;
import model.RecomplaintsListData;
import model.RescheduleData;
import model.ServiceListForRateData;
import model.SubServiceData;
import model.WalletSummaryData;
import model.WorkingAreaData;
import model.WorkingLeadsData;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiRequest {

    @POST("api/partner-login")
    @FormUrlEncoded
    Call<LoginData> getLogin(@Field("contact_no") String phone);

    @GET("api/partner-dashboard")
    Call<DashboardData> getDashboardData(@Query("partner_id") String query);

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

    @GET("api/partner-completed")
    Call<CompletedLeadsData> getallCompletedLeads(@Query("partner_id") String query);

    @GET("api/partner-completed")
    Call<CompletedLeadsData> getallCompletedLeadsFilter(@Query("partner_id") String query,@Query("lead") String lead);

    @GET("api/partner-working")
    Call<WorkingLeadsData> getallWorkingLeads(@Query("partner_id") String query);

    @GET("api/partner-profile")
    Call<ProfileDetailsData> getProfileData(@Query("partner_id") String query);

    @GET("api/get-sub-services-by-service-id")
    Call<SubServiceData> getSubService(@Query("city_id") String city_id, @Query("service_id") String service_id);

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

    @POST("api/cancel-by-partner")
    @FormUrlEncoded
    Call<CancelByData> cancelBy(@Field("partner_id") String partner_id, @Field("order_id") String order_id, @Field("reason") String reason);

    @POST("api/reschedule-booking")
    @FormUrlEncoded
    Call<RescheduleData> rescheduleBooking(@Field("user_id") String user_id, @Field("id") String id, @Field("message") String message, @Field("service_date") String service_date, @Field("service_time") String service_time, @Field("statusid") String idstatus);


}
