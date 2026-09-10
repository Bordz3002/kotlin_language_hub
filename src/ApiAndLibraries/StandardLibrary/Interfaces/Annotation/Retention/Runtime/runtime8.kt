//annotation parameters with default values
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class DeviceInfo(val deviceBrand:String, val deviceModel:String="unknown")
@DeviceInfo("honda")
class Scooter
fun main(){
    val deviceInfo=Scooter::class.java.getAnnotation(DeviceInfo::class.java)
    println("brand: ${deviceInfo.deviceBrand}")
    println("model: ${deviceInfo.deviceModel}")
}