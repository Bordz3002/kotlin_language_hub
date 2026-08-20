interface Drivable{
    fun drive()
}
class Animals(val expectAnimalName:String):Drivable{
    override fun drive(){
        println("Riding the $expectAnimalName animal")
    }
}
class Aircrafts(val expectAircraftName:String):Drivable{
    override fun drive(){
        println("flying the $expectAircraftName aircraft")
    }
}
fun main(){
    val pig=Animals("pig")
    val jet=Aircrafts("fighter jet")
    with(pig){
        drive()
    }
    with(jet){
        drive()
    }
}