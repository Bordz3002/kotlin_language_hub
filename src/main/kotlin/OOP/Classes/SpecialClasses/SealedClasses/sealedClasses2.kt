sealed class Mammal(val expectName:String)
class Dolphin(expectDolphinName:String):Mammal(expectDolphinName)
class Humans(expectHumanName:String, val expectJob:String):Mammal(expectHumanName)
fun greetMammal(mammal:Mammal):String{
    when(mammal){
        is Dolphin->return "hello dolphin named:${mammal.expectName}"
        is Humans->return "hello ${mammal.expectName}. you're working as a ${mammal.expectJob}"
    }
}
fun main(){
    println(greetMammal(Dolphin("Daphnie")))
    println(greetMammal(Humans("naval", "programmer")))
}
