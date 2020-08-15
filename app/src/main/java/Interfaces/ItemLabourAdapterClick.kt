package Interfaces

interface ItemLabourAdapterClick {
    fun onPlusPartItemClick(partid: Int,pos: Int, quantity: Int,total_amount:Float)
    fun onMinusPartItemClick(partid: Int,pos: Int, quantity: Int,total_amount:Float)
    fun onRemmovePartItemClick(partid: Int)
    fun onFinalPartAmount(amnt:Int)
}