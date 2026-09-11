class Coffee{
    var name:String=""
    var sugarLevel:Double=0.0
}
val coffee1=Coffee().apply{
    name="nescafe"
    sugarLevel=10.0
}
fun main(){
    println("coffee1: name - ${coffee1.name}, sugar level - ${coffee1.sugarLevel}")
}