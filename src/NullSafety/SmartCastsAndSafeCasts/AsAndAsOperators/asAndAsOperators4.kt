//using 'as' in when expressions
fun describe(expectedValue:Any){
    when(expectedValue){
        is String->{println("String: ${expectedValue.length}")}
        is Int->{println("Int: ${expectedValue +10}")}
        else->{
            val double:Double?=expectedValue as? Double
            if(double!=null){
                println("double: ${double*2}")
            }else{
                println("unknown type")
            }
        }
    }
}
fun main(){
    describe("hello")
    describe(42)
    describe(3.14)
    describe(true)
}