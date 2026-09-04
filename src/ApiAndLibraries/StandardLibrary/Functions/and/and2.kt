//all possible combinations
fun main(){
    val values =listOf(true to true, true to false, false to true, false to false)
    values.forEach{
        (a, b) -> println("$a and $b = ${a.and(b)}")
    }
}