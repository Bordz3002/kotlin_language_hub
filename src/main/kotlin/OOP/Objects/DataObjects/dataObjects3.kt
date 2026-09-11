data object Online{
    val message:String="System is online"
}
fun main(){
    with(Online){
        println(message)
    }
}