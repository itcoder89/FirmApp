package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetPartListByOrderIdData {


    /**
     * status : true
     * message : Rate Card Found.
     * data : {"part-labour":[{"id":117,"idservice":"2","part_name":"Booster Pump Univesal","amount":"2000","labour":"200","unit":"","qty":"0","only_service_flag":"0","grand_total":"2200","created_at":"Jul 18 2020 17:50","updated_at":"Jul 18 2020 17:50"},{"id":115,"idservice":"2","part_name":"Carbon Filter Univesal","amount":"450","labour":"200","unit":"","qty":"0","only_service_flag":"0","grand_total":"650","created_at":"Jul 18 2020 17:50","updated_at":"Jul 18 2020 17:50"},{"id":111,"idservice":"2","part_name":"Flot Switch and Bloon Univesal","amount":"350","labour":"200","unit":"","qty":"0","only_service_flag":"0","grand_total":"550","created_at":"Jul 18 2020 17:50","updated_at":"Jul 18 2020 17:50"},{"id":118,"idservice":"2","part_name":"Membrane Univesal","amount":"1800","labour":"200","unit":"","qty":"0","only_service_flag":"0","grand_total":"2000","created_at":"Jul 18 2020 17:50","updated_at":"Jul 18 2020 17:50"},{"id":113,"idservice":"2","part_name":"Post Carbon Filter Univesal","amount":"450","labour":"200","unit":"","qty":"0","only_service_flag":"0","grand_total":"650","created_at":"Jul 18 2020 17:50","updated_at":"Jul 18 2020 17:50"},{"id":104,"idservice":"2","part_name":"Pre Filter Univesal","amount":"300","labour":"200","unit":"","qty":"0","only_service_flag":"0","grand_total":"500","created_at":"Jul 18 2020 17:50","updated_at":"Jul 18 2020 17:50"},{"id":116,"idservice":"2","part_name":"Sediment Filter Univesal","amount":"450","labour":"200","unit":"","qty":"0","only_service_flag":"0","grand_total":"650","created_at":"Jul 18 2020 17:50","updated_at":"Jul 18 2020 17:50"},{"id":106,"idservice":"2","part_name":"SMPS Univesal","amount":"700","labour":"200","unit":"","qty":"0","only_service_flag":"0","grand_total":"900","created_at":"Jul 18 2020 17:50","updated_at":"Jul 18 2020 17:50"},{"id":114,"idservice":"2","part_name":"Spoon Filter Univesal","amount":"50","labour":"200","unit":"","qty":"0","only_service_flag":"0","grand_total":"250","created_at":"Jul 18 2020 17:50","updated_at":"Jul 18 2020 17:50"},{"id":110,"idservice":"2","part_name":"SV Univesal","amount":"450","labour":"200","unit":"","qty":"0","only_service_flag":"0","grand_total":"650","created_at":"Jul 18 2020 17:50","updated_at":"Jul 18 2020 17:50"},{"id":105,"idservice":"2","part_name":"TDS Controller","amount":"250","labour":"200","unit":"","qty":"0","only_service_flag":"0","grand_total":"450","created_at":"Jul 18 2020 17:50","updated_at":"Jul 18 2020 17:50"},{"id":112,"idservice":"2","part_name":"UF Filter Univesal","amount":"500","labour":"200","unit":"","qty":"0","only_service_flag":"0","grand_total":"700","created_at":"Jul 18 2020 17:50","updated_at":"Jul 18 2020 17:50"},{"id":108,"idservice":"2","part_name":"UV Chamber Univesal","amount":"300","labour":"200","unit":"","qty":"0","only_service_flag":"0","grand_total":"500","created_at":"Jul 18 2020 17:50","updated_at":"Jul 18 2020 17:50"},{"id":109,"idservice":"2","part_name":"UV Lamp Univesal","amount":"230","labour":"200","unit":"","qty":"0","only_service_flag":"0","grand_total":"430","created_at":"Jul 18 2020 17:50","updated_at":"Jul 18 2020 17:50"},{"id":107,"idservice":"2","part_name":"UV Power Supply Univesal","amount":"300","labour":"200","unit":"","qty":"0","only_service_flag":"0","grand_total":"500","created_at":"Jul 18 2020 17:50","updated_at":"Jul 18 2020 17:50"}],"labour":[{"id":103,"idservice":"2","part_name":"Installation","amount":"0","labour":"300","unit":"","qty":"0","only_service_flag":"1","grand_total":"300","created_at":"Jul 18 2020 17:42","updated_at":"Jul 18 2020 17:42"},{"id":101,"idservice":"2","part_name":"Re-installation","amount":"0","labour":"400","unit":"","qty":"0","only_service_flag":"1","grand_total":"400","created_at":"Jul 18 2020 17:42","updated_at":"Jul 18 2020 17:42"},{"id":100,"idservice":"2","part_name":"Servicing and Filter Replace","amount":"0","labour":"200","unit":"","qty":"0","only_service_flag":"1","grand_total":"200","created_at":"Jul 18 2020 17:42","updated_at":"Jul 18 2020 17:42"},{"id":102,"idservice":"2","part_name":"Un-installation","amount":"0","labour":"200","unit":"","qty":"0","only_service_flag":"1","grand_total":"200","created_at":"Jul 18 2020 17:42","updated_at":"Jul 18 2020 17:42"}]}
     * header_text : The prices mentioned here are only indicative. Prices may vary depending upon the brand of the product you choose.
     * footer_text : Customer will have to make available any required spare part, if not available with our expert at the time of service.
     */

    private boolean status;
    private String message;
    private DataBean data;
    private String header_text;
    private String footer_text;

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

    public String getHeader_text() {
        return header_text;
    }

    public void setHeader_text(String header_text) {
        this.header_text = header_text;
    }

    public String getFooter_text() {
        return footer_text;
    }

    public void setFooter_text(String footer_text) {
        this.footer_text = footer_text;
    }

    public static class DataBean {
        @SerializedName("part-labour")
        private List<PartlabourBean> partlabour;
        private List<LabourBean> labour;

        public List<PartlabourBean> getPartlabour() {
            return partlabour;
        }

        public void setPartlabour(List<PartlabourBean> partlabour) {
            this.partlabour = partlabour;
        }

        public List<LabourBean> getLabour() {
            return labour;
        }

        public void setLabour(List<LabourBean> labour) {
            this.labour = labour;
        }

        public static class PartlabourBean {
            /**
             * id : 117
             * idservice : 2
             * part_name : Booster Pump Univesal
             * amount : 2000
             * labour : 200
             * unit :
             * qty : 0
             * only_service_flag : 0
             * grand_total : 2200
             * created_at : Jul 18 2020 17:50
             * updated_at : Jul 18 2020 17:50
             */

            private int id;
            private String idservice;
            private String part_name;
            private String amount;
            private String labour;
            private String unit;
            private String qty;
            private String only_service_flag;
            private String grand_total;
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

            public String getPart_name() {
                return part_name;
            }

            public void setPart_name(String part_name) {
                this.part_name = part_name;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getLabour() {
                return labour;
            }

            public void setLabour(String labour) {
                this.labour = labour;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public String getQty() {
                return qty;
            }

            public void setQty(String qty) {
                this.qty = qty;
            }

            public String getOnly_service_flag() {
                return only_service_flag;
            }

            public void setOnly_service_flag(String only_service_flag) {
                this.only_service_flag = only_service_flag;
            }

            public String getGrand_total() {
                return grand_total;
            }

            public void setGrand_total(String grand_total) {
                this.grand_total = grand_total;
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

        public static class LabourBean {
            /**
             * id : 103
             * idservice : 2
             * part_name : Installation
             * amount : 0
             * labour : 300
             * unit :
             * qty : 0
             * only_service_flag : 1
             * grand_total : 300
             * created_at : Jul 18 2020 17:42
             * updated_at : Jul 18 2020 17:42
             */

            private int id;
            private String idservice;
            private String part_name;
            private String amount;
            private String labour;
            private String unit;
            private String qty;
            private String only_service_flag;
            private String grand_total;
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

            public String getPart_name() {
                return part_name;
            }

            public void setPart_name(String part_name) {
                this.part_name = part_name;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getLabour() {
                return labour;
            }

            public void setLabour(String labour) {
                this.labour = labour;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public String getQty() {
                return qty;
            }

            public void setQty(String qty) {
                this.qty = qty;
            }

            public String getOnly_service_flag() {
                return only_service_flag;
            }

            public void setOnly_service_flag(String only_service_flag) {
                this.only_service_flag = only_service_flag;
            }

            public String getGrand_total() {
                return grand_total;
            }

            public void setGrand_total(String grand_total) {
                this.grand_total = grand_total;
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
}
