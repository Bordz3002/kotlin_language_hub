//removes all null elements from a collection
fun main(){
    val mixed:List<String?> =listOf("kotlin", null, "java", null, "scala")
    val nonNull:List<String> =mixed.filterNotNull()
    println(mixed)
    println(nonNull)
}