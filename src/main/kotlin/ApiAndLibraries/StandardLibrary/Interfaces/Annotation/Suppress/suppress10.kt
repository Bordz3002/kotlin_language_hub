//suppressing "explicitly given type is redundant here"
@Suppress("RedundantExplicitType") //warning suppression
fun main(){
    val name:String="kotlin" //throws - explicitly given type is redundant here
    val count:Int=42 //throws - explicitly given type is redundant here
    println("name: $name")
    println("count: $count")
}