//objects inheriting from interfaces
interface Flyable{
    fun fly()
}
object Drone:Flyable{
    override fun fly(){
        println("drone is flying")
    }
}
fun main(){
    with(Drone){
        fly()
    }
}