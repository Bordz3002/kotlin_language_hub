//@Deprecated on a Property with ReplaceWith
class SomeCrop{
    val height:Int=25
    @Deprecated(message="use heightInCentimeters instead", replaceWith=ReplaceWith("heightInCentimeters"))
    val oldHeight:Int=height

    val heightInCentimeters:Int=height
}
fun main(){
    val crop:SomeCrop=SomeCrop()
    println(crop.oldHeight)
}