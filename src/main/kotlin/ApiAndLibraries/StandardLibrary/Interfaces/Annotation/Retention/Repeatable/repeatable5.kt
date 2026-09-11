//repeated annotations on functions
import kotlin.reflect.full.findAnnotations
import kotlin.reflect.KFunction
@Repeatable
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class Permission(val name:String)
@Permission("Gps")
@Permission("camera")
@Permission("internet")
fun startDrone(){
    println("drone started")
}
fun main(){
    val function:KFunction<*> =::startDrone
    val permissions=function.findAnnotations<Permission>()
    for(permission in permissions){
        println(permission.name)
    }

}