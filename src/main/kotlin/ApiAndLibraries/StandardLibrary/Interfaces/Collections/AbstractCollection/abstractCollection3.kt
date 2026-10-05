// A unique collection (like a Set)
class UniqueCollection<out E>(private val items:List<E>):AbstractCollection<E>(){
    override val size: Int
        get()=items.toSet().size
    override fun iterator():Iterator<E> =items.toSet().iterator()
}
fun main(){
    val collection:UniqueCollection<String> =UniqueCollection(listOf("apple", "banana", "apple", "cherry", "banana"))
    println("size: ${collection.size}")
    println("is empty: ${collection.isEmpty()}")
    println("contains 'apple': ${collection.contains(element="apple")}")
    println("contains 'mango': ${collection.contains(element="mango")}")
    println("contents: ${collection}")
    for(item:String in collection){
        println("item: $item")
    }
}