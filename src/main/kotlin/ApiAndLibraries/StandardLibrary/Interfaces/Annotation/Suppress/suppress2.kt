//suppressing multiple warnings
@Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
fun processDatas(name:String, age:Int){
    val unusedVariable:String="im not used"
    println("processing complete")
}

fun main(){
    processDatas(name="alice", age=25)
}