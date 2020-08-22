package model;

import java.util.List;

public class OfflineRechargeData {


    /**
     * status : true
     * message : Payment Details Successfully Saved !!.
     * data : []
     */

    private boolean status;
    private String message;
    private List<?> data;

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

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
