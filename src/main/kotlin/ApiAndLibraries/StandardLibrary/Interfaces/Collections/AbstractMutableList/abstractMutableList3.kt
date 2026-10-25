//a list that tracks modifications
class TrackedMutableList<E>:AbstractMutableList<E>(){
    private val _items:MutableList<E> =mutableListOf<E>()
    private var _modificationCount:Int=0
    private fun _modifiedMessage():Unit{
        println("modified! total modifictaions: $_modificationCount")
    }
    override val size:Int
        get()=_items.size
    override fun get(index:Int):E=_items[index]
    override fun add(index:Int, element:E){
        _items.add(index=index, element=element)
        _modificationCount++
        _modifiedMessage()
    }
    override fun removeAt(index:Int):E{
        val removed:E=_items.removeAt(index=index)
        _modificationCount++
        _modifiedMessage()
        return removed
    }
    override fun set(index:Int, element:E):E{
        val old:E=_items.set(index=index, element=element)
        _modificationCount++
        _modifiedMessage()
        return old
    }
    fun getModificationCount():Int=_modificationCount
}
fun main(){
    val list:TrackedMutableList<String> =TrackedMutableList<String>()
    println("---adding items---")
    for(letter:Char in 'A'..'C'){
        list.add(element=letter.toString())
    }
    println("\n---setting an item---")
    list[1]="B2"
    println("\n---removing an item---")
    list.removeAt(index=0)
    println("\n---using remove(element) (free, but class removeAt())---")
    list.remove(element="C")
    println("\n---using clear(), (free, but calls removeAt())---")
    list.clear()
    println("\n---final state---")
    println("size: ${list.size}")
    println("contents: $list")
    println("total modifications: ${list.getModificationCount()}")
}