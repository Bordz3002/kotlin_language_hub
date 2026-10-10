//A prime number iterator
import kotlin.math.sqrt
class PrimeIterator(private val limit:Int):AbstractIterator<Int>(){
    private var _current:Int=2
    override fun computeNext(){
        while(_current<=limit&&_isPrime(_current)){
            _current++
        }
        if(_current>limit){
            done()
        }else{
            setNext(_current)
            _current++
        }
    }
    private fun _isPrime(number:Int):Boolean{
        if(number<2)return false
        for(i:Int in 2..sqrt(x=number.toDouble()).toInt()){
            if(number%i==0)return false
        }
        return true
    }
}
fun main(){
    val iterator:PrimeIterator=PrimeIterator(limit=30)
    while(iterator.hasNext()){
        println(iterator.next())
    }
}