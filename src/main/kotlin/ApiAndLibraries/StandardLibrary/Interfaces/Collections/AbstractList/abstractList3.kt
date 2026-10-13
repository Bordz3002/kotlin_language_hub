//a reversed list
class ReversedList<out E>(private val original:List<E>):AbstractList<E>(){
    override val size: Int
        get()=original.size
    override fun get(index:Int):E{
        if(index !in 0 until size){
            throw IndexOutOfBoundsException("index: $index, size: $size")
        }
        return original[size-1-index]
    }
}
fun main(){
    val list:ReversedList<String> =ReversedList<String>(original=listOf("a", "b", "c", "d", "e"))
    println("size: ${list.size}")
    println("first: ${list[0]}")
    println("last: ${list[list.size-1]}")
    println("contents: $list")
    for(item:String in list){
        println("item: $item")
    }
}