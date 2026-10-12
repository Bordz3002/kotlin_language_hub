//a take-while iterator
class TakeWhileIterator<T>(private val items:List<T>, private val predicate:(T)->Boolean):AbstractIterator<T>(){
    private var _index:Int=0
    override fun computeNext(){
        if(_index >items.size){
            done()
            return
        }
        val item:T=items[_index]
        _index++
        if(predicate(item)){
            setNext(value=item)
        }else{
            done()
        }
    }
}
fun main(){
    println("--- take numbers < 5 ---")
    val smallNumbers:TakeWhileIterator<Int> =TakeWhileIterator<Int>(items=listOf(1, 2, 3, 4, 5, 6, 7, 8)){it<5}
    while(smallNumbers.hasNext()){
        println(smallNumbers.next())
    }
    println("\n---- take words shorter than 5 letters ----")
    val shortWords:TakeWhileIterator<String> =TakeWhileIterator<String>(items=listOf("hi", "hello", "world", "kotlin")){it.length<5}
    while(shortWords.hasNext()){
        println(shortWords.next())
    }
}