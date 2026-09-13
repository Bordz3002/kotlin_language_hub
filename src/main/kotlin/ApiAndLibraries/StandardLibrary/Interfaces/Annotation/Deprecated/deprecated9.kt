//deprecating a constructor
class DroneGadget{
    @Deprecated(message="use the constructor with a model instead")
    constructor(){
        println("old drone")
    }

    constructor(model:String){
        println("drone model: $model")
    }
}
fun main(){
    // val drone=DroneGadget() - throws the deprecated message
    val drone:DroneGadget=DroneGadget("e88")
}