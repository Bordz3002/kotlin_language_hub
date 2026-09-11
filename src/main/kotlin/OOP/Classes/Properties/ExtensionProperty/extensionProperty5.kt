class Applicant(val firstName:String, val lastName:String, val age:Int)
val Applicant.fullName: String
    get()="${this.firstName} ${this.lastName}"
val Applicant.isAdult: Boolean
    get()=this.age>=18
val Applicant.ageGroup: String
    get()=if(this.age<18)"minor" else "adult"
fun main(){
    val applicant1:Applicant=Applicant("tororo", "rororo", 25)
    val applicant2:Applicant=Applicant("bob", "jones", 16)
    println(applicant1.fullName)
    println(applicant1.isAdult)
    println(applicant1.ageGroup)

    println(applicant2.fullName)
    println(applicant2.isAdult)
    println(applicant2.ageGroup)
}