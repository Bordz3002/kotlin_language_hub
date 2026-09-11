//use case: custom source annotation for code quality

import kotlin.annotation.AnnotationRetention
import kotlin.annotation.Retention

@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.FUNCTION)
annotation class NeedsReview(val reason:String)

@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.CLASS)
annotation class Unstable

@NeedsReview("this algorithm might not handle edge cases")
fun complexCalculation():Int{
    return 42
}

@Unstable
class ExperimentalFeature(){
    fun test(){
        println("testing experimental feature")
    }
}

//these annotations only exist during development
//they're removed in production