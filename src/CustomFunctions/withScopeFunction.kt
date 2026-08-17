/*with(subject){"im working with subject here} */
class Music{
    var genre:String=""
    var songName:String=""
    var year:Int=0
}
fun main(){
    val rap=Music()
    with(rap){
        genre="rap"
        songName="rap god"
        year=2003
    }
    println("genre:${rap.genre}, songName:${rap.songName}, year:${rap.year}")
}