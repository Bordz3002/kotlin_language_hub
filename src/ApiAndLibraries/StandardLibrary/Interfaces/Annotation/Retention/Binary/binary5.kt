//use case: build time processing

import kotlin.annotation.AnnotationRetention
import kotlin.annotation.Retention

@Retention(AnnotationRetention.BINARY)
annotation class Loggable(val category:String)

class UserService(){
    @Loggable("User")
    fun createUser(name:String){
        println("creating user: $name")
    }
    @Loggable("Auth")
    fun login(username:String, password:String){
        println("loggin in: $username")
    }
}

//a build time tool could:
//- scan the class file for @Loggable annotations
//- generate logging code
//- but the annotation itself is not accessible at runtime