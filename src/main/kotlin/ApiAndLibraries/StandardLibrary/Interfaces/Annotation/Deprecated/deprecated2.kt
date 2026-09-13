//@Deprecated with ReplaceWith
@Deprecated("Use currentFunction() instead", ReplaceWith("currentFunction()"))
fun lastFunction(){
    println("last function")
}

fun currentFunction(){
    println("current function")
}
fun main(){
    lastFunction()
}