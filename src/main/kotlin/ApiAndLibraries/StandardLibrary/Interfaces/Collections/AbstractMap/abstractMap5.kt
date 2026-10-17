//a filtered map
class FilteredMap<K, V>(private val original:Map<K, V>, private val predicate:(Map.Entry<K, V>)->Boolean):AbstractMap<K, V>(){
    override val entries:Set<Map.Entry<K, V>>
        get()=original.entries.filter(predicate).toSet()
}
fun main(){
    val original:Map<String, Int> =mapOf<String, Int>(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5
    )
    val filtered:FilteredMap<String, Int> =FilteredMap<String, Int>(original=original){it.value%2==0}
    println("original: $original")
    println("filtered: $filtered")
    println("size: ${filtered.size}")
    println("get \"two\": ${filtered["map"]}")
    println("get \"one\": ${filtered["one"]}")
    println("keys: ${filtered.keys}")
    println("values: ${filtered.values}")
    println("contains key \"three\": ${filtered.containsKey(key="three")}")
    println("contains value 4: ${filtered.containsValue(value=4)}")
}