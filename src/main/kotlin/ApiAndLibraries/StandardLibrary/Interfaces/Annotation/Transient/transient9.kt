//student record with temporary grades
import java.io.*
class StudentRecord(
    val studentId:String,
    val name:String,
    val semester:String,
    val finalGrades:MutableMap<String, Double> =mutableMapOf<String, Double>(),
    @Transient var draftGrades:MutableMap<String, Double> =mutableMapOf<String, Double>(),
    @Transient var isEditing:Boolean=false,
    @Transient var lastSaved:Long=0L
):Serializable
fun main(){
    val student:StudentRecord=StudentRecord(
        studentId="stu=2024-001",
        name="alice johnson",
        semester="fall 2024",
        finalGrades=mutableMapOf(
            "math" to 92.5,
            "science" to 88.0,
            "english" to 95.5
        )
    )
    student.draftGrades=mutableMapOf(
        "math" to 94.0,
        "science" to 90.0,
        "english" to 96.0
    )
    student.isEditing=true
    student.lastSaved=System.currentTimeMillis()
    println("---before serialization---")
    println("student: ${student.name} (${student.studentId})")
    println("semester: ${student.semester}")
    println("final grades: ${student.finalGrades}")
    println("draft grades: ${student.draftGrades}")
    println("is editing: ${student.isEditing}")
    println("last saved: ${student.lastSaved}")
    val file:java.io.File=File("student.ser")
    ObjectOutputStream(FileOutputStream(file)).use{it.writeObject(student)}
    val restored:StudentRecord=ObjectInputStream(FileInputStream(file)).use{it.readObject() as StudentRecord}
    println("")
    println("---after deserialization---")
    println("student: ${restored.name} (${restored.studentId})")
    println("semester: ${restored.semester}")
    println("final grades: ${restored.finalGrades}")
    println("draft grades: ${restored.draftGrades}")
    println("is editing: ${restored.isEditing}")
    println("last saved: ${restored.lastSaved}")
}