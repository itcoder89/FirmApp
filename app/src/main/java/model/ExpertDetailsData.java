package model;

import java.io.Serializable;

public class ExpertDetailsData implements Serializable {


    /**
     * status : true
     * data : {"id":1,"name":"Pradeep","father_name":"","contact_no":"9460238000","alt_mob_no":"000","email":"pradeep@gmail.com","password":"9460238000","e_image":null,"signature_file":null,"expert_agreement":null,"address":"Harima nagaur","is_approve":"1","reason":"","aadhar_no":"","pan_no":null,"created_at":"Jul 14 2020 12:51","updated_at":"Jul 15 2020 05:56"}
     */

    private boolean status;

    public String getImg_path() {
        if(img_path==null || img_path.equals("")){
            img_path = "";
        }
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    private String img_path;
    private DataBean data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * name : Pradeep
         * father_name :
         * contact_no : 9460238000
         * alt_mob_no : 000
         * email : pradeep@gmail.com
         * password : 9460238000
         * e_image : null
         * signature_file : null
         * expert_agreement : null
         * address : Harima nagaur
         * is_approve : 1
         * reason :
         * aadhar_no :
         * pan_no : null
         * created_at : Jul 14 2020 12:51
         * updated_at : Jul 15 2020 05:56
         */

        private int id;
        private String name;
        private String father_name;
        private String contact_no;
        private String alt_mob_no;
        private String email;
        private String password;
        private Object e_image;
        private String signature_file;
        private Object expert_agreement;
        private String address;
        private String is_approve;
        private String reason;
        private String aadhar_no;
        private String pan_no;
        private String created_at;
        private String updated_at;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFather_name() {
            return father_name;
        }

        public void setFather_name(String father_name) {
            this.father_name = father_name;
        }

        public String getContact_no() {
            return contact_no;
        }

        public void setContact_no(String contact_no) {
            this.contact_no = contact_no;
        }

        public String getAlt_mob_no() {
            return alt_mob_no;
        }

        public void setAlt_mob_no(String alt_mob_no) {
            this.alt_mob_no = alt_mob_no;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Object getE_image() {
            return e_image;
        }

        public void setE_image(Object e_image) {
            this.e_image = e_image;
        }

        public String getSignature_file() {
            if(signature_file==null || signature_file.equals("")){
                signature_file = "";
            }
            return signature_file;
        }

        public void setSignature_file(String signature_file) {
            this.signature_file = signature_file;
        }

        public Object getExpert_agreement() {
            return expert_agreement;
        }

        public void setExpert_agreement(Object expert_agreement) {
            this.expert_agreement = expert_agreement;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getIs_approve() {
            return is_approve;
        }

        public void setIs_approve(String is_approve) {
            this.is_approve = is_approve;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getAadhar_no() {
            if(aadhar_no==null || aadhar_no.equals("")){
                aadhar_no = "Not Available";
            }
            return aadhar_no;
        }

        public void setAadhar_no(String aadhar_no) {
            this.aadhar_no = aadhar_no;
        }

        public String getPan_no() {
            if(pan_no==null || pan_no.equals("")){
                pan_no = "Not Available";
            }
            return pan_no;
        }

        public void setPan_no(String pan_no) {
            this.pan_no = pan_no;
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
