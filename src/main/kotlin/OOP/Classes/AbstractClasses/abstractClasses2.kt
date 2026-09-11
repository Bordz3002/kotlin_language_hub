abstract class Animal{
    abstract val name: String
    abstract fun makeSound()
}
class Dog:Animal(){
    override val name:String="browny"
    override fun makeSound() {
        println("arf arf arf")
    }
}
fun main(){
    val dog=Dog()
    with(dog){
        println(name)
        makeSound()
    }
}