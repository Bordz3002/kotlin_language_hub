open class Material(val expectType:String){
    fun getMaterialType():String{
        return "the material is:${expectType.uppercase()}"
    }
}
class Furniture(expectType:String):Material(expectType)
fun main(){
    val chair=Furniture("wood")
    with(chair){
        println("$this ${getMaterialType()}")
    }
}