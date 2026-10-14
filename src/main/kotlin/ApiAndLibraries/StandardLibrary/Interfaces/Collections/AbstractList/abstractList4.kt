//a filtered list
class FilteredList<out TYPE>(original:List<TYPE>, predicate:(TYPE)->Boolean):AbstractList<TYPE>(){
    private val filtered:List<TYPE> =original.filter(predicate)
    override val size: Int
        get()=filtered.size
    override fun get(index:Int):TYPE{
        if(index !in 0 until size){
            throw IndexOutOfBoundsException("index: $index, size: $size")
        }
        return filtered[index]
    }
}
fun main(){
    val list:FilteredList<Int> =FilteredList<Int>(original=listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)){it%2==0}
    println("size: ${list.size}")
    println("first: ${list[0]}")
    println("last: ${list[list.size-1]}")
    println("contains 4: ${list.contains(element=4)}")
    println("contains 5: ${list.contains(element=5)}")
    println("index of 6: ${list.indexOf(element=6)}")
    println("contents: $list")
    for(number:Int in list){
        println("even number: $number")
    }
}