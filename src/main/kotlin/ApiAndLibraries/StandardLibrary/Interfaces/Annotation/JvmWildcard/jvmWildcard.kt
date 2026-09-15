//basic example
fun renderCrops(crops:List<@JvmWildcard String>){
    for(crop in crops){
        println(crop)
    }
}
fun main(){
    val crops:List<String> =listOf("onion", "tomato","pepper")
    renderCrops(crops=crops)
}