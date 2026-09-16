//map
open class CropObject(val name:String)
class Vegetable(name:String):CropObject(name)
fun showCrops(crops:Map<String, @JvmWildcard  CropObject>){
    for((key, cropObject) in crops){
        println("$key: ${cropObject.name}")
    }
}
fun main(){
    val cropsList:Map<String, CropObject> =mapOf(
        "a1" to Vegetable(name="onion"),
        "a2" to Vegetable(name="tomato")
    )
    showCrops(cropsList)
}