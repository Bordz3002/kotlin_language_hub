val Int.isEven: Boolean
    get()=this%2==0
val Int.isPositive: Boolean
    get()=this>0
val Int.squared: Int
    get()=this*this
fun main(){
    val num1:Int=4
    val num2:Int=-3
    println(num1.isEven)
    println(num1.isPositive)
    println(num1.squared)

    println(num2.isEven)
    println(num2.isPositive)
}