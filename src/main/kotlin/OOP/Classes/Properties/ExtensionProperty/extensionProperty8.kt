class Book(val title:String, val pages:Int)
val Book.isLong: Boolean
    get()=this.pages>300
val Book.readingTimeMinutes: Int
    get()=this.pages*2
val Book.uppercaseTitle: String
    get()=this.title.uppercase()
fun main(){
    val book1:Book=Book("Kotlin Basics", 250)
    val book2:Book=Book("advanced programming", 450)
    println(book1.uppercaseTitle)
    println(book1.isLong)
    println(book1.readingTimeMinutes)

    println(book2.uppercaseTitle)
    println(book2.isLong)
    println(book2.readingTimeMinutes)
}
