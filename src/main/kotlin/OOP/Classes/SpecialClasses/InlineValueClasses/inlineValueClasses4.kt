@JvmInline
value class UserId(val value:Int)
@JvmInline
value class OrderId(val value:Int)
@JvmInline
value class ProductId(val value:String)
fun main(){
    val userId=UserId(123)
    val orderId=OrderId(456)
    val productId=ProductId("p-789")
    println("user id: ${userId.value}")
    println("order id:${orderId.value}")
    println("product id:${productId.value}")
}