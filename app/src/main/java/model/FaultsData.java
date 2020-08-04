package model;

import java.util.ArrayList;

public class FaultsData {


    /**
     * status : true
     * message : Faults Exists
     * data : [{"idservice":"1","idsubservice":"2","idfaults":"3","fault":"Water Lekage","_subfaults":[{"id":64,"name":"Other Issue","title":"","image":"2.jpg","status":"0","idfaults":"3","created_at":"Jun 23 2020 06:46","updated_at":"Jun 23 2020 06:46"},{"id":65,"name":"Service Require","title":"","image":"3.jpg","status":"0","idfaults":"3","created_at":"Jun 23 2020 06:46","updated_at":"Jun 23 2020 06:46"}],"_servicecityrates":{"id":221,"idfaults":"3","default_amount":"2500","qty1_rate":"0","qty2_rate":"0","qty3_rate":"0"},"_partcardrate":[{"id":38,"idservice":"1","part_name":"Capacitor 35-55 MFD","amount":"560","labour":"800","unit":"","qty":"0","only_service_flag":"0","grand_total":"1360","created_at":"Jun 26 2020 13:00","updated_at":"Jun 26 2020 13:00"},{"id":39,"idservice":"1","part_name":"Swing Blade","amount":"580","labour":"300","unit":"","qty":"0","only_service_flag":"0","grand_total":"880","created_at":"Jun 26 2020 13:00","updated_at":"Jun 26 2020 13:00"},{"id":40,"idservice":"1","part_name":"Swing Motor","amount":"350","labour":"400","unit":"","qty":"0","only_service_flag":"0","grand_total":"750","created_at":"Jun 26 2020 13:00","updated_at":"Jun 26 2020 13:00"},{"id":41,"idservice":"1","part_name":"1 Fit Pipe Kit","amount":"280","labour":"0","unit":"","qty":"0","only_service_flag":"0","grand_total":"0","created_at":"Jun 26 2020 13:00","updated_at":"Jun 26 2020 13:00"},{"id":42,"idservice":"1","part_name":"Blower Motor","amount":"1800","labour":"800","unit":"","qty":"0","only_service_flag":"0","grand_total":"2600","created_at":"Jun 26 2020 13:00","updated_at":"Jun 26 2020 13:00"},{"id":43,"idservice":"1","part_name":"Blower","amount":"750","labour":"650","unit":"","qty":"0","only_service_flag":"0","grand_total":"1400","created_at":"Jun 26 2020 13:00","updated_at":"Jun 26 2020 13:00"},{"id":44,"idservice":"1","part_name":"Cooling Sensor","amount":"350","labour":"400","unit":"","qty":"0","only_service_flag":"0","grand_total":"750","created_at":"Jun 26 2020 13:00","updated_at":"Jun 26 2020 13:00"}]},{"idservice":"1","idsubservice":"2","idfaults":"4","fault":"Gas Filling","_subfaults":[],"_servicecityrates":{"id":222,"idfaults":"4","default_amount":"3000","qty1_rate":"0","qty2_rate":"0","qty3_rate":"0"},"_partcardrate":[{"id":38,"idservice":"1","part_name":"Capacitor 35-55 MFD","amount":"560","labour":"800","unit":"","qty":"0","only_service_flag":"0","grand_total":"1360","created_at":"Jun 26 2020 13:00","updated_at":"Jun 26 2020 13:00"},{"id":39,"idservice":"1","part_name":"Swing Blade","amount":"580","labour":"300","unit":"","qty":"0","only_service_flag":"0","grand_total":"880","created_at":"Jun 26 2020 13:00","updated_at":"Jun 26 2020 13:00"},{"id":40,"idservice":"1","part_name":"Swing Motor","amount":"350","labour":"400","unit":"","qty":"0","only_service_flag":"0","grand_total":"750","created_at":"Jun 26 2020 13:00","updated_at":"Jun 26 2020 13:00"},{"id":41,"idservice":"1","part_name":"1 Fit Pipe Kit","amount":"280","labour":"0","unit":"","qty":"0","only_service_flag":"0","grand_total":"0","created_at":"Jun 26 2020 13:00","updated_at":"Jun 26 2020 13:00"},{"id":42,"idservice":"1","part_name":"Blower Motor","amount":"1800","labour":"800","unit":"","qty":"0","only_service_flag":"0","grand_total":"2600","created_at":"Jun 26 2020 13:00","updated_at":"Jun 26 2020 13:00"},{"id":43,"idservice":"1","part_name":"Blower","amount":"750","labour":"650","unit":"","qty":"0","only_service_flag":"0","grand_total":"1400","created_at":"Jun 26 2020 13:00","updated_at":"Jun 26 2020 13:00"},{"id":44,"idservice":"1","part_name":"Cooling Sensor","amount":"350","labour":"400","unit":"","qty":"0","only_service_flag":"0","grand_total":"750","created_at":"Jun 26 2020 13:00","updated_at":"Jun 26 2020 13:00"}]}]
     */

    public boolean status;
    private String message;
    private ArrayList<DataBean> data;

    public String getPart_header() {
        return part_header;
    }

    public void setPart_header(String part_header) {
        this.part_header = part_header;
    }

    public String getPart_footer() {
        return part_footer;
    }

    public void setPart_footer(String part_footer) {
        this.part_footer = part_footer;
    }

    private String part_header;
    private String part_footer;

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

    public ArrayList<DataBean> getData() {
        return data;
    }

    public void setData(ArrayList<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * idservice : 1
         * idsubservice : 2
         * idfaults : 3
         * fault : Water Lekage
         * _subfaults : [{"id":64,"name":"Other Issue","title":"","image":"2.jpg","status":"0","idfaults":"3","created_at":"Jun 23 2020 06:46","updated_at":"Jun 23 2020 06:46"},{"id":65,"name":"Service Require","title":"","image":"3.jpg","status":"0","idfaults":"3","created_at":"Jun 23 2020 06:46","updated_at":"Jun 23 2020 06:46"}]
         * _servicecityrates : {"id":221,"idfaults":"3","default_amount":"2500","qty1_rate":"0","qty2_rate":"0","qty3_rate":"0"}
         * _partcardrate : [{"id":38,"idservice":"1","part_name":"Capacitor 35-55 MFD","amount":"560","labour":"800","unit":"","qty":"0","only_service_flag":"0","grand_total":"1360","created_at":"Jun 26 2020 13:00","updated_at":"Jun 26 2020 13:00"},{"id":39,"idservice":"1","part_name":"Swing Blade","amount":"580","labour":"300","unit":"","qty":"0","only_service_flag":"0","grand_total":"880","created_at":"Jun 26 2020 13:00","updated_at":"Jun 26 2020 13:00"},{"id":40,"idservice":"1","part_name":"Swing Motor","amount":"350","labour":"400","unit":"","qty":"0","only_service_flag":"0","grand_total":"750","created_at":"Jun 26 2020 13:00","updated_at":"Jun 26 2020 13:00"},{"id":41,"idservice":"1","part_name":"1 Fit Pipe Kit","amount":"280","labour":"0","unit":"","qty":"0","only_service_flag":"0","grand_total":"0","created_at":"Jun 26 2020 13:00","updated_at":"Jun 26 2020 13:00"},{"id":42,"idservice":"1","part_name":"Blower Motor","amount":"1800","labour":"800","unit":"","qty":"0","only_service_flag":"0","grand_total":"2600","created_at":"Jun 26 2020 13:00","updated_at":"Jun 26 2020 13:00"},{"id":43,"idservice":"1","part_name":"Blower","amount":"750","labour":"650","unit":"","qty":"0","only_service_flag":"0","grand_total":"1400","created_at":"Jun 26 2020 13:00","updated_at":"Jun 26 2020 13:00"},{"id":44,"idservice":"1","part_name":"Cooling Sensor","amount":"350","labour":"400","unit":"","qty":"0","only_service_flag":"0","grand_total":"750","created_at":"Jun 26 2020 13:00","updated_at":"Jun 26 2020 13:00"}]
         */

        private String idservice;

        public String getService() {
            return service;
        }

        public void setService(String service) {
            this.service = service;
        }

        public String getSubservice() {
            return subservice;
        }

        public void setSubservice(String subservice) {
            this.subservice = subservice;
        }

        private String service;
        private String subservice;
        private String idsubservice;
        private String idfaults;
        private String fault;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        private String description;
        private ServicecityratesBean _servicecityrates;
        private ArrayList<SubfaultsBean> _subfaults;
        private ArrayList<PartcardrateBean> _partcardrate;

        public String getIdservice() {
            return idservice;
        }

        public void setIdservice(String idservice) {
            this.idservice = idservice;
        }

        public String getIdsubservice() {
            return idsubservice;
        }

        public void setIdsubservice(String idsubservice) {
            this.idsubservice = idsubservice;
        }

        public String getIdfaults() {
            return idfaults;
        }

        public void setIdfaults(String idfaults) {
            this.idfaults = idfaults;
        }

        public String getFault() {
            return fault;
        }

        public void setFault(String fault) {
            this.fault = fault;
        }

        public ServicecityratesBean get_servicecityrates() {
            return _servicecityrates;
        }

        public void set_servicecityrates(ServicecityratesBean _servicecityrates) {
            this._servicecityrates = _servicecityrates;
        }

        public ArrayList<SubfaultsBean> get_subfaults() {
            return _subfaults;
        }

        public void set_subfaults(ArrayList<SubfaultsBean> _subfaults) {
            this._subfaults = _subfaults;
        }

        public ArrayList<PartcardrateBean> get_partcardrate() {
            return _partcardrate;
        }

        public void set_partcardrate(ArrayList<PartcardrateBean> _partcardrate) {
            this._partcardrate = _partcardrate;
        }

        public static class ServicecityratesBean {
            /**
             * id : 221
             * idfaults : 3
             * default_amount : 2500
             * qty1_rate : 0
             * qty2_rate : 0
             * qty3_rate : 0
             */

            private int id;
            private String idfaults;
            private String default_amount;
            private String qty1_rate;

            public String getQty() {
                if(qty==null || qty.equals("")){
                    qty = "0";
                }
                return qty;
            }

            public void setQty(String qty) {
                this.qty = qty;
            }

            private String qty;
            private String qty2_rate;
            private String qty3_rate;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getIdfaults() {
                return idfaults;
            }

            public void setIdfaults(String idfaults) {
                this.idfaults = idfaults;
            }

            public String getDefault_amount() {

                if(default_amount==null || default_amount.equals("")){
                    default_amount = "0";
                }

                return default_amount;
            }

            public void setDefault_amount(String default_amount) {
                this.default_amount = default_amount;
            }

            public String getQty1_rate() {

                if(qty1_rate==null || qty1_rate.equals("")){
                    qty1_rate = "0";
                }

                return qty1_rate;
            }

            public void setQty1_rate(String qty1_rate) {
                this.qty1_rate = qty1_rate;
            }

            public String getQty2_rate() {

                if(qty2_rate==null || qty2_rate.equals("")){
                    qty2_rate = "0";
                }

                return qty2_rate;
            }

            public void setQty2_rate(String qty2_rate) {
                this.qty2_rate = qty2_rate;
            }

            public String getQty3_rate() {

                if(qty3_rate==null || qty3_rate.equals("")){
                    qty3_rate = "0";
                }

                return qty3_rate;
            }

            public void setQty3_rate(String qty3_rate) {
                this.qty3_rate = qty3_rate;
            }
        }

        public static class SubfaultsBean {
            /**
             * id : 64
             * name : Other Issue
             * title :
             * image : 2.jpg
             * status : 0
             * idfaults : 3
             * created_at : Jun 23 2020 06:46
             * updated_at : Jun 23 2020 06:46
             */

            private int id;
            private String name;
            private String title;
            private String image;
            private String status;
            private String idfaults;
            private String created_at;
            private String updated_at;
            private String is_select;

            public String getIs_select() {
                if(is_select==null){
                    is_select = "";
                }
                return is_select;
            }

            public void setIs_select(String is_select) {
                this.is_select = is_select;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getIdfaults() {
                return idfaults;
            }

            public void setIdfaults(String idfaults) {
                this.idfaults = idfaults;
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

        public static class PartcardrateBean {
            /**
             * id : 38
             * idservice : 1
             * part_name : Capacitor 35-55 MFD
             * amount : 560
             * labour : 800
             * unit :
             * qty : 0
             * only_service_flag : 0
             * grand_total : 1360
             * created_at : Jun 26 2020 13:00
             * updated_at : Jun 26 2020 13:00
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
