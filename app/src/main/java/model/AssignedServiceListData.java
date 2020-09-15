package model;

import java.util.List;

public class AssignedServiceListData {


    /**
     * status : true
     * data : [{"id":1,"name":"AC","subservices_id":1,"subservice_name":"Repair","faults_id":3,"fault_name":"Split AC Repair","rates":[{"qty1_rate":200,"qty1_commision":0,"qty2_rate":200,"qty2_commision":0,"qty3_rate":200,"qty3_commision":0}]},{"id":1,"name":"AC","subservices_id":1,"subservice_name":"Repair","faults_id":4,"fault_name":"Window AC Repair","rates":[{"qty1_rate":200,"qty1_commision":0,"qty2_rate":200,"qty2_commision":0,"qty3_rate":200,"qty3_commision":0}]},{"id":1,"name":"AC","subservices_id":1,"subservice_name":"Repair","faults_id":80,"fault_name":"Gas Charging (Full)","rates":[{"qty1_rate":2100,"qty1_commision":500,"qty2_rate":2100,"qty2_commision":500,"qty3_rate":2100,"qty3_commision":500}]},{"id":1,"name":"AC","subservices_id":1,"subservice_name":"Repair","faults_id":81,"fault_name":"Gas Charging (Top up)","rates":[{"qty1_rate":1500,"qty1_commision":500,"qty2_rate":1500,"qty2_commision":500,"qty3_rate":1500,"qty3_commision":500}]},{"id":1,"name":"AC","subservices_id":1,"subservice_name":"Repair","faults_id":82,"fault_name":"PCB Repair (Inverter Model)","rates":[{"qty1_rate":2500,"qty1_commision":500,"qty2_rate":2500,"qty2_commision":500,"qty3_rate":2500,"qty3_commision":500}]},{"id":1,"name":"AC","subservices_id":1,"subservice_name":"Repair","faults_id":83,"fault_name":"PCB Repair","rates":[{"qty1_rate":1800,"qty1_commision":500,"qty2_rate":1800,"qty2_commision":500,"qty3_rate":1800,"qty3_commision":500}]},{"id":1,"name":"AC","subservices_id":1,"subservice_name":"Repair","faults_id":172,"fault_name":"Water Leakage","rates":[{"qty1_rate":500,"qty1_commision":200,"qty2_rate":500,"qty2_commision":200,"qty3_rate":500,"qty3_commision":200}]},{"id":1,"name":"AC","subservices_id":2,"subservice_name":"Water Service","faults_id":1,"fault_name":"Split AC","rates":[{"qty1_rate":499,"qty1_commision":200,"qty2_rate":1,"qty2_commision":0,"qty3_rate":250,"qty3_commision":50}]},{"id":1,"name":"AC","subservices_id":2,"subservice_name":"Water Service","faults_id":2,"fault_name":"Window AC","rates":[{"qty1_rate":499,"qty1_commision":200,"qty2_rate":1,"qty2_commision":0,"qty3_rate":250,"qty3_commision":50}]},{"id":1,"name":"AC","subservices_id":3,"subservice_name":"Installation","faults_id":5,"fault_name":"Split AC Installation","rates":[{"qty1_rate":1300,"qty1_commision":300,"qty2_rate":1300,"qty2_commision":300,"qty3_rate":1300,"qty3_commision":300}]},{"id":1,"name":"AC","subservices_id":3,"subservice_name":"Installation","faults_id":6,"fault_name":"Window AC Installation","rates":[{"qty1_rate":800,"qty1_commision":200,"qty2_rate":800,"qty2_commision":200,"qty3_rate":800,"qty3_commision":200}]},{"id":1,"name":"AC","subservices_id":26,"subservice_name":"Uninstallation","faults_id":78,"fault_name":"Split AC Uninstallation","rates":[{"qty1_rate":800,"qty1_commision":200,"qty2_rate":800,"qty2_commision":200,"qty3_rate":800,"qty3_commision":200}]},{"id":1,"name":"AC","subservices_id":26,"subservice_name":"Uninstallation","faults_id":79,"fault_name":"Window AC Uninstallation","rates":[{"qty1_rate":500,"qty1_commision":100,"qty2_rate":500,"qty2_commision":100,"qty3_rate":500,"qty3_commision":100}]},{"id":2,"name":"Water Purifier","subservices_id":8,"subservice_name":"RO, UV Purifier","faults_id":12,"fault_name":"Repair","rates":[{"qty1_rate":50,"qty1_commision":0,"qty2_rate":50,"qty2_commision":0,"qty3_rate":50,"qty3_commision":0}]},{"id":2,"name":"Water Purifier","subservices_id":8,"subservice_name":"RO, UV Purifier","faults_id":13,"fault_name":"Service or Filter Change","rates":[{"qty1_rate":50,"qty1_commision":0,"qty2_rate":50,"qty2_commision":0,"qty3_rate":50,"qty3_commision":0}]},{"id":2,"name":"Water Purifier","subservices_id":8,"subservice_name":"RO, UV Purifier","faults_id":14,"fault_name":"Installation","rates":[{"qty1_rate":250,"qty1_commision":50,"qty2_rate":250,"qty2_commision":50,"qty3_rate":250,"qty3_commision":50}]},{"id":2,"name":"Water Purifier","subservices_id":8,"subservice_name":"RO, UV Purifier","faults_id":15,"fault_name":"Uninstallation","rates":[{"qty1_rate":200,"qty1_commision":50,"qty2_rate":200,"qty2_commision":50,"qty3_rate":200,"qty3_commision":50}]},{"id":2,"name":"Water Purifier","subservices_id":8,"subservice_name":"RO, UV Purifier","faults_id":16,"fault_name":"Reinstallation","rates":[{"qty1_rate":300,"qty1_commision":50,"qty2_rate":300,"qty2_commision":50,"qty3_rate":300,"qty3_commision":50}]},{"id":2,"name":"Water Purifier","subservices_id":8,"subservice_name":"RO, UV Purifier","faults_id":84,"fault_name":"Membrane 75 GPD","rates":[{"qty1_rate":900,"qty1_commision":50,"qty2_rate":900,"qty2_commision":50,"qty3_rate":900,"qty3_commision":50}]},{"id":2,"name":"Water Purifier","subservices_id":8,"subservice_name":"RO, UV Purifier","faults_id":85,"fault_name":"Pump 100 GPD","rates":[{"qty1_rate":1250,"qty1_commision":50,"qty2_rate":1250,"qty2_commision":50,"qty3_rate":1250,"qty3_commision":50}]},{"id":2,"name":"Water Purifier","subservices_id":8,"subservice_name":"RO, UV Purifier","faults_id":86,"fault_name":"Membrane 80 GPD","rates":[{"qty1_rate":1000,"qty1_commision":50,"qty2_rate":1000,"qty2_commision":50,"qty3_rate":1000,"qty3_commision":50}]},{"id":2,"name":"Water Purifier","subservices_id":8,"subservice_name":"RO, UV Purifier","faults_id":87,"fault_name":"Pump Branded","rates":[{"qty1_rate":0,"qty1_commision":50,"qty2_rate":0,"qty2_commision":50,"qty3_rate":0,"qty3_commision":50}]},{"id":6,"name":"Water Tank Cleaning","subservices_id":16,"subservice_name":"Plastic Tank","faults_id":31,"fault_name":"1000 - 2000 Ltr.","rates":[{"qty1_rate":300,"qty1_commision":100,"qty2_rate":250,"qty2_commision":50,"qty3_rate":250,"qty3_commision":50}]},{"id":6,"name":"Water Tank Cleaning","subservices_id":16,"subservice_name":"Plastic Tank","faults_id":32,"fault_name":"Upto 1000 Ltr.","rates":[{"qty1_rate":250,"qty1_commision":100,"qty2_rate":200,"qty2_commision":100,"qty3_rate":200,"qty3_commision":50}]},{"id":6,"name":"Water Tank Cleaning","subservices_id":16,"subservice_name":"Plastic Tank","faults_id":33,"fault_name":"Above 2000 Ltr.","rates":[{"qty1_rate":0,"qty1_commision":200,"qty2_rate":0,"qty2_commision":200,"qty3_rate":0,"qty3_commision":200}]},{"id":6,"name":"Water Tank Cleaning","subservices_id":17,"subservice_name":"Cement Tank","faults_id":30,"fault_name":"Upto 5000 Ltr.","rates":[{"qty1_rate":500,"qty1_commision":200,"qty2_rate":450,"qty2_commision":100,"qty3_rate":450,"qty3_commision":100}]},{"id":6,"name":"Water Tank Cleaning","subservices_id":17,"subservice_name":"Cement Tank","faults_id":34,"fault_name":"5000 - 10000 Ltr.","rates":[{"qty1_rate":800,"qty1_commision":300,"qty2_rate":700,"qty2_commision":200,"qty3_rate":700,"qty3_commision":200}]},{"id":6,"name":"Water Tank Cleaning","subservices_id":17,"subservice_name":"Cement Tank","faults_id":35,"fault_name":"Above 10000 Ltr.","rates":[{"qty1_rate":0,"qty1_commision":0,"qty2_rate":0,"qty2_commision":300,"qty3_rate":0,"qty3_commision":200}]},{"id":6,"name":"Water Tank Cleaning","subservices_id":17,"subservice_name":"Cement Tank","faults_id":171,"fault_name":"Upto 1000 Ltr.","rates":[{"qty1_rate":250,"qty1_commision":100,"qty2_rate":200,"qty2_commision":50,"qty3_rate":200,"qty3_commision":50}]},{"id":6,"name":"Water Tank Cleaning","subservices_id":17,"subservice_name":"Cement Tank","faults_id":274,"fault_name":"1 K Ltr. Upto","rates":[{"qty1_rate":250,"qty1_commision":100,"qty2_rate":200,"qty2_commision":100,"qty3_rate":150,"qty3_commision":50}]},{"id":6,"name":"Water Tank Cleaning","subservices_id":17,"subservice_name":"Cement Tank","faults_id":275,"fault_name":"2 K Ltr.Upto","rates":[{"qty1_rate":350,"qty1_commision":100,"qty2_rate":300,"qty2_commision":100,"qty3_rate":250,"qty3_commision":50}]},{"id":6,"name":"Water Tank Cleaning","subservices_id":17,"subservice_name":"Cement Tank","faults_id":276,"fault_name":"3 K Ltr.Upto","rates":[{"qty1_rate":400,"qty1_commision":100,"qty2_rate":350,"qty2_commision":100,"qty3_rate":300,"qty3_commision":50}]},{"id":6,"name":"Water Tank Cleaning","subservices_id":17,"subservice_name":"Cement Tank","faults_id":277,"fault_name":"4 K Ltr.Upto","rates":[{"qty1_rate":450,"qty1_commision":100,"qty2_rate":400,"qty2_commision":100,"qty3_rate":350,"qty3_commision":100}]},{"id":6,"name":"Water Tank Cleaning","subservices_id":17,"subservice_name":"Cement Tank","faults_id":278,"fault_name":"5 K Ltr.Upto","rates":[{"qty1_rate":500,"qty1_commision":150,"qty2_rate":450,"qty2_commision":100,"qty3_rate":400,"qty3_commision":100}]},{"id":6,"name":"Water Tank Cleaning","subservices_id":17,"subservice_name":"Cement Tank","faults_id":279,"fault_name":"6 K Ltr.Upto","rates":[{"qty1_rate":600,"qty1_commision":200,"qty2_rate":500,"qty2_commision":150,"qty3_rate":450,"qty3_commision":150}]},{"id":6,"name":"Water Tank Cleaning","subservices_id":17,"subservice_name":"Cement Tank","faults_id":280,"fault_name":"7 K Ltr.Upto","rates":[{"qty1_rate":700,"qty1_commision":250,"qty2_rate":600,"qty2_commision":200,"qty3_rate":500,"qty3_commision":150}]},{"id":6,"name":"Water Tank Cleaning","subservices_id":17,"subservice_name":"Cement Tank","faults_id":281,"fault_name":"8 K Ltr.Upto","rates":[{"qty1_rate":800,"qty1_commision":300,"qty2_rate":700,"qty2_commision":250,"qty3_rate":600,"qty3_commision":200}]},{"id":6,"name":"Water Tank Cleaning","subservices_id":17,"subservice_name":"Cement Tank","faults_id":282,"fault_name":"9 K Ltr.Upto","rates":[{"qty1_rate":900,"qty1_commision":350,"qty2_rate":800,"qty2_commision":300,"qty3_rate":700,"qty3_commision":250}]},{"id":6,"name":"Water Tank Cleaning","subservices_id":17,"subservice_name":"Cement Tank","faults_id":283,"fault_name":"10 K Ltr.Upto","rates":[{"qty1_rate":1000,"qty1_commision":400,"qty2_rate":900,"qty2_commision":350,"qty3_rate":800,"qty3_commision":300}]},{"id":6,"name":"Water Tank Cleaning","subservices_id":17,"subservice_name":"Cement Tank","faults_id":284,"fault_name":"11 K Ltr.Upto","rates":[{"qty1_rate":1100,"qty1_commision":450,"qty2_rate":1000,"qty2_commision":400,"qty3_rate":900,"qty3_commision":350}]},{"id":6,"name":"Water Tank Cleaning","subservices_id":17,"subservice_name":"Cement Tank","faults_id":285,"fault_name":"12 K Ltr.Upto","rates":[{"qty1_rate":1200,"qty1_commision":500,"qty2_rate":1100,"qty2_commision":450,"qty3_rate":1000,"qty3_commision":400}]},{"id":6,"name":"Water Tank Cleaning","subservices_id":17,"subservice_name":"Cement Tank","faults_id":286,"fault_name":"13 K Ltr.Upto","rates":[{"qty1_rate":1300,"qty1_commision":550,"qty2_rate":1200,"qty2_commision":500,"qty3_rate":1100,"qty3_commision":450}]},{"id":6,"name":"Water Tank Cleaning","subservices_id":17,"subservice_name":"Cement Tank","faults_id":287,"fault_name":"14 K Ltr.Upto","rates":[{"qty1_rate":1400,"qty1_commision":600,"qty2_rate":1300,"qty2_commision":550,"qty3_rate":1200,"qty3_commision":500}]},{"id":6,"name":"Water Tank Cleaning","subservices_id":17,"subservice_name":"Cement Tank","faults_id":288,"fault_name":"15 K Ltr.Upto","rates":[{"qty1_rate":1500,"qty1_commision":650,"qty2_rate":1400,"qty2_commision":600,"qty3_rate":1300,"qty3_commision":550}]},{"id":6,"name":"Water Tank Cleaning","subservices_id":17,"subservice_name":"Cement Tank","faults_id":289,"fault_name":"16 K Ltr.Upto","rates":[{"qty1_rate":1600,"qty1_commision":700,"qty2_rate":1500,"qty2_commision":650,"qty3_rate":1400,"qty3_commision":600}]},{"id":6,"name":"Water Tank Cleaning","subservices_id":17,"subservice_name":"Cement Tank","faults_id":290,"fault_name":"17 K Ltr.Upto","rates":[{"qty1_rate":1700,"qty1_commision":750,"qty2_rate":1600,"qty2_commision":700,"qty3_rate":1500,"qty3_commision":650}]},{"id":6,"name":"Water Tank Cleaning","subservices_id":17,"subservice_name":"Cement Tank","faults_id":291,"fault_name":"18 K Ltr.Upto","rates":[{"qty1_rate":1800,"qty1_commision":800,"qty2_rate":1700,"qty2_commision":750,"qty3_rate":1600,"qty3_commision":700}]},{"id":6,"name":"Water Tank Cleaning","subservices_id":17,"subservice_name":"Cement Tank","faults_id":292,"fault_name":"19 K Ltr.Upto","rates":[{"qty1_rate":1900,"qty1_commision":850,"qty2_rate":1800,"qty2_commision":800,"qty3_rate":1700,"qty3_commision":750}]},{"id":6,"name":"Water Tank Cleaning","subservices_id":17,"subservice_name":"Cement Tank","faults_id":293,"fault_name":"20 K Ltr.Upto","rates":[{"qty1_rate":2000,"qty1_commision":900,"qty2_rate":1900,"qty2_commision":850,"qty3_rate":1800,"qty3_commision":800}]},{"id":7,"name":"Plumber","subservices_id":19,"subservice_name":"Repair","faults_id":37,"fault_name":"Wash Basin Repair","rates":[{"qty1_rate":111,"qty1_commision":0,"qty2_rate":91,"qty2_commision":0,"qty3_rate":91,"qty3_commision":0}]},{"id":7,"name":"Plumber","subservices_id":19,"subservice_name":"Repair","faults_id":52,"fault_name":"Tap Repair and Replace","rates":[{"qty1_rate":51,"qty1_commision":0,"qty2_rate":51,"qty2_commision":0,"qty3_rate":51,"qty3_commision":0}]},{"id":7,"name":"Plumber","subservices_id":19,"subservice_name":"Repair","faults_id":53,"fault_name":"Flush Tank Repair (Concealed)","rates":[{"qty1_rate":211,"qty1_commision":0,"qty2_rate":151,"qty2_commision":0,"qty3_rate":151,"qty3_commision":0}]},{"id":7,"name":"Plumber","subservices_id":19,"subservice_name":"Repair","faults_id":54,"fault_name":"Toilet Cover Replace","rates":[{"qty1_rate":111,"qty1_commision":0,"qty2_rate":111,"qty2_commision":0,"qty3_rate":111,"qty3_commision":0}]},{"id":7,"name":"Plumber","subservices_id":19,"subservice_name":"Repair","faults_id":55,"fault_name":"Plastic Tank Leakage","rates":[{"qty1_rate":221,"qty1_commision":0,"qty2_rate":221,"qty2_commision":0,"qty3_rate":221,"qty3_commision":0}]},{"id":7,"name":"Plumber","subservices_id":19,"subservice_name":"Repair","faults_id":56,"fault_name":"Hot and Cold Water Mixer Repair","rates":[{"qty1_rate":221,"qty1_commision":0,"qty2_rate":221,"qty2_commision":0,"qty3_rate":221,"qty3_commision":0}]},{"id":7,"name":"Plumber","subservices_id":19,"subservice_name":"Repair","faults_id":57,"fault_name":"Shower Repair","rates":[{"qty1_rate":151,"qty1_commision":0,"qty2_rate":151,"qty2_commision":0,"qty3_rate":151,"qty3_commision":0}]},{"id":7,"name":"Plumber","subservices_id":19,"subservice_name":"Repair","faults_id":58,"fault_name":"Other","rates":[{"qty1_rate":0,"qty1_commision":0,"qty2_rate":0,"qty2_commision":0,"qty3_rate":0,"qty3_commision":0}]}]
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
         * id : 1
         * name : AC
         * subservices_id : 1
         * subservice_name : Repair
         * faults_id : 3
         * fault_name : Split AC Repair
         * rates : [{"qty1_rate":200,"qty1_commision":0,"qty2_rate":200,"qty2_commision":0,"qty3_rate":200,"qty3_commision":0}]
         */

        private int id;
        private String name;
        private int subservices_id;
        private String subservice_name;
        private int faults_id;
        private String fault_name;
        private List<RatesBean> rates;

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

        public int getSubservices_id() {
            return subservices_id;
        }

        public void setSubservices_id(int subservices_id) {
            this.subservices_id = subservices_id;
        }

        public String getSubservice_name() {
            return subservice_name;
        }

        public void setSubservice_name(String subservice_name) {
            this.subservice_name = subservice_name;
        }

        public int getFaults_id() {
            return faults_id;
        }

        public void setFaults_id(int faults_id) {
            this.faults_id = faults_id;
        }

        public String getFault_name() {
            return fault_name;
        }

        public void setFault_name(String fault_name) {
            this.fault_name = fault_name;
        }

        public List<RatesBean> getRates() {
            return rates;
        }

        public void setRates(List<RatesBean> rates) {
            this.rates = rates;
        }

        public static class RatesBean {
            /**
             * qty1_rate : 200
             * qty1_commision : 0
             * qty2_rate : 200
             * qty2_commision : 0
             * qty3_rate : 200
             * qty3_commision : 0
             */

            private int qty1_rate;
            private int qty1_commision;
            private int qty2_rate;
            private int qty2_commision;
            private int qty3_rate;
            private int qty3_commision;

            public int getQty1_rate() {
                return qty1_rate;
            }

            public void setQty1_rate(int qty1_rate) {
                this.qty1_rate = qty1_rate;
            }

            public int getQty1_commision() {
                return qty1_commision;
            }

            public void setQty1_commision(int qty1_commision) {
                this.qty1_commision = qty1_commision;
            }

            public int getQty2_rate() {
                return qty2_rate;
            }

            public void setQty2_rate(int qty2_rate) {
                this.qty2_rate = qty2_rate;
            }

            public int getQty2_commision() {
                return qty2_commision;
            }

            public void setQty2_commision(int qty2_commision) {
                this.qty2_commision = qty2_commision;
            }

            public int getQty3_rate() {
                return qty3_rate;
            }

            public void setQty3_rate(int qty3_rate) {
                this.qty3_rate = qty3_rate;
            }

            public int getQty3_commision() {
                return qty3_commision;
            }

            public void setQty3_commision(int qty3_commision) {
                this.qty3_commision = qty3_commision;
            }
        }
    }
}
