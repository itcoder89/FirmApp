package Interfaces

interface ItemFaultAdapterClick {
    fun onPlusClick(id:Int,pos: Int, quantity: Int,total_amount:Float)
    fun onMinusClick(id:Int,pos: Int, quantity: Int,total_amount:Float)
    fun onRemoveItemClick(id:Int)
}