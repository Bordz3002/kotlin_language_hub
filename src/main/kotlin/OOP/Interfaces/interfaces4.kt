interface PaymentMethod{
    fun initiatePayment(amount:Double):String
}
class CreditCardPayment(val expectCardNumber:String, val expectCardHolderName:String, val expectExpiryDate:String):PaymentMethod{
    override fun initiatePayment(amount:Double):String{
        return "Payment of $$amount initiated using Credit card ending in ${expectCardNumber.takeLast(4)}"
    }
}
fun main(){
    val paymentMethod=CreditCardPayment("1234 5678 9012 3456", "Toto totoro", "07/10/2028")
    with(paymentMethod){
        println(initiatePayment(1324.321))
    }

}