//a map with subset of keys
class SubsetMap<K, V>(private val original:Map<K, V>, private val includedKeys:Set<K>):AbstractMap<K, V>(){
    override val entries:Set<Map.Entry<K, V>>
        get()=original.entries.filter{it.key in includedKeys}.toSet()
}
fun main(){
    val original:Map<String, Int> =mapOf<String, Int>(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5
    )
    val subset:SubsetMap<String, Int> =SubsetMap<String, Int>(original=original, includedKeys=setOf<String>("two", "four", "six"))
    println("original: $original")
    println("subset keys: [two, four, six")
    println("subset: $subset")
    println("size: ${subset.size}")
    println("get \"two\": ${subset["two"]}")
    println("get \"one\": ${subset["one"]}")
    println("keys: ${subset.keys}")
    println("values: ${subset.values}")
    println("contains key \"four\": ${subset.containsKey(key="four")}")
    println("contains key \"three\": ${subset.containsKey(key="three")}")
}