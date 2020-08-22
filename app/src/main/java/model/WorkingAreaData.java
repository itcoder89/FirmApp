package model;

public class WorkingAreaData {


    /**
     * status : true
     * data : {"id":16,"f_city_name":"Jaipur","lat_codes":26.9059167,"lng_codes":75.772732,"working_radius":12}
     */

    private boolean status;
    private DataBean data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 16
         * f_city_name : Jaipur
         * lat_codes : 26.9059167
         * lng_codes : 75.772732
         * working_radius : 12
         */

        private int id;
        private String f_city_name;
        private double lat_codes;
        private double lng_codes;
        private double working_radius;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getF_city_name() {
            return f_city_name;
        }

        public void setF_city_name(String f_city_name) {
            this.f_city_name = f_city_name;
        }

        public double getLat_codes() {
            return lat_codes;
        }

        public void setLat_codes(double lat_codes) {
            this.lat_codes = lat_codes;
        }

        public double getLng_codes() {
            return lng_codes;
        }

        public void setLng_codes(double lng_codes) {
            this.lng_codes = lng_codes;
        }

        public double getWorking_radius() {
            return working_radius;
        }

        public void setWorking_radius(double working_radius) {
            this.working_radius = working_radius;
        }
    }
}
