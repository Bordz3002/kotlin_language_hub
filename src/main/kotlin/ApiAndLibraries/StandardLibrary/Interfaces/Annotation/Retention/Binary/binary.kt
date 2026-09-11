//simplest example
import kotlin.annotation.AnnotationRetention
import kotlin.annotation.Retention

//define annotation with binary retention
@Retention(AnnotationRetention.BINARY)
annotation class BinaryAnnotation(val message:String)

@BinaryAnnotation("this is in the class file")
class JustClass(){}

fun main(){
    //this annotation is not available at runtime
    //even though it exists in the class file, you cant access it
    println("cant access this annotation at runtime")
}