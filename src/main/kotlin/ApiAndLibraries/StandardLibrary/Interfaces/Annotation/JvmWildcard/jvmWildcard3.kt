//using real inheritance relationship so the wildcard makes more sense
open class AnimalClass(val name:String)
class DogClass(name:String):AnimalClass(name)
fun showAnimals(animals:List<@JvmWildcard AnimalClass>){
    for(animal in animals){
        println(animal.name)
    }
}
fun main(){
    val dogs:List<DogClass> =listOf(DogClass(name="buddy"), DogClass(name="max"))
    showAnimals(dogs)
}