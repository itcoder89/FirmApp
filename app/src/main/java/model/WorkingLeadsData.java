package model;

import java.util.List;

public class WorkingLeadsData {


    /**
     * status : true
     * data : [{"id":208,"order_id":"202007208","group_order_id":"208","idservice":"2","idsubservice":"8","idfault":"12","idsubfault":"0","user_id":"3","default_amount":"250","amount":"200","qty":"1","session_id":"","idcity":"6","lat_code":"27.1649571","lng_code":"73.7358336","name_prefix":"","ocustomer_name":"","address_street":"","address_type":"","address":"Nagaur Rd, Taausar, Rajasthan 341001, India","coupon_code":"","coupon_discount":"0","idcart":"0","idstatus":"3","status_date":"2020-07-27 06:52:15","booking_from":"app","service_date":"2020-07-28","service_time":"08 AM - 12 PM","multigroup":"1","description":"hello","cancel_reason":"","cancel_by":"","idfirm":"3","idexpert":"0","send_estimate_flag":"1","send_estimate_date":"2020-07-27 06:46:04","feedback_send_flag":"0","message":"","created_at":"Jul 27 2020 13:10","updated_at":"Jul 27 2020 13:22","feedback_date":"","feedback_rating":"","feedback_message":"","feedback_by":"","hold_reason":"","hold_by":"","hold_start_time":"","hold_end_time":""},{"id":25,"order_id":"20200725","group_order_id":"25","idservice":"1","idsubservice":"2","idfault":"1","idsubfault":"0","user_id":"3","default_amount":"600","amount":"400","qty":"1","session_id":"","idcity":"6","lat_code":"27.159789","lng_code":"73.7389596","name_prefix":"","ocustomer_name":"","address_street":"","address_type":"","address":"Taausar, Rajasthan, India","coupon_code":"","coupon_discount":"0","idcart":"0","idstatus":"3","status_date":"2020-07-24 07:06:34","booking_from":"app","service_date":"2020-07-18","service_time":"12 PM - 04 PM","multigroup":"1","description":"","cancel_reason":"","cancel_by":"","idfirm":"3","idexpert":"0","send_estimate_flag":"1","send_estimate_date":"2020-07-15 02:44:29","feedback_send_flag":"0","message":"","created_at":"Jul 15 2020 05:47","updated_at":"Jul 24 2020 13:36","feedback_date":"","feedback_rating":"","feedback_message":"","feedback_by":"","hold_reason":"Tools not available","hold_by":"admin","hold_start_time":"","hold_end_time":"2020-07-24 07:06:34"},{"id":32,"order_id":"20200732","group_order_id":"32","idservice":"1","idsubservice":"3","idfault":"5","idsubfault":"0","user_id":"2","default_amount":"2000","amount":"1800","qty":"1","session_id":"","idcity":"6","lat_code":"27.1983368","lng_code":"73.7493272","name_prefix":"","ocustomer_name":"","address_street":"","address_type":"","address":"Nagaur, Rajasthan, India","coupon_code":"","coupon_discount":"0","idcart":"0","idstatus":"3","status_date":"2020-07-24 07:06:00","booking_from":"web","service_date":"2020-07-15","service_time":"04 PM - 08 PM","multigroup":"0","description":"","cancel_reason":"","cancel_by":"","idfirm":"3","idexpert":"0","send_estimate_flag":"1","send_estimate_date":"2020-07-15 03:33:16","feedback_send_flag":"0","message":"","created_at":"Jul 15 2020 09:55","updated_at":"Jul 24 2020 13:36","feedback_date":"","feedback_rating":"","feedback_message":"","feedback_by":"","hold_reason":"","hold_by":"","hold_start_time":"","hold_end_time":""}]
     */

    private boolean status;
    private List<DataBean> data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 208
         * order_id : 202007208
         * group_order_id : 208
         * idservice : 2
         * idsubservice : 8
         * idfault : 12
         * idsubfault : 0
         * user_id : 3
         * default_amount : 250
         * amount : 200
         * qty : 1
         * session_id :
         * idcity : 6
         * lat_code : 27.1649571
         * lng_code : 73.7358336
         * name_prefix :
         * ocustomer_name :
         * address_street :
         * address_type :
         * address : Nagaur Rd, Taausar, Rajasthan 341001, India
         * coupon_code :
         * coupon_discount : 0
         * idcart : 0
         * idstatus : 3
         * status_date : 2020-07-27 06:52:15
         * booking_from : app
         * service_date : 2020-07-28
         * service_time : 08 AM - 12 PM
         * multigroup : 1
         * description : hello
         * cancel_reason :
         * cancel_by :
         * idfirm : 3
         * idexpert : 0
         * send_estimate_flag : 1
         * send_estimate_date : 2020-07-27 06:46:04
         * feedback_send_flag : 0
         * message :
         * created_at : Jul 27 2020 13:10
         * updated_at : Jul 27 2020 13:22
         * feedback_date :
         * feedback_rating :
         * feedback_message :
         * feedback_by :
         * hold_reason :
         * hold_by :
         * hold_start_time :
         * hold_end_time :
         */

        private int id;
        private String order_id;
        private String group_order_id;
        private String idservice;
        private String idsubservice;
        private String idfault;
        private String idsubfault;
        private String user_id;
        private String default_amount;
        private String amount;
        private String qty;
        private String session_id;
        private String idcity;
        private String lat_code;
        private String lng_code;
        private String name_prefix;
        private String ocustomer_name;
        private String address_street;
        private String address_type;
        private String address;
        private String coupon_code;
        private String coupon_discount;
        private String idcart;
        private String idstatus;
        private String status_date;
        private String booking_from;
        private String service_date;
        private String service_time;
        private String multigroup;
        private String description;
        private String cancel_reason;
        private String cancel_by;
        private String idfirm;
        private String idexpert;
        private String send_estimate_flag;
        private String send_estimate_date;
        private String feedback_send_flag;
        private String message;
        private String created_at;
        private String updated_at;
        private String feedback_date;
        private String feedback_rating;
        private String feedback_message;
        private String feedback_by;
        private String hold_reason;
        private String hold_by;
        private String hold_start_time;
        private String hold_end_time;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getGroup_order_id() {
            return group_order_id;
        }

        public void setGroup_order_id(String group_order_id) {
            this.group_order_id = group_order_id;
        }

        public String getIdservice() {
            return idservice;
        }

        public void setIdservice(String idservice) {
            this.idservice = idservice;
        }

        public String getIdsubservice() {
            return idsubservice;
        }

        public void setIdsubservice(String idsubservice) {
            this.idsubservice = idsubservice;
        }

        public String getIdfault() {
            return idfault;
        }

        public void setIdfault(String idfault) {
            this.idfault = idfault;
        }

        public String getIdsubfault() {
            return idsubfault;
        }

        public void setIdsubfault(String idsubfault) {
            this.idsubfault = idsubfault;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getDefault_amount() {
            return default_amount;
        }

        public void setDefault_amount(String default_amount) {
            this.default_amount = default_amount;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getQty() {
            return qty;
        }

        public void setQty(String qty) {
            this.qty = qty;
        }

        public String getSession_id() {
            return session_id;
        }

        public void setSession_id(String session_id) {
            this.session_id = session_id;
        }

        public String getIdcity() {
            return idcity;
        }

        public void setIdcity(String idcity) {
            this.idcity = idcity;
        }

        public String getLat_code() {
            return lat_code;
        }

        public void setLat_code(String lat_code) {
            this.lat_code = lat_code;
        }

        public String getLng_code() {
            return lng_code;
        }

        public void setLng_code(String lng_code) {
            this.lng_code = lng_code;
        }

        public String getName_prefix() {
            return name_prefix;
        }

        public void setName_prefix(String name_prefix) {
            this.name_prefix = name_prefix;
        }

        public String getOcustomer_name() {
            return ocustomer_name;
        }

        public void setOcustomer_name(String ocustomer_name) {
            this.ocustomer_name = ocustomer_name;
        }

        public String getAddress_street() {
            return address_street;
        }

        public void setAddress_street(String address_street) {
            this.address_street = address_street;
        }

        public String getAddress_type() {
            return address_type;
        }

        public void setAddress_type(String address_type) {
            this.address_type = address_type;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCoupon_code() {
            return coupon_code;
        }

        public void setCoupon_code(String coupon_code) {
            this.coupon_code = coupon_code;
        }

        public String getCoupon_discount() {
            return coupon_discount;
        }

        public void setCoupon_discount(String coupon_discount) {
            this.coupon_discount = coupon_discount;
        }

        public String getIdcart() {
            return idcart;
        }

        public void setIdcart(String idcart) {
            this.idcart = idcart;
        }

        public String getIdstatus() {
            return idstatus;
        }

        public void setIdstatus(String idstatus) {
            this.idstatus = idstatus;
        }

        public String getStatus_date() {
            return status_date;
        }

        public void setStatus_date(String status_date) {
            this.status_date = status_date;
        }

        public String getBooking_from() {
            return booking_from;
        }

        public void setBooking_from(String booking_from) {
            this.booking_from = booking_from;
        }

        public String getService_date() {
            return service_date;
        }

        public void setService_date(String service_date) {
            this.service_date = service_date;
        }

        public String getService_time() {
            return service_time;
        }

        public void setService_time(String service_time) {
            this.service_time = service_time;
        }

        public String getMultigroup() {
            return multigroup;
        }

        public void setMultigroup(String multigroup) {
            this.multigroup = multigroup;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCancel_reason() {
            return cancel_reason;
        }

        public void setCancel_reason(String cancel_reason) {
            this.cancel_reason = cancel_reason;
        }

        public String getCancel_by() {
            return cancel_by;
        }

        public void setCancel_by(String cancel_by) {
            this.cancel_by = cancel_by;
        }

        public String getIdfirm() {
            return idfirm;
        }

        public void setIdfirm(String idfirm) {
            this.idfirm = idfirm;
        }

        public String getIdexpert() {
            return idexpert;
        }

        public void setIdexpert(String idexpert) {
            this.idexpert = idexpert;
        }

        public String getSend_estimate_flag() {
            return send_estimate_flag;
        }

        public void setSend_estimate_flag(String send_estimate_flag) {
            this.send_estimate_flag = send_estimate_flag;
        }

        public String getSend_estimate_date() {
            return send_estimate_date;
        }

        public void setSend_estimate_date(String send_estimate_date) {
            this.send_estimate_date = send_estimate_date;
        }

        public String getFeedback_send_flag() {
            return feedback_send_flag;
        }

        public void setFeedback_send_flag(String feedback_send_flag) {
            this.feedback_send_flag = feedback_send_flag;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getFeedback_date() {
            return feedback_date;
        }

        public void setFeedback_date(String feedback_date) {
            this.feedback_date = feedback_date;
        }

        public String getFeedback_rating() {
            return feedback_rating;
        }

        public void setFeedback_rating(String feedback_rating) {
            this.feedback_rating = feedback_rating;
        }

        public String getFeedback_message() {
            return feedback_message;
        }

        public void setFeedback_message(String feedback_message) {
            this.feedback_message = feedback_message;
        }

        public String getFeedback_by() {
            return feedback_by;
        }

        public void setFeedback_by(String feedback_by) {
            this.feedback_by = feedback_by;
        }

        public String getHold_reason() {
            return hold_reason;
        }

        public void setHold_reason(String hold_reason) {
            this.hold_reason = hold_reason;
        }

        public String getHold_by() {
            return hold_by;
        }

        public void setHold_by(String hold_by) {
            this.hold_by = hold_by;
        }

        public String getHold_start_time() {
            return hold_start_time;
        }

        public void setHold_start_time(String hold_start_time) {
            this.hold_start_time = hold_start_time;
        }

        public String getHold_end_time() {
            return hold_end_time;
        }

        public void setHold_end_time(String hold_end_time) {
            this.hold_end_time = hold_end_time;
        }
    }
}
