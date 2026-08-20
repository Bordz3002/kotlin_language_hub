class Chicken{
    companion object{
        val animalFamily:String="bird"
        fun describe(){
            println("chicken goes bakaaak")
        }
    }
}
fun main(){
    //members inside the companion object
    //of the Chicken class cannot be accessed to
    //it's instance
    //but rather call the Class directly to
    //access it's companion object
    //example: val chicken=Chicken(), the chicken property cannot access
    //the companion object since its an instance
    with(Chicken){
        println(animalFamily)
        describe()
    }
}