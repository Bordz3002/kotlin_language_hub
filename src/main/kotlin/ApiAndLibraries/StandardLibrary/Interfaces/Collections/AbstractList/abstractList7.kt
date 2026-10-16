//a sliding window list
class WindowList<out E>(private val original:List<E>, private val  windowSize:Int):AbstractList<List<E>>(){
    init{
        require(value=windowSize>0){"window size must be positive"}
    }
    override val size: Int
        get()=if(original.size<windowSize) 0 else original.size-windowSize+1
    override fun get(index:Int):List<E>{
        if(index !in 0 until size){
            throw IndexOutOfBoundsException("index: $index, size: $size")
        }
        return original.subList(fromIndex=index, toIndex=index+windowSize)
    }
}
fun main(){
    val original:List<Int> =listOf<Int>(1, 2, 3, 4, 5)
    val windows:WindowList<Int> =WindowList<Int>(original=original, windowSize=3)
    println("original: $original")
    println("window size: 3")
    println("number of windows: ${windows.size}")
    for(window:List<Int> in windows){
        println("window: $window")
    }
}