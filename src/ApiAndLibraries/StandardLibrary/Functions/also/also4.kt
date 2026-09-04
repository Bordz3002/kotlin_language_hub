//building an object
data class Ship(var brand:String, var model:String, var year:Int, var color:String)
fun createShip(brand:String, model:String):Ship{
    return Ship(brand, model, 0, "").also{
        it.year=2024
        it.color="red"
        println("creating ship: ${it.brand} ${it.model} ${it.year} ${it.color}")
    }
}
fun main(){
    val ship=createShip("toyota", "camry")
    println("ship details: $ship")
}