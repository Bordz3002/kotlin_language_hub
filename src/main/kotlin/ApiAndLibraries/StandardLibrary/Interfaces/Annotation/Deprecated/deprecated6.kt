//DeprecationLevel.HIDDEN
@Deprecated(message="old method", level=DeprecationLevel.HIDDEN)
fun oldMethod(){
    println("old method")
}

fun newMethod(){
    println("new method")
}
fun main(){
   // oldMethod() -unresolved reference (hidden)
    newMethod()
}