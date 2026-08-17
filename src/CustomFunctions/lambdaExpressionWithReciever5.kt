fun main(){
    val buildMessage:StringBuilder.()->Unit={
        append("Hello")
        append(" tororo")
        append("!")
    }
    val message=StringBuilder()
    message.buildMessage()
    println(message)
}