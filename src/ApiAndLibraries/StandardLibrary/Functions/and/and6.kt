//Short Circuiting
//both '&&' and 'and()' have a difference
//&& - (behavior) stops as soon as it finds a 'false' (short-circuits)
//and() - (behavior) still calls the function, but returns 'false' immediately
fun falseFunction():Boolean{
    println("called falseFunction")
    return false
}
fun main(){
    //with '&&' (short-circuits)
    println("--- using && ---")
    val result1=true && falseFunction() //falseFunction is called
    val result2=false && falseFunction() //falseFunction is not called
    //output: called falseFunction()
    //with and() (still carries the function)
    println("--- using and() ---")
    val result3=true.and(falseFunction()) //falseFunction is called
    val result4=false.and(falseFunction())  //falseFunction is still called
    //output: called falseFunction (2x)
}