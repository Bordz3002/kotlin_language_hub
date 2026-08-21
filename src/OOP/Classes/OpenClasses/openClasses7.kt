open class Automobile(val expectMake:String, val expectModel:String, val expectTransimissionType:String="Manual"){
    // parameter (transmissionType) is given a default value
}
class FourWheels(expectMake:String, expectModel:String, val expectNumberOfDoors:String):Automobile(expectMake, expectModel, "Automatic"){
    //empty block
}
fun main(){
    val supra=FourWheels("toyota", "mk4", "2")
    val everest=FourWheels("ford", "2012", "4")
    with(supra){
        println("Info: Make-$expectMake Model-$expectModel No.ofDoors-$expectNumberOfDoors")
    }
    with(everest){
        println("Info: Make-$expectMake Model-$expectModel No.ofDoors-$expectNumberOfDoors")
    }
}
