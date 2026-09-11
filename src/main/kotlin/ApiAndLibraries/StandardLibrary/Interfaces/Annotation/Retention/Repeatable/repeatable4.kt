//repeated annotations with multiple pieces of data
import kotlin.reflect.full.findAnnotations
@Repeatable
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class Sensor(val type:String, val range:Int)
@Sensor("soil moisture", 50)
@Sensor("temperature", 30)
@Sensor("light", 100)
class FarmNode
fun main(){
    val sensors=FarmNode::class.findAnnotations<Sensor>()
    for(sensor in sensors){
        println("${sensor.type}: ${sensor.range} meters")
    }
}