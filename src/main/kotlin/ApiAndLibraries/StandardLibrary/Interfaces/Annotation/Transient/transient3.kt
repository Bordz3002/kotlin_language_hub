//game character with transient state
import java.io.*
class GameCharacter(
    val name:String,
    val health:Int,
    val level:Int,
    @Transient var isOnline:Boolean=false,
    @Transient var currentSession:String=""
):Serializable{}
fun main(){
    val hero:GameCharacter=GameCharacter(
        name="aragon",
        health=100,
        level=25
    )
    hero.isOnline=true
    hero.currentSession="session-abc-123"
    println("---before serialization---")
    println("name: ${hero.name}")
    println("health: ${hero.health}")
    println("level: ${hero.level}")
    println("is online: ${hero.isOnline}")
    println("session: ${hero.currentSession}")
    val file:java.io.File=File("character.ser")
    ObjectOutputStream(FileOutputStream(file)).use{it.writeObject(hero)}
    val restored:GameCharacter=ObjectInputStream(FileInputStream(file)).use{it.readObject() as GameCharacter}
    println("---after deserialization---")
    println("name: ${restored.name}")
    println("health: ${restored.health}")
    println("level: ${restored.level}")
    println("is Online: ${restored.isOnline}")
    println("session: ${restored.currentSession}")
}