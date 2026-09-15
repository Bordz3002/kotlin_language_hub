//basic example
@JvmOverloads
fun makeDrone(name:String, speed:Int=50){
    println("drone: $name")
    println("speed: $speed")
}

fun main(){
    makeDrone(name="e88")
    makeDrone(name="e88", speed=80)
}