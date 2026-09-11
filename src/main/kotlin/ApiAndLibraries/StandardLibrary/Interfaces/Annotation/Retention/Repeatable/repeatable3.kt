//reading repeated annotations with kotlin reflection
import kotlin.reflect.full.findAnnotations
@Repeatable
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class Feature(val name:String)
@Feature("GPS")
@Feature("camera")
@Feature("obstacle detection")
class FarmDrone
fun main(){
    val features=FarmDrone::class.findAnnotations<Feature>()
    for(feature in features){
        println(feature.name)
    }
}