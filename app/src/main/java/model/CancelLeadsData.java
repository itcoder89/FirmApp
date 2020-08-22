package model;

import java.util.List;

public class CancelLeadsData {


    /**
     * status : true
     * data : [{"id":104,"order_id":"202007104","amount":"0","unit":"1","service_date":"2020-07-20","service_time":"04 PM - 08 PM","fault":"AC/Repair/Split AC Repair","lat_code":"27.1649571","lng_code":"73.7358336","idcity":"6","commission":"50","booking_date":"2020-07-20T07:44:46.000000Z","cancel_date":"2020-07-30 10:50:30","cancel_reason":"just testing","cancel_by":"firm","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":105,"order_id":"202007105","amount":"1800","unit":"1","service_date":"2020-07-20","service_time":"04 PM - 08 PM","fault":"AC/Installation/Split AC Installation","lat_code":"27.1649571","lng_code":"73.7358336","idcity":"6","commission":"100","booking_date":"2020-07-20T07:58:23.000000Z","cancel_date":"2020-07-30 11:08:33","cancel_reason":"just tetjng","cancel_by":"firm","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":140,"order_id":"202007140","amount":"500","unit":"1","service_date":"2020-07-22","service_time":"08 AM - 12 PM","fault":"Washing Machine/Front Load Repair/Front Load Repair","lat_code":"27.1991407","lng_code":"73.7475266","idcity":"6","commission":"50","booking_date":"2020-07-21T11:56:40.000000Z","cancel_date":"2020-07-30 11:19:21","cancel_reason":"s","cancel_by":"firm","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":39,"order_id":"20200739","amount":"300","unit":"1","service_date":"2020-07-17","service_time":"08 AM - 12 PM","fault":"Washing Machine/Top Load Repair/Semi Auto Repair","lat_code":"26.9839089","lng_code":"73.9712488","idcity":"6","commission":"50","booking_date":"2020-07-16T12:42:43.000000Z","cancel_date":"2020-07-18 13:49:01","cancel_reason":"work done by other","cancel_by":"customer","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}}]
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
         * id : 104
         * order_id : 202007104
         * amount : 0
         * unit : 1
         * service_date : 2020-07-20
         * service_time : 04 PM - 08 PM
         * fault : AC/Repair/Split AC Repair
         * lat_code : 27.1649571
         * lng_code : 73.7358336
         * idcity : 6
         * commission : 50
         * booking_date : 2020-07-20T07:44:46.000000Z
         * cancel_date : 2020-07-30 10:50:30
         * cancel_reason : just testing
         * cancel_by : firm
         * customerDetails : {"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}
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
        private String commission;
        private String booking_date;
        private String cancel_date;
        private String cancel_reason;
        private String cancel_by;
        private CustomerDetailsBean customerDetails;
        private String customerName;
        private String address;

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getStreet() {
            if(street==null || street.equals("")){
                street = "";
            }
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        private String street;

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

        public String getCommission() {
            return commission;
        }

        public void setCommission(String commission) {
            this.commission = commission;
        }

        public String getBooking_date() {
            return booking_date;
        }

        public void setBooking_date(String booking_date) {
            this.booking_date = booking_date;
        }

        public String getCancel_date() {
            return cancel_date;
        }

        public void setCancel_date(String cancel_date) {
            this.cancel_date = cancel_date;
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

        public CustomerDetailsBean getCustomerDetails() {
            return customerDetails;
        }

        public void setCustomerDetails(CustomerDetailsBean customerDetails) {
            this.customerDetails = customerDetails;
        }

        public static class CustomerDetailsBean {
            /**
             * id : 3
             * name_prefix : null
             * firstname : Sanjay Panwar
             * lastname : null
             * dob : null
             * contact_no : 8104651676
             * img : null
             * latitude : 27.1993592
             * longitude : 73.7449765
             * address_street : null
             * address_type : null
             * address : Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India
             * city : Nagaur
             * state : Rajasthan
             * country_code : null
             * country : India
             * user_id : 3
             * register_from : 1
             * created_at : Jul 10 2020 12:49
             * updated_at : Aug 04 2020 04:53
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
