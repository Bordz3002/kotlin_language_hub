fun main(){
    val numbers:MutableList<Int> =mutableListOf(1,2,3)
    val result=numbers.also{
        println("original list:$it")
        it.add(4)
        println("updated list:$it")
    }
    println("is result the same object?:${result===numbers}")
    println("result:$result")
}