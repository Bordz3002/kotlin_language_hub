import javax.print.Doc

interface Printable{
    fun print()
}
class Document(val expectDocumentName:String):Printable{
    override fun print(){
        println("Printing document file: $expectDocumentName")
    }
}
class Image(val expectImageName:String):Printable{
    override fun print(){
        println("Printing image file: $expectImageName")
    }
}
fun main(){
    val wordDocument= Document("Research title")
    val jpeg=Image("nostalgic.jpeg")
    with(wordDocument){
        print()
    }
    with(jpeg){
        print()
    }
}