//using 'as?' with default values
fun getStringLength(expectedVariable:Any){
    val str=expectedVariable as? String
    return str?.length ?:0
}