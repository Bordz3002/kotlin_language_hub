@JvmInline
value class Temperature(val value:Double){
    init{require(value>=-273.15){"temperature cannot be below absolute zero"}}
    fun toFahrenheit():Double=value*9/5+32
    fun toKelvin():Double=value+273.15
    fun isFreezing():Boolean=value<=0
    fun isBoiling():Boolean=value>=100
}
fun main(){
    val roomTemp=Temperature(22.5)
    val freezing=Temperature(0.0)
    val boiling=Temperature(100.0)
    println("room: ${roomTemp.value}C")
    println("room in fahrenheit: ${roomTemp.toFahrenheit()}F")
    println("room in kelvin: ${roomTemp.toKelvin()}K")
    println("is the room freezing?: ${roomTemp.isFreezing()}")
    println("\n ---comparison---")
    println("water freezes at: ${freezing.value}C")
    println("water boils at: ${boiling.value}C")
}