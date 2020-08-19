package model

data class WalletRechargeSummaryData(
    val `data`: Data,
    val message: String,
    val status: Boolean
)

data class Data(
    val kodCommision: Int,
    val paymentSummary: List<PaymentSummary>,
    val totalEarningAmount: Int,
    val totalRechargeAmnt: Int,
    val walletBalance: Float
)

data class PaymentSummary(
    val amount: Int,
    val coupon_code: Any,
    val created_at: String,
    val id: Int,
    val idexpert: Int,
    val idfirm: Int,
    val order_date: String,
    val order_id: String,
    val pay_sign: String,
    val pay_type: String,
    val payment_date: String,
    val transaction_number: String,
    val transaction_type: Any,
    val updated_at: String
)