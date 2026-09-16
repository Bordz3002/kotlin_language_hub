//basic example
open class FarmItem(val label:String)
fun displayFarmItems(items:List<@JvmSuppressWildcards FarmItem>){
    for(item in items){
        println(item.label)
    }
}
fun main(){
    val inventory:List<FarmItem> =listOf(
        FarmItem(label="seed tray"),
        FarmItem(label="water pump")
    )
    displayFarmItems(items=inventory)
}