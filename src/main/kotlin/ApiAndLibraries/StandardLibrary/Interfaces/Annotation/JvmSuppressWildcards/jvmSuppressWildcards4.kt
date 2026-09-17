//generic types
class SensorBox<T>(val readings:List<@JvmSuppressWildcards T>)
fun main(){
    val box:SensorBox<Int> =SensorBox(readings=listOf(42, 55, 61))
    println(box.readings)
}