sealed class DeliveryStatus
data class Preparing(val expectRestaurant:String):DeliveryStatus()
data class OnTheWay(val expectDriver:String):DeliveryStatus()
data class Delivered(val expectArrivalTime:String):DeliveryStatus()
fun showDeliveryStatus(expectDeliveryStatusObject:DeliveryStatus):String{
    when(expectDeliveryStatusObject){
        is Preparing->return "preparing order from ${expectDeliveryStatusObject.expectRestaurant}"
        is OnTheWay->return "driver: ${expectDeliveryStatusObject.expectDriver} is on the way"
        is Delivered->return "delivered on: ${expectDeliveryStatusObject.expectArrivalTime}"
    }
}
fun main(){
    val preparing=Preparing("barko")
    val onTheWay=OnTheWay("tororo")
    val delivered=Delivered("12:43-23/08")
    println(showDeliveryStatus(preparing))
    println(showDeliveryStatus(onTheWay))
    println(showDeliveryStatus(delivered))
}