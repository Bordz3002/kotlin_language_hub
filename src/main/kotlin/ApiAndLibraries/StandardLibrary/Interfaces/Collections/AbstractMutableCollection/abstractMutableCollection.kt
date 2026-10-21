//a simple mutable collection
class SimpleMutableCollection<E>:AbstractMutableCollection<E>(){
    private val items:MutableList<E> =mutableListOf<E>()
    override val size:Int
        get()=items.size
    override fun iterator():MutableIterator<E> =items.iterator()
    override fun add(element:E):Boolean{
        return items.add(element=element)
    }
}
fun main(){
    val collection:SimpleMutableCollection<String> =SimpleMutableCollection<String>()
    println("size: ${collection.size}")
    println("is empty: ${collection.isEmpty()}")
    collection.add(element="apple")
    collection.add(element="banana")
    collection.add(element="cherry")
    println("after adding: ")
    println("size: ${collection.size}")
    println("contents: $collection")
    println("contains 'banana': ${collection.contains(element="banana")}")
    collection.remove(element="banana")
    println("after removing 'banana': ")
    println("size: ${collection.size}")
    println("contents: $collection")
    for(item:String in collection){
        println("item: $item")
    }
}