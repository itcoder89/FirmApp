package model;

import java.util.List;

public class GetAllSelectedPartListData {


    /**
     * status : true
     * message : Data Found.
     * data : [{"id":20,"idpart":"88","name":"Capacitor 35-50 mfd","amount":"400","order_id":"202008329"},{"id":21,"idpart":"89","name":"Capacitor 50-60 mfd","amount":"500","order_id":"202008329"}]
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
         * id : 20
         * idpart : 88
         * name : Capacitor 35-50 mfd
         * amount : 400
         * order_id : 202008329
         */

        private int id;
        private String idpart;
        private String name;
        private String amount;
        private String order_id;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }
    }
}
