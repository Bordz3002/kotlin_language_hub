//using 'is' with when
fun describeType(expectedVariable:Any){
    when(expectedVariable){
        is String->println("type is a String: $expectedVariable")
        is Int->println("type is an Int: $expectedVariable")
        is Boolean->println("type is Boolean: $expectedVariable")
        else->println("type is not covered in the cases")
    }
}
fun main(){
    describeType("kotlin")
    describeType(999)
    describeType(false)
    describeType(3.14)
}