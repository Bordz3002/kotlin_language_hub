//a list that logs all operations
class LoggingMutableList<E>(private val name:String):AbstractMutableList<E>(){
    private val _items:MutableList<E> =mutableListOf<E>()
    override val size: Int
        get()=_items.size
    override fun get(index:Int):E{
        val item:E=_items[index]
        println("[$name] get($index) -> $item")
        return item
    }
    override fun add(index:Int, element:E){
        _items.add(index=index, element=element)
        println("[$name] add(index=$index, element=$element) ->size: $size")
    }
    override fun removeAt(index:Int):E{
        val removed:E=_items.removeAt(index=index)
        println("[$name] removeAt(index=$index) -> $removed (size: $size)")
        return removed
    }
    override fun set(index:Int, element:E):E{
        val old:E=_items.set(index=index, element=element)
        println("[$name] set(index=$index, element=$element) -> was $old")
        return old
    }
}
fun main(){
    val list:LoggingMutableList<String> =LoggingMutableList<String>(name="ShoppingCart")
    val fruits:List<String> =listOf<String>("Apple", "Banana", "Cherry")
    println("---adding items---")
    for(fruit:String in fruits){
        list.add(element=fruit)
    }
    println("\n---accessing elements---")
    println("first: ${list[0]}")
    println("second: ${list[1]}")
    println("\n---setting an item---")
    list[1]="Blueberry"
    println("\n---removing an item---")
    list.removeAt(index=0)
    println("\n---using inherited methods---")
    list.remove(element="cherry")
    println("\n---contents---")
    println("size: ${list.size}")
    println("contents: $list")
}