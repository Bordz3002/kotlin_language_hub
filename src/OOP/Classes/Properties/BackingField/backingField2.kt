class Users{
    var email:String=""
        set(value){
            if(value.contains("@")&&value.contains(".")){
                field=value.lowercase()
            }else{
                println("invalid email: '$value' not store")
            }
        }
}
fun main(){
    val user=Users()
    user.email="test@email.com"
    println(user.email)
    user.email="invalid.email"
    println(user.email)
}