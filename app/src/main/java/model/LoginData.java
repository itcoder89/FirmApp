package model;

public class LoginData {


    /**
     * status : 1
     * message : Expert has Logged in Successfully
     * data : {"user":{"id":19,"username":"KC Enterprises","contact_no":"9660223303","email":"sanjaykods@gmail.com","password_reset_token":"$2y$10$N0C4pSzk2K.Yl3o1nImJD.6koTTvFC43Ff6bMONV8elHTbJhlzZny","usertype":"2","refrenceid":"3","img":null,"status":"0","created_at":"2020-07-14T12:46:53.000000Z","updated_at":"2020-07-14T12:46:53.000000Z"},"otp":4020}
     */

    private int status;
    private String message;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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
         * user : {"id":19,"username":"KC Enterprises","contact_no":"9660223303","email":"sanjaykods@gmail.com","password_reset_token":"$2y$10$N0C4pSzk2K.Yl3o1nImJD.6koTTvFC43Ff6bMONV8elHTbJhlzZny","usertype":"2","refrenceid":"3","img":null,"status":"0","created_at":"2020-07-14T12:46:53.000000Z","updated_at":"2020-07-14T12:46:53.000000Z"}
         * otp : 4020
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
             * id : 19
             * username : KC Enterprises
             * contact_no : 9660223303
             * email : sanjaykods@gmail.com
             * password_reset_token : $2y$10$N0C4pSzk2K.Yl3o1nImJD.6koTTvFC43Ff6bMONV8elHTbJhlzZny
             * usertype : 2
             * refrenceid : 3
             * img : null
             * status : 0
             * created_at : 2020-07-14T12:46:53.000000Z
             * updated_at : 2020-07-14T12:46:53.000000Z
             */

            private int id;
            private String username;
            private String contact_no;
            private String email;
            private String password_reset_token;
            private String usertype;
            private String refrenceid;
            private Object img;
            private String status;
            private String created_at;
            private String updated_at;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getContact_no() {
                return contact_no;
            }

            public void setContact_no(String contact_no) {
                this.contact_no = contact_no;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getPassword_reset_token() {
                return password_reset_token;
            }

            public void setPassword_reset_token(String password_reset_token) {
                this.password_reset_token = password_reset_token;
            }

            public String getUsertype() {
                return usertype;
            }

            public void setUsertype(String usertype) {
                this.usertype = usertype;
            }

            public String getRefrenceid() {
                return refrenceid;
            }

            public void setRefrenceid(String refrenceid) {
                this.refrenceid = refrenceid;
            }

            public Object getImg() {
                return img;
            }

            public void setImg(Object img) {
                this.img = img;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
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
