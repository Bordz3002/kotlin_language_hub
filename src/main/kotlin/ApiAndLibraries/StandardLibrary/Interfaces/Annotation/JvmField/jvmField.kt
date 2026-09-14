//basic example
class Field{
    @JvmField
    val cropName:String="onion"
}
fun main(){
    val farm=Field()
    println(farm.cropName)
}