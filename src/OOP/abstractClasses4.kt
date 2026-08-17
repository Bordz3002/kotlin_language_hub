abstract class soda{
    abstract val brand: String
    abstract val sugarLevel: Double
}
class EnergyDrink(override val brand:String, override val sugarLevel:Double):soda()
fun main(){
    val sting=EnergyDrink("pepsi", 80.0)
    with(sting){
        println("brand: $brand")
        println("sugarLevel: $sugarLevel")
    }
}