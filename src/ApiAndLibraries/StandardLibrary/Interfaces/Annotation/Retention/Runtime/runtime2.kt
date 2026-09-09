//use case: annotation carrying information
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class CropInfo(val name:String)
@CropInfo("scallion")
class MyFarm
fun main(){
    val annotations=MyFarm::class.java.annotations
    for(annotation in annotations){
        println(annotation)
    }
}
