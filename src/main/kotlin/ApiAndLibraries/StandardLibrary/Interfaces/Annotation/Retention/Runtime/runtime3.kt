//reading a specific annotation
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class CropData(val name:String)
@CropData("scallion")
class ScallionFarm
fun main(){
    val cropData=ScallionFarm::class.java.getAnnotation(CropData::class.java)
    println(cropData)
}