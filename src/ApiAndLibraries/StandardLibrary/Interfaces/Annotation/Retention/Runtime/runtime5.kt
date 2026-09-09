//using annotation on a function
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class Command(val name:String)
class Controller{
    @Command("start")
    fun startEngine(){
        println("engine started")
    }
    @Command("stop")
    fun stopEngine(){
        println("engine stoppped")
    }
}
fun main(){
    val methods=Controller::class.java.declaredMethods
    for(method in methods){
        val command=method.getAnnotation(Command::class.java)
        if(command!=null){
            println("${method.name} -> ${command.name}")
        }
    }
}