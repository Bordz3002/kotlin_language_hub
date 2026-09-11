//use case: code documentation (dev notes)

import kotlin.annotation.AnnotationRetention
import kotlin.annotation.Retention

@Retention(AnnotationRetention.SOURCE)
annotation class Todo(val task:String, val priority:String="medium")

@Todo("fix this bug", "high")
class BuggyClass(){
    @Todo("add validation")
    fun processData(){}
}

//these annotations helps developers during coding
//but dont affect the compiled program