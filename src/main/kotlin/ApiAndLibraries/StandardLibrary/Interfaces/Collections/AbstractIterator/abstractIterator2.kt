//The fibonacci iterator
class FibonacciIterator(private val count:Int):AbstractIterator<Long>(){
    private var _a:Long=0L
    private var _b:Long=1L
    private var _index=0
    override fun computeNext(){
        if(_index>=count){
            done()
        }else{
            setNext(_a)
            val next:Long=_a+_b
            _a=_b
            _b=next
            _index++
        }
    }
}
fun main(){
    val iterator:FibonacciIterator=FibonacciIterator(count=10)
    while(iterator.hasNext()){
        println(iterator.next())
    }
}
