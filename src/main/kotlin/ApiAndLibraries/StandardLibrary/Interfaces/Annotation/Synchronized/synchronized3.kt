//thread-safe singleton pattern
class DatabaseConnection private constructor(){
    init{
        println("database connection created")
    }
    fun query(sql:String):String{
        return "result of: $sql"
    }
    companion object{
        private var _instance:DatabaseConnection?=null

        @Synchronized
        fun getInstance():DatabaseConnection{
            if(_instance==null){
                _instance=DatabaseConnection()
            }
            return _instance!!
        }
    }
}
fun main(){
    val threads:MutableList<Thread> =mutableListOf<Thread>()
    repeat(times=5){i:Int->
        val thread:Thread=Thread{
            val connection:DatabaseConnection=DatabaseConnection.getInstance()
            println("thread $i got: ${connection.query(sql="SELECT $i")}")
        }
        threads.add(thread)
    }
    threads.forEach{it.start()}
    threads.forEach{it.join()}
    println("done")
}