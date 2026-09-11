fun main(){
//    you can provide a default value to return if a null
//    value is detected by using the Elvis operator ?:
//    write on the left-hand side of the Elvis operator what should be checked
//    for a null value
//    write on the right-hand side of the Elvis operator what should be returned if a
//    null value is detected
    val nullString:String? = null
    println(nullString?.length?:0)
//    0
}