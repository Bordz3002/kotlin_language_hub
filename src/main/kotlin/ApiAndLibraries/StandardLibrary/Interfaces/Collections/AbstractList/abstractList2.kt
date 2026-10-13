//a range list
class RangeList(private val start:Int, private val end:Int):AbstractList<Int>(){
    override val size: Int
        get()=if(end>=start) end-start+1 else 0
    override fun get(index:Int):Int{
        if(index !in 0 until size){
            throw IndexOutOfBoundsException("index: $index, size: $size")
        }
        return start+index
    }
}
fun main(){
    val list:RangeList=RangeList(start=1, end=5)
    println("size: ${list.size}")
    println("is empty: ${list.isEmpty()}")
    println("first: ${list[0]}")
    println("last: ${list[list.size-1]}")
    println("contain 3: ${list.contains(element=3)}")
    println("contains 10: ${list.contains(element=10)}")
    println("index of 4: ${list.indexOf(element=4)}")
    println("contents: $list")
    for(number:Int in list){
        println("number: $number")
    }
}