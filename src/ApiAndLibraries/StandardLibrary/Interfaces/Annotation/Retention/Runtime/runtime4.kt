//annotation with multiple properties
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class RobotInfo(val model:String, val version:Int)
@RobotInfo("rx-7", 2)
class FieldRobot
fun main(){
    val info=FieldRobot::class.java.getAnnotation(RobotInfo::class.java)
    println("model: ${info.model}")
    println("version: ${info.version}")
}