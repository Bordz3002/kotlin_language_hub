import kotlin.properties.Delegates
class Budget(var expectTotal:Int){
    var remaining:Int by Delegates.observable(expectTotal){_, old, new ->
        val percent:Double=(new.toDouble() / expectTotal) *100
        when{
            new<0 ->println("over budget. (was $old, now $new)")
            new<expectTotal*0.2 ->println("warning: only ${"%.0f".format(percent)}% remaining")
            else ->println("budget updated: $old -> $new")
        }
    }
}
fun main(){
    val budget:Budget=Budget(1000)
    budget.remaining=800
    budget.remaining=150
    budget.remaining=-50
}