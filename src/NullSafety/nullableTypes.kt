// neverNull has a string type
var neverNull:String = "random text"
// neverNull=null - throws a compiler error
var nullable:String? = "you can keep a null here"
fun main(){
//    setting null to nullable is accepted
    nullable = null
}