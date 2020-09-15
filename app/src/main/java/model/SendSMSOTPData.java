package model;

public class SendSMSOTPData {


    /**
     * status : true
     * message : Your OTP for confirmation is 8775
     * data : {"user":{"id":16,"name_prefix":null,"firstname":"surendra kumar","lastname":null,"dob":null,"contact_no":"9521159082","img":null,"latitude":"26.8837667","longitude":"75.7819036","address_street":null,"address_type":null,"address":"C-10, Adarsh Krishna Nagar, Bal Nagar, Kartarpur, Gopal Pura Mode, Jaipur, Rajasthan 302015, India","city":"Jaipur","state":"Rajasthan","country_code":null,"country":"India","user_id":16,"register_from":1,"created_at":"Jul 12 2020 17:21","updated_at":"Jul 13 2020 11:38"},"otp":8775}
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
         * user : {"id":16,"name_prefix":null,"firstname":"surendra kumar","lastname":null,"dob":null,"contact_no":"9521159082","img":null,"latitude":"26.8837667","longitude":"75.7819036","address_street":null,"address_type":null,"address":"C-10, Adarsh Krishna Nagar, Bal Nagar, Kartarpur, Gopal Pura Mode, Jaipur, Rajasthan 302015, India","city":"Jaipur","state":"Rajasthan","country_code":null,"country":"India","user_id":16,"register_from":1,"created_at":"Jul 12 2020 17:21","updated_at":"Jul 13 2020 11:38"}
         * otp : 8775
         */

        private UserBean user;
        private int otp;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public int getOtp() {
            return otp;
        }

        public void setOtp(int otp) {
            this.otp = otp;
        }

        public static class UserBean {
            /**
             * id : 16
             * name_prefix : null
             * firstname : surendra kumar
             * lastname : null
             * dob : null
             * contact_no : 9521159082
             * img : null
             * latitude : 26.8837667
             * longitude : 75.7819036
             * address_street : null
             * address_type : null
             * address : C-10, Adarsh Krishna Nagar, Bal Nagar, Kartarpur, Gopal Pura Mode, Jaipur, Rajasthan 302015, India
             * city : Jaipur
             * state : Rajasthan
             * country_code : null
             * country : India
             * user_id : 16
             * register_from : 1
             * created_at : Jul 12 2020 17:21
             * updated_at : Jul 13 2020 11:38
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
