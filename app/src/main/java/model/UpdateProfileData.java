package model;

import java.util.List;

public class UpdateProfileData {


    /**
     * status : true
     * message : Profile updated successfully.
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
