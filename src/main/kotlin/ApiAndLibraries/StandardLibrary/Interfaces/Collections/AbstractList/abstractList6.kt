//a sublist view
class SubListView<out TYPE>(
    private val original:List<TYPE>,
    private val fromIndex:Int,
    private val toIndex:Int
):AbstractList<TYPE>(){
    init{
        require(value=fromIndex in 0..toIndex){"fromIndex must be <= toIndex"}
        require(value=toIndex<=original.size){"toIndex must be <= size"}
    }
    override val size: Int
        get()=toIndex-fromIndex
    override fun get(index:Int):TYPE{
        if(index !in 0 until size){
            throw IndexOutOfBoundsException("index: $index, size: size")
        }
        return original[fromIndex+index]
    }
}
fun main(){
    val original:List<String> =listOf("A", "B", "C", "D", "E", "F", "G", "H")
    val subList:SubListView<String> =SubListView<String>(original=original, fromIndex=2, toIndex=6)
    println("original: $original")
    println("sublist: $subList")
    println("size: ${subList.size}")
    println("first: ${subList[0]}")
    println("last: ${subList[subList.size-1]}")
    println("contains 'C': ${subList.contains(element="C")}")
    println("contains 'A': ${subList.contains(element="A")}")
    println("index of 'E': ${subList.indexOf(element="E")}")
    for(item:String in subList){
        println("item: $item")
    }
}