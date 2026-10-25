//a list that rejects duplicates
class UniqueMutableList<E>:AbstractMutableList<E>(){
    private val _items:MutableList<E> =mutableListOf<E>()
    override val size: Int
        get()=_items.size
    private fun _rejectMessage(element:E):Unit{
        println("'$element' already exists - rejected")
    }
    override fun get(index:Int):E=_items[index]
    override fun add(index:Int, element:E){
        if(_items.contains(element=element)){
            _rejectMessage(element=element)
            return
        }
        _items.add(index=index, element=element)
    }
    override fun removeAt(index:Int):E=_items.removeAt(index=index)
    override fun set(index:Int, element:E):E{
        if(_items.contains(element=element)){
            _rejectMessage(element=element)
            return _items[index]
        }
        return _items.set(index=index, element=element)
    }
}
fun main(){
    val list:UniqueMutableList<String> =UniqueMutableList<String>()
    val letters:List<String> =listOf<String>("A", "B", "A", "C", "B")
    println("---adding items (duplicates rejected)---")
    for(letter:String in letters){
        list.add(element=letter)
    }
    println("\n---contents: $list---")
    println("size: ${list.size}")
    println("\n---trying to set a duplicate---")
    list[2]="A"
    println("\n---contents: $list")
    println("\n---setting a unique duplicate---")
    list[2]="D"
    println("contents: $list")
    println("\n---using add(index, element) with duplicate---")
    list.add(index=1, element="A")
    println("\ncontents: $list")
    println("size: ${list.size}")
}
