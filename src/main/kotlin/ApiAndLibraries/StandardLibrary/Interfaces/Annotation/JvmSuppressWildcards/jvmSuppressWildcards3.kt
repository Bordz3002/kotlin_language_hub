//function parameter
open class FieldDevice(val code:String)
fun registerDevices(devices:List<@JvmSuppressWildcards FieldDevice>){
    for(device:FieldDevice in devices){
        println("registered: ${device.code}")
    }
}
fun main(){
    val devices:List<FieldDevice> =listOf(
        FieldDevice(code="NPK-01"),
        FieldDevice(code="PH-02")
    )
    registerDevices(devices=devices)
}