object GameSettings{
    var volume:Int=50
    var difficulty:String="Normal"
    fun showSettings(){
        println("volume: $volume")
        println("difficulty: $difficulty")
    }
}
fun main(){
    GameSettings.showSettings()
    GameSettings.volume=80
    GameSettings.difficulty="Hard"
    GameSettings.showSettings()
}