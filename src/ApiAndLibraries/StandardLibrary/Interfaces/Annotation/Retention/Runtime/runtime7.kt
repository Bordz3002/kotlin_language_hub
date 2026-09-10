//annotation on function parameters
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.VALUE_PARAMETER)
annotation class Required
class UserApplication{
    fun createUser(@Required userName:String, @Required userPassword:String){
        println("creating user: $userName")
    }
}
fun main(){
    val method=UserApplication::class.java.getDeclaredMethod("createUser", String::class.java, String::class.java)
    for(parameter in method.parameters){
        val required=parameter.getAnnotation(Required::class.java)
        if(required!=null){
            println("${parameter.name} is required")
        }
    }
}