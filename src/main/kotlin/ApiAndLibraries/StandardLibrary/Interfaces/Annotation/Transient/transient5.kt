//employee wth sensitive data
import java.io.*
class EmployeeObject(
    val id:Int,
    val name:String,
    val department:String,
    val salary:Double,
    @Transient val socialSecurityNumber:String="",
    @Transient val bankAccount:String=""
):Serializable
fun main(){
    val employee:EmployeeObject=EmployeeObject(
        id=1001,
        name="alice johnson",
        department="engineering",
        salary=85000.0,
        socialSecurityNumber="123-45-6789",
        bankAccount="acc-987654321"
    )
    println("---before serialization---")
    println("ID: ${employee.id}")
    println("name: ${employee.name}")
    println("department: ${employee.department}")
    println("salary: ${employee.salary}")
    println("ssn: ${employee.socialSecurityNumber}")
    println("bank account: ${employee.bankAccount}")
    val file:java.io.File=File("employee.ser")
    ObjectOutputStream(FileOutputStream(file)).use{it.writeObject(employee)}
    val restored:EmployeeObject=ObjectInputStream(FileInputStream(file)).use{it.readObject() as EmployeeObject}
    println("\n")
    println("---after deserialization---")
    println("id: ${restored.id}")
    println("name: ${restored.name}")
    println("department: ${restored.department}")
    println("salary: ${restored.salary}")
    println("ssn: ${restored.socialSecurityNumber}")
    println("bank account: ${restored.bankAccount}")
}