//a cycling list
class CyclingList<out E>(private val original:List<E>):AbstractList<E>(){
    override val size: Int
        get()=Int.MAX_VALUE
    override fun get(index:Int):E{
        return original[index%original.size]
    }
}
fun main(){
    val list:CyclingList<String> =CyclingList<String>(original=listOf<String>("A", "B", "C"))
    println("size conceptually infinite: ${list.size}")
    println("first 9 items:")
    for(i:Int in 0 until 9){
        println("index $i: ${list[i]}")
    }

}