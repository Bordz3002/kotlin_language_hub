//An alternating iterator
class AlternatingIterator<T>(private val first:List<T>, private val second:List<T>):AbstractIterator<T>(){
    private var _index:Int=0
    private var _useFirst:Boolean=true
    override fun computeNext(){
        if(_useFirst&&_index<first.size){
            setNext(value=first[_index])
            _useFirst=false
        }else if(!_useFirst&&_index<second.size){
            setNext(value=second[_index])
            _useFirst=true
            _index++
        }else if(_index<first.size){
            setNext(value=first[_index])
            _index++
        }else{
            done()
        }
    }
}
fun main(){
    val iterator:AlternatingIterator<String> =AlternatingIterator<String>(first=listOf("a1", "a2", "a3"), second=listOf("b1", "b2", "b3"))
    while(iterator.hasNext()){
        println(iterator.next())
    }
}