//a collection with change tracking
class TrackedCollection<E>:AbstractMutableCollection<E>(){
    private val _items:MutableList<E> =mutableListOf<E>()
    private var _addCount:Int=0
    private var _removeCount:Int=0
    override val size:Int
        get()=_items.size
    override fun iterator():MutableIterator<E> =_items.iterator()
    override fun add(element:E):Boolean{
        val added:Boolean=_items.add(element=element)
        if(added) _addCount++
        return added
    }
    override fun remove(element:E):Boolean{
        val removed:Boolean=_items.remove(element=element)
        if(removed) _removeCount++
        return removed
    }
    fun getAddCount():Int=_addCount
    fun getRemoveCount():Int=_removeCount
    fun getStats():String="added: $_addCount, removed: $_removeCount, current size: $size"
}
fun main(){
    val collection:TrackedCollection<String> =TrackedCollection<String>()
    println("---adding items---")
    collection.add(element="apple")
    collection.add(element="banana")
    collection.add(element="cherry")
    collection.add(element="apple")
    collection.add(element="mango")
    println("\nstats after adding:")
    println(collection.getStats())
    println("\n---removing items---")
    collection.remove(element="banana")
    collection.remove(element="apple")
    collection.remove(element="orange")
    println("\nstats after removing")
    println(collection.getStats())
    println("\ncontents: $collection")
    println("add count: ${collection.getAddCount()}")
    println("remove count: ${collection.getRemoveCount()}")
}