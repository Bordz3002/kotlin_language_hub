//a unique mutable collection (set-like)
class UniqueMutableCollection<E>:AbstractMutableCollection<E>(){
    private val _items:MutableList<E> =mutableListOf<E>()
    override val size: Int
        get()=_items.size
    override fun iterator():MutableIterator<E> =_items.iterator()
    override fun add(element:E):Boolean{
        if(_items.contains(element=element)){
            println("'$element' already exists - skipped")
            return false
        }
        return _items.add(element=element)
    }
}
fun main(){
    val collection:UniqueMutableCollection<String> =UniqueMutableCollection<String>()
    println("adding items (duplicates rejected):")
    collection.add(element="apple")
    collection.add(element="banana")
    collection.add(element="apple")
    collection.add(element="cherry")
    collection.add(element="banana")
    println("\nsize: ${collection.size}")
    println("contents: $collection")
    println("contains 'apple': ${collection.contains(element="apple")}")
    println("contains 'mango': ${collection.contains(element="mango")}")
    collection.remove(element="banana")
    println("\nafter removing 'banana':")
    println("contents: $collection")
    collection.add(element="banana")
    println("\nafter re-adding 'banana':")
    println("contents: $collection")
}