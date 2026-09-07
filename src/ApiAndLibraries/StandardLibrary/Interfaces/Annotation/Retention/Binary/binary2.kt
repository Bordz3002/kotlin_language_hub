//use case: library annotations (bytecode analysis)
import kotlin.annotation.AnnotationRetention
import kotlin.annotation.Retention

@Retention(AnnotationRetention.BINARY)
annotation class ApiVersion(val version:String)

@ApiVersion("2.0")
class UserApi(){
    fun getUser(){}
}

//tools can analyze the class file
//but your app cant read the annotation at runtime