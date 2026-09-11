interface SoundMaker{
    fun makeSound()
}
class Phone:SoundMaker{
    override fun makeSound() {
        println("beeeeep")
    }
}
class MorseRadio:SoundMaker{
    override fun makeSound(){
        println("bop booop bop")
    }
}
fun main(){
    val phone=Phone()
    val radio=MorseRadio()
    with(phone){
        makeSound()
    }
    with(radio){
        makeSound()
    }
}