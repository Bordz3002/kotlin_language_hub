//processing repeated annotations
import kotlin.reflect.KFunction
import kotlin.reflect.full.findAnnotations
@Repeatable
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class Requirement(val name:String)
@Requirement("gps")
@Requirement("battery")
@Requirement("network")
fun deployDrone(){
    println("drone deployed")
}
fun main(){
    val function:KFunction<*> =::deployDrone
    val requirements=function.findAnnotations<Requirement>()
    println("requirements:")
    for(each in requirements){
        println("- ${each.name}")
    }
    if(requirements.size==3){
        function.call()
    }
}