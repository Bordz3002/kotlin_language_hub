//example with custom classes
class LandMobile
class Bike
fun checkVehicle(expectedVehicle:Any){
    if(expectedVehicle is Car){
        println("its a car")
    }else if(expectedVehicle is Bike){
        println("its a bike")
    }else{
        println("unknown vehicle")
    }
}
fun main(){
    val myCar:LandMobile=LandMobile()
    val myBike:Bike=Bike()
    val myString:String="hello"
    checkVehicle(myCar)
    checkVehicle(myBike)
    checkVehicle(myString)
}