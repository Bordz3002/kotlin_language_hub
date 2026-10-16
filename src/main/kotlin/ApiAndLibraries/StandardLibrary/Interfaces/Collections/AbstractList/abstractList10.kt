//a partitioned list
class PartitionedList<out E>(private val original:List<E>, private val partitions:Int):AbstractList<List<E>>(){
    init{
        require(value=partitions>0){"partitions must be positive"}
    }
    override val size:Int
        get()=partitions
    override fun get(index:Int):List<E>{
        if(index !in 0 until size){
            throw IndexOutOfBoundsException("index: $index, size: $size")
        }
        val baseSize:Int=original.size/partitions
        val remainder:Int=original.size%partitions
        val from:Int=index*baseSize+minOf(a=index, b=remainder)
        val to:Int=from+baseSize+if(index<remainder) 1 else 0
        return original.subList(fromIndex=from, toIndex=to)
    }
}
fun main(){
    val original:List<Int> =listOf<Int>(1, 2, 3, 4, 5, 6, 7)
    val partitioned:PartitionedList<Int> =PartitionedList<Int>(original=original, partitions=3)
    println("original: $original")
    println("partitions: 3")
    println("number of partitions: ${partitioned.size}")
    for(partition:List<Int> in partitioned){
        println("partition: $partition")
    }
}