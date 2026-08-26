sealed class CoffeeOrder{
    object Espresso:CoffeeOrder()
    data class Latte(val sugar:Int):CoffeeOrder()
    data class Cappuccino(val size:String, val extraShot:Boolean):CoffeeOrder()
}
fun prepareCoffee(order:CoffeeOrder){
    when(order){
        CoffeeOrder.Espresso->println("making espresso, strong and quick")
        is CoffeeOrder.Latte->println("making latte with ${order.sugar} sugars")
        is CoffeeOrder.Cappuccino->{
            val shot=if(order.extraShot) "with extra shot" else "regular"
            println("making ${order.size} cappuccino $shot")
        }
    }
}
fun main(){
    prepareCoffee(CoffeeOrder.Espresso)
    prepareCoffee(CoffeeOrder.Latte(2))
    prepareCoffee(CoffeeOrder.Cappuccino("large", true))
}