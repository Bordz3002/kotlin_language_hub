val String.isValidEmail: Boolean
    get()=this.contains("@")&&this.contains(".")
fun main(){
    val email1:String="test@mail.com"
    val email2:String="invalid-email-com"
    println(email1.isValidEmail)
    println(email2.isValidEmail)
}