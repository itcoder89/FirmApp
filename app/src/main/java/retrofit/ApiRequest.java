package retrofit;



import model.AcceptLeadData;
import model.AddFaultSuccessData;
import model.CancelByData;
import model.CancelLeadsData;
import model.CloseByPartnerData;
import model.CompletedLeadsData;
import model.CreateOrderData;
import model.DashboardData;
import model.EstimateSentData;
import model.ExpertDetailsData;
import model.ExpertListData;
import model.GetAllSelectedPartListData;
import model.GetMoreFaultsData;
import model.GetOrderFaultsData;
import model.GetPartListByOrderIdData;
import model.HoldReasonData;
import model.LoginData;
import model.NewLeadsData;
import model.OnHoldLeadsListData;
import model.OpenLeadsData;
import model.OrderPlaceData;
import model.PendingLeadsData;
import model.ProfileDetailsData;
import model.RateListData;
import model.RechargeWalletData;
import model.RecomplaintsListData;
import model.RemoveOrderFaultData;
import model.RemoveOrderPartData;
import model.RescheduleData;
import model.RescheduleLeadsData;
import model.SaveOrderPartData;
import model.SendOTPData;
import model.ServiceListForRateData;
import model.SubServiceData;
import model.TimeDateSlabData;
import model.UpdateProfileData;
import model.WalletSummaryData;
import model.WalletSummaryListData;
import model.WorkCloseData;
import model.WorkingAreaData;
import model.WorkingLeadsData;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
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

    @GET("api/remove-order-part")
    Call<RemoveOrderPartData> removeOrderPartItem(@Query("partner_id") String query, @Query("order_id") String lead, @Query("idpart") String idpart);

    @GET("api/remove-order-faults")
    Call<RemoveOrderFaultData> removeOrderFaultItem(@Query("partner_id") String query, @Query("order_id") String lead, @Query("idfault") String idfault);

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

    @POST("api/save-complete-work")
    @FormUrlEncoded
    Call<OrderPlaceData> placeOrder(@Field("work_list") String data);

    @POST("api/get-more-faults")
    @FormUrlEncoded
    Call<GetMoreFaultsData> getMoreFaults(@Field("partner_id") String partner_id,
                                          @Field("idservice") String idservice,
                                          @Field("idsubservice") String idsubservice);

    @GET("api/get-order-faults")
    Call<GetOrderFaultsData> getOrderFaults(@Query("partner_id") String partner_id,
                                           @Query("order_id") String idservice);

    @GET("api/send-order-estimate")
    Call<EstimateSentData> sendEstimateValue(@Query("partner_id") String partner_id,
                                          @Query("order_id") String order_id,
                                          @Query("amount") String amount);

    @GET("api/get-rate-card-by-order-id")
    Call<GetPartListByOrderIdData> getPartListByOrderID(@Query("partner_id") String partner_id,
                                                        @Query("order_id") String idservice);

    @GET("api/get-order-part?")
    Call<GetAllSelectedPartListData> getOrderPartList(@Query("partner_id") String partner_id,
                                                          @Query("order_id") String idservice);

    @POST("api/wallet-recharge-by-partner")
    @FormUrlEncoded
    Call<RechargeWalletData> walletRecharge(@Field("partner_id") String partner_id, @Field("payment_status") String payment_status,
                                            @Field("recharge_amount") String recharge_amount,
                                            @Field("transaction_number") String transaction_number,
                                            @Field("payment_date") String payment_date);

    @POST("api/save-order-part")
    @FormUrlEncoded
    Call<SaveOrderPartData> saveOrderPart(@Field("partner_id") String partner_id,
                                          @Field("order_id") String order_id,
                                          @Field("partid") String partid,
                                          @Field("part_amount") String part_amount);

    @POST("api/closed-partner-booking")
    @FormUrlEncoded
    Call<WorkCloseData> workClose(@Field("partner_id") String partner_id,
                                      @Field("order_id") String order_id,
                                      @Field("recv_amount") String partid,
                                      @Field("part_amount") String part_amount);

    @POST("api/add-more-faults-inorder")
    @FormUrlEncoded
    Call<AddFaultSuccessData> addFaultSuccess(@Field("partner_id") String partner_id,
                                              @Field("order_id") String order_id,
                                             @Field("idfault") String idfault,
                                             @Field("default_amount") String default_amount,
                                             @Field("amount") String amount,
                                             @Field("qty") Integer qty,
                                             @Field("description") String description);

    @POST("api/update-partner-profile")
    @Multipart
    Call<UpdateProfileData> updateProfile(@Field("partner_id") String partner_id,
                                          @Field("p_name") String p_name,
                                          @Field("p_father_name") String p_father_name,
                                          @Field("alt_mob_no") String alt_mob_no,
                                          @Field("p_address") String p_address,
                                          @Field("p_pan_no") String p_pan_no,
                                          @Field("p_aadhar_no") String p_aadhar_no);
    @Multipart
    @POST("api/update-partner-profile")
    Call<UpdateProfileData> updateProfileWithImage(@Part MultipartBody.Part partner_id,
                                             @Part MultipartBody.Part p_name,
                                             @Part MultipartBody.Part p_father_name,
                                             @Part MultipartBody.Part alt_mob_no,
                                             @Part MultipartBody.Part p_address,
                                             @Part MultipartBody.Part p_pan_no,
                                             @Part MultipartBody.Part p_aadhar_no,
                                             @Part MultipartBody.Part photo,
                                             @Part MultipartBody.Part signature);

}
