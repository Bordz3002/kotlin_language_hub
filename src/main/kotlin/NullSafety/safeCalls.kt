fun stringLength(expectString:String?):Int? = expectString?.length
fun main(){
    val nullSting:String? = null
    println(stringLength(nullString))
}