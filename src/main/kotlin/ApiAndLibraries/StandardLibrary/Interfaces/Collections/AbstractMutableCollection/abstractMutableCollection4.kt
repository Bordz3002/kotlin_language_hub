//a logging collection
class LoggingCollection<E>(private val name:String):AbstractMutableCollection<E>(){
    private val _items:MutableList<E> =mutableListOf<E>()
    override val size: Int
        get()=_items.size
    override fun iterator():MutableIterator<E> =_items.iterator()
    override fun add(element:E):Boolean{
        println("[$name] adding: $element")
        return _items.add(element=element)
    }
    override fun remove(element:E):Boolean{
        if(_items.remove(element=element)){
            println("[$name] removed: $element")
        }else{
            println("[$name] not found: $element")
        }
        return _items.remove(element=element)
    }
    override fun clear(){
        println("[$name] clearing all ${_items.size} items")
        _items.clear()
    }
}
fun main(){
    val collection:LoggingCollection<String> =LoggingCollection<String>(name="fruits")
    val fruitsList:List<String> =listOf<String>("apple", "banana", "cherry")
    println("---adding items---")
    for(fruit:String in fruitsList){
        collection.add(element=fruit)
    }
    println("\n---removing items---")
    collection.remove(element="banana")
    collection.remove(element="mango")
    println("\nsize: ${collection.size}")
    println("contents: $collection")
    println("\n---clearing")
    collection.clear()
    println("size after clear: ${collection.size}")
    println("is empty: ${collection.isEmpty()}")
}