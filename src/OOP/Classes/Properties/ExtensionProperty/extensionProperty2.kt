val String.wordCount:Int
    get()=this.split("").size
val String.isBlankOrEmpty: Boolean
    get()=this.isBlank()
val String.firstChar:Char?
    get()=if(this.isEmpty())null else this[0]
fun main(){
    val text:String="hello kotlin"
    println(text.wordCount)
    println(text.isBlankOrEmpty)
    println(text.firstChar)
}