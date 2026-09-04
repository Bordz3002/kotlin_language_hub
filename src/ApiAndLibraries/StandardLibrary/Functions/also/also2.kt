//logging and debugging
fun processNumber(num:Int):Int{
    return num.also{
        println("input:$it")
    }.also{
        println("after processing:${it*2}")
    }.let{it*2}
}
fun main(){
    val result=processNumber(5)
    println("result:$result")
}