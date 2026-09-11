//processing mixed data
fun processData(expectedList:List<Any?>):Map<String,Any>{
    val nonNull=expectedList.filterNotNull() //remove nulls
    val strings=nonNull.filterIsInstance<String>() //extract strings
    val numbers=nonNull.filterIsInstance<Int>() //extract numbers
    val maxNumber=numbers.maxOrNull()?:0 //find max number safely
    val combined=strings.joinToString(" ")
    return mapOf(
        "maxNumber" to maxNumber,
        "combinedText" to combined
    )
}
fun main(){
    val data =listOf("hello",null,"world",42,null,99,true,"kotlin")
    val result=processData(data)
    println("max number: ${result["maxNumber"]}")
    println("combined text: ${result["combinedText"]}")
}