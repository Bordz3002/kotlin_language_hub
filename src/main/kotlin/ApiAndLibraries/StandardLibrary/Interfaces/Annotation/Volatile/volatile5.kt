//file download progress
class FileDownloader{
    @Volatile
    var progress:Int=0

    @Volatile
    var isComplete:Boolean=false

    fun download(){
        println("starting download...")
        for(i:Int in 1..10){
            Thread.sleep(300)
            this.progress=i*10
            println("download progress: ${this.progress}")
        }
        this.isComplete=true
        println("download complete")
    }
    fun showProgress(){
        while (!isComplete) {
            val bar = "█".repeat(progress / 10)
            val empty = "░".repeat(10 - progress / 10)
            print("\r[$bar$empty] $progress%")
            Thread.sleep(100)
        }
        println("\r[██████████] 100%")
        println("Progress bar finished")
    }
}
fun main(){
    val downloader:FileDownloader=FileDownloader()
    val downloadThread:Thread=Thread{
        downloader.download()
    }
    val progressThread:Thread=Thread{
        downloader.showProgress()
    }
    progressThread.start()
    downloadThread.start()
    downloadThread.join()
    progressThread.join()
    println("main thread done")
}