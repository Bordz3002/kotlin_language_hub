//basic example
class FarmController{
    fun startSystem(){
        println("system started")
    }
    @JvmSynthetic //this function is inaccessible/hidden in the java code.
    fun calculateInternalValue(){
        println("internal calculation")
    }
}
fun main(){
    val controller:FarmController=FarmController()
    controller.startSystem()
    controller.calculateInternalValue()
}