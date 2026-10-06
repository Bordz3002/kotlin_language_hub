//A filtered collection
class EvenNumbers(private val _numbers:List<Int>):AbstractCollection<Int>(){
    private val _evenNumbers=_numbers.filter{it%2==0}
    override val size: Int
        get()=_numbers.size
    override fun iterator():Iterator<Int> =_evenNumbers.iterator()
}
fun main(){
    val collection:EvenNumbers=EvenNumbers(_numbers=listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    println("size: ${collection.size}")
    println("is empty: ${collection.isEmpty()}")
    println("contains 4: ${collection.contains(element=4)}")
    println("contains 5: ${collection.contains(element=5)}")
    println("contents: $collection")
    for(number:Int in collection){
        println("even number: $number")
    }
}