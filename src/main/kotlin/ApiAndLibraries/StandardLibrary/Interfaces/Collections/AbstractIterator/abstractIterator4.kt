//A repeat iterator
class RepeatIterator<T>(private val value:T, private val times:Int):AbstractIterator<T>(){
    private var _count:Int=0
    override fun computeNext(){
        if(_count>=times){
            done()
        }else{
            setNext(value)
            _count++
        }
    }
}
fun main(){
    val iterator:RepeatIterator<String> =RepeatIterator<String>(value="hello", times=3)
    while(iterator.hasNext()){
        println(iterator.next())
    }
}