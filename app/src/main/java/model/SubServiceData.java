package model;

import java.util.List;

public class SubServiceData {


    /**
     * status : true
     * data : [{"idsubservice":"1","name":"Repair"},{"idsubservice":"2","name":"Water Service"},{"idsubservice":"26","name":"Uninstallation"},{"idsubservice":"3","name":"Installation"}]
     */

    public boolean status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
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
         * idsubservice : 1
         * name : Repair
         */

        private String idsubservice;
        private String name;

        public String getIdsubservice() {
            return idsubservice;
        }

        public void setIdsubservice(String idsubservice) {
            this.idsubservice = idsubservice;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
