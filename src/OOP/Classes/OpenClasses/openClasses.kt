open class Drink{
    open fun getSugarLevel(expectLevel:Int):String{
        return "sugarLevel is:$expectLevel"
    }
}
class Matcha:Drink(){
    override fun getSugarLevel(expectLevel: Int):String{
        return "Matcha's sugar level: $expectLevel"
    }
}
fun main(){
    val matcha=Matcha()
    with(matcha){
        println(getSugarLevel(45))
    }
}