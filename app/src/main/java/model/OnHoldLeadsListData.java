package model;

import java.util.List;

public class OnHoldLeadsListData {


    /**
     * status : true
     * data : [{"id":1,"order_id":"20200701","amount":"0","unit":"1","service_date":"2020-07-11","service_time":"08 AM - 12 PM","fault":"AC/Repair/Split AC Repair","lat_code":"27.1990586","lng_code":"73.7475227","idcity":"1","customerDetails":{"id":1,"name_prefix":null,"firstname":"suresh kumar","lastname":null,"dob":null,"contact_no":"9660223303","img":null,"latitude":"26.8946871","longitude":"75.7104896","address_street":null,"address_type":null,"address":"22, Gandhi Path W, Vaishali Nagar, Jaipur, Rajasthan 302034, India","city":"Jaipur","state":"Rajasthan","country_code":null,"country":"India","user_id":"1","register_from":"1","created_at":"Jul 09 2020 15:28","updated_at":"Jul 17 2020 16:46"}}]
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

        public String getBooking_date() {
            return booking_date;
        }

        public void setBooking_date(String booking_date) {
            this.booking_date = booking_date;
        }

        private String booking_date;
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
