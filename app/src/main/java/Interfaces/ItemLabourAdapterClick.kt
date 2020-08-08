package Interfaces

interface ItemLabourAdapterClick {
    fun onPlusPartItemClick(pos: Int, quantity: Int,total_amount:Float)
    fun onMinusPartItemClick(pos: Int, quantity: Int,total_amount:Float)
}