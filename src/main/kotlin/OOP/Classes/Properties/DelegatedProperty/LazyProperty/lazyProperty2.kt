val expensiveNumber:Int by lazy{
    println("doing heavy calculation...")
    Thread.sleep(1000)
    42
}
fun main(){
    println("program started")
    println("first access: $expensiveNumber") //first access: takes 1 second
    println("second access: $expensiveNumber") //second access: instant. (uses cached value)
}