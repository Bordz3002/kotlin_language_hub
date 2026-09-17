//map values
open class Equipment(val model:String)
fun printEquipment(equipment:Map<String,@JvmSuppressWildcards Equipment>){
    for((code:String, item:Equipment) in equipment){
        println("$code -> ${item.model}")
    }
}
fun main(){
    val storage:Map<String, Equipment> =mapOf(
        "eq01" to Equipment(model="water pump"),
        "eq02" to Equipment(model="soil sensor")
    )
    printEquipment(equipment=storage)
}