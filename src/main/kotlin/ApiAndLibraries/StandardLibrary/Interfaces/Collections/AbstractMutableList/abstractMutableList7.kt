//a list with undo support
class UndoableMutableList<E>:AbstractMutableList<E>(){
    private val _items:MutableList<E> =mutableListOf<E>()
    private val _undoStack:MutableList<UndoAction> =mutableListOf<UndoAction>()
    private sealed class UndoAction{
        data class Add<E>(val index:Int, val element:E):UndoAction()
        data class Remove<E>(val index:Int, val element:E):UndoAction()
        data class Set<E>(val index:Int, val oldElement:E, val newElement:E):UndoAction()
    }
    override val size: Int
        get()=_items.size
    override fun get(index:Int):E=_items[index]
    override fun add(index:Int, element:E){
        _items.add(index=index, element=element)
        _undoStack.add(UndoAction.Add(index=index, element=element))
    }
    override fun removeAt(index:Int):E{
        val removed:E=_items.removeAt(index=index)
        _undoStack.add(UndoAction.Remove(index=index, element=removed))
        return removed
    }
    override fun set(index:Int, element:E):E{
        val old:E=_items.set(index=index, element=element)
        _undoStack.add(UndoAction.Set(index=index, oldElement=old, newElement=element))
        return old
    }
    fun undo():Boolean{
        if(_undoStack.isEmpty()){
            println("nothing to undo")
            return false
        }
        when(val action:UndoAction=_undoStack.removeAt(index=_undoStack.size-1)){
            is UndoAction.Add<*>->{
                _items.removeAt(index=action.index)
                println("undid add: ${action.element}")
            }
            is UndoAction.Remove<*>->{
                @Suppress("UNCHECKED_CAST")
                _items.add(index=action.index, element=action.element as E)
                println("undid remove: ${action.element}")
            }
            is UndoAction.Set<*>->{
                @Suppress("UNCHECKED_CAST")
                _items[action.index] =action.oldElement as E
                println("undid set: ${action.newElement} -> ${action.oldElement}")
            }
        }
        return true
    }
    fun undoAll():Unit{
        while(_undoStack.isNotEmpty()){
            undo()
        }
    }
    fun getHistory():List<String> =_undoStack.map{it:UndoAction->
        when(it){
            is UndoAction.Add<*>->"Add(element=${it.element}"
            is UndoAction.Remove<*>->"Remove(element=${it.element}"
            is UndoAction.Set<*>->"Set(index=${it.index}, element=${it.newElement}"
        }
    }
}
fun main(){
    val list:UndoableMutableList<String> =UndoableMutableList<String>()
    println("---adding items---")
    for(letter:Char in 'A'..'C'){
        list.add(element=letter.toString())
    }
    println("contents: $list")
    println("\n---setting an item---")
    list[1]="B2"
    println("contents: $list")
    println("\n---removing an item---")
    list.removeAt(index=0)
    println("contents: $list")
    repeat(times=4){it:Int->
        if(it==0){
            println("\n---undo once---")
        }else{
            println("\n---undo again---")
        }
        list.undo()
        println("contents: $list")
    }
    println("\n---undo when empty---")
    list.undo()
    println("\n---final state---")
    println("contents: $list")
    println("history: ${list.getHistory()}")
}