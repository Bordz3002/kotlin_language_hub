//a collection with size limit and automatic eviction
class BoundedQueue<E>(private val maxSize:Int):AbstractMutableCollection<E>(){
    private val _items:MutableList<E> =mutableListOf<E>()
    override val size:Int
        get()=_items.size
    override fun iterator():MutableIterator<E> =_items.iterator()
    override fun add(element:E):Boolean{
        if(_items.size>=maxSize){
            val removed:E=_items.removeAt(index=0)
            println("evicted: $removed (queue full)")
        }
        return _items.add(element=element)
    }
    fun getItems():List<E> =_items.toList()
}
fun main(){
    val queue:BoundedQueue<String> =BoundedQueue<String>(maxSize=3)
    val letters:List<String> =listOf<String>("A", "B", "C")
    println("---adding items (max size: 3)---")
    for(letter:String in letters){
        queue.add(element=letter)
    }
    println("contents: $queue")
    println("\n---adding more (eviction starts)---")
    queue.add(element="D")
    println("contents: $queue")
    queue.add(element="E")
    println("contents: $queue")
    queue.add(element="F")
    println("contents: $queue")
    println("\nfinal size: ${queue.size}")
    println("final contents: $queue")
}