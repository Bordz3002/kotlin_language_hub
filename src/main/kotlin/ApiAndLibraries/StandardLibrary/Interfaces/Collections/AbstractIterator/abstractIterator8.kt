//a unique iterator (distinct)
class UniqueIterator<T>(private val items:List<T>):AbstractIterator<T>(){
    private val _seen:MutableSet<T> =mutableSetOf<T>()
    private var _index:Int=0
    override fun computeNext(){
        while(_index<items.size){
            val item:T=items[_index]
            _index++
            if(_seen.add(element=item)){
                setNext(value=item)
                return
            }
        }
        done()
    }
}
fun main(){
    val iterator:UniqueIterator<Int> =UniqueIterator<Int>(items=listOf(1, 2, 2, 3, 3, 3, 4, 4, 4, 4 ))
    while(iterator.hasNext()){
        println(iterator.next())
    }
}