//using repeated annotations as configuration
import kotlin.reflect.full.findAnnotations
import kotlin.reflect.KFunction
@Repeatable
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class SomeLog(val level:String)
@SomeLog("info")
@SomeLog("audit")
@SomeLog("security")
fun saveFarmData(){
    println("farm data saved")
}
fun main(){
    val function:KFunction<*> =::saveFarmData
    val logs=function.findAnnotations<SomeLog>()
    for(log in logs){
        println("log level: ${log.level}")
    }
}