@JvmInline
value class Email(val value:String)
fun sendEmail(email:Email){
    println("sending email to:${email.value}")
}
fun main(){
    sendEmail(Email("tororo@example.com"))
}