//one annotation, multiple targets
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
annotation class CanLog
@CanLog
class WeatherCamp{
    fun readTemperature(){
        println("temperature: 30C")
    }
}
class IrrigationSystem{
    @CanLog
    fun startPump(){
        println("pump started")
    }
}