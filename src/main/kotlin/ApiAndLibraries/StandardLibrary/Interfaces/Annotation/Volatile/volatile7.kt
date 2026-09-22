//stock price monitor
class StockMonitor{
    @Volatile
    var currentPrice:Double=100.0

    @Volatile
    var priceChanged:Boolean=false

    fun simulateMarket(){
        val prices:List<Double> =listOf(102.0, 98.0, 105.0, 95.0, 110.0, 108.0, 115.0)
        for(price:Double in prices){
            if(this.priceChanged){
                println("alert already sent. stopping simulation")
                return
            }
            this.currentPrice=price
            println("market update: $price")
            Thread.sleep(500)
        }
        println("market closed")
    }
    fun watchPrice(){
        while(true){
            if(this.currentPrice>110.0){
                this.priceChanged=true
                println("alert! stock price jumped to ${this.currentPrice}")
                return
            }
            Thread.sleep(100)
        }
    }
}
fun main(){
    val monitor:StockMonitor=StockMonitor()
    val marketThread:Thread=Thread{
        monitor.simulateMarket()
    }
    val watcherThread:Thread=Thread{
        monitor.watchPrice()
    }
    watcherThread.start()
    marketThread.start()
    marketThread.join()
    watcherThread.join()
    println("monitor stopped")
}