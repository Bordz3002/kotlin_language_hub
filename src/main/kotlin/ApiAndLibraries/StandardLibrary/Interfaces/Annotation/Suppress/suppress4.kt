//suppressing unchecked cast warning
@Suppress("UNCHECKED_CAST")
fun <T> castList(list:List<*>):List<T>{
    return list as List<T>
}

fun main(){
    val strings:List<String> =castList<String>(listOf("A", "B", "C"))
    println(strings)
}