//A Collection with duplicate counting
class DuplicateCounter(private val _numbers:List<Int>):AbstractCollection<Int>(){
    private val _count:Map<Int, Int> =_numbers.groupingBy{it}.eachCount()
    override val size: Int
        get()=_count.size
    override fun iterator():Iterator<Int> =_count.keys.iterator()
    fun getCount(number:Int):Int{
        return _count[number]?:0
    }
}
fun main(){
    val collection:DuplicateCounter=DuplicateCounter(_numbers=listOf(1, 2, 2, 3, 3, 3, 4, 4, 4, 4))
    println("size (unique numbers): ${collection.size}")
    println("is empty: ${collection.isEmpty()}")
    println("contains 2: ${collection.contains(element=2)}")
    println("contains 5: ${collection.contains(element=5)}")
    println("unique numbers: $collection")
    for(number:Int in collection){
        println("number $number appears ${collection.getCount(number=number)}")
    }
}