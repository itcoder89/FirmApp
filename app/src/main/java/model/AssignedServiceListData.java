package model;

import java.util.List;

public class AssignedServiceListData {


    /**
     * status : true
     * data : {"AC":[{"Repair":[{"Split_AC_Repair":[[{"qty1_rate":200,"qty1_commision":0,"qty2_rate":200,"qty2_commision":0,"qty3_rate":200,"qty3_commision":0}]]}]},{"Repair":[{"Window_AC_Repair":[[{"qty1_rate":200,"qty1_commision":0,"qty2_rate":200,"qty2_commision":0,"qty3_rate":200,"qty3_commision":0}]]}]},{"Repair":[{"Gas_Charging_(Full)":[[{"qty1_rate":2500,"qty1_commision":500,"qty2_rate":2500,"qty2_commision":500,"qty3_rate":2500,"qty3_commision":500}]]}]},{"Repair":[{"Gas_Charging_(Top_up)":[[{"qty1_rate":1500,"qty1_commision":500,"qty2_rate":1500,"qty2_commision":500,"qty3_rate":1500,"qty3_commision":500}]]}]},{"Repair":[{"PCB_Repair_(Inverter_Model)":[[{"qty1_rate":3000,"qty1_commision":1000,"qty2_rate":3000,"qty2_commision":1000,"qty3_rate":3000,"qty3_commision":1000}]]}]},{"Repair":[{"PCB_Repair":[[{"qty1_rate":1800,"qty1_commision":500,"qty2_rate":1800,"qty2_commision":500,"qty3_rate":1800,"qty3_commision":500}]]}]},{"Repair":[{"Water_Leakage":[[{"qty1_rate":500,"qty1_commision":200,"qty2_rate":500,"qty2_commision":200,"qty3_rate":500,"qty3_commision":200}]]}]},{"Water_Service":[{"Split_AC":[[{"qty1_rate":499,"qty1_commision":200,"qty2_rate":1,"qty2_commision":0,"qty3_rate":250,"qty3_commision":50}]]}]},{"Water_Service":[{"Window_AC":[[{"qty1_rate":499,"qty1_commision":200,"qty2_rate":1,"qty2_commision":0,"qty3_rate":250,"qty3_commision":50}]]}]},{"Installation":[{"Split_AC_Installation":[[{"qty1_rate":1300,"qty1_commision":300,"qty2_rate":1300,"qty2_commision":300,"qty3_rate":1300,"qty3_commision":300}]]}]},{"Installation":[{"Window_AC_Installation":[[{"qty1_rate":800,"qty1_commision":200,"qty2_rate":800,"qty2_commision":200,"qty3_rate":800,"qty3_commision":200}]]}]},{"Uninstallation":[{"Split_AC_Uninstallation":[[{"qty1_rate":800,"qty1_commision":200,"qty2_rate":800,"qty2_commision":200,"qty3_rate":800,"qty3_commision":200}]]}]},{"Uninstallation":[{"Window_AC_Uninstallation":[[{"qty1_rate":500,"qty1_commision":100,"qty2_rate":500,"qty2_commision":100,"qty3_rate":500,"qty3_commision":100}]]}]}]}
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
        private List<ACBean> AC;

        public List<ACBean> getAC() {
            return AC;
        }

        public void setAC(List<ACBean> AC) {
            this.AC = AC;
        }

        public static class ACBean {
            private List<RepairBean> Repair;
            private List<WaterServiceBean> Water_Service;
            private List<InstallationBean> Installation;
            private List<UninstallationBean> Uninstallation;

            public List<RepairBean> getRepair() {
                return Repair;
            }

            public void setRepair(List<RepairBean> Repair) {
                this.Repair = Repair;
            }

            public List<WaterServiceBean> getWater_Service() {
                return Water_Service;
            }

            public void setWater_Service(List<WaterServiceBean> Water_Service) {
                this.Water_Service = Water_Service;
            }

            public List<InstallationBean> getInstallation() {
                return Installation;
            }

            public void setInstallation(List<InstallationBean> Installation) {
                this.Installation = Installation;
            }

            public List<UninstallationBean> getUninstallation() {
                return Uninstallation;
            }

            public void setUninstallation(List<UninstallationBean> Uninstallation) {
                this.Uninstallation = Uninstallation;
            }

            public static class RepairBean {
                private List<List<SplitACRepairBean>> Split_AC_Repair;

                public List<List<SplitACRepairBean>> getSplit_AC_Repair() {
                    return Split_AC_Repair;
                }

                public void setSplit_AC_Repair(List<List<SplitACRepairBean>> Split_AC_Repair) {
                    this.Split_AC_Repair = Split_AC_Repair;
                }

                public static class SplitACRepairBean {
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

            public static class WaterServiceBean {
                private List<List<SplitACBean>> Split_AC;

                public List<List<SplitACBean>> getSplit_AC() {
                    return Split_AC;
                }

                public void setSplit_AC(List<List<SplitACBean>> Split_AC) {
                    this.Split_AC = Split_AC;
                }

                public static class SplitACBean {
                    /**
                     * qty1_rate : 499
                     * qty1_commision : 200
                     * qty2_rate : 1
                     * qty2_commision : 0
                     * qty3_rate : 250
                     * qty3_commision : 50
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

            public static class InstallationBean {
                private List<List<SplitACInstallationBean>> Split_AC_Installation;

                public List<List<SplitACInstallationBean>> getSplit_AC_Installation() {
                    return Split_AC_Installation;
                }

                public void setSplit_AC_Installation(List<List<SplitACInstallationBean>> Split_AC_Installation) {
                    this.Split_AC_Installation = Split_AC_Installation;
                }

                public static class SplitACInstallationBean {
                    /**
                     * qty1_rate : 1300
                     * qty1_commision : 300
                     * qty2_rate : 1300
                     * qty2_commision : 300
                     * qty3_rate : 1300
                     * qty3_commision : 300
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

            public static class UninstallationBean {
                private List<List<SplitACUninstallationBean>> Split_AC_Uninstallation;

                public List<List<SplitACUninstallationBean>> getSplit_AC_Uninstallation() {
                    return Split_AC_Uninstallation;
                }

                public void setSplit_AC_Uninstallation(List<List<SplitACUninstallationBean>> Split_AC_Uninstallation) {
                    this.Split_AC_Uninstallation = Split_AC_Uninstallation;
                }

                public static class SplitACUninstallationBean {
                    /**
                     * qty1_rate : 800
                     * qty1_commision : 200
                     * qty2_rate : 800
                     * qty2_commision : 200
                     * qty3_rate : 800
                     * qty3_commision : 200
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
    }
}
