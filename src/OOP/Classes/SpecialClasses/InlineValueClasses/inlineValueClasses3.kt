@JvmInline
value class Email(val value:String){
    init{
        require(value.isNotEmpty()){"email cannot be empty"}
        require(value.contains("@")){"email must contain @"}
        require(value.contains(".")){"email must contain a dot"}
    }
    fun getDomain():String=value.substringAfter("@")
    fun mask():String{
        val username:String=value.substringBefore("@")
        val domain:String=value.substringAfter("@")
        return if(username.length<=2){
            "$username...@$domain"
        }else{
            "${username.take(2)}...@$domain"
        }
    }
}
@JvmInline
value class Password(val value:String){
    init{
        require(value.length>=8){"password must be at least 8 characters"}
        require(value.any {it.isUpperCase()}){"password must contain uppercase letter"}
        require(value.any {it.isLowerCase()}){"password must contain lowercase letter"}
        require(value.any {it.isDigit()}){"password must contain a number"}
    }
    fun strength():String{
        var score=0
        if(value.length>=12) score++
        if(value.any {it.isUpperCase()}) score++
        if(value.any {it.isLowerCase()}) score++
        if(value.any {it.isDigit()}) score++
        if(value.any {it in "!@#$%^&*"}) score++
        return when(score){
            0, 1->"weak"
            2,3->"medium"
            4,5->"strong"
            else->"unknown"
        }
    }
}
sealed class AuthState{
    object LoggedOut:AuthState()
    data class LoggedIn(val email:Email, val displayName:String):AuthState()
    data class Error(val messages:String):AuthState()
    object Loading:AuthState()
}
fun loginUser(email:Email, password:Password):AuthState{
    println("attempting login....")
    println("email: ${email.mask()}")
    println("password strength: ${password.strength()}")
    return when{
        email.value=="test@email.com"&&password.value=="Secret123"->{
            AuthState.LoggedIn(email, "john doe")
        }
        email.value=="test@email.com"->{
            AuthState.Error("invalid password")
        }
        else->AuthState.Error("user not found")
    }
}
fun handleAuthState(state:AuthState){
    println("\n"+"=".repeat(20))
    when(state){
        AuthState.Loading->{
            println("loading...please wait")
        }
        AuthState.LoggedOut->{
            println("you are logged out")
            println("please log in to continue")
        }
        is AuthState.LoggedIn->{
            println("Welcom, ${state.displayName}")
        }
        is AuthState.Error->{
            println(state.messages)
            println("please try again")
        }
    }
    println("=".repeat(20))
}
fun main(){
    println("---authentication system---")
    val email1=Email("test@email.com")
    val password1=Password("Secret123")
}