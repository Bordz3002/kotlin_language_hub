//a cycle iterator
class CycleIterator<T>(private val items:List<T>):AbstractIterator<T>(){
    private var _index:Int=0
    override fun computeNext(){
        if(items.isEmpty()){
            done()
            return
        }
        setNext(value=items[_index])
        _index=(_index+1)%items.size
    }
}
fun main(){
    val iterator:CycleIterator<String> =CycleIterator<String>(items=listOf("A", "B", "C"))
    repeat(times=7){
        println(iterator.next())
    }
}