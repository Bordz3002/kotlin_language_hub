//this function returns only elements of specific type and cast them automatically
fun main(){
    val mixed:List<Any> =listOf("kotlin",42,"java",true,"scala",3.14)
    val strings:List<String> =mixed.filterIsInstance<String>()
    val numbers:List<Int> =mixed.filterIsInstance<Int>()
    println(strings) //returns [kotlin,java,scala]
    println(numbers) //returns [42]
}