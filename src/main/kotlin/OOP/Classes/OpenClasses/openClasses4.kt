open class Human(val expectHumanName:String){
    fun introduce(){
        println("Human's name is:${expectHumanName.uppercase()}")
    }
}
class Student(expectStudentName:String, val expectCourse:String):Human(expectStudentName)
fun main(){
    val student=Student("naval", "computer science")
    with(student){
        introduce()
        println("student course: $expectCourse")
    }
}