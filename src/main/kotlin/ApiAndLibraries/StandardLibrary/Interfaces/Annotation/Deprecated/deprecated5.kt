//DeprecationLevel.ERROR
@Deprecated(message="use newSensor() instead", level=DeprecationLevel.ERROR)
fun oldSensor(){
    println("old sensor")
}

fun newSensor(){
    println("new sensor")
}
fun main(){
   // oldSensor() - compilation fails
}