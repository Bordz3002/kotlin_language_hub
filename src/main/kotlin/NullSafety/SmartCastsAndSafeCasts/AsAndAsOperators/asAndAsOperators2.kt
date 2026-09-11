//using 'as' (when you're sure)
fun main(){
    val numbers:Any=listOf(1,2,3)
    val list=numbers as List<*>
    println(list.size)
}