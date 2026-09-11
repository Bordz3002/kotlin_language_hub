object DoAuth{
    fun takeParams(expectUsername:String, expectPassword:String){
        println("Input Auth parameters = $expectUsername:$expectPassword")
    }
}
fun main(){
    DoAuth.takeParams("sting_drink", "m4ximum3FFort")
}