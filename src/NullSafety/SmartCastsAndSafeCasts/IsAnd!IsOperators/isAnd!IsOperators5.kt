//using '!is' in when
fun defineType(expectedVariable:Any){
    when(expectedVariable){
        !is String->println("$expectedVariable is NOT a String")
        is Int->println("$expectedVariable is Int")
        else->println("$expectedVariable type is not covered in the cases")
    }
}
fun main(){
    defineType(10)
    defineType("hi")
}