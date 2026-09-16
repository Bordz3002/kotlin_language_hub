//with vs without wildcard
open class AnimalObject(val name:String)
class DogObject(name:String):AnimalObject(name)
fun showAnimals(animals:List<AnimalObject>){
    for(animal:AnimalObject in animals){
        println(animal.name)
    }
}
fun showAnimalsWithWildcard(animals:List<@JvmWildcard AnimalObject>){
    for(animal:AnimalObject in animals){
        println(animal.name)
    }
}
fun main(){
    val dogsList:List<AnimalObject> =listOf(DogObject(name="brownuy"), DogObject(name="whitey"))
    for(dog:AnimalObject in dogsList){
        println(dog.name)
    }
}