package model;

public class EstimateSentData {


    /**
     * status : true
     * message : Estimate Sent
     * data : {"otp":7642,"estimateCount":6}
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
         * otp : 7642
         * estimateCount : 6
         */

        private int otp;
        private int estimateCount;

        public int getOtp() {
            return otp;
        }

        public void setOtp(int otp) {
            this.otp = otp;
        }

        public int getEstimateCount() {
            return estimateCount;
        }

        public void setEstimateCount(int estimateCount) {
            this.estimateCount = estimateCount;
        }
    }
}
