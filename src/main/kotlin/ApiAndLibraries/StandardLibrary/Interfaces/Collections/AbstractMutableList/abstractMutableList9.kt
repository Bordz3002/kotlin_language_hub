//a list with custom iterator
class CustomIteratorList<E>:AbstractMutableList<E>(){
    private val _items:MutableList<E> =mutableListOf<E>()
    override val size:Int
        get()=_items.size
    override fun get(index:Int):E=_items[index]
    override fun add(index:Int, element:E):Unit{
        _items.add(index=index, element=element)
    }
    override fun removeAt(index:Int):E=_items.removeAt(index=index)
    override fun set(index:Int, element:E):E=_items.set(index=index, element=element)
    override fun iterator():MutableIterator<E>{
        println("creating custom iterator")
        return object:MutableIterator<E>{
            private var _currentIndex:Int=0
            private var _lastReturnedIndex:Int=-1
            override fun hasNext():Boolean=_currentIndex<size
            override fun next():E{
                if(!hasNext()) throw NoSuchElementException()
                val element:E=get(_currentIndex)
                _lastReturnedIndex=_currentIndex
                _currentIndex++
                return element
            }
            override fun remove(){
                if(_lastReturnedIndex==-1){
                    throw IllegalStateException("call next() before remove()")
                }
                removeAt(index=_lastReturnedIndex)
                _currentIndex=_lastReturnedIndex
                _lastReturnedIndex=-1
                println("iterator removed element at index $_currentIndex")
            }
        }
    }
}
fun main(){
    val list:CustomIteratorList<String> =CustomIteratorList<String>()
    for(letter:Char in 'A'..'E'){
        list.add(element=letter.toString())
    }
    println("---using custom iterator---")
    val iterator:MutableIterator<String> =list.iterator()
    while(iterator.hasNext()){
        val element:String=iterator.next()
        println("element: $element")
        if(element=="C"){
            iterator.remove()
        }
    }
    println("\n---final state---")
    println("contents: $list")
    println("size: ${list.size}")
    println("\n---using for-each loop---")
    for(element:String in list){
        println("element: $element")
    }
}