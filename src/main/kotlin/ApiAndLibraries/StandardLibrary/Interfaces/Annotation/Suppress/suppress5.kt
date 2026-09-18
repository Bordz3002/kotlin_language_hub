//suppressing name shadowing warning
@Suppress("NAME_SHADOWING")
fun main(){
    val name:String="outer"
    if(true){
        val name:String="inner" //warning name shadowed -> warning suppressed
        println("inner block: $name")
    }
    println("outer block: $name")
}