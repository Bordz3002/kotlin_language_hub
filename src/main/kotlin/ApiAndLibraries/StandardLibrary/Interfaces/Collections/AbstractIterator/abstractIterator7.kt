//A chunked iterator
class ChunkedIterator<T>(private val items:List<T>, private val  chunkSize:Int):AbstractIterator<List<T>>(){
    private var _index:Int=0
    override fun computeNext(){
        if(_index>=items.size){
            done()
        }else{
            val end:Int=minOf(a=_index+chunkSize, b=items.size)
            setNext(value=items.subList(fromIndex=_index, toIndex=end))
            _index=end
        }
    }
}
fun main(){
    val iterator:ChunkedIterator<Int> =ChunkedIterator(items=listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), chunkSize=3)
    while(iterator.hasNext()){
        println(iterator.next())
    }
}