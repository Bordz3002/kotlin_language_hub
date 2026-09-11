sealed class GameState
class Playing:GameState()
class Paused:GameState()
class GameOver:GameState()
fun showGameState(expectGameState:GameState):String{
    when(expectGameState){
        is Playing->return "Game is running"
        is Paused->return "Game is paused"
        is GameOver->return "Game over"
    }
}
fun main(){
    val play=Playing()
    val paused=Paused()
    val over=GameOver()
    println(showGameState(play))
    println(showGameState(paused))
    println(showGameState(over))
}