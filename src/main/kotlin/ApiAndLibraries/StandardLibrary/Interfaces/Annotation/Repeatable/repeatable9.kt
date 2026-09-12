//using annotation data to control function execution
import kotlin.reflect.KFunction
import kotlin.reflect.full.findAnnotations
@Repeatable
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class Task(val name:String, val priority:Int)
@Task("check gps", 1)
@Task("check battery", 2)
@Task("check network", 3)
fun prepareDrone(){
    println("drone is ready")
}
fun main(){
    val function:KFunction<*> =::prepareDrone
    val tasks=function.findAnnotations<Task>()
    for(task in tasks){
        println("${task.priority}. ${task.name}")
    }
    println("executing function...")
    function.call()
}