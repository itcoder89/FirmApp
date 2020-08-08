package model;

import java.util.List;

public class GetOrderFaultsData {


    /**
     * status : true
     * message : OrderID Found.
     * data : [{"id":339,"order_id":"202008329","default_amount":"0","amount":"2500","unit":"1","service_date":"2020-08-07","service_time":"04 PM - 08 PM","idfault":"80","fault":"Gas Charging (Full)","lat_code":"26.8590969","lng_code":"75.6704022","idcity":"1","booking_date":"2020-08-08T09:41:09.000000Z"},{"id":329,"order_id":"202008329","default_amount":"2000","amount":"3900","unit":"3","service_date":"2020-08-07","service_time":"04 PM - 08 PM","idfault":"5","fault":"Split AC Installation","lat_code":"26.8590969","lng_code":"75.6704022","idcity":"1","booking_date":"2020-08-07T07:25:33.000000Z"},{"id":330,"order_id":"202008329","default_amount":"1200","amount":"2400","unit":"3","service_date":"2020-08-07","service_time":"04 PM - 08 PM","idfault":"6","fault":"Window AC Installation","lat_code":"26.8590969","lng_code":"75.6704022","idcity":"1","booking_date":"2020-08-07T07:25:33.000000Z"}]
     */

    private boolean status;
    private String message;
    private List<DataBean> data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 339
         * order_id : 202008329
         * default_amount : 0
         * amount : 2500
         * unit : 1
         * service_date : 2020-08-07
         * service_time : 04 PM - 08 PM
         * idfault : 80
         * fault : Gas Charging (Full)
         * lat_code : 26.8590969
         * lng_code : 75.6704022
         * idcity : 1
         * booking_date : 2020-08-08T09:41:09.000000Z
         */

        private int id;
        private String order_id;
        private String default_amount;
        private String amount;
        private String unit;
        private String service_date;
        private String service_time;
        private String idfault;
        private String fault;
        private String lat_code;
        private String lng_code;
        private String idcity;
        private String booking_date;

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

        public String getIdfault() {
            return idfault;
        }

        public void setIdfault(String idfault) {
            this.idfault = idfault;
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

        public String getBooking_date() {
            return booking_date;
        }

        public void setBooking_date(String booking_date) {
            this.booking_date = booking_date;
        }
    }
}
