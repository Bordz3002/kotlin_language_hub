//objects inheriting from interfaces
interface Authentication{
    fun takeParams(expectUsername:String, expectPassword:String)
}
object DoAuthentication:Authentication{
    override fun takeParams(expectUsername: String, expectPassword: String){
        println("Input Auth parameters: $expectUsername:$expectPassword")
    }
}
fun main(){
    with(DoAuthentication){
        takeParams("coding_ninja", "ninj4Code")
    }
}
