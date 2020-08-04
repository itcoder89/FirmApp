package model;

public class WorkingAreaData {


    /**
     * status : true
     * data : {"id":3,"f_city_name":"Nagaur","lat_codes":"27.2009026","lng_codes":"73.73853319999999"}
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
         * id : 3
         * f_city_name : Nagaur
         * lat_codes : 27.2009026
         * lng_codes : 73.73853319999999
         */

        private int id;
        private String f_city_name;
        private String lat_codes;
        private String lng_codes;

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

        public String getLat_codes() {
            return lat_codes;
        }

        public void setLat_codes(String lat_codes) {
            this.lat_codes = lat_codes;
        }

        public String getLng_codes() {
            return lng_codes;
        }

        public void setLng_codes(String lng_codes) {
            this.lng_codes = lng_codes;
        }
    }
}
