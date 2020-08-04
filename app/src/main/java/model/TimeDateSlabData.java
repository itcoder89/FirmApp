package model;

import java.util.ArrayList;

public class TimeDateSlabData {

    /**
     * status : true
     * message : data available
     * data : [{"date":"2020-06-25","time":["08 AM - 12 PM","12 PM - 04 PM","04 PM - 08 PM"]},{"date":"2020-06-26","time":["08 AM - 12 PM","12 PM - 04 PM","04 PM - 08 PM"]},{"date":"2020-06-27","time":["08 AM - 12 PM","12 PM - 04 PM","04 PM - 08 PM"]},{"date":"2020-06-28","time":["08 AM - 12 PM","12 PM - 04 PM","04 PM - 08 PM"]},{"date":"2020-06-29","time":["08 AM - 12 PM","12 PM - 04 PM","04 PM - 08 PM"]},{"date":"2020-06-30","time":["08 AM - 12 PM","12 PM - 04 PM","04 PM - 08 PM"]}]
     */

    public String status;
    private String message;
    private ArrayList<DataBean> data;

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<DataBean> getData() {
        return data;
    }

    public void setData(ArrayList<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * date : 2020-06-25
         * time : ["08 AM - 12 PM","12 PM - 04 PM","04 PM - 08 PM"]
         */

        private String date;
        private ArrayList<String> time;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public ArrayList<String> getTime() {
            return time;
        }

        public void setTime(ArrayList<String> time) {
            this.time = time;
        }
    }
}
