fun main(){
    val numbers:MutableList<Int> =mutableListOf(1, 2, 3)

    //using also to log and modify
    numbers.also{
        println("list before: $it")
    }.also{
        it.add(4)
        it.add(5)
    }.also{
        println("list after: $it")
    }
    val doubled=numbers.also{
        println("doubling: $it")
    }.map{it*2}
    println("doubled: $doubled")
}