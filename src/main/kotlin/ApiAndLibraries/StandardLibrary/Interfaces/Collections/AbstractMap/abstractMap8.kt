//a merged map
class MergedMap<K, V>(private val first:Map<K, V>, private val second:Map<K, V>):AbstractMap<K, V>(){
    override val entries:Set<Map.Entry<K, V>>
        get()=(first.entries+second.entries).toSet()
}
fun main(){
    val first:Map<String, Int> =mapOf<String, Int>(
        "one" to 1,
        "two" to 2,
        "three" to 3
    )
    val second:Map<String, Int> =mapOf<String, Int>(
        "three" to 30,
        "four" to 4,
        "five" to 5
    )
    val merged:MergedMap<String, Int> =MergedMap<String, Int>(first=first, second=second)
    println("first: $first")
    println("second: $second")
    println("merged: $merged")
    println("size: ${merged.size}")
    println("get \"one\": ${merged["one"]}")
    println("get \"three\": ${merged["three"]}")
    println("get \"four\": ${merged["four"]}")
    println("keys: ${merged.keys}")
    println("values: ${merged.values}")
    println("contains key \"five\": ${merged.containsKey(key="five")}")
    println("contains value 30: ${merged.containsValue(value=30)}")
}