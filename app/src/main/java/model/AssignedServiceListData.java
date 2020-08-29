package model;

import java.util.List;

public class AssignedServiceListData {


    /**
     * status : true
     * data : [{"AC":[{"Repair":[{"Split_AC_Repair":[{"qty1_rate":200,"qty1_commision":0,"qty2_rate":200,"qty2_commision":0,"qty3_rate":200,"qty3_commision":0}],"Window_AC_Repair":[{"qty1_rate":200,"qty1_commision":0,"qty2_rate":200,"qty2_commision":0,"qty3_rate":200,"qty3_commision":0}],"Gas_Charging_Full":[{"qty1_rate":2500,"qty1_commision":500,"qty2_rate":2500,"qty2_commision":500,"qty3_rate":2500,"qty3_commision":500}],"Gas_Charging_Top_up":[{"qty1_rate":1500,"qty1_commision":500,"qty2_rate":1500,"qty2_commision":500,"qty3_rate":1500,"qty3_commision":500}],"PCB_Repair_Inverter_Model":[{"qty1_rate":3000,"qty1_commision":1000,"qty2_rate":3000,"qty2_commision":1000,"qty3_rate":3000,"qty3_commision":1000}],"PCB_Repair":[{"qty1_rate":1800,"qty1_commision":500,"qty2_rate":1800,"qty2_commision":500,"qty3_rate":1800,"qty3_commision":500}],"Water_Leakage":[{"qty1_rate":500,"qty1_commision":200,"qty2_rate":500,"qty2_commision":200,"qty3_rate":500,"qty3_commision":200}]}]}]}]
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
        private List<ACBean> AC;

        public List<ACBean> getAC() {
            return AC;
        }

        public void setAC(List<ACBean> AC) {
            this.AC = AC;
        }

        public static class ACBean {
            private List<RepairBean> Repair;

            public List<RepairBean> getRepair() {
                return Repair;
            }

            public void setRepair(List<RepairBean> Repair) {
                this.Repair = Repair;
            }

            public static class RepairBean {
                private List<SplitACRepairBean> Split_AC_Repair;
                private List<WindowACRepairBean> Window_AC_Repair;
                private List<GasChargingFullBean> Gas_Charging_Full;
                private List<GasChargingTopUpBean> Gas_Charging_Top_up;
                private List<PCBRepairInverterModelBean> PCB_Repair_Inverter_Model;
                private List<PCBRepairBean> PCB_Repair;
                private List<WaterLeakageBean> Water_Leakage;

                public List<SplitACRepairBean> getSplit_AC_Repair() {
                    return Split_AC_Repair;
                }

                public void setSplit_AC_Repair(List<SplitACRepairBean> Split_AC_Repair) {
                    this.Split_AC_Repair = Split_AC_Repair;
                }

                public List<WindowACRepairBean> getWindow_AC_Repair() {
                    return Window_AC_Repair;
                }

                public void setWindow_AC_Repair(List<WindowACRepairBean> Window_AC_Repair) {
                    this.Window_AC_Repair = Window_AC_Repair;
                }

                public List<GasChargingFullBean> getGas_Charging_Full() {
                    return Gas_Charging_Full;
                }

                public void setGas_Charging_Full(List<GasChargingFullBean> Gas_Charging_Full) {
                    this.Gas_Charging_Full = Gas_Charging_Full;
                }

                public List<GasChargingTopUpBean> getGas_Charging_Top_up() {
                    return Gas_Charging_Top_up;
                }

                public void setGas_Charging_Top_up(List<GasChargingTopUpBean> Gas_Charging_Top_up) {
                    this.Gas_Charging_Top_up = Gas_Charging_Top_up;
                }

                public List<PCBRepairInverterModelBean> getPCB_Repair_Inverter_Model() {
                    return PCB_Repair_Inverter_Model;
                }

                public void setPCB_Repair_Inverter_Model(List<PCBRepairInverterModelBean> PCB_Repair_Inverter_Model) {
                    this.PCB_Repair_Inverter_Model = PCB_Repair_Inverter_Model;
                }

                public List<PCBRepairBean> getPCB_Repair() {
                    return PCB_Repair;
                }

                public void setPCB_Repair(List<PCBRepairBean> PCB_Repair) {
                    this.PCB_Repair = PCB_Repair;
                }

                public List<WaterLeakageBean> getWater_Leakage() {
                    return Water_Leakage;
                }

                public void setWater_Leakage(List<WaterLeakageBean> Water_Leakage) {
                    this.Water_Leakage = Water_Leakage;
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

                public static class WindowACRepairBean {
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

                public static class GasChargingFullBean {
                    /**
                     * qty1_rate : 2500
                     * qty1_commision : 500
                     * qty2_rate : 2500
                     * qty2_commision : 500
                     * qty3_rate : 2500
                     * qty3_commision : 500
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

                public static class GasChargingTopUpBean {
                    /**
                     * qty1_rate : 1500
                     * qty1_commision : 500
                     * qty2_rate : 1500
                     * qty2_commision : 500
                     * qty3_rate : 1500
                     * qty3_commision : 500
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

                public static class PCBRepairInverterModelBean {
                    /**
                     * qty1_rate : 3000
                     * qty1_commision : 1000
                     * qty2_rate : 3000
                     * qty2_commision : 1000
                     * qty3_rate : 3000
                     * qty3_commision : 1000
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

                public static class PCBRepairBean {
                    /**
                     * qty1_rate : 1800
                     * qty1_commision : 500
                     * qty2_rate : 1800
                     * qty2_commision : 500
                     * qty3_rate : 1800
                     * qty3_commision : 500
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

                public static class WaterLeakageBean {
                    /**
                     * qty1_rate : 500
                     * qty1_commision : 200
                     * qty2_rate : 500
                     * qty2_commision : 200
                     * qty3_rate : 500
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
