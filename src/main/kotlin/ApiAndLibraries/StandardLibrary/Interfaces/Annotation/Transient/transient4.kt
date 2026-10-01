//configuration with cached values
import java.io.*
import kotlin.math.PI
class CircleConfig(
    val radius:Double,
    @Transient var area:Double=0.0,
    @Transient var circumference:Double=0.0
):Serializable{
    init{
        recalculate()
    }
    fun recalculate(){
        area=PI*radius*radius
        circumference=2*PI*radius
    }
}
fun main(){
    val config:CircleConfig=CircleConfig(radius=5.0)
    println("---before serialization---")
    println("radius: ${config.radius}")
    println("area: ${"%.2f".format(config.area)}")
    println("circumference: ${"%.2f".format(config.circumference)}")
    val file:java.io.File=File("circle.ser")
    ObjectOutputStream(FileOutputStream(file)).use{it.writeObject(config)}
    val restored:CircleConfig=ObjectInputStream(FileInputStream(file)).use{it.readObject() as CircleConfig}
    println("---after deserialization---")
    println("radius: ${restored.radius}")
    println("area: ${"%.2f".format(restored.area)}")
    println("circumference: ${"%.2f".format(restored.circumference)}")
    restored.recalculate()
    println("---after recalculation---")
    println("area: ${"%.2f".format(restored.area)}")
    println("circumference: ${"%.2f".format(restored.circumference)}")
}