//deprecating a class
@Deprecated("use modern drone instead")
class OldDrone{
    fun fly(){
        println("old drone is flying")
    }
}

class ModernDrone{
    fun fly(){
        println("modern drone is flying")
    }
}
fun main(){
    val drone=OldDrone()
    drone.fly()
}