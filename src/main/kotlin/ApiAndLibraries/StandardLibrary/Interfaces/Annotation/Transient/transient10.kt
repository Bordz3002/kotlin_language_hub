//e-commerce order with payment session
import java.io.*
class Order(
    val orderId:String,
    val customerName:String,
    val items:MutableList<String> =mutableListOf<String>(),
    val totalAmount:Double=0.0,
    val orderDate:String="",
    @Transient var paymentSessionId:String="",
    @Transient var isPaymentProcessing:Boolean=false,
    @Transient var paymentAttempts:Int=0
):Serializable
fun main(){
    val order:Order=Order(
        orderId="ord-2024-001",
        customerName="alice johnson",
        items=mutableListOf("laptop", "mouse", "keyboard"),
        totalAmount=1299.99,
        orderDate="2024-01-15"
    )
    order.paymentSessionId="pay-session-xyz-789"
    order.isPaymentProcessing=true
    order.paymentAttempts=2
    println("---before serialization---")
    println("order id: ${order.orderId}")
    println("customer name: ${order.customerName}")
    println("items: ${order.items}")
    println("total amount: ${order.totalAmount}")
    println("order date: ${order.orderDate}")
    println("payment session: ${order.paymentSessionId}")
    println("is processing: ${order.isPaymentProcessing}")
    println("payment attempts: ${order.paymentAttempts}")
    val file:java.io.File=File("order.ser")
    ObjectOutputStream(FileOutputStream(file)).use{it.writeObject(order)}
    val restored:Order=ObjectInputStream(FileInputStream(file)).use{it.readObject() as Order}
    println("")
    println("---after deserialization---")
    println("order id: ${restored.orderId}")
    println("customer name: ${restored.customerName}")
    println("items: ${restored.items}")
    println("total amount: ${restored.totalAmount}")
    println("order date: ${restored.orderDate}")
    println("payment session: ${restored.paymentSessionId}")
    println("is processing: ${restored.isPaymentProcessing}")
    println("payment attempts: ${restored.paymentAttempts}")
}