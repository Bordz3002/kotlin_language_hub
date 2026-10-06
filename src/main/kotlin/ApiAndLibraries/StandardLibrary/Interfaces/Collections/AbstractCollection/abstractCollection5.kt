//A word collection from a sentence
class Words(private val _sentence:String):AbstractCollection<String>(){
    private val _words:List<String> =_sentence.split("").filter{it.isNotBlank()}
    override val size: Int
        get()=_words.size
    override fun iterator():Iterator<String> =_words.iterator()
}
fun main(){
    val collection:Words=Words(_sentence="Kotlin is a modern and concise language")
    println("size: ${collection.size}")
    println("is empty: ${collection.isEmpty()}")
    println("contains 'Kotlin': ${collection.contains(element="Kotlin")}")
    println("contains 'Java': ${collection.contains(element="Java")}")
    println("contents: $collection")
    for(word:String in collection){
        println("word: $word")
    }
}