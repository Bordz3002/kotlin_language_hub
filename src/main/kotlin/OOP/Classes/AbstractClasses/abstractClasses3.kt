abstract class Vehicle{
    abstract val brand: String
    abstract fun start()
}
class cycle:Vehicle(){
    override val brand:String="honda"
    override fun start(){
        println("brap brap brap")
    }
}
fun main(){
    val click=cycle();
    with(click){
        println("bike name: $brand")
        start()
    }
}