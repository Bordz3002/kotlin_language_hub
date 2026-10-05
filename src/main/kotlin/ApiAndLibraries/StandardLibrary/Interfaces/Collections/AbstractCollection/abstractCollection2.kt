//A range collection
class NumberRange(private val start:Int, private val end:Int):AbstractCollection<Int>(){
    override val size: Int
        get()=if(end>=start) end-start+1 else 0
    override fun iterator():Iterator<Int> =object:Iterator<Int>{
        private var current=start
        override fun hasNext():Boolean=current<=end
        override fun next():Int{
            if(!hasNext()) throw NoSuchElementException()
            return current++
        }
    }
}
fun main(){
    val range:NumberRange=NumberRange(start=1, end=5)
    println("size: ${range.size}")
    println("is empty: ${range.isEmpty()}")
    println("contains 3: ${range.contains(element=3)}")
    println("contains 10: ${range.contains(element=10)}")
    println("contents: $range")
    for(number:Int in range){
        println("number: $number")
    }
}