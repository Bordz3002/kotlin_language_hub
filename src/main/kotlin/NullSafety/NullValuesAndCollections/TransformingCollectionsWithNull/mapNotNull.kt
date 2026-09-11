//transforms each element and filters out 'null' results
fun main(){
    val numbers:List<Int> =listOf(1,2,3,4,5)
    val result=numbers.mapNotNull{if(it%2==0) null else it*10}
    println(result)
}