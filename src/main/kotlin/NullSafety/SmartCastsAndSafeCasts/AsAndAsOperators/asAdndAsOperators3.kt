//example: parsing user input
fun parseNumber(expectedInput:Any):Int?{
    val number:Int?=expectedInput as? Int
    if(number!=null){
        return number
    }
    val text:String?=expectedInput as? String
    return text?.toIntOrNull()
}
fun main(){
    println(parseNumber(100))
    println(parseNumber("200"))
    println(parseNumber("abc"))
    println(parseNumber(true))
}