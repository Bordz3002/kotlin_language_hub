class Airplane{
    fun fly(){
        println("airplane has taken off")
    }
    companion object{
        val wheels:Int=6
        fun getInfo():String{
            return "airplane can have wheels up to $wheels wheels but is built to fly"
        }
    }
}
fun main(){
    //airplane is an instance of the Airplane class
    val airplane=Airplane()
    airplane.fly()
    //calling the Airplane class directly to access companion object
    with(Airplane.Companion){
        println(wheels)
        println(getInfo())
    }
}