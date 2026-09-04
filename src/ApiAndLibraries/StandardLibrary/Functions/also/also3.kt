//initialization and configuration
data class Employee(var name:String, var age:Int, var city:String)
fun createEmployee(name:String):Employee{
    return Employee(name, 0, "unknown").also{
        it.age=25
        it.city="new york"
        println("employee configured; ${it.name}, ${it.age}, ${it.city}")
    }
}
fun main(){
    val employee:Employee=createEmployee("bob")
    println("returned: $employee")
}