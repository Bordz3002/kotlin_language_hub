//a queue (FIFO) collection
class QueueCollection<E>:AbstractMutableCollection<E>(){
    private val _items:MutableList<E> =mutableListOf<E>()
    override val size: Int
        get()=_items.size
    override fun iterator():MutableIterator<E> =_items.iterator()
    override fun add(element:E):Boolean{
        return _items.add(element=element)
    }
    fun enqueue(element:E):Boolean{
        return add(element=element)
    }
    fun dequeue():E?{
        if(_items.isEmpty()){
            println("queue is empty")
            return null
        }
        return _items.removeAt(index=0)
    }
    fun peek():E?{
        if(_items.isEmpty()){
            println("queue is empty")
            return null
        }
        return _items.first()
    }
}
fun main(){
    val queue:QueueCollection<String> =QueueCollection<String>()
    val letters:List<String> =listOf<String>("A", "B", "C")
    println("---enqueueing items---")
    for(letter:String in letters){
        queue.enqueue(element=letter)
    }
    println("size: ${queue.size}")
    println("contents: $queue")
    println("peek: ${queue.peek()}")
    println("\n---dequeuing items---")
    repeat(times=2){
        println("dequeue: ${queue.dequeue()}")
    }
    println("size: ${queue.size}")
    println("contents: $queue")
    println("\n---dequeuing again---")
    repeat(times=2){
        println("dequeue: ${queue.dequeue()}")
    }
    println("size: ${queue.size}")
    println("is empty: ${queue.isEmpty()}")
}