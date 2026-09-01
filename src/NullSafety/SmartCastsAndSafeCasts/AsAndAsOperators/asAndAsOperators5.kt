fun toIntSafe(expectedValue:Any):Int?{
    val intValue:Int?=expectedValue as? Int
    if(intValue!=null){
        return intValue
    }
    val strValue:String?=expectedValue as? String
    return strValue?.toIntOrNull()
}
fun main(){
    println(toIntSafe(100))
    println(toIntSafe("200"))
    println(toIntSafe("abc"))
    println(toIntSafe(true))
    println(toIntSafe(3.14))
}