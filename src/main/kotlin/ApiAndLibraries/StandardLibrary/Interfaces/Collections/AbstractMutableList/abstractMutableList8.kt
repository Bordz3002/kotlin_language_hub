//a list that fires change events
class ObservableMutableList<E>:AbstractMutableList<E>(){
    private val _items:MutableList<E> =mutableListOf<E>()
    private val _listeners:MutableList<(ChangeEvent)->Unit> =mutableListOf<(ChangeEvent)->Unit>()
    data class ChangeEvent(
        val type:String,
        val index: Int,
        val oldValue:Any?,
        val newValue:Any?,
        val size:Int
    )
    fun addListeners(listener:(ChangeEvent)->Unit):Unit{
        _listeners.add(element=listener)
    }
    private fun _notifyListeners(event:ChangeEvent):Unit{
        _listeners.forEach{it(event)}
    }
    override val size:Int
        get()=_items.size
    override fun get(index:Int):E=_items[index]
    override fun add(index:Int, element:E):Unit{
        _items.add(index=index, element=element)
        _notifyListeners(event=ChangeEvent(
            type="ADD",
            index=index,
            oldValue=null,
            newValue=element,
            size=size
        ))
    }
    override fun removeAt(index:Int):E{
        val removed:E=_items.removeAt(index=index)
        _notifyListeners(event=ChangeEvent(
            type="REMOVE",
            index=index,
            oldValue=removed,
            newValue=null,
            size=size
        ))
        return removed
    }
    override fun set(index:Int, element:E):E{
        val old:E=_items.set(index=index, element=element)
        _notifyListeners(event=ChangeEvent(
            type="SET",
            index=index,
            oldValue=old,
            newValue=element,
            size=size
        ))
        return old
    }
}
fun main(){
    val list:ObservableMutableList<String> =ObservableMutableList<String>()
    list.addListeners{event:ObservableMutableList.ChangeEvent->
        println("listener 1: ${event.type} at index ${event.index} | old=${event.oldValue}, new=${event.newValue}, size=${event.size}")
    }
    list.addListeners{event:ObservableMutableList.ChangeEvent->
        if(event.type=="REMOVE"){
            println("listener 2: item removed! was: ${event.oldValue}")
        }
    }
    println("---adding items---")
    for(letter:Char in 'A'..'C'){
        list.add(element=letter.toString())
    }
    println("\n---setting an item---")
    list[1]="B2"
    println("\n---removing an item---")
    list.removeAt(index=0)
    println("\n---using inherited remove(element)---")
    list.remove(element="C")
    println("\n---final state---")
    println("contents: $list")
    println("size: ${list.size}")
}