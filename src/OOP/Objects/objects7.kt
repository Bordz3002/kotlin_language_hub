interface PaymentProcessor{
    fun processPayment(expectAmount:Double)
}
object StorePayment:PaymentProcessor{
    override fun processPayment(expectAmount:Double){
        println("processing payment of:$expectAmount")
    }
}
fun main(){
    with(StorePayment){
        processPayment(123452.3223)
    }
}