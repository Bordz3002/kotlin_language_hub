//A simple countdown iterator
class CountdownIterator(private val start:Int):AbstractIterator<Int>(){
    private var _current:Int=start
    override fun computeNext(){
        if(_current<0){
            done()
        }else{
            setNext(value=_current)
            _current--
        }
    }
}
fun main(){
    val iterator:CountdownIterator=CountdownIterator(start=5)
    while(iterator.hasNext()){
        println(iterator.next())
    }
}