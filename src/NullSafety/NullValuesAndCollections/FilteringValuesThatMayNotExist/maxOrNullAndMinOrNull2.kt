//using the Elvis operator
fun main(){
    val numbers:List<Int> =listOf(5, 2, 8, 1, 9)
    val empty=emptyList<Int>()
    val max:Int=numbers.maxOrNull()?:0
    val min:Int=empty.minOrNull()?:-1
    println("max: $max")
    println("min: $min")
}