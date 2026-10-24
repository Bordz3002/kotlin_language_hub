//a fixed-size mutable list
class FixedSizeList<E>(private val maxSize:Int):AbstractMutableList<E>(){
    private val _items:MutableList<E?> =MutableList<E?>(maxSize){null}
    private var _count:Int=0
    override val size: Int
        get()=_count
    override fun get(index:Int):E{
        if(index !in 0 until _count){
            throw IndexOutOfBoundsException("index: $index, size: $size")
        }
        @Suppress("UNCHECKED_CAST")
        return _items[index] as E
    }
    override fun add(index:Int, element:E){
        if(_count>=maxSize){
            println("cannot add - list is full (max: $maxSize)")
            return
        }
        if(index !in 0.._count){
            throw IndexOutOfBoundsException("index: $index, size: $size")
        }
        for(i:Int in _count downTo index+1){
            _items[i]=_items[i-1]
        }
        _items[index]=element
        _count++
    }
    override fun removeAt(index:Int):E{
        if(index !in 0 until _count){
            throw IndexOutOfBoundsException("index: $index, size: $size")
        }
        @Suppress("UNCHECKED_CAST")
        val removed:E=_items[index] as E
        for(i:Int in index until _count-1){
            _items[i]=_items[i+1]
        }
        _items[_count-1]=null
        _count--
        return removed
    }
    override fun set(index:Int, element:E):E{
        if(index !in 0 until _count){
            throw IndexOutOfBoundsException("index: $index, size: $size")
        }
        @Suppress("UNCHECKED_CAST")
        val old:E=_items[index] as E
        _items[index]=element
        return old
    }
}
fun main(){
    val list:FixedSizeList<String> =FixedSizeList<String>(maxSize=3)
    val letters:List<String> =listOf<String>("A", "B", "C")
    println("max size: 3")
    println("\nadding items")
    for(letter:String in letters){
        list.add(element=letter)
    }
    println("contents: $list")
    println("\ntrying to add beyond limit")
    list.add(element="D")
    println("\nsetting an item")
    list[1]="B2"
    println("contents: $list")
    println("\nremoving an item")
    list.removeAt(index=0)
    println("contents: $list")
    println("\nadding again")
    list.add(element="D")
    println("contents: $list")
}