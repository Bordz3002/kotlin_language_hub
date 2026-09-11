sealed class NetworkResult{
    object Loading:NetworkResult()
    data class Success(val data:String):NetworkResult()
    data class Error(val message:String, val code:Int):NetworkResult()
}
fun handleApiResponse(result:NetworkResult){
    when(result){
        NetworkResult.Loading->println("loading... Please wait")
        is NetworkResult.Success->println("data received:${result.data}")
        is NetworkResult.Error->println("error ${result.code}: ${result.message}")
    }
}
fun fetchDataFromServer():NetworkResult{
    val random=(1..3).random()
    return when(random){
        1->NetworkResult.Loading
        2->NetworkResult.Success("user data loaded successfully")
        else->NetworkResult.Error("network timeout", 504)
    }
}
fun main(){
    handleApiResponse(fetchDataFromServer())
}