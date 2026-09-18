//suppressing unused anonymous parameter
@Suppress("UNUSED_ANONYMOUS_PARAMETER") //warning suppression
fun main(){
    val numbers:List<Int> =listOf(1, 2, 3, 4, 5)
    numbers.forEach{number:Int->
        println("processing...") //throws - 'number' is never used
    }
}