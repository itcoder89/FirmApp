package model;

import java.util.List;

public class GetMoreFaultsData {


    /**
     * status : true
     * data : [{"id":80,"idservice":"1","idsubservice":"1","name":"Gas Charging (Full)","title":"","fault_rate":"2500","description":"","video_url":"","status":"1","multi_group":"1","in_booking":"0","in_working":"1","orders":"3","created_at":"Jul 16 2020 09:22","updated_at":"Jul 23 2020 12:07"},{"id":81,"idservice":"1","idsubservice":"1","name":"Gas Charging (Top up)","title":"","fault_rate":"1500","description":"","video_url":"","status":"1","multi_group":"1","in_booking":"0","in_working":"1","orders":"0","created_at":"Jul 16 2020 09:23","updated_at":"Jul 22 2020 09:06"},{"id":83,"idservice":"1","idsubservice":"1","name":"PCB Repair","title":"","fault_rate":"1800","description":"","video_url":"","status":"1","multi_group":"1","in_booking":"0","in_working":"1","orders":"0","created_at":"Jul 16 2020 09:26","updated_at":"Jul 22 2020 09:06"},{"id":82,"idservice":"1","idsubservice":"1","name":"PCB Repair (Inverter Model)","title":"","fault_rate":"3000","description":"","video_url":"","status":"1","multi_group":"1","in_booking":"0","in_working":"1","orders":"0","created_at":"Jul 16 2020 09:25","updated_at":"Jul 22 2020 09:06"},{"id":3,"idservice":"1","idsubservice":"1","name":"Split AC Repair","title":"","fault_rate":"400","description":"","video_url":"","status":"1","multi_group":"1","in_booking":"1","in_working":"1","orders":"1","created_at":"Jul 10 2020 04:33","updated_at":"Jul 22 2020 09:06"},{"id":4,"idservice":"1","idsubservice":"1","name":"Window AC Repair","title":"Minimum Charge","fault_rate":"400","description":"","video_url":"","status":"1","multi_group":"1","in_booking":"1","in_working":"1","orders":"2","created_at":"Jul 10 2020 04:34","updated_at":"Jul 22 2020 09:06"}]
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
         * id : 80
         * idservice : 1
         * idsubservice : 1
         * name : Gas Charging (Full)
         * title :
         * fault_rate : 2500
         * description :
         * video_url :
         * status : 1
         * multi_group : 1
         * in_booking : 0
         * in_working : 1
         * orders : 3
         * created_at : Jul 16 2020 09:22
         * updated_at : Jul 23 2020 12:07
         */

        private int id;
        private String idservice;
        private String idsubservice;
        private String name;
        private String title;
        private String fault_rate;
        private String description;
        private String video_url;
        private String status;
        private String multi_group;
        private String in_booking;
        private String in_working;
        private String orders;
        private String created_at;
        private String updated_at;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getIdservice() {
            return idservice;
        }

        public void setIdservice(String idservice) {
            this.idservice = idservice;
        }

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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getFault_rate() {
            return fault_rate;
        }

        public void setFault_rate(String fault_rate) {
            this.fault_rate = fault_rate;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getVideo_url() {
            return video_url;
        }

        public void setVideo_url(String video_url) {
            this.video_url = video_url;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMulti_group() {
            return multi_group;
        }

        public void setMulti_group(String multi_group) {
            this.multi_group = multi_group;
        }

        public String getIn_booking() {
            return in_booking;
        }

        public void setIn_booking(String in_booking) {
            this.in_booking = in_booking;
        }

        public String getIn_working() {
            return in_working;
        }

        public void setIn_working(String in_working) {
            this.in_working = in_working;
        }

        public String getOrders() {
            return orders;
        }

        public void setOrders(String orders) {
            this.orders = orders;
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
