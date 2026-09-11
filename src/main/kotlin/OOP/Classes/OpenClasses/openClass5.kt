open class Planet{
    open val color:String="unknown"
}
class Jupiter:Planet(){
    override val color="orange"
}
fun main(){
    val jupiter=Jupiter()
    println(jupiter.color)
}