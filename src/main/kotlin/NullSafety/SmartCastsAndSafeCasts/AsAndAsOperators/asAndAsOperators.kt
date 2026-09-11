//processing mixed data
fun processValue(expectedVariable:Any){
    val str:String?=expectedVariable as? String //safe cast to String
    if(str!=null){
        println("String: ${str.uppercase()}")
    }else{
        println("not a String")
    }
}
fun main(){
    processValue("hello")
    processValue(42)
    processValue("kotlin")
}