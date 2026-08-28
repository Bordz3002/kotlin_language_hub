class Kupal(val firstName:String, val lastName:String)
val Kupal.fullName:String
    get()="$firstName $lastName"
fun main(){
    val kupalEntity=Kupal("justin", "bieber")
    println(kupalEntity.fullName)
}