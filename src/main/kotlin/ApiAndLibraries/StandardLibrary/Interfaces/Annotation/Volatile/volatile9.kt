//chat application with online status
class ChatUser(val name:String){
    @Volatile
    var isOnline:Boolean=false

    @Volatile
    var lastMessage:String=""

    @Volatile
    var messageCount:Int=0

    fun goOnline(){
        isOnline=true
        println("$name is now online")
    }
    fun goOffline(){
        isOnline=false
        println("$name is now offline")
    }
    fun sendMessage(message:String){
        if(!isOnline){
            println("$name is offline. cannot send message")
            return
        }
        lastMessage=message
        messageCount++
        println("$name sent: \"$message\"")
    }
}
fun main(){
    val alice:ChatUser=ChatUser(name="alice")
    val bob:ChatUser=ChatUser(name="bob")
    val aliceThread:Thread=Thread{
        alice.goOnline()
        repeat(times=3){
            alice.sendMessage(message="hello bob (${it+1})")
            Thread.sleep(400)
        }
        alice.goOffline()
    }
    val bobThread:Thread=Thread{
        bob.goOnline()
        repeat(times=3){
            bob.sendMessage(message="hi alice (${it+1})")
            Thread.sleep(500)
        }
        bob.goOffline()
    }
    aliceThread.start()
    bobThread.start()
    aliceThread.join()
    bobThread.join()
    println("-----chat summary-----")
    println("alice: ${alice.messageCount} messages, Online: ${alice.isOnline}")
    println("bob: ${bob.messageCount} messages, Online: ${bob.isOnline}")
    println("last message from alice: \"${alice.lastMessage}\"")
    println("last message from bob: \"${bob.lastMessage}\"")
}