//example1 - lambda expression
val capitalizeString = {text:String -> text.uppercase()}

//example2 - pass a lambda expression to a function
val numbers:List<Int> = listOf(1, -23, 7, 10, -3, -9)
val positiveNumbers:List<Int> = numbers.filter({number -> number>0})
val negativeNumbers:List<Int> = numbers.filter({number:Int -> number<0})

fun main(args:Array<String>){
    println(capitalizeString("linkin park"))
    println("positive numbers: ${positiveNumbers}")
    println("negative numbers: ${negativeNumbers}")
}