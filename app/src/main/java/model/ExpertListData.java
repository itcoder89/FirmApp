package model;

import java.util.List;

public class ExpertListData {


    /**
     * status : true
     * message : 1 Expert Founds.
     * data : [{"expert_id":"1","name":"Pradeep","contact_no":"9460238000","image":null}]
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
         * expert_id : 1
         * name : Pradeep
         * contact_no : 9460238000
         * image : null
         */

        private String expert_id;
        private String name;
        private String contact_no;
        private String image;

        public String getExpert_id() {
            return expert_id;
        }

        public void setExpert_id(String expert_id) {
            this.expert_id = expert_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getContact_no() {
            return contact_no;
        }

        public void setContact_no(String contact_no) {
            this.contact_no = contact_no;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
