//A collection of prime numbers
import kotlin.math.sqrt
class Primes(private val limit:Int):AbstractCollection<Int>(){
    private val _primes:List<Int> =(2..limit).filter{_isPrime(number=it)}
    override val size: Int
        get()=_primes.size
    override fun iterator():Iterator<Int> =_primes.iterator()
    private fun _isPrime(number:Int):Boolean{
        if(number<2) return  false
        for(i:Int in 2..sqrt(x=number.toDouble()).toInt()){
            if(number%i==0) return false
        }
        return true
    }
}
fun main(){
    val collection:Primes=Primes(limit=30)
    println("size: ${collection.size}")
    println("is empty: ${collection.isEmpty()}")
    println("contains 7: ${collection.contains(element=7)}")
    println("contains 10: ${collection.contains(element=10)}")
    println("prime numbers up to 30: $collection")
    for(prime:Int in collection){
        println("prime: $prime")
    }
}