package model;

public class RescheduleData {


    /**
     * status : true
     * message : Successfully Submitted Feedback on Booking.
     */

    public boolean status;
    private String message;

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

}
