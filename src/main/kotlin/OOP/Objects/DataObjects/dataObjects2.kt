data object Ciggarette{
    fun smoke(){
        println("puff puff pass")
    }
}
fun main(){
    with(Ciggarette){
        smoke()
    }
}