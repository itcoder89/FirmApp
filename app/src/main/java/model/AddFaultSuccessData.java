package model;

public class AddFaultSuccessData {


    /**
     * status : true
     * message : Faults Added Successfully.
     * data : {"order_id":"202008329","group_order_id":"329","idservice":1,"idsubservice":1,"idfault":80,"idsubfault":0,"idfirm":"3","user_id":"7","default_amount":"0","qty":"1","amount":"2500","idstatus":"3","status_date":"2020-08-08 03:11:09","lat_code":"26.8590969","lng_code":"75.6704022","idcity":"1","address":"Mahapura, Rajasthan 302026, India","service_date":"2020-08-07","service_time":"04 PM - 08 PM","multigroup":"1","description":"this is fault","idcart":"0","updated_at":"Aug 08 2020 09:41","created_at":"Aug 08 2020 09:41","id":339}
     */

    private boolean status;
    private String message;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * order_id : 202008329
         * group_order_id : 329
         * idservice : 1
         * idsubservice : 1
         * idfault : 80
         * idsubfault : 0
         * idfirm : 3
         * user_id : 7
         * default_amount : 0
         * qty : 1
         * amount : 2500
         * idstatus : 3
         * status_date : 2020-08-08 03:11:09
         * lat_code : 26.8590969
         * lng_code : 75.6704022
         * idcity : 1
         * address : Mahapura, Rajasthan 302026, India
         * service_date : 2020-08-07
         * service_time : 04 PM - 08 PM
         * multigroup : 1
         * description : this is fault
         * idcart : 0
         * updated_at : Aug 08 2020 09:41
         * created_at : Aug 08 2020 09:41
         * id : 339
         */

        private String order_id;
        private String group_order_id;
        private int idservice;
        private int idsubservice;
        private int idfault;
        private int idsubfault;
        private String idfirm;
        private String user_id;
        private String default_amount;
        private String qty;
        private String amount;
        private String idstatus;
        private String status_date;
        private String lat_code;
        private String lng_code;
        private String idcity;
        private String address;
        private String service_date;
        private String service_time;
        private String multigroup;
        private String description;
        private String idcart;
        private String updated_at;
        private String created_at;
        private int id;

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

        public int getIdservice() {
            return idservice;
        }

        public void setIdservice(int idservice) {
            this.idservice = idservice;
        }

        public int getIdsubservice() {
            return idsubservice;
        }

        public void setIdsubservice(int idsubservice) {
            this.idsubservice = idsubservice;
        }

        public int getIdfault() {
            return idfault;
        }

        public void setIdfault(int idfault) {
            this.idfault = idfault;
        }

        public int getIdsubfault() {
            return idsubfault;
        }

        public void setIdsubfault(int idsubfault) {
            this.idsubfault = idsubfault;
        }

        public String getIdfirm() {
            return idfirm;
        }

        public void setIdfirm(String idfirm) {
            this.idfirm = idfirm;
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

        public String getQty() {
            return qty;
        }

        public void setQty(String qty) {
            this.qty = qty;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
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

        public String getIdcart() {
            return idcart;
        }

        public void setIdcart(String idcart) {
            this.idcart = idcart;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
