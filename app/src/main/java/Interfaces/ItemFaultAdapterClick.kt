package Interfaces

interface ItemFaultAdapterClick {
    fun onPlusClick(pos: Int, quantity: Int,total_amount:Float)
    fun onMinusClick(pos: Int, quantity: Int,total_amount:Float)
}