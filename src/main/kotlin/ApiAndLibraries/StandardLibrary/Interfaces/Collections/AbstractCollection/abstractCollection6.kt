//A reversed collection
class ReversedCollection<out E>(private val _items:List<E>):AbstractCollection<E>(){
    override val size: Int
        get()=_items.size
    override fun iterator():Iterator<E> =_items.reversed().iterator()
}
fun main(){
    val collection:ReversedCollection<String> =ReversedCollection<String>(_items=listOf("A", "B", "C", "D", "E"))
    println("size: ${collection.size}")
    println("is empty: ${collection.isEmpty()}")
    println("contains 'C': ${collection.contains(element="C")}")
    println("contains 'Z': ${collection.contains(element="Z")}")
    println("contents: $collection")
    for(item:String in collection){
        println("item: $item")
    }
}