//a mutable list
open class SpeciesObject(val name:String)
class HumanObject(name:String):SpeciesObject(name)
fun addSpecies(species:MutableList<@JvmWildcard SpeciesObject>){
    species.add(HumanObject(name="naval"))
}