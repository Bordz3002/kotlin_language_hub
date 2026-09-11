//example1 - lambda expression
val capitalizeString = {text:String -> text.uppercase()}

//example2 - pass a lambda expression to a function
val numbers:List<Int> = listOf(1, -23, 7, 10, -3, -9)
val positiveNumbers:List<Int> = numbers.filter{number -> number>0}
val negativeNumbers:List<Int> = numbers.filter{number:Int -> number<0}

//example3- pass a lambda function to map function
//using the numbers list above
val doubled=numbers.map{number:Int->number*2}
val tripled=numbers.map{number:Int->number*3}

fun main(args:Array<String>){
    println(capitalizeString("linkin park"))
    println("positive numbers: $positiveNumbers")
    println("negative numbers: $negativeNumbers")
    println("doubled: $doubled")
    println("tripled: $tripled")
}