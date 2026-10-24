//a simple mutable list
class SimpleMutableList<E>:AbstractMutableList<E>(){
    private val _items:MutableList<E> =mutableListOf<E>()
    override val size: Int
        get()=_items.size
    override fun get(index:Int):E=_items[index]
    override fun add(index:Int, element:E){
        _items.add(index=index, element=element)
    }
    override fun removeAt(index:Int):E=_items.removeAt(index=index)
    override fun set(index:Int, element:E):E=_items.set(index=index, element=element)
}
fun main(){
    val list:SimpleMutableList<String> =SimpleMutableList<String>()
    val fruits:List<String> =listOf<String>("apple", "banana", "cherry")
    println("size: ${list.size}")
    println("is empty: ${list.isEmpty()}")
    for(fruit:String in fruits){
        list.add(element=fruit)
    }
    println("\nafter adding:")
    println("size: ${list.size}")
    println("contents: $list")
    println("first: ${list[0]}")
    println("second: ${list[1]}")
    list[1]="blueberry"
    println("\nafter set(1, \"blueberry\"):")
    println("contents: $list")
    list.removeAt(index=0)
    println("\nafter removeAt(index=0):")
    println("contents: $list")
    list.add(index=1, element="mango")
    println("contents: $list")
    list.remove(element="mango")
    println("\nafer remove(element=\"mango\"):")
    println("contents: $list")
}