package model;

import java.util.List;

public class CompletedLeadsData {


    /**
     * status : true
     * data : [{"id":21,"order_id":"20200721","amount":"0","unit":"1","service_date":"2020-07-15","service_time":"08 AM - 12 PM","fault":"AC/Repair/Split AC Repair","lat_code":"27.159789","lng_code":"73.7389596","idcity":"6","rating":null,"feedback_by":null,"booking_date":"2020-07-14T13:05:54.000000Z","completed_date":"2020-07-14 06:59:31","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":218,"order_id":"202007218","amount":"400","unit":"1","service_date":"2020-07-29","service_time":"04 PM - 08 PM","fault":"AC/Repair/Split AC Repair","lat_code":"27.1962843","lng_code":"73.7562303","idcity":"6","rating":null,"feedback_by":null,"booking_date":"2020-07-28T11:34:34.000000Z","completed_date":"2020-07-28 05:07:55","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":225,"order_id":"202007225","amount":"250","unit":"1","service_date":"2020-08-01","service_time":"12 PM - 04 PM","fault":"Electrician/Repair/Fan Repair","lat_code":"27.023803599999997","lng_code":"74.21793260000001","idcity":"6","rating":null,"feedback_by":null,"booking_date":"2020-07-31T12:35:24.000000Z","completed_date":"2020-08-01 02:06:33","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":26,"order_id":"20200726","amount":"400","unit":"1","service_date":"2020-07-18","service_time":"12 PM - 04 PM","fault":"AC/Water Service/Window AC","lat_code":"27.159789","lng_code":"73.7389596","idcity":"6","rating":"5","feedback_by":null,"booking_date":"2020-07-15T05:47:15.000000Z","completed_date":"2020-07-15 11:57:24","customerDetails":{"id":3,"name_prefix":null,"firstname":"Sanjay Panwar","lastname":null,"dob":null,"contact_no":"8104651676","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"3","register_from":"1","created_at":"Jul 10 2020 12:49","updated_at":"Aug 04 2020 04:53"}},{"id":27,"order_id":"20200727","amount":"600","unit":"1","service_date":"2020-07-16","service_time":"08 AM - 12 PM","fault":"AC/Installation/","lat_code":"27.1983368","lng_code":"73.7493272","idcity":"6","rating":null,"feedback_by":null,"booking_date":"2020-07-15T06:23:32.000000Z","completed_date":"2020-07-15 12:17:16","customerDetails":{"id":2,"name_prefix":null,"firstname":"Sanjay Saini","lastname":null,"dob":null,"contact_no":"9460238000","img":null,"latitude":"27.1993592","longitude":"73.7449765","address_street":null,"address_type":null,"address":"Unnamed Road,, Khatri Pura, Nagaur, Rajasthan 341001, India","city":"Nagaur","state":"Rajasthan","country_code":null,"country":"India","user_id":"2","register_from":"1","created_at":"Jul 10 2020 12:48","updated_at":"Jul 10 2020 12:48"}},{"id":50,"order_id":"20200750","amount":"400","unit":"1","service_date":"2020-07-21","service_time":"04 PM - 08 PM","fault":"Other Home Appliances/TV, LED/TV Installation (Upto 42 Inch)","lat_code":"27.1926004","lng_code":"73.7520147","idcity":"6","rating":null,"feedback_by":null,"booking_date":"2020-07-17T14:02:32.000000Z","completed_date":"2020-07-19 01:16:12","customerDetails":{"id":4,"name_prefix":null,"firstname":"mohit","lastname":null,"dob":null,"contact_no":"8130824151","img":null,"latitude":"0.0","longitude":"0.0","address_street":null,"address_type":null,"address":null,"city":null,"state":null,"country_code":null,"country":null,"user_id":"4","register_from":"1","created_at":"Jul 10 2020 14:11","updated_at":"Jul 10 2020 14:11"}},{"id":51,"order_id":"20200751","amount":"600","unit":"2","service_date":"2020-07-18","service_time":"08 AM - 12 PM","fault":"Refrigerator/Single Door/Single Door Repair","lat_code":"27.1926004","lng_code":"73.7520147","idcity":"6","rating":"5","feedback_by":"customer","booking_date":"2020-07-17T14:12:09.000000Z","completed_date":"2020-07-19 01:06:23","customerDetails":{"id":4,"name_prefix":null,"firstname":"mohit","lastname":null,"dob":null,"contact_no":"8130824151","img":null,"latitude":"0.0","longitude":"0.0","address_street":null,"address_type":null,"address":null,"city":null,"state":null,"country_code":null,"country":null,"user_id":"4","register_from":"1","created_at":"Jul 10 2020 14:11","updated_at":"Jul 10 2020 14:11"}}]
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
         * id : 21
         * order_id : 20200721
         * amount : 0
         * unit : 1
         * service_date : 2020-07-15
         * service_time : 08 AM - 12 PM
         * fault : AC/Repair/Split AC Repair
         * lat_code : 27.159789
         * lng_code : 73.7389596
         * idcity : 6
         * rating : null
         * feedback_by : null
         * booking_date : 2020-07-14T13:05:54.000000Z
         * completed_date : 2020-07-14 06:59:31
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
        private Object rating;
        private Object feedback_by;
        private String booking_date;
        private String completed_date;
        private CustomerDetailsBean customerDetails;
        private String customerName;
        private String address;

        public String getCommision() {
            return commision;
        }

        public void setCommision(String commision) {
            this.commision = commision;
        }

        private String commision;

        public String getWarrenty_day() {
            return warrenty_day;
        }

        public void setWarrenty_day(String warrenty_day) {
            this.warrenty_day = warrenty_day;
        }

        private String warrenty_day;

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
