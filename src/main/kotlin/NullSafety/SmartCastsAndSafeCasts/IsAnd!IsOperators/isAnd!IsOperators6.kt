//combining 'is' with '&&' and '||'
fun typeCheck(expectedVariable:Any){
    if(expectedVariable is String && expectedVariable.length>3){
        println("its a long string: ${expectedVariable.length}")
    }
    if(expectedVariable is Int || expectedVariable is Double){
        println("its a number")
    }
}
fun main(){
    typeCheck("hello")
    typeCheck("hi") // will not print
    typeCheck(42)
    typeCheck(3.14)
}