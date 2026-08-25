enum class WeatherStatus(val expectTemperature:Int){
    SUNNY(30),
    RAINY(18),
    CLOUDY(22),
    SNOWY(-5)
}
fun main(){
    val weatherStatusToday=WeatherStatus.SUNNY
    println("today is $weatherStatusToday and its ${weatherStatusToday.expectTemperature}C")
}