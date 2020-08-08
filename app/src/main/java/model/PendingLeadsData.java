package model;

import java.util.List;

public class PendingLeadsData {


    /**
     * status : true
     * data : [{"id":1,"order_id":"20200701","amount":"0","unit":"1","service_date":"2020-07-11","service_time":"08 AM - 12 PM","fault":"AC/Repair/Split AC Repair","lat_code":"27.1990586","lng_code":"73.7475227","idcity":"1","rating":null,"feedback_by":null,"booking_date":"2020-07-10T14:24:52.000000Z","completed_date":"2020-07-16 13:58:28","current_status":"ON HOLD","customerDetails":{"id":1,"name_prefix":null,"firstname":"suresh kumar","lastname":null,"dob":null,"contact_no":"9660223303","img":null,"latitude":"26.8946871","longitude":"75.7104896","address_street":null,"address_type":null,"address":"22, Gandhi Path W, Vaishali Nagar, Jaipur, Rajasthan 302034, India","city":"Jaipur","state":"Rajasthan","country_code":null,"country":"India","user_id":"1","register_from":"1","created_at":"Jul 09 2020 15:28","updated_at":"Jul 17 2020 16:46"}},{"id":208,"order_id":"202007208","amount":"200","unit":"1","service_date":"2020-07-28","service_time":"08 AM - 12 PM","fault":"Water Purifier/RO, UV Purifier/Repair","lat_code":"27.1649571","lng_code":"73.7358336","idcity":"6","rating":null,"feedback_by":null,"booking_date":"2020-07-27T13:10:51.000000Z","completed_date":"2020-07-27 06:52:15","current_status":"WORKING","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":219,"order_id":"202007219","amount":"400","unit":"1","service_date":"2020-07-29","service_time":"08 AM - 12 PM","fault":"AC/Repair/Split AC Repair","lat_code":"27.1992233","lng_code":"73.7476018","idcity":"6","rating":null,"feedback_by":null,"booking_date":"2020-07-28T11:40:13.000000Z","completed_date":"2020-07-28 05:10:44","current_status":"BOOKING ASSIGNED","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":25,"order_id":"20200725","amount":"400","unit":"1","service_date":"2020-07-18","service_time":"12 PM - 04 PM","fault":"AC/Water Service/Split AC","lat_code":"27.159789","lng_code":"73.7389596","idcity":"6","rating":null,"feedback_by":null,"booking_date":"2020-07-15T05:47:15.000000Z","completed_date":"2020-07-24 07:06:34","current_status":"WORKING","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":32,"order_id":"20200732","amount":"1800","unit":"1","service_date":"2020-07-15","service_time":"04 PM - 08 PM","fault":"AC/Installation/Split AC Installation","lat_code":"27.1983368","lng_code":"73.7493272","idcity":"6","rating":null,"feedback_by":null,"booking_date":"2020-07-15T09:55:39.000000Z","completed_date":"2020-07-24 07:06:00","current_status":"WORKING","customerDetails":{"id":2,"name_prefix":null,"firstname":"Sanjay Saini","lastname":null,"dob":null,"contact_no":"9460238000","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"2","register_from":"1","created_at":"Jul 10 2020 12:48","updated_at":"Jul 10 2020 12:48"}},{"id":49,"order_id":"20200749","amount":"300","unit":"1","service_date":"2020-07-18","service_time":"08 AM - 12 PM","fault":"Water Tank Cleaning/Plastic Tank/Upto 1000 Ltr.","lat_code":"27.1926004","lng_code":"73.7520147","idcity":"6","rating":null,"feedback_by":null,"booking_date":"2020-07-17T14:01:40.000000Z","completed_date":"2020-07-19 01:01:07","current_status":"BOOKING ASSIGNED","customerDetails":{"id":4,"name_prefix":null,"firstname":"mohit","lastname":null,"dob":null,"contact_no":"8130824151","img":null,"latitude":"0.0","longitude":"0.0","address_street":null,"address_type":null,"address":null,"city":null,"state":null,"country_code":null,"country":null,"user_id":"4","register_from":"1","created_at":"Jul 10 2020 14:11","updated_at":"Jul 10 2020 14:11"}},{"id":76,"order_id":"20200776","amount":"400","unit":"1","service_date":"2020-07-24","service_time":"08 AM - 12 PM","fault":"AC/Repair/Split AC Repair","lat_code":"27.1926004","lng_code":"73.7520147","idcity":"6","rating":"3","feedback_by":"customer","booking_date":"2020-07-19T11:44:51.000000Z","completed_date":"2020-07-21 22:15:47","current_status":"RE COMPLAINT","customerDetails":{"id":1,"name_prefix":null,"firstname":"suresh kumar","lastname":null,"dob":null,"contact_no":"9660223303","img":null,"latitude":"26.8946871","longitude":"75.7104896","address_street":null,"address_type":null,"address":"22, Gandhi Path W, Vaishali Nagar, Jaipur, Rajasthan 302034, India","city":"Jaipur","state":"Rajasthan","country_code":null,"country":"India","user_id":"1","register_from":"1","created_at":"Jul 09 2020 15:28","updated_at":"Jul 17 2020 16:46"}},{"id":87,"order_id":"20200787","amount":"0","unit":"1","service_date":"2020-07-20","service_time":"08 AM - 12 PM","fault":"AC/Repair/Window AC Repair","lat_code":"26.6253485","lng_code":"75.0364723","idcity":"6","rating":null,"feedback_by":null,"booking_date":"2020-07-19T12:23:03.000000Z","completed_date":"2020-08-05 04:48:00","current_status":"BOOKING ASSIGNED","customerDetails":{"id":52,"name_prefix":null,"firstname":"vijay maanju","lastname":null,"dob":null,"contact_no":"9024110015","img":null,"latitude":"26.6253485","longitude":"75.0364723","address_street":null,"address_type":null,"address":"Mundoti Rd, Bandar Seendri, Rajasthan 305816, India","city":"Bandar Seendri","state":"Rajasthan","country_code":null,"country":"India","user_id":"52","register_from":"1","created_at":"Jul 19 2020 12:19","updated_at":"Jul 19 2020 12:19"}},{"id":229,"order_id":"202008229","amount":"200","unit":"1","service_date":"2020-08-02","service_time":"08 AM - 12 PM","fault":"Water Purifier/RO, UV Purifier/Repair","lat_code":"27.1982984","lng_code":"73.7493277","idcity":"6","rating":null,"feedback_by":null,"booking_date":"2020-08-01T09:58:26.000000Z","completed_date":"2020-08-05 04:17:13","current_status":"BOOKING ASSIGNED","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":233,"order_id":"202008233","amount":"220","unit":"1","service_date":"2020-08-03","service_time":"12 PM - 04 PM","fault":"Water Purifier/RO, UV Purifier/Service or Filter Change","lat_code":"27.1992233","lng_code":"73.7476018","idcity":"6","rating":null,"feedback_by":null,"booking_date":"2020-08-01T10:12:09.000000Z","completed_date":"2020-08-05 04:17:09","current_status":"BOOKING ASSIGNED","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":277,"order_id":"202008277","amount":"500","unit":"1","service_date":"2020-08-03","service_time":"08 AM - 12 PM","fault":"Water Tank Cleaning/Cement Tank/Upto 5000 Ltr.","lat_code":"26.8832296","lng_code":"75.782569","idcity":"1","rating":null,"feedback_by":null,"booking_date":"2020-08-02T19:39:09.000000Z","completed_date":"2020-08-04 10:35:25","current_status":"BOOKING ASSIGNED","customerDetails":{"id":16,"name_prefix":null,"firstname":"surendra kumar","lastname":null,"dob":null,"contact_no":"9521159082","img":null,"latitude":"26.8837667","longitude":"75.7819036","address_street":null,"address_type":null,"address":"C-10, Adarsh Krishna Nagar, Bal Nagar, Kartarpur, Gopal Pura Mode, Jaipur, Rajasthan 302015, India","city":"Jaipur","state":"Rajasthan","country_code":null,"country":"India","user_id":"16","register_from":"1","created_at":"Jul 12 2020 17:21","updated_at":"Jul 13 2020 11:38"}},{"id":281,"order_id":"202008281","amount":"499","unit":"1","service_date":"2020-08-04","service_time":"12 PM - 04 PM","fault":"AC/Water Service/Split AC","lat_code":"26.859105","lng_code":"75.6704084","idcity":"1","rating":null,"feedback_by":null,"booking_date":"2020-08-03T11:53:52.000000Z","completed_date":"2020-08-04 11:16:43","current_status":"BOOKING ASSIGNED","customerDetails":{"id":7,"name_prefix":null,"firstname":"md","lastname":null,"dob":null,"contact_no":"9252279720","img":null,"latitude":"26.8590022","longitude":"75.6703667","address_street":null,"address_type":null,"address":"Mahapura, Rajasthan 302026, India","city":null,"state":"Rajasthan","country_code":null,"country":"India","user_id":"7","register_from":"1","created_at":"Jul 11 2020 19:43","updated_at":"Jul 11 2020 19:43"}},{"id":282,"order_id":"202008282","amount":"200","unit":"1","service_date":"2020-08-04","service_time":"12 PM - 04 PM","fault":"Water Purifier/RO, UV Purifier/Repair","lat_code":"27.159789","lng_code":"73.7389596","idcity":"6","rating":null,"feedback_by":null,"booking_date":"2020-08-04T04:53:39.000000Z","completed_date":"2020-08-04 10:57:53","current_status":"BOOKING ASSIGNED","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":283,"order_id":"202008283","amount":"280","unit":"1","service_date":"2020-08-04","service_time":"12 PM - 04 PM","fault":"Washing Machine/Top Load Repair/Semi Auto Repair","lat_code":"27.159789","lng_code":"73.7389596","idcity":"6","rating":null,"feedback_by":null,"booking_date":"2020-08-04T04:53:39.000000Z","completed_date":"2020-08-04 10:47:59","current_status":"BOOKING ASSIGNED","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":284,"order_id":"202008284","amount":"400","unit":"1","service_date":"2020-08-05","service_time":"04 PM - 08 PM","fault":"AC/Repair/Split AC Repair","lat_code":"27.1991736","lng_code":"73.7475062","idcity":"6","rating":null,"feedback_by":null,"booking_date":"2020-08-05T07:38:16.000000Z","completed_date":"2020-08-05 04:16:58","current_status":"BOOKING ASSIGNED","customerDetails":{"id":12,"name_prefix":null,"firstname":"Saveen","lastname":null,"dob":null,"contact_no":"9667393475","img":null,"latitude":"26.8708346","longitude":"75.69726659999999","address_street":null,"address_type":null,"address":"Bhankrota, Jaipur, Rajasthan, India","city":"Jaipur","state":null,"country_code":null,"country":null,"user_id":"12","register_from":"0","created_at":"Jul 12 2020 10:49","updated_at":"Jul 23 2020 12:14"}},{"id":286,"order_id":"202008286","amount":"1800","unit":"1","service_date":"2020-08-05","service_time":"04 PM - 08 PM","fault":"AC/Installation/Split AC Installation","lat_code":"27.1991973","lng_code":"73.7474823","idcity":"6","rating":null,"feedback_by":null,"booking_date":"2020-08-05T07:49:35.000000Z","completed_date":"2020-08-05 04:16:56","current_status":"BOOKING ASSIGNED","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":287,"order_id":"202008287","amount":"400","unit":"1","service_date":"2020-08-05","service_time":"04 PM - 08 PM","fault":"AC/Water Service/Split AC","lat_code":"27.1991654","lng_code":"73.7475142","idcity":"6","rating":null,"feedback_by":null,"booking_date":"2020-08-05T07:52:12.000000Z","completed_date":"2020-08-05 04:16:54","current_status":"BOOKING ASSIGNED","customerDetails":{"id":12,"name_prefix":null,"firstname":"Saveen","lastname":null,"dob":null,"contact_no":"9667393475","img":null,"latitude":"26.8708346","longitude":"75.69726659999999","address_street":null,"address_type":null,"address":"Bhankrota, Jaipur, Rajasthan, India","city":"Jaipur","state":null,"country_code":null,"country":null,"user_id":"12","register_from":"0","created_at":"Jul 12 2020 10:49","updated_at":"Jul 23 2020 12:14"}},{"id":288,"order_id":"202008288","amount":"1200","unit":"1","service_date":"2020-08-05","service_time":"04 PM - 08 PM","fault":"AC/Uninstallation/Split AC Uninstallation","lat_code":"27.1991592","lng_code":"73.7475173","idcity":"6","rating":null,"feedback_by":null,"booking_date":"2020-08-05T08:20:48.000000Z","completed_date":"2020-08-05 04:16:52","current_status":"BOOKING ASSIGNED","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":289,"order_id":"202008289","amount":"1800","unit":"1","service_date":"2020-08-05","service_time":"04 PM - 08 PM","fault":"AC/Installation/Split AC Installation","lat_code":"27.199141","lng_code":"73.747523","idcity":"6","rating":null,"feedback_by":null,"booking_date":"2020-08-05T08:21:54.000000Z","completed_date":"2020-08-05 04:16:49","current_status":"BOOKING ASSIGNED","customerDetails":{"id":12,"name_prefix":null,"firstname":"Saveen","lastname":null,"dob":null,"contact_no":"9667393475","img":null,"latitude":"26.8708346","longitude":"75.69726659999999","address_street":null,"address_type":null,"address":"Bhankrota, Jaipur, Rajasthan, India","city":"Jaipur","state":null,"country_code":null,"country":null,"user_id":"12","register_from":"0","created_at":"Jul 12 2020 10:49","updated_at":"Jul 23 2020 12:14"}},{"id":290,"order_id":"202008290","amount":"400","unit":"1","service_date":"2020-08-05","service_time":"04 PM - 08 PM","fault":"AC/Repair/Window AC Repair","lat_code":"27.1991592","lng_code":"73.7475173","idcity":"6","rating":null,"feedback_by":null,"booking_date":"2020-08-05T09:01:48.000000Z","completed_date":"2020-08-05 04:13:27","current_status":"BOOKING ASSIGNED","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":291,"order_id":"202008291","amount":"400","unit":"1","service_date":"2020-08-06","service_time":"08 AM - 12 PM","fault":"AC/Water Service/Window AC","lat_code":"27.1991592","lng_code":"73.7475173","idcity":"6","rating":null,"feedback_by":null,"booking_date":"2020-08-05T10:42:15.000000Z","completed_date":"2020-08-05 04:20:00","current_status":"BOOKING ASSIGNED","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":294,"order_id":"202008294","amount":"400","unit":"1","service_date":"2020-08-06","service_time":"08 AM - 12 PM","fault":"AC/Repair/Split AC Repair","lat_code":"27.1791663","lng_code":"73.7095365","idcity":"6","rating":null,"feedback_by":null,"booking_date":"2020-08-05T10:58:02.000000Z","completed_date":"2020-08-05 04:34:49","current_status":"BOOKING ASSIGNED","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}}]
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
         * id : 1
         * order_id : 20200701
         * amount : 0
         * unit : 1
         * service_date : 2020-07-11
         * service_time : 08 AM - 12 PM
         * fault : AC/Repair/Split AC Repair
         * lat_code : 27.1990586
         * lng_code : 73.7475227
         * idcity : 1
         * rating : null
         * feedback_by : null
         * booking_date : 2020-07-10T14:24:52.000000Z
         * completed_date : 2020-07-16 13:58:28
         * current_status : ON HOLD
         * customerDetails : {"id":1,"name_prefix":null,"firstname":"suresh kumar","lastname":null,"dob":null,"contact_no":"9660223303","img":null,"latitude":"26.8946871","longitude":"75.7104896","address_street":null,"address_type":null,"address":"22, Gandhi Path W, Vaishali Nagar, Jaipur, Rajasthan 302034, India","city":"Jaipur","state":"Rajasthan","country_code":null,"country":"India","user_id":"1","register_from":"1","created_at":"Jul 09 2020 15:28","updated_at":"Jul 17 2020 16:46"}
         */

        private int id;
        private String order_id;
        private String amount;
        private String unit;
        private String service_date;
        private String service_time;
        private String fault;
        private String lat_code;
        private String lng_code;
        private String idcity;
        private Object rating;
        private Object feedback_by;
        private String booking_date;
        private String completed_date;
        private String current_status;
        private CustomerDetailsBean customerDetails;

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

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
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

        public String getFault() {
            return fault;
        }

        public void setFault(String fault) {
            this.fault = fault;
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

        public String getIdcity() {
            return idcity;
        }

        public void setIdcity(String idcity) {
            this.idcity = idcity;
        }

        public Object getRating() {
            return rating;
        }

        public void setRating(Object rating) {
            this.rating = rating;
        }

        public Object getFeedback_by() {
            return feedback_by;
        }

        public void setFeedback_by(Object feedback_by) {
            this.feedback_by = feedback_by;
        }

        public String getBooking_date() {
            return booking_date;
        }

        public void setBooking_date(String booking_date) {
            this.booking_date = booking_date;
        }

        public String getCompleted_date() {
            return completed_date;
        }

        public void setCompleted_date(String completed_date) {
            this.completed_date = completed_date;
        }

        public String getCurrent_status() {
            return current_status;
        }

        public void setCurrent_status(String current_status) {
            this.current_status = current_status;
        }

        public CustomerDetailsBean getCustomerDetails() {
            return customerDetails;
        }

        public void setCustomerDetails(CustomerDetailsBean customerDetails) {
            this.customerDetails = customerDetails;
        }

        public static class CustomerDetailsBean {
            /**
             * id : 1
             * name_prefix : null
             * firstname : suresh kumar
             * lastname : null
             * dob : null
             * contact_no : 9660223303
             * img : null
             * latitude : 26.8946871
             * longitude : 75.7104896
             * address_street : null
             * address_type : null
             * address : 22, Gandhi Path W, Vaishali Nagar, Jaipur, Rajasthan 302034, India
             * city : Jaipur
             * state : Rajasthan
             * country_code : null
             * country : India
             * user_id : 1
             * register_from : 1
             * created_at : Jul 09 2020 15:28
             * updated_at : Jul 17 2020 16:46
             */

            private int id;
            private Object name_prefix;
            private String firstname;
            private Object lastname;
            private Object dob;
            private String contact_no;
            private Object img;
            private String latitude;
            private String longitude;
            private Object address_street;
            private Object address_type;
            private String address;
            private String city;
            private String state;
            private Object country_code;
            private String country;
            private String user_id;
            private String register_from;
            private String created_at;
            private String updated_at;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Object getName_prefix() {
                return name_prefix;
            }

            public void setName_prefix(Object name_prefix) {
                this.name_prefix = name_prefix;
            }

            public String getFirstname() {
                return firstname;
            }

            public void setFirstname(String firstname) {
                this.firstname = firstname;
            }

            public Object getLastname() {
                return lastname;
            }

            public void setLastname(Object lastname) {
                this.lastname = lastname;
            }

            public Object getDob() {
                return dob;
            }

            public void setDob(Object dob) {
                this.dob = dob;
            }

            public String getContact_no() {
                return contact_no;
            }

            public void setContact_no(String contact_no) {
                this.contact_no = contact_no;
            }

            public Object getImg() {
                return img;
            }

            public void setImg(Object img) {
                this.img = img;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public Object getAddress_street() {
                return address_street;
            }

            public void setAddress_street(Object address_street) {
                this.address_street = address_street;
            }

            public Object getAddress_type() {
                return address_type;
            }

            public void setAddress_type(Object address_type) {
                this.address_type = address_type;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public Object getCountry_code() {
                return country_code;
            }

            public void setCountry_code(Object country_code) {
                this.country_code = country_code;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getRegister_from() {
                return register_from;
            }

            public void setRegister_from(String register_from) {
                this.register_from = register_from;
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
        }
    }
}
