//deprecating a property
class FieldFarm{
    @Deprecated(message="use farmName instead", replaceWith=ReplaceWith("farmName"))
    val oldName:String="old farm"

    val farmName:String="green name"
}
fun main(){
    val farm=FieldFarm()
    println(farm.oldName)
}