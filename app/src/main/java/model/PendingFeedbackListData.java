package model;

import java.util.List;

public class PendingFeedbackListData {


    /**
     * status : true
     * data : [{"id":128,"order_id":"202008120","amount":500,"unit":1,"service_date":"2020-08-25","service_time":"04 PM - 08 PM","fault":"AC/Repair/Water Leakage","lat_code":"26.9059167","lng_code":"75.77273199999999","idcity":1,"booking_date":"2020-08-25T07:20:51.000000Z","customerDetails":{"id":115,"name_prefix":null,"firstname":"SONA","lastname":null,"dob":null,"contact_no":"9799057394","img":null,"latitude":"27.2098065","longitude":"73.7238808","address_street":null,"address_type":null,"address":"vyas colony, Indira Colony, Nagaur, Rajasthan, India","city":"Jaipur","state":null,"country_code":null,"country":null,"user_id":115,"register_from":0,"created_at":"Aug 06 2020 07:51","updated_at":"Aug 25 2020 10:38"},"customerName":"","address":"Sodala, Jaipur, Rajasthan, India","street":""},{"id":129,"order_id":"202008123","amount":1234,"unit":1,"service_date":"2020-08-26","service_time":"08 AM - 12 PM","fault":"AC/Repair/Water Leakage","lat_code":"26.9059167","lng_code":"75.77273199999999","idcity":1,"booking_date":"2020-08-25T10:39:45.000000Z","customerDetails":{"id":115,"name_prefix":null,"firstname":"SONA","lastname":null,"dob":null,"contact_no":"9799057394","img":null,"latitude":"27.2098065","longitude":"73.7238808","address_street":null,"address_type":null,"address":"vyas colony, Indira Colony, Nagaur, Rajasthan, India","city":"Jaipur","state":null,"country_code":null,"country":null,"user_id":115,"register_from":0,"created_at":"Aug 06 2020 07:51","updated_at":"Aug 25 2020 10:38"},"customerName":"","address":"Sodala, Jaipur, Rajasthan, India","street":""}]
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
         * id : 128
         * order_id : 202008120
         * amount : 500
         * unit : 1
         * service_date : 2020-08-25
         * service_time : 04 PM - 08 PM
         * fault : AC/Repair/Water Leakage
         * lat_code : 26.9059167
         * lng_code : 75.77273199999999
         * idcity : 1
         * booking_date : 2020-08-25T07:20:51.000000Z
         * customerDetails : {"id":115,"name_prefix":null,"firstname":"SONA","lastname":null,"dob":null,"contact_no":"9799057394","img":null,"latitude":"27.2098065","longitude":"73.7238808","address_street":null,"address_type":null,"address":"vyas colony, Indira Colony, Nagaur, Rajasthan, India","city":"Jaipur","state":null,"country_code":null,"country":null,"user_id":115,"register_from":0,"created_at":"Aug 06 2020 07:51","updated_at":"Aug 25 2020 10:38"}
         * customerName :
         * address : Sodala, Jaipur, Rajasthan, India
         * street :
         */

        private int id;
        private String order_id;
        private int amount;
        private int unit;
        private String service_date;
        private String service_time;
        private String fault;
        private String lat_code;
        private String lng_code;
        private int idcity;
        private String booking_date;
        private CustomerDetailsBean customerDetails;
        private String customerName;
        private String address;
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

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getUnit() {
            return unit;
        }

        public void setUnit(int unit) {
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

        public int getIdcity() {
            return idcity;
        }

        public void setIdcity(int idcity) {
            this.idcity = idcity;
        }

        public String getBooking_date() {
            return booking_date;
        }

        public void setBooking_date(String booking_date) {
            this.booking_date = booking_date;
        }

        public CustomerDetailsBean getCustomerDetails() {
            return customerDetails;
        }

        public void setCustomerDetails(CustomerDetailsBean customerDetails) {
            this.customerDetails = customerDetails;
        }

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
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public static class CustomerDetailsBean {
            /**
             * id : 115
             * name_prefix : null
             * firstname : SONA
             * lastname : null
             * dob : null
             * contact_no : 9799057394
             * img : null
             * latitude : 27.2098065
             * longitude : 73.7238808
             * address_street : null
             * address_type : null
             * address : vyas colony, Indira Colony, Nagaur, Rajasthan, India
             * city : Jaipur
             * state : null
             * country_code : null
             * country : null
             * user_id : 115
             * register_from : 0
             * created_at : Aug 06 2020 07:51
             * updated_at : Aug 25 2020 10:38
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
            private Object state;
            private Object country_code;
            private Object country;
            private int user_id;
            private int register_from;
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

            public Object getState() {
                return state;
            }

            public void setState(Object state) {
                this.state = state;
            }

            public Object getCountry_code() {
                return country_code;
            }

            public void setCountry_code(Object country_code) {
                this.country_code = country_code;
            }

            public Object getCountry() {
                return country;
            }

            public void setCountry(Object country) {
                this.country = country;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public int getRegister_from() {
                return register_from;
            }

            public void setRegister_from(int register_from) {
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
