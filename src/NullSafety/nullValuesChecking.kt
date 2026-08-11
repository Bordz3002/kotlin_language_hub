fun analyzeString(expectString:String?):String{
    if(expectString != null && expectString.isNotEmpty()){
        return "length of $expectString: ${expectString.length}"
    }else{
        return "empty or null string"
    }
}
val nullString:String? = null
fun main(){
    println(analyzeString(nullString))
}