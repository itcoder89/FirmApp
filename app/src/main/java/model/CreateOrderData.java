package model;

public class CreateOrderData {

    /**
     * status : true
     * message : Thanks for submitting your service request.Confirmation for your service request may take upto 24 working hours. You can check the latest status in My Booking section.
     */

    public String status;
    private String message;

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
}
