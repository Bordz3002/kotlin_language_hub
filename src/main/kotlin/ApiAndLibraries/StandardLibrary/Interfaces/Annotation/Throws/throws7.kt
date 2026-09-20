//@Throws with custom exceptions
class ValidationException(message:String):Exception(message)
class UserValidator{
    @Throws(ValidationException::class)
    fun validateUsername(username:String):String{
        if(username.isEmpty()){
            throw ValidationException(message="username cannot be empty")
        }
        if(username.length<3){
            throw ValidationException(message="username must be at least 3 characters")
        }
        if(username.length>20){
            throw ValidationException(message="username cannot be exceed 20 characters")
        }
        return username
    }
}
fun main(){
    val validator:UserValidator=UserValidator()
    val usernames:List<String> =listOf("alice", "", "ab", "this_username_is_way_too_long")
    for(username:String in usernames){
        try{
            val result:String=validator.validateUsername(username=username)
            println("result: $result")
        }catch(e:ValidationException){
            println("exception: ${e.message}")
        }
    }
}