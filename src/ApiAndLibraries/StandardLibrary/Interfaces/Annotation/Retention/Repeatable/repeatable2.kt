//retrieving repeated annotations
@Repeatable
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class Label(val label:String)
@Label("Sensor")
@Label("outdoor")
@Label("LoRa")
class NodeWeather
fun main(){
    val labels=NodeWeather::class.java.getAnnotationsByType(Label::class.java)
    for(label in labels){
        println(label.label)
    }
}