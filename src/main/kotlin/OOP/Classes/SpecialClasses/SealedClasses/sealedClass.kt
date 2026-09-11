sealed class Earthlings
class Male:Earthlings()
class Female:Earthlings()
fun describeHuman(human:Earthlings){
    when(human){
        is Male->println("human is male")
        is Female->println("human is female")
    }
}
fun main(){
    val male=Male()
    val female=Female()
    describeHuman(male)
    describeHuman(female)
}