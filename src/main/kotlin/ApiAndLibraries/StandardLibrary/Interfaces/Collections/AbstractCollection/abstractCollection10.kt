//A fibonacci collection
class Fibonacci(private val count:Int):AbstractCollection<Long>(){
    private val _numbers:List<Long> =_generateFibonacci(n=count)
    override val size: Int
        get()=_numbers.size
    override fun iterator():Iterator<Long> =_numbers.iterator()
    private fun _generateFibonacci(n:Int):List<Long>{
        if(n<=0) return emptyList()
        if(n==1) return listOf(0)
        val result:MutableList<Long> =mutableListOf(0L, 1L)
        while(result.size<n){
            val next:Long=result[result.size-1]+result[result.size-2]
            result.add(element=next)
        }
        return result
    }
}
fun main(){
    val fib:Fibonacci=Fibonacci(count=10)
    println("count: ${fib.size}")
    println("is empty: ${fib.isEmpty()}")
    println("contains 5: ${fib.contains(element=5)}")
    println("contains 100: ${fib.contains(element=100)}")
    println("fibonacci sequence: $fib")
    for(number:Long in fib){
        println("fibonacci: $number")
    }
}