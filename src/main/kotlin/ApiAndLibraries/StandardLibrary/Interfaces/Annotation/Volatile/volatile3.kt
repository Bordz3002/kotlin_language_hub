//configuration update signal
class ConfigManager{
    @Volatile
    var configVersion:Int=0

    @Volatile
    var currentConfig:String="default"

    fun updateConfig(newConfig:String){
        Thread.sleep(500) //simulate loading config
        this.currentConfig=newConfig
        this.configVersion++ //signal: config has changed
        println("config updated to: $newConfig (version ${this.configVersion}")
    }
    fun watchConfig(){
        var lastSeenVersion:Int=-1
        while(true){
            if(this.configVersion!=lastSeenVersion){
                lastSeenVersion=this.configVersion
                println("detected config change! new value: ${this.currentConfig}")
            }
            if(this.configVersion>=3){
                println("received all updates.stopping watcher")
                break
            }
            Thread.sleep(100)
        }
    }
}
fun main(){
    val manager:ConfigManager=ConfigManager()
    val watcherThread=Thread{
        manager.watchConfig()
    }
    val updaterThread=Thread{
        manager.updateConfig(newConfig="production")
        manager.updateConfig(newConfig="staging")
        manager.updateConfig(newConfig="development")
    }
    watcherThread.start()
    updaterThread.start()
    watcherThread.join()
    updaterThread.join()
    println("main thread done")
}