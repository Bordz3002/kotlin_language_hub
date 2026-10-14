//a mapped list
class MappedList<out TYPE1, out TYPE2>(private val original:List<TYPE1>, private val transform:(TYPE1)->TYPE2):AbstractList<TYPE2>(){
    override val size: Int
        get()=original.size
    override fun get(index:Int):TYPE2{
        if(index !in 0 until size){
            throw IndexOutOfBoundsException("index: $index, size: $size")
        }
        return transform(original[index])
    }
}
fun main(){
    val list:List<Int> =listOf(1, 2, 3, 4, 5)
    val doubled:MappedList<Int, Int> =MappedList(original=list){it*2}
    println("original: $numbers")
    println("mapped: $doubled")
    println("size: ${doubled.size}")
    println("first: ${doubled[0]}")
    println("last: ${doubled[doubled.size-1]}")
    println("contains 6: ${doubled.contains(element=6)}")
    println("contains 7: ${doubled.contains(element=7)}")
    println("index of 8: ${doubled.indexOf(element=8)}")
    for(number:Int in doubled){
        println("number: $number")
    }
}