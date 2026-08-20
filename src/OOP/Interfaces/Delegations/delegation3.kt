interface Logger{
    fun log(expectMessage:String)
}
class FileLogger:Logger{
    override fun log(expectMessage:String){
        println("saving to file: $expectMessage")
    }
}
class Application(expectFileLoggerObject:FileLogger):Logger by expectFileLoggerObject
fun main(){
    val fileLogger= FileLogger()
    val app=Application(fileLogger)
    with(app){
        log("goodbye")
    }
}