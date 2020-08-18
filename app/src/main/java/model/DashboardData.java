package model;

import java.io.Serializable;

public class DashboardData implements Serializable {


    /**
     * status : true
     * data : {"totalOpenLeadsBooking":4,"totalNewLeadsBooking":0,"totalWorkingBooking":13,"totalHoldBooking":0,"totalCancelBooking":1,"totalCompleteBooking":7,"totalRescheduleBooking":0,"totalRecomplaintBooking":1,"totalFeedbackPendingBooking":22,"totalCustomerFeedback":2,"totalFeedbackCompleteBooking":4,"totalKodFeedback":0,"rating":4,"walletAmount":9000,"totalEarningAmount":5700,"kodCommission":"50"}
     */

    private boolean status;
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

    public static class DataBean implements Serializable{
        /**
         * totalOpenLeadsBooking : 4
         * totalNewLeadsBooking : 0
         * totalWorkingBooking : 13
         * totalHoldBooking : 0
         * totalCancelBooking : 1
         * totalCompleteBooking : 7
         * totalRescheduleBooking : 0
         * totalRecomplaintBooking : 1
         * totalFeedbackPendingBooking : 22
         * totalCustomerFeedback : 2
         * totalFeedbackCompleteBooking : 4
         * totalKodFeedback : 0
         * rating : 4
         * walletAmount : 9000
         * totalEarningAmount : 5700
         * kodCommission : 50
         */

        private int totalOpenLeadsBooking;
        private int totalNewLeadsBooking;
        private int totalWorkingBooking;
        private int totalHoldBooking;
        private int totalCancelBooking;
        private int totalCompleteBooking;
        private int totalRescheduleBooking;
        private int totalRecomplaintBooking;
        private int totalFeedbackPendingBooking;
        private int totalCustomerFeedback;
        private int totalFeedbackCompleteBooking;
        private int totalKodFeedback;
        private Float rating;
        private int walletAmount;
        private int totalEarningAmount;
        private String kodCommission;

        public int getTotalOpenLeadsBooking() {
            return totalOpenLeadsBooking;
        }

        public void setTotalOpenLeadsBooking(int totalOpenLeadsBooking) {
            this.totalOpenLeadsBooking = totalOpenLeadsBooking;
        }

        public int getTotalNewLeadsBooking() {
            return totalNewLeadsBooking;
        }

        public void setTotalNewLeadsBooking(int totalNewLeadsBooking) {
            this.totalNewLeadsBooking = totalNewLeadsBooking;
        }

        public int getTotalWorkingBooking() {
            return totalWorkingBooking;
        }

        public void setTotalWorkingBooking(int totalWorkingBooking) {
            this.totalWorkingBooking = totalWorkingBooking;
        }

        public int getTotalHoldBooking() {
            return totalHoldBooking;
        }

        public void setTotalHoldBooking(int totalHoldBooking) {
            this.totalHoldBooking = totalHoldBooking;
        }

        public int getTotalCancelBooking() {
            return totalCancelBooking;
        }

        public void setTotalCancelBooking(int totalCancelBooking) {
            this.totalCancelBooking = totalCancelBooking;
        }

        public int getTotalCompleteBooking() {
            return totalCompleteBooking;
        }

        public void setTotalCompleteBooking(int totalCompleteBooking) {
            this.totalCompleteBooking = totalCompleteBooking;
        }

        public int getTotalRescheduleBooking() {
            return totalRescheduleBooking;
        }

        public void setTotalRescheduleBooking(int totalRescheduleBooking) {
            this.totalRescheduleBooking = totalRescheduleBooking;
        }

        public int getTotalRecomplaintBooking() {
            return totalRecomplaintBooking;
        }

        public void setTotalRecomplaintBooking(int totalRecomplaintBooking) {
            this.totalRecomplaintBooking = totalRecomplaintBooking;
        }

        public int getTotalFeedbackPendingBooking() {
            return totalFeedbackPendingBooking;
        }

        public void setTotalFeedbackPendingBooking(int totalFeedbackPendingBooking) {
            this.totalFeedbackPendingBooking = totalFeedbackPendingBooking;
        }

        public int getTotalCustomerFeedback() {
            return totalCustomerFeedback;
        }

        public void setTotalCustomerFeedback(int totalCustomerFeedback) {
            this.totalCustomerFeedback = totalCustomerFeedback;
        }

        public int getTotalFeedbackCompleteBooking() {
            return totalFeedbackCompleteBooking;
        }

        public void setTotalFeedbackCompleteBooking(int totalFeedbackCompleteBooking) {
            this.totalFeedbackCompleteBooking = totalFeedbackCompleteBooking;
        }

        public int getTotalKodFeedback() {
            return totalKodFeedback;
        }

        public void setTotalKodFeedback(int totalKodFeedback) {
            this.totalKodFeedback = totalKodFeedback;
        }

        public Float getRating() {
            return rating;
        }

        public void setRating(Float rating) {
            this.rating = rating;
        }

        public int getWalletAmount() {
            return walletAmount;
        }

        public void setWalletAmount(int walletAmount) {
            this.walletAmount = walletAmount;
        }

        public int getTotalEarningAmount() {
            return totalEarningAmount;
        }

        public void setTotalEarningAmount(int totalEarningAmount) {
            this.totalEarningAmount = totalEarningAmount;
        }

        public String getKodCommission() {
            return kodCommission;
        }

        public void setKodCommission(String kodCommission) {
            this.kodCommission = kodCommission;
        }
    }
}
