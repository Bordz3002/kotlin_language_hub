//use case: suppressing compiler warnings
import kotlin.annotation.AnnotationRetention
import kotlin.annotation.Retention

@Retention(AnnotationRetention.SOURCE)
annotation class SuppressWarning(val reason:String)

//use it to document why a waring is suppressed
@SuppressWarning("this variable is used by reflection")
val unusedVariable:String="hello"

//this annotation disappears after compilation