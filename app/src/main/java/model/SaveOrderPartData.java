package model;

import java.util.List;

public class SaveOrderPartData {


    /**
     * status : true
     * message : Part Added Successfully.
     * data : [{"id":12,"idpart":"117","order_id":"202008329","part_amount":"2000","created_at":"Aug 08 2020 00:23","updated_at":"Aug 08 2020 12:53"},{"id":13,"idpart":"88","order_id":"202008329","part_amount":"400","created_at":"Aug 08 2020 12:37","updated_at":"Aug 08 2020 12:37"},{"id":14,"idpart":"88","order_id":"202008329","part_amount":"400","created_at":"Aug 08 2020 12:39","updated_at":"Aug 08 2020 12:39"}]
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
         * id : 12
         * idpart : 117
         * order_id : 202008329
         * part_amount : 2000
         * created_at : Aug 08 2020 00:23
         * updated_at : Aug 08 2020 12:53
         */

        private int id;
        private String idpart;
        private String order_id;
        private String part_amount;
        private String created_at;
        private String updated_at;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getIdpart() {
            return idpart;
        }

        public void setIdpart(String idpart) {
            this.idpart = idpart;
        }

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getPart_amount() {
            return part_amount;
        }

        public void setPart_amount(String part_amount) {
            this.part_amount = part_amount;
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
