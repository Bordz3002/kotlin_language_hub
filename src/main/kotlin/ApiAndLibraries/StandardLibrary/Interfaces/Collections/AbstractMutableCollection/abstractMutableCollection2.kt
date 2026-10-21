//a bounded mutable collection
class BoundedCollection<E>(private val maxSize:Int):AbstractMutableCollection<E>(){
    private val items:MutableList<E> =mutableListOf<E>()
    override val size: Int
        get()=items.size
    override fun iterator():MutableIterator<E> =items.iterator()
    override fun add(element:E):Boolean{
        if(items.size>=maxSize){
            println("cannot add '$element' - collection is full (max: $maxSize)")
            return false
        }
        return items.add(element=element)
    }
}
fun main(){
    val collection:BoundedCollection<String> =BoundedCollection<String>(maxSize=3)
    println("max size: 3")
    println("\nadding items: ")
    collection.add(element="apple")
    collection.add(element="banana")
    collection.add(element="cherry")
    println("\ntrying to add beyond size limit: ")
    collection.add(element="mango")
    collection.add(element="orange")
    println("\nfinal size: ${collection.size}")
    println("contents: $collection")
    collection.remove(element="banana")
    println("\nafter removing 'banana': ")
    println("contents: $collection")
    collection.add(element="mango")
    println("\nafter adding 'mango':")
    println("contents: $collection")
}