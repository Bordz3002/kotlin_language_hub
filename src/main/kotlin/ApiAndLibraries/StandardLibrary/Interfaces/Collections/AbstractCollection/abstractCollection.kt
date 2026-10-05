//simple fixed collection
class FixedCollection<out E>(private val items:List<E>):AbstractCollection<E>(){
    override val size:Int
        get()=items.size
    override fun iterator():Iterator<E> =items.iterator()
}
fun main(){
    val collection:FixedCollection<String> =FixedCollection(items=listOf("apple", "banana", "cherry"))
    println("size: ${collection.size}")
    println("is empty: ${collection.isEmpty()}")
    println("contains 'banana': ${collection.contains("banana")}")
    println("contains 'mango': ${collection.contains("mango")}")
    println("contents: $collection")
    for(item:String in collection){
        println("item: $item")
    }
}