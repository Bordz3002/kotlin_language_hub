//user with cached Full Name
import java.io.*
class UserObjects(val firstName:String, val lastName:String, @Transient var fullName:String=""):Serializable{
    init{
        fullName="$firstName $lastName"
    }
    fun rebuildFullName(){
        fullName="$firstName $lastName"
    }
}
fun main(){
    val user:UserObjects=UserObjects(firstName="alice", lastName="smith")
    println("before serialization")
    println("first name: ${user.firstName}")
    println("last name: ${user.lastName}")
    println("full name: ${user.fullName}")
    val file:java.io.File=File("user_cache.ser")
    ObjectOutputStream(FileOutputStream(file)).use{it.writeObject(user)}
    val restored:UserObjects=ObjectInputStream(FileInputStream(file)).use{it.readObject() as UserObjects}
    println("---after deserialization---")
    println("first name: ${restored.firstName}")
    println("last name: ${restored.lastName}")
    println("full name: ${restored.fullName}")
    restored.rebuildFullName()
    println("rebuilt full name: ${restored.fullName}")
    file.delete()
}