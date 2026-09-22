//connection pool status
class ConnectionPool{
    @Volatile
    var availableConnections:Int=5

    @Volatile
    var isShuttingDown:Boolean=false

    fun acquireConnection():Boolean{
        if(this.isShuttingDown){
            println("pool is shutting down. cannot acquire")
            return false
        }
        return if(this.availableConnections>0){
            this.availableConnections--
            println("connection acquired. available ${this.availableConnections}")
            true
        }else{
            println("no connections available")
            false
        }
    }
    fun releaseConnection(){
        if(!this.isShuttingDown){
            this.availableConnections++
            println("connection released. available ${this.availableConnections}")
        }
    }
    fun shutdown(){
        println("shutting down pool...")
        this.isShuttingDown=true
    }
}
fun main(){
    val pool:ConnectionPool=ConnectionPool()
    val clientThread1:Thread=Thread{
        repeat(times=3){
            if(pool.acquireConnection()){
                Thread.sleep(300)
                pool.releaseConnection()
            }
            Thread.sleep(200)
        }
    }
    val clientThread2:Thread=Thread{
        repeat(times=3){
            if(pool.acquireConnection()){
                Thread.sleep(300)
                pool.releaseConnection()
            }
            Thread.sleep(200)
        }
    }
    clientThread1.start()
    clientThread2.start()
    Thread.sleep(1000)
    pool.shutdown()
    clientThread1.join()
    clientThread2.join()
    println("main thread done")
}