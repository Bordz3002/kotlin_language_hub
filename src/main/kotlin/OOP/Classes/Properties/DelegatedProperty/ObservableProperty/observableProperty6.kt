// triggers on every change
import kotlin.properties.Delegates
var entity:String by Delegates.observable(""){_, last, current->
    println("'$last' -> '$current'")
}
fun main(){
    entity="kupal"
    entity="kupal"
    entity="kupal"
}