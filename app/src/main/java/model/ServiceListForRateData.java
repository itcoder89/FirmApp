package model;

import java.util.List;

public class ServiceListForRateData {


    /**
     * status : true
     * data : [{"idservice":"1","name":"AC"},{"idservice":"11","name":"Painter"},{"idservice":"12","name":"Home Cleaning Services"},{"idservice":"13","name":"Beauty Salon at Home"},{"idservice":"15","name":"Other Home Appliances"},{"idservice":"16","name":"Kitchen Chimney"},{"idservice":"2","name":"Water Purifier"},{"idservice":"3","name":"Refrigerator"},{"idservice":"4","name":"Washing Machine"},{"idservice":"5","name":"Car Wash Service"},{"idservice":"6","name":"Water Tank Cleaning"},{"idservice":"7","name":"Plumber"},{"idservice":"8","name":"Carpenter"},{"idservice":"9","name":"Electrician"}]
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
         * idservice : 1
         * name : AC
         */

        private String idservice;
        private String name;

        public String getIdservice() {
            return idservice;
        }

        public void setIdservice(String idservice) {
            this.idservice = idservice;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
