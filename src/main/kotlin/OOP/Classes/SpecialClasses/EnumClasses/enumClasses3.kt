enum class HttpStatus(val expectCode:Int, val expectDescription:String){
    OK(200, "success"),
    CREATED(201, "created"),
    BAD_REQUEST(400, "bad request"),
    UNAUTHORIZED(401, "unauthorized"),
    NOT_FOUND(404, "not found"),
    SERVER_ERROR(500, "server error")
}
fun getStatusMessage(expectHttpStatusObj:HttpStatus):String{
    return when(expectHttpStatusObj){
        HttpStatus.OK->"data loaded successfully"
        HttpStatus.CREATED->"new record created"
        HttpStatus.BAD_REQUEST->"please check your input"
        HttpStatus.UNAUTHORIZED->"please login first"
        HttpStatus.NOT_FOUND->"the data doesnt exist"
        HttpStatus.SERVER_ERROR->"our team is working a fix to it"
    }
}
fun main(){
    val apiResponse:HttpStatus=HttpStatus.OK
    println("code: ${apiResponse.expectCode}")
    println("description: ${apiResponse.expectDescription}")
    println("message: ${getStatusMessage(apiResponse)}")
}