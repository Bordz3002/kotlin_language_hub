//thread-safe counter
class CounterObject{
    private var _count:Int=0

    @Synchronized
    fun increment(){
        _count++
    }

    @Synchronized
    fun decrement(){
        _count--
    }

    @Synchronized
    fun getCount():Int{
        return _count
    }
}
fun main(){
    val counter:CounterObject=CounterObject()
    val threads:MutableList<Thread> =mutableListOf<Thread>()
    repeat(times=5){
        val thread:Thread=Thread{
            repeat(times=1000){
                counter.increment()
            }
        }
        threads.add(thread)
    }
    threads.forEach{it.start()}
    threads.forEach{it.join()}
    println("final count: ${counter.getCount()}")
    println("expected: 5000")
}