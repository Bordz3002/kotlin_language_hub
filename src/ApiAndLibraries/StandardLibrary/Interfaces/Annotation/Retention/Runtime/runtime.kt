@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class Important

@Important
class SomeFarm
fun main(){
    val annotations=SomeFarm::class.java.annotations
    println(annotations.contentToString())
}