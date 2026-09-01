//creates a list while ignoring null values at creation time
fun main(){
    val list =listOfNotNull("kotlin", null, "java", null, "scala")
    println(list)
}