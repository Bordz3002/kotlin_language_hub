//multiple targets

//define annotation that can be used on classes and functions
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class ApiVersion(val version:String)

//correct: used on a class
@ApiVersion("1.0")
class End{
    //correct: used on a function
    @ApiVersion("2.0")
    fun update(){
        println("updating end")
    }

    //incorrect: used on a property
    //@ApiVersion("1.5")
    //val name:String="john"
}