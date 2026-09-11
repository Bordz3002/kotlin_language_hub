data object AppConfig{
    var AppName:String="my application"
    var version:String="1.0.0"
}
fun main(){
    with(AppConfig){
        println(this)
        println("$AppName:$version")
    }
}