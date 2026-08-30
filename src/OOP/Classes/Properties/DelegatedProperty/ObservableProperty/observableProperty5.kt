import kotlin.properties.Delegates
class Counter{
    var count:Int by Delegates.observable(0){_, last, current->
        println("count: $last -> $current")
        if(current>last){
            println("increased by ${current-last}")
        }else if(current<last){
            println("decreased by: ${last-current}")
        }else{
            println("no change, current value: $current")
        }
    }
}
fun main(){
    val counter:Counter=Counter()
    counter.count=5
    counter.count=3
    counter.count=3
}