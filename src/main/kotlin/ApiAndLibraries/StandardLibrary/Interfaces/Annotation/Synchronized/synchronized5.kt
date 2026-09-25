//thread-safe logger
class LoggerObject{
    private val _logs:MutableList<String> =mutableListOf<String>()

    @Synchronized
    fun log(message:String){
        val timestamp:Long=System.currentTimeMillis()
        val entry:String="[$timestamp] $message"
        _logs.add(element=entry)
        println("logged: $message")
    }

    @Synchronized
    fun getLogs():List<String>{
        return _logs.toList()
    }

    @Synchronized
    fun clear(){
        _logs.clear()
        println("logs cleared")
    }

    @Synchronized
    fun size():Int{
        return _logs.size
    }
}
fun main(){
    val logger:LoggerObject=LoggerObject()
    val threads:List<Thread> =(1..5).map{i:Int->
        Thread{
            repeat(times=3){j:Int->
                logger.log(message="thread $i - message $j")
                Thread.sleep(100)
            }
        }
    }
    threads.forEach{it.start()}
    threads.forEach{it.join()}
    println("---log summary---")
    println("total logs: ${logger.size()}")
    println("all logs: ")
    logger.getLogs().forEach{println{"$ $it"}}
}