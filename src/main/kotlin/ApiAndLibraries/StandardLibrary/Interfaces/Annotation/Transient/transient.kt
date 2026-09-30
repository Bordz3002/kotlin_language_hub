//user with password
import java.io.*
class UserObject(val username:String, @Transient val password:String=""): Serializable
fun main(){
    val user:UserObject=UserObject(username="alice", password="secret123")
    //serialize to file
    val file:java.io.File=File("user.ser")
    ObjectOutputStream(FileOutputStream(file)).use{it.writeObject(user)}
    //deserialize from file
    val restored:UserObject=ObjectInputStream(FileInputStream(file)).use{it.readObject() as UserObject}
    println("original: username=${user.username}, password=${user.password}")
    println("restored: username=${restored.username}, password=${restored.password}")
}