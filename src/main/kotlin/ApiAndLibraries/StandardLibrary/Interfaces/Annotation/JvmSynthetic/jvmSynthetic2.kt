//internal helper
class IrrigationManager{
    fun startIrrigation(){
        prepareWaterFlow()
        println("irrigation started")
    }
    @JvmSynthetic
    fun prepareWaterFlow(){
        println("checking water pressure...")
    }
}
fun main(){
    val manager:IrrigationManager=IrrigationManager()
    manager.startIrrigation()
    manager.prepareWaterFlow()
}