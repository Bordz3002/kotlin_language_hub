//a stack (LIFO) collection
class StackCollection<E>:AbstractMutableCollection<E>(){
    private val _items:MutableList<E> =mutableListOf<E>()
    override val size: Int
        get()=_items.size
    override fun iterator():MutableIterator<E> =_items.iterator()
    override fun add(element:E):Boolean{
        return _items.add(element=element)
    }
    fun push(element:E):Boolean{
        return add(element=element)
    }
    fun pop():E?{
        if(_items.isEmpty()){
            println("stack is empty")
            return null
        }
        return _items.removeAt(index=_items.size-1)
    }
    fun peek():E?{
        if(_items.isEmpty()){
            println("stack is empty")
            return null
        }
        return _items.last()
    }
}
fun main(){
    val stack:StackCollection<String> =StackCollection<String>()
    val letters:List<String> =listOf<String>("A", "B", "C")
    println("---adding items---")
    for(letter:String in letters){
        stack.push(element=letter)
    }
    println("size: ${stack.size}")
    println("contents: $stack")
    println("peek: ${stack.peek()}")
    println("\n----popping items---")
    repeat(times=2){
        stack.pop()
    }
    println("size: ${stack.size}")
    println("contents: $stack")
    println("\n---popping again---")
    repeat(times=2){
        stack.pop()
    }
    println("size: ${stack.size}")
    println("is empty: ${stack.isEmpty()}")
}