fun main(){
    val numbers:List<Int> =listOf(1,2,3,4,5)
    val duplicates:List<Int> =listOf(1,2,2,3)
    println(numbers.singleOrNull{it>4}) //finds the single number greater than 4 (passed lambda expression)
    println(numbers.singleOrNull{it>5}) //no single number greater than 5. returns 'null'
    println(numbers.singleOrNull{it>2}) //multiple numbers greater than 2. returns 'null'
}