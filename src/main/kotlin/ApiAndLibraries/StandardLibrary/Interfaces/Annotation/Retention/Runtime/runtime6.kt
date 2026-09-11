//annotation-driven behavior
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class Action(val name:String)
class DroneController{
    @Action("takeoff")
    fun takeOff(){
        println("drone is taking off...")
    }
    @Action("land")
    fun land(){
        println("drone is landing")
    }
    fun diagnostics(){
        println("running diagnostics")
    }
}
fun main(){
    val controller=DroneController()
    for(method in DroneController::class.java.declaredMethods){
        val action=method.getAnnotation(Action::class.java)
        if(action!=null){
            println("executing: ${action.name}")
            method.invoke(controller)
        }
    }
}