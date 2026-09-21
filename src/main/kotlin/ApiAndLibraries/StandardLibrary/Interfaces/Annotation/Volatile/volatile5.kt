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
        while(!this.isComplete){
            var bar
        }
    }
}