//flag to Stop a Thread
class WorkerClass{
    @Volatile
    var running:Boolean=true

    fun start(){
        println("worker started")
        var count:Int=0
        while(this.running){
            count++
            Thread.sleep(100)
        }
        println("worker stopped after $count iterations")
    }
    fun stop(){
        println("stop signal sent")
        this.running=false
    }
}
fun main(){
    val worker:WorkerClass=WorkerClass()
    val thread=Thread{
        worker.start()
    }
    thread.start()
    Thread.sleep(500)
    worker.stop()
    thread.join()
    println("main thread done")
}