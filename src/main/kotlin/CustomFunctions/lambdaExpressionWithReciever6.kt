fun main(){
    val removeEmptyElements:MutableList<String>.()->Unit={
        removeAll{it.isEmpty()}
    }
    val dogs:MutableList<String> =mutableListOf("browny","","whitey", "","doggie")
    dogs.removeEmptyElements()
    println(dogs)
}