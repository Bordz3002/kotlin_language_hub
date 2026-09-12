//repeated annotations with different actions
import kotlin.reflect.KFunction
import kotlin.reflect.full.findAnnotations
@Repeatable
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class ToDo(val name:String)
@ToDo("log start")
@ToDo("check battery")
@ToDo("start gps")
fun launchDrone(){
    println("drone launched")
}
fun main(){
    val function:KFunction<*> =::launchDrone
    val actions=function.findAnnotations<ToDo>()
    for(action in actions){
        println("action: ${action.name}")
    }
    function.call()
}