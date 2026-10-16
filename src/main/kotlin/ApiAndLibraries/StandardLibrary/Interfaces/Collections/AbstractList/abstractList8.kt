//a repeated list
class RepeatedList<out E>(private val original:List<E>, private val times:Int):AbstractList<E>(){
    init{
        require(value=times>=0){"times must be non-negative"}
    }
    override val size: Int
        get()=original.size*times
    override fun get(index:Int):E{
        if(index !in 0 until size){
            throw IndexOutOfBoundsException("index: $index, size: $size")
        }
        return original[index%original.size]
    }
}
fun main(){
    val list:RepeatedList<String> =RepeatedList<String>(original=listOf<String>("A", "B", "C"), times=3)
    println("size: ${list.size}")
    println("first: ${list[0]}")
    println("last: ${list[list.size-1]}")
    println("contains 'B': ${list.contains(element="B")}")
    println("index of 'A': ${list.indexOf(element="A")}")
    println("last index of 'A': ${list.lastIndexOf(element="A")}")
    println("contents: $list")
    for(item:String in list){
        println("item: $item")
    }
}