//suppressing unnecessary safe call and not-null assertion
@Suppress("UNNECESSARY_SAFE_CALL", "UNNECESSARY_NOT_NULL_ASSERTION") //warning suppression
fun main(){
    val name:String="kotlin"
    println(name?.length) //throws - unnecessary safe call
    println(name!!.length) //throws - unnecessary not-null assertion
}