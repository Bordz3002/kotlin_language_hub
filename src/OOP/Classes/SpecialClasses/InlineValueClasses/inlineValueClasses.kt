@JvmInline
value class Emails(val value:String)
fun sendEmail(email:Emails){
    println("sending email to:${email.value}")
}
fun main(){
    sendEmail(Emails("tororo@example.com"))
}