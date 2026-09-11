interface EcoFriendly{
    val emissionLevel:String
}
interface ElectricVehicle{
    val batteryCapacity:Double
}
open class Vehicles(val expectMake:String, val expectModel:String)
open class CityCar(expectMake:String, expectModel:String, val expectNumberOfDoors:Int):Vehicles(expectMake, expectModel)
class ElectricCar(expectMake:String, expectModel:String, expectNumberOfDoors:Int, override val emissionLevel:String, override val batteryCapacity:Double):CityCar(expectMake, expectModel, expectNumberOfDoors), EcoFriendly, ElectricVehicle
fun main(){
    val jblCar=ElectricCar("jbl", "blj212", 2, "Great", 80.0)
    with(jblCar){
        println("Info: Make:${expectMake.uppercase()}, Model:${expectModel.uppercase()}, No.OfDoors:$expectNumberOfDoors, Emission Level:${emissionLevel.uppercase()}, Battery Capacity:$batteryCapacity")
    }
}
