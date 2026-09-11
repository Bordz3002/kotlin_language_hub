import kotlin.reflect.full.findAnnotation

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class Thermos

@Important
class Coco

fun main() {
    val annotation = Coco::class.findAnnotation<Thermos>()

    println(annotation)
}