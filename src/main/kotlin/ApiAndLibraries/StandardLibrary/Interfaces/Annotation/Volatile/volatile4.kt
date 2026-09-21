//shutdown signal
class Server{
    @Volatile
    var isRunning:Boolean=true

    @Volatile
    var shutdownRequested:Boolean=false

    fun start(){
        println("server started. listening for requests...")
        var requestCount:Int=0
        while(this.isRunning){
            if(this.shutdownRequested){
                println("shutdown requested. finishing up...")
                this.isRunning=false
            }else{
                requestCount++
                Thread.sleep(200)
            }
        }
        println("server stopped. processed $requestCount requests")
    }
    fun shutdown(){
        println("shutdown signal received")
        this.shutdownRequested=true
    }
}
fun main(){
    val server:Server=Server()
    val serverThread:Thread=Thread{
        server.start()
    }
    serverThread.start()
    Thread.sleep(1000)
    server.shutdown()
    serverThread.join()
    println("main thread done")

}