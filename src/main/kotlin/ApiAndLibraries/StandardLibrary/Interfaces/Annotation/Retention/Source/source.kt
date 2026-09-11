import kotlin.annotation.AnnotationRetention
import kotlin.annotation.Retention

//define annotation with SOURCE retention
@Retention(AnnotationRetention.SOURCE)
annotation class DeveloperNote(val message:String)

//use the annotation
@DeveloperNote("this function needs optimization")
fun someFunction(){
    println("hello world")
}
fun main(){
    //this annotation is NOT available at runtime
    //the compiler removed it entirely
    println("the annotation is gone after compilation")
}
