interface Payment{
    fun pay(expectAmount:Double)
}
class CreditCard:Payment{
    override fun pay(expectAmount:Double){
        println("paid '$expectAmount' using credit card")
    }
}
class Store(expectCardObject:CreditCard):Payment by expectCardObject
fun main() {
    val creditCard=CreditCard()
    val store=Store(creditCard)
    with(store){
        pay(5432.21)
    }
}