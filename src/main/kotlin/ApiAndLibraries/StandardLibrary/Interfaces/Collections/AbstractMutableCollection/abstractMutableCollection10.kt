//a collection with undo support
class UndoableCollection<E>:AbstractMutableCollection<E>(){
    private val _items:MutableList<E> =mutableListOf<E>()
    private val _undoStack:MutableList<UndoAction> =mutableListOf<UndoAction>()
    private sealed class UndoAction{
        data class Add<E>(val element:E):UndoAction()
        data class Remove<E>(val element:E, val index:Int):UndoAction()
    }
    override val size: Int
        get()=_items.size
    override fun iterator():MutableIterator<E> =_items.iterator()
    override fun add(element:E):Boolean{
        val added:Boolean=_items.add(element=element)
        if(added){
            _undoStack.add(UndoAction.Add(element=element))
        }
        return added
    }
    override fun remove(element:E):Boolean{
        val index:Int=_items.indexOf(element=element)
        if(index==-1) return false
        val removed:E=_items.removeAt(index=index)
        _undoStack.add(UndoAction.Remove(element=removed, index=index))
        return true
    }
    fun undo():Boolean{
        if(_undoStack.isEmpty()){
            println("nothing to undo")
            return false
        }
        when(val action:UndoableCollection.UndoAction=_undoStack.removeAt(index=_undoStack.size-1)){
            is UndoAction.Add<*>->{
                _items.remove(element=action.element)
            }
            is UndoAction.Remove<*>->{
                @Suppress("UNCHECKED_CAST")
                _items.add(action.index, action.element as E)
                println("undid remove: ${action.element}")
            }
        }
        return true
    }
    fun undoAll(){
        while(_undoStack.isNotEmpty()){
            undo()
        }
    }
    fun main(){
        val collection:UndoableCollection<String> =UndoableCollection<String>()
        val letters:List<String> =listOf<String>("A", "B", "C")
        println("---adding items---")
        for(letter:String in letters){
            collection.add(element=letter)
        }
        println("contents: $collection")
        println("\n---removing items---")
        collection.remove(element="B")
        println("contents: $collection")
        println("\n---undo once---")
        collection.undo()
        println("contents: $collection")
        println("\n---undo again---")
        collection.undo()
        println("contents: $collection")
        println("\n---undo again---")
        collection.undo()
        println("contents: $collection")
        println("\n---undo when empty---")
        collection.undo()
    }
}
