fun main(){
    val name:String="naval"
    val result=name.also{println("Checking $it")}
    name.also{
        println("name: $it")
    }
    println("$result")
}