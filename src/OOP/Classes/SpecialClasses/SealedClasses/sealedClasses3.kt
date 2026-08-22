sealed class Weather
class Sunny:Weather()
class Rainy:Weather()
class Cloudy:Weather()
fun describeWeather(weather:Weather):String{
    when(weather){
        is Sunny->return "the sun is shining"
        is Rainy->return "it is raining"
        is Cloudy->return "the sky is cloudy"
    }
}
fun main(){
    val sunny=Sunny()
    val rainy=Rainy()
    val cloudy=Cloudy()
    println(describeWeather(sunny))
    println(describeWeather(rainy))
    println(describeWeather(cloudy))
}