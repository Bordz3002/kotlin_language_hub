//a list that supports reverse iteration
class ReversibleList<E>:AbstractMutableList<E>(){
    private val _items:MutableList<E> =mutableListOf<E>()
    override val size:Int
        get()=_items.size
    override fun get(index:Int):E=_items[index]
    override fun add(index:Int, element:E):Unit{
        _items.add(index=index, element=element)
    }
    override fun removeAt(index:Int):E=_items.removeAt(index=index)
    override fun set(index:Int, element:E):E=_items.set(index=index, element=element)
    fun reverseIterator():MutableIterator<E>{
        println("creating reverse iterator")
        return object:MutableIterator<E>{
            private var _currentIndex:Int=size-1
            private var _lastReturnedIndex:Int=-1
            override fun hasNext():Boolean=_currentIndex>=0
            override fun next():E{
                if(!hasNext()) throw NoSuchElementException()
                val element:E=get(_currentIndex)
                _lastReturnedIndex=_currentIndex
                _currentIndex--
                return element
            }
            override fun remove(){
                if(_lastReturnedIndex==-1){
                    throw IllegalStateException("call next() before remove()")
                }
                removeAt(index=_lastReturnedIndex)
                _currentIndex=_lastReturnedIndex-1
                _lastReturnedIndex=-1
                println("reversed iterator removed element")
            }
        }
    }
}
fun main(){
    val list:ReversibleList<String> =ReversibleList<String>()
    for(letter:Char in 'A'..'E'){
        list.add(element=letter.toString())
    }
    println("\n---forward iteration---")
    val reverseIterator:MutableIterator<String> =list.reverseIterator()
    while(reverseIterator.hasNext()){
        println("item: ${reverseIterator.next()}")
    }
    println("\n---reverse iteration with removal---")
    val removeIterator:MutableIterator<String> =list.reverseIterator()
    while(removeIterator.hasNext()){
        val item:String=removeIterator.next()
        println("item: $item")
        if(item=="C"){
            removeIterator.remove()
        }
    }
    println("\n---final state---")
    println("contents: $list")
    println("size: ${list.size}")
    println("\n---using inherited methods---")
    println("contains 'A': ${list.contains(element="A")}")
    println("index of 'D': ${list.indexOf(element="D")}")
    println("sublist(1, 3): ${list.subList(fromIndex=1, toIndex=3)}")
}