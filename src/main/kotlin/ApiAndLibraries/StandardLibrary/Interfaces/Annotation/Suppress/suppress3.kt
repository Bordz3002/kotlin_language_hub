//suppress deprecation warning
@Deprecated(message="Use newFunction() instead")
fun pastMethod(){
    println("this is the old method")
}
fun currentMethod(){
    println("this is the new method")
}

@Suppress("DEPRECATION")
fun main(){
    pastMethod()
}