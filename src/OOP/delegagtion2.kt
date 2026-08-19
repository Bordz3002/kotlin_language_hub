interface Irrigator{
    fun work()
}
class WaterPump:Irrigator{
    override fun work(){println("watering the field")}
}
class Farmer(pump:WaterPump):Irrigator by pump
fun main(){
    val pump=WaterPump()
    val farmer=Farmer(pump)
    with(farmer){
        work()
    }
}