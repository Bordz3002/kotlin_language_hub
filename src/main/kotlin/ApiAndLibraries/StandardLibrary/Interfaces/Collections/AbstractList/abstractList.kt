//a simple read-only list
class SimpleList<out E>(private val items:List<E>):AbstractList<E>(){
    override val size:Int
        get()=items.size
    override fun get(index:Int):E =items[index]
}
fun main(){
    val list:SimpleList<String> =SimpleList<String>(items=listOf("apple", "banana", "cherry"))
    println("size: ${list.size}")
    println("is empty: ${list.isEmpty()}")
    println("first: ${list[0]}")
    println("second: ${list[1]}")
    println("contains 'banana': ${list.contains(element="banana")}")
    println("index of 'cherry': ${list.indexOf(element="cherry")}")
    println("contains: $list")
}