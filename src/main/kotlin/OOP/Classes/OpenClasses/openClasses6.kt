open class Nation{
    open val governmentType:String="unknown"
}
class Philippines:Nation(){
    override val governmentType:String="democracy"
}
class America:Nation(){
    override val governmentType:String="federal"
}
fun main(){
    val ph=Philippines()
    val us=America()
    println("philippines government type: ${ph.governmentType.uppercase()}")
    println("united states government type: ${us.governmentType.uppercase()}")
}