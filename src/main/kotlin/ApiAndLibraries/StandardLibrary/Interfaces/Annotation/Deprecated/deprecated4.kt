//DeprecationLevel.WARNING
@Deprecated(message="use newPlant() instead", level=DeprecationLevel.WARNING)
fun oldPlant(){
    println("old plant function")
}

fun newPlant(){
    println("new plant function")
}
fun main(){
    oldPlant()
}