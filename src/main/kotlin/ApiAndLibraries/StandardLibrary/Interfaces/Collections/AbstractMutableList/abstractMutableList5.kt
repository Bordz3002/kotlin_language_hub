//a list with maximum size
class BoundedMutableList<E>(private val maxSize:Int):AbstractMutableList<E>(){
    private val _items:MutableList<E> =mutableListOf<E>()
    override val size: Int
        get()=_items.size
    override fun get(index:Int):E=_items[index]
    override fun add(index:Int, element:E){
        if(_items.size>=maxSize){
            println("cannot add '$element' - list is full (max: $maxSize)")
            return
        }
        _items.add(index=index, element=element)
    }
    override fun removeAt(index:Int):E=_items.removeAt(index=index)
    override fun set(index:Int, element:E):E=_items.set(index=index, element=element)
}
fun main(){
    val list:BoundedMutableList<String> =BoundedMutableList<String>(maxSize=3)
    println("max size: 3")
    println("\n---adding items---")
    for(letter:Char in 'A'..'C'){
        list.add(element=letter.toString())
    }
    println("contents: $list")
    println("\n---trying to add beyond limit---")
    for(letter:Char in 'D'..'E'){
        list.add(element=letter.toString())
    }
    println("contents: $list")
    println("size: ${list.size}")
    println("\n---using add(index, element) beyond limit---")
    list.add(index=1, element="X")
    println("contents: $list")
    println("\n---removing an item---")
    list.removeAt(index=0)
    println("contents: $list")
    println("size: ${list.size}")
    println("\n---adding again---")
    list.add(element="D")
    println("contents: $list")
    println("size: ${list.size}")
}