//using the '!is' operators
fun checkNotType(expectedValue:Any){
    if(expectedValue !is String){
        println("$expectedValue is NOT a String")
    }
    if(expectedValue !is Int){
        println("$expectedValue is NOT an INt")
    }
}
fun main(){
    checkType("hello")
    checkType(100
    )
}