import java.time.Year
fun main(){
    val birthYear:Int=2003
    var currentAge:Int=Year.now().value-birthYear
    val height:Double=1.76
    var favoriteColor:String="gray"
    var middleName:String?=null
    println("--- My Info ---")
    println("Birth Year: $birthYear")
    println("Current Age: $currentAge")
    println("Height: $height meters")
    println("Favorite color: $favoriteColor")
    println("--- Null Safety ---")
    println("Middle name length: ${middleName?.length?:0}")
    println("Do i have a middle name: ${if(middleName!=null) "Yes" else "No"}")
    println("--- Type Conversions ---")
    println("Height as Float: ${height.toInt().toFloat()}")
}