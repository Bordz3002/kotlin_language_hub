//repeated annotations on properties
import kotlin.reflect.full.findAnnotations
@Repeatable
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.PROPERTY)
annotation class SensorProperty(val name:String)
class SoilSensor{
    @SensorProperty("moisture")
    @SensorProperty("temperature")
    @SensorProperty("pH")
    val readings:String="sensor data"
}
fun main(){
    val property=SoilSensor::class.members.first{it.name=="readings"}
    val properties=property.findAnnotations<SensorProperty>()
    for(item in properties){
        println(item.name)
    }
}