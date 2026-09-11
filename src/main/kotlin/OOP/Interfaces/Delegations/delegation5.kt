interface Notifier{
    fun sendMessage(expectMessage:String)
}
class EmailNotifier:Notifier{
    override fun sendMessage(expectMessage:String){
        println("Email sent. Content:$expectMessage")
    }
}
class App(expectEmailNotifier:EmailNotifier):Notifier by expectEmailNotifier
fun main(){
    val emailNotifier=EmailNotifier()
    val app=App(emailNotifier)
    with(app){
        sendMessage("hello lord")
    }
}