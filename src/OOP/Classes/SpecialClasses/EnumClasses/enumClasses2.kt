enum class OrderStatus(val message:String, val priority:Int){
    PENDING("your order is being prepared", 1),
    SHIPPED("your order is on the way", 2),
    DELIVERED("your order has arrived", 3),
    CANCELLED("your order was cancelled", 0)
}
fun showOrderUpdates(status:OrderStatus){
    println("status: $status")
    println("priority: ${status.priority}")
    println("message: ${status.message}")
}
fun isUrgent(status:OrderStatus):Boolean{
    return status.priority>=2
}
fun main(){
    val orderCurrentStatus:OrderStatus=OrderStatus.SHIPPED
    showOrderUpdates(orderCurrentStatus)
    println("is urgent: ${isUrgent(orderCurrentStatus)}")
}