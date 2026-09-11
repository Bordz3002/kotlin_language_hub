//maxOrNull() - finds the highest value, or null if empty
//minOrNull() - finds the lowest value, or null if empty
fun main(){
    val numbers:List<Int> =listOf(5, 2, 8, 1, 9)
    val empty=emptyList<Int>()
    println(numbers.maxOrNull())
    println(numbers.minOrNull())
    println(empty.maxOrNull())
}