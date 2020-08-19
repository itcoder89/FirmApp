package model;

import java.util.List;

public class WalletSummaryListData {


    /**
     * status : true
     * data : {"walletBalance":7900,"kodCommision":"200","paymentSummary":[{"id":18,"idfirm":"3","idexpert":"0","amount":"100","coupon_code":null,"transaction_number":"122121212121","transaction_type":"bank_trans","order_id":null,"payment_date":"2020-08-08 11:45:00","order_date":null,"pay_sign":"cr","pay_type":"bank_trans","created_at":"Aug 08 2020 06:19","updated_at":"Aug 08 2020 06:19"},{"id":12,"idfirm":"3","idexpert":"0","amount":"0","coupon_code":null,"transaction_number":"","transaction_type":"cash","order_id":"20200701","payment_date":"2020-08-06 09:58:16","order_date":"2020-07-10 19:54:52","pay_sign":"dr","pay_type":"commision","created_at":"Aug 06 2020 16:28","updated_at":"Aug 06 2020 16:28"},{"id":11,"idfirm":"3","idexpert":"0","amount":"200","coupon_code":null,"transaction_number":"","transaction_type":"cash","order_id":"202008281","payment_date":"2020-08-05 06:40:17","order_date":"2020-08-03 17:23:52","pay_sign":"dr","pay_type":"commision","created_at":"Aug 05 2020 13:10","updated_at":"Aug 05 2020 13:10"},{"id":6,"idfirm":"3","idexpert":"0","amount":"8000","coupon_code":null,"transaction_number":"","transaction_type":"bank_trans","order_id":null,"payment_date":"2020-08-05 12:41:51","order_date":null,"pay_sign":"cr","pay_type":"bank_trans","created_at":"Aug 05 2020 07:13","updated_at":"Aug 05 2020 07:13"},{"id":2,"idfirm":"3","idexpert":"0","amount":"0","coupon_code":null,"transaction_number":"","transaction_type":"cash","order_id":"202007225","payment_date":"2020-08-01 02:06:33","order_date":"2020-07-31 18:05:24","pay_sign":"dr","pay_type":"commision","created_at":"Aug 01 2020 08:36","updated_at":"Aug 01 2020 08:36"},{"id":3,"idfirm":"3","idexpert":"0","amount":"0","coupon_code":null,"transaction_number":"","transaction_type":"cash","order_id":"202007225","payment_date":"2020-08-01 02:06:33","order_date":"2020-07-31 18:05:25","pay_sign":"dr","pay_type":"commision","created_at":"Aug 01 2020 08:36","updated_at":"Aug 01 2020 08:36"},{"id":4,"idfirm":"3","idexpert":"0","amount":"0","coupon_code":null,"transaction_number":"","transaction_type":"cash","order_id":"202007225","payment_date":"2020-08-01 02:06:33","order_date":"2020-07-31 18:05:25","pay_sign":"dr","pay_type":"commision","created_at":"Aug 01 2020 08:36","updated_at":"Aug 01 2020 08:36"},{"id":5,"idfirm":"3","idexpert":"0","amount":"0","coupon_code":null,"transaction_number":"","transaction_type":"cash","order_id":"202007225","payment_date":"2020-08-01 02:06:33","order_date":"2020-07-31 18:05:25","pay_sign":"dr","pay_type":"commision","created_at":"Aug 01 2020 08:36","updated_at":"Aug 01 2020 08:36"}],"totalRechargeAmnt":0,"totalEarningAmount":"8479"}
     */

    private boolean status;

    public String getMessage() {
        if(message==null || message.equals("")){
            message = "";
        }
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
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
         * walletBalance : 7900
         * kodCommision : 200
         * paymentSummary : [{"id":18,"idfirm":"3","idexpert":"0","amount":"100","coupon_code":null,"transaction_number":"122121212121","transaction_type":"bank_trans","order_id":null,"payment_date":"2020-08-08 11:45:00","order_date":null,"pay_sign":"cr","pay_type":"bank_trans","created_at":"Aug 08 2020 06:19","updated_at":"Aug 08 2020 06:19"},{"id":12,"idfirm":"3","idexpert":"0","amount":"0","coupon_code":null,"transaction_number":"","transaction_type":"cash","order_id":"20200701","payment_date":"2020-08-06 09:58:16","order_date":"2020-07-10 19:54:52","pay_sign":"dr","pay_type":"commision","created_at":"Aug 06 2020 16:28","updated_at":"Aug 06 2020 16:28"},{"id":11,"idfirm":"3","idexpert":"0","amount":"200","coupon_code":null,"transaction_number":"","transaction_type":"cash","order_id":"202008281","payment_date":"2020-08-05 06:40:17","order_date":"2020-08-03 17:23:52","pay_sign":"dr","pay_type":"commision","created_at":"Aug 05 2020 13:10","updated_at":"Aug 05 2020 13:10"},{"id":6,"idfirm":"3","idexpert":"0","amount":"8000","coupon_code":null,"transaction_number":"","transaction_type":"bank_trans","order_id":null,"payment_date":"2020-08-05 12:41:51","order_date":null,"pay_sign":"cr","pay_type":"bank_trans","created_at":"Aug 05 2020 07:13","updated_at":"Aug 05 2020 07:13"},{"id":2,"idfirm":"3","idexpert":"0","amount":"0","coupon_code":null,"transaction_number":"","transaction_type":"cash","order_id":"202007225","payment_date":"2020-08-01 02:06:33","order_date":"2020-07-31 18:05:24","pay_sign":"dr","pay_type":"commision","created_at":"Aug 01 2020 08:36","updated_at":"Aug 01 2020 08:36"},{"id":3,"idfirm":"3","idexpert":"0","amount":"0","coupon_code":null,"transaction_number":"","transaction_type":"cash","order_id":"202007225","payment_date":"2020-08-01 02:06:33","order_date":"2020-07-31 18:05:25","pay_sign":"dr","pay_type":"commision","created_at":"Aug 01 2020 08:36","updated_at":"Aug 01 2020 08:36"},{"id":4,"idfirm":"3","idexpert":"0","amount":"0","coupon_code":null,"transaction_number":"","transaction_type":"cash","order_id":"202007225","payment_date":"2020-08-01 02:06:33","order_date":"2020-07-31 18:05:25","pay_sign":"dr","pay_type":"commision","created_at":"Aug 01 2020 08:36","updated_at":"Aug 01 2020 08:36"},{"id":5,"idfirm":"3","idexpert":"0","amount":"0","coupon_code":null,"transaction_number":"","transaction_type":"cash","order_id":"202007225","payment_date":"2020-08-01 02:06:33","order_date":"2020-07-31 18:05:25","pay_sign":"dr","pay_type":"commision","created_at":"Aug 01 2020 08:36","updated_at":"Aug 01 2020 08:36"}]
         * totalRechargeAmnt : 0
         * totalEarningAmount : 8479
         */

        private Float walletBalance;
        private String kodCommision;
        private int totalRechargeAmnt;
        private String totalEarningAmount;
        private List<PaymentSummaryBean> paymentSummary;

        public Float getWalletBalance() {
            return walletBalance;
        }

        public void setWalletBalance(Float walletBalance) {
            this.walletBalance = walletBalance;
        }

        public String getKodCommision() {
            return kodCommision;
        }

        public void setKodCommision(String kodCommision) {
            this.kodCommision = kodCommision;
        }

        public int getTotalRechargeAmnt() {
            return totalRechargeAmnt;
        }

        public void setTotalRechargeAmnt(int totalRechargeAmnt) {
            this.totalRechargeAmnt = totalRechargeAmnt;
        }

        public String getTotalEarningAmount() {
            return totalEarningAmount;
        }

        public void setTotalEarningAmount(String totalEarningAmount) {
            this.totalEarningAmount = totalEarningAmount;
        }

        public List<PaymentSummaryBean> getPaymentSummary() {
            return paymentSummary;
        }

        public void setPaymentSummary(List<PaymentSummaryBean> paymentSummary) {
            this.paymentSummary = paymentSummary;
        }

        public static class PaymentSummaryBean {
            /**
             * id : 18
             * idfirm : 3
             * idexpert : 0
             * amount : 100
             * coupon_code : null
             * transaction_number : 122121212121
             * transaction_type : bank_trans
             * order_id : null
             * payment_date : 2020-08-08 11:45:00
             * order_date : null
             * pay_sign : cr
             * pay_type : bank_trans
             * created_at : Aug 08 2020 06:19
             * updated_at : Aug 08 2020 06:19
             */

            private int id;
            private String idfirm;
            private String idexpert;
            private String amount;
            private Object coupon_code;
            private String transaction_number;
            private String transaction_type;
            private Object order_id;
            private String payment_date;
            private Object order_date;
            private String pay_sign;
            private String pay_type;
            private String created_at;
            private String updated_at;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getIdfirm() {
                return idfirm;
            }

            public void setIdfirm(String idfirm) {
                this.idfirm = idfirm;
            }

            public String getIdexpert() {
                return idexpert;
            }

            public void setIdexpert(String idexpert) {
                this.idexpert = idexpert;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public Object getCoupon_code() {
                return coupon_code;
            }

            public void setCoupon_code(Object coupon_code) {
                this.coupon_code = coupon_code;
            }

            public String getTransaction_number() {
                return transaction_number;
            }

            public void setTransaction_number(String transaction_number) {
                this.transaction_number = transaction_number;
            }

            public String getTransaction_type() {
                return transaction_type;
            }

            public void setTransaction_type(String transaction_type) {
                this.transaction_type = transaction_type;
            }

            public Object getOrder_id() {
                return order_id;
            }

            public void setOrder_id(Object order_id) {
                this.order_id = order_id;
            }

            public String getPayment_date() {
                return payment_date;
            }

            public void setPayment_date(String payment_date) {
                this.payment_date = payment_date;
            }

            public Object getOrder_date() {
                return order_date;
            }

            public void setOrder_date(Object order_date) {
                this.order_date = order_date;
            }

            public String getPay_sign() {
                return pay_sign;
            }

            public void setPay_sign(String pay_sign) {
                this.pay_sign = pay_sign;
            }

            public String getPay_type() {
                return pay_type;
            }

            public void setPay_type(String pay_type) {
                this.pay_type = pay_type;
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
