sealed class GameStatus
class InSession(val expectScore:Int):GameStatus()
class PausedSession(val expectReason:String):GameStatus()
class Over(val expectFinalScore:Int):GameStatus()
fun getStatus(expectGameStatusObject:GameStatus):String{
    when(expectGameStatusObject){
        is InSession->return "playing - current score: ${expectGameStatusObject.expectScore}"
        is PausedSession->return "game paused. reason: ${expectGameStatusObject.expectReason}"
        is Over->return "game over, final score: ${expectGameStatusObject.expectFinalScore}"
    }
}
fun main(){
    val playing=InSession(89)
    val paused=PausedSession("away from keyboard")
    val gameOver=Over(92)
    println(getStatus(playing))
    println(getStatus(paused))
    println(getStatus(gameOver))
}