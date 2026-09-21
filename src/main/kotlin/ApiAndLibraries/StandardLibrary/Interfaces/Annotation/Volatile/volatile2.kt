//ready signal between threads
class DataLoader{
    @Volatile
    var isReady:Boolean=false

    private var _data:String=""
    fun loadData(){
        println("loading data...")
        Thread.sleep(1000)
        this._data="important data"
        this.isReady=true
        println("data loaded and signal send")
    }
    fun processData(){
        println("waiting for data...")
        while(!this.isReady){
            //wait for signal
        }
        println("processing :${this._data}")
    }
}
fun main(){
    val loader:DataLoader=DataLoader()
    val loaderThread=Thread{
        loader.loadData()
    }
    val processorThread=Thread{
        loader.processData()
    }
    processorThread.start()
    loaderThread.start()
    loaderThread.join()
    processorThread.join()
    println("done!")
}