//basic deprecation warning
@Deprecated("Use the newFunction instead")
fun oldFunction(){
    println("this is the old function")
}
fun newFunction(){
    println("this is the new function")
}
fun main(){
    oldFunction()
}