//using the 'is' operator
fun checkType(expectedValue:Any){
    if(expectedValue is String){
        println("$expectedValue is a String")
    }else if(expectedValue is Int){
        println("$expectedValue is Int")
    }else if(expectedValue is Boolean){
        println("$expectedValue is Boolean")
    }else if(expectedValue is Double){
        println("$expectedValue is Double")
    }else{
        println("type of $expectedValue is not covered")
    }
}
fun main(){
    checkType("hello")
    checkType(2)
    checkType(3.14)
    checkType(true)
}