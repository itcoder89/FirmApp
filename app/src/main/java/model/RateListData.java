package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RateListData {


    /**
     * status : true
     * message : Rate Card Exists
     * data : {"part-labour":[{"id":98,"idservice":"1","part_name":"Blower","amount":"1100","labour":"200","unit":"","qty":"0","only_service_flag":"0","grand_total":"1300","created_at":"Jul 18 2020 17:34","updated_at":"Jul 18 2020 17:34"},{"id":97,"idservice":"1","part_name":"Blower Motor","amount":"2200","labour":"200","unit":"","qty":"0","only_service_flag":"0","grand_total":"2400","created_at":"Jul 18 2020 17:34","updated_at":"Jul 18 2020 17:34"},{"id":88,"idservice":"1","part_name":"Capacitor 35-50 mfd","amount":"400","labour":"200","unit":"","qty":"0","only_service_flag":"0","grand_total":"600","created_at":"Jul 18 2020 17:34","updated_at":"Jul 18 2020 17:34"},{"id":89,"idservice":"1","part_name":"Capacitor 50-60 mfd","amount":"500","labour":"200","unit":"","qty":"0","only_service_flag":"0","grand_total":"700","created_at":"Jul 18 2020 17:34","updated_at":"Jul 18 2020 17:34"},{"id":93,"idservice":"1","part_name":"Cooling coil","amount":"4000","labour":"200","unit":"","qty":"0","only_service_flag":"0","grand_total":"4200","created_at":"Jul 18 2020 17:34","updated_at":"Jul 18 2020 17:34"},{"id":90,"idservice":"1","part_name":"Copper pipe (per Feet)","amount":"250","labour":"200","unit":"","qty":"0","only_service_flag":"0","grand_total":"450","created_at":"Jul 18 2020 17:34","updated_at":"Jul 18 2020 17:34"},{"id":91,"idservice":"1","part_name":"Fan blade outdoor","amount":"700","labour":"200","unit":"","qty":"0","only_service_flag":"0","grand_total":"900","created_at":"Jul 18 2020 17:34","updated_at":"Jul 18 2020 17:34"},{"id":92,"idservice":"1","part_name":"Fan motor outdoor","amount":"1600","labour":"200","unit":"","qty":"0","only_service_flag":"0","grand_total":"1800","created_at":"Jul 18 2020 17:34","updated_at":"Jul 18 2020 17:34"},{"id":96,"idservice":"1","part_name":"Swing Blade","amount":"400","labour":"200","unit":"","qty":"0","only_service_flag":"0","grand_total":"600","created_at":"Jul 18 2020 17:34","updated_at":"Jul 18 2020 17:34"},{"id":95,"idservice":"1","part_name":"Swing Moter","amount":"600","labour":"200","unit":"","qty":"0","only_service_flag":"0","grand_total":"800","created_at":"Jul 18 2020 17:34","updated_at":"Jul 18 2020 17:34"},{"id":94,"idservice":"1","part_name":"Universal Remote","amount":"700","labour":"200","unit":"","qty":"0","only_service_flag":"0","grand_total":"900","created_at":"Jul 18 2020 17:34","updated_at":"Jul 18 2020 17:34"}],"labour":[{"id":80,"idservice":"1","part_name":"Gas Charging Full","amount":"0","labour":"2500","unit":"","qty":"0","only_service_flag":"1","grand_total":"2500","created_at":"Jul 18 2020 17:16","updated_at":"Jul 18 2020 17:16"},{"id":81,"idservice":"1","part_name":"Gas Charging Top-up","amount":"0","labour":"1500","unit":"","qty":"0","only_service_flag":"1","grand_total":"1500","created_at":"Jul 18 2020 17:16","updated_at":"Jul 18 2020 17:16"},{"id":82,"idservice":"1","part_name":"installation Split AC","amount":"0","labour":"1500","unit":"","qty":"0","only_service_flag":"1","grand_total":"1500","created_at":"Jul 18 2020 17:18","updated_at":"Jul 18 2020 17:18"},{"id":85,"idservice":"1","part_name":"Installation Window AC","amount":"0","labour":"1000","unit":"","qty":"0","only_service_flag":"1","grand_total":"1000","created_at":"Jul 18 2020 17:21","updated_at":"Jul 18 2020 17:21"},{"id":78,"idservice":"1","part_name":"Inverter AC PCB Repair","amount":"0","labour":"3000","unit":"","qty":"0","only_service_flag":"1","grand_total":"3000","created_at":"Jul 18 2020 17:16","updated_at":"Jul 18 2020 17:16"},{"id":87,"idservice":"1","part_name":"Minimum Repair Charge","amount":"0","labour":"200","unit":"","qty":"0","only_service_flag":"1","grand_total":"200","created_at":"Jul 18 2020 17:27","updated_at":"Jul 18 2020 17:27"},{"id":79,"idservice":"1","part_name":"PCB Repair","amount":"0","labour":"1800","unit":"","qty":"0","only_service_flag":"1","grand_total":"1800","created_at":"Jul 18 2020 17:16","updated_at":"Jul 18 2020 17:16"},{"id":84,"idservice":"1","part_name":"Re-Installation Split AC","amount":"0","labour":"2000","unit":"","qty":"0","only_service_flag":"1","grand_total":"2000","created_at":"Jul 18 2020 17:18","updated_at":"Jul 18 2020 17:18"},{"id":83,"idservice":"1","part_name":"Un-Installation Split AC","amount":"0","labour":"1000","unit":"","qty":"0","only_service_flag":"1","grand_total":"1000","created_at":"Jul 18 2020 17:18","updated_at":"Jul 18 2020 17:18"},{"id":86,"idservice":"1","part_name":"Un-Installation Window AC","amount":"0","labour":"700","unit":"","qty":"0","only_service_flag":"1","grand_total":"700","created_at":"Jul 18 2020 17:21","updated_at":"Jul 18 2020 17:21"}]}
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
             * id : 98
             * idservice : 1
             * part_name : Blower
             * amount : 1100
             * labour : 200
             * unit :
             * qty : 0
             * only_service_flag : 0
             * grand_total : 1300
             * created_at : Jul 18 2020 17:34
             * updated_at : Jul 18 2020 17:34
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
             * id : 80
             * idservice : 1
             * part_name : Gas Charging Full
             * amount : 0
             * labour : 2500
             * unit :
             * qty : 0
             * only_service_flag : 1
             * grand_total : 2500
             * created_at : Jul 18 2020 17:16
             * updated_at : Jul 18 2020 17:16
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
