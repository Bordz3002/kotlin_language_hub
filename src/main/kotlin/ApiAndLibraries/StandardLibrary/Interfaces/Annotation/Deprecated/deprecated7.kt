//ReplaceWith with an argument
@Deprecated(message="use addCrop() instead", replaceWith=ReplaceWith("addCrop(name)"))
fun addOldCrop(name:String){
    println("adding old crop: $name")
}

fun addCrop(name:String){
    println("adding crop: $name")
}
fun main(){
    addOldCrop("onion")
}