object WeatherStation{
    var temperature:Int=30
    fun showTemperature(){
        println("temperature: $temperature")
    }
}
fun main(){
    WeatherStation.showTemperature()
    WeatherStation.temperature=100
    WeatherStation.showTemperature()
}