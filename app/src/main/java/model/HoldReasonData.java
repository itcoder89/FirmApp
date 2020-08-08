package model;

public class HoldReasonData {


    /**
     * status : true
     * reason : Customer not at home
     */

    private boolean status;
    private String reason;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
