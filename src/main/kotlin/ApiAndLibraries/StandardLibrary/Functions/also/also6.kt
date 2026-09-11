fun processString(input:String):String{
    return input.also{
        println("input: $it")
    }.also{
        if(it.isEmpty()){
            println("warning!: empty string")
        }
    }
}
fun main(){
    val result=processString("hello kotlin")
    println("returned: $result")
    val empty=processString("")
    println("returned: $empty")
}