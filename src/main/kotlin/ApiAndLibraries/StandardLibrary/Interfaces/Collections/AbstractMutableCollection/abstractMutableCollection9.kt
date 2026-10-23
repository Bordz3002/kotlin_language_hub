//a collection with validation on add
class ValidatedCollection<E>(private val validator:(E)->Boolean):AbstractMutableCollection<E>(){
    private val _items:MutableList<E> =mutableListOf<E>()
    override val size: Int
        get()=_items.size
    override fun iterator():MutableIterator<E> =_items.iterator()
    override fun add(element:E):Boolean{
        if(!validator(element)){
            println("rejected: $element - failed validation")
            return false
        }
        return _items.add(element=element)
    }
}
fun main(){
    val names:ValidatedCollection<String> =ValidatedCollection<String>(validator={it.isNotBlank()})
    val namesList:List<String> =listOf<String>("alice", "", "bob", "", "charlie")
    println("---adding valid and invalid items---")
    for(name:String in namesList){
        names.add(element=name)
    }
    println("\nsize: ${names.size}")
    println("contents: $names")
    val positiveNumbers:ValidatedCollection<Int> =ValidatedCollection<Int>(validator={it>0})
    val numbers:List<Int> =listOf<Int>(10, -5, 25, 0, 100)
    for(number:Int in numbers){
        positiveNumbers.add(element=number)
    }
    println("\nsize: ${positiveNumbers.size}")
    println("contents: $positiveNumbers")
}