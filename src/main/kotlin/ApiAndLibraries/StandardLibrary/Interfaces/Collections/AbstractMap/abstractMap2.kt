//a reversed map (key-value)
class ReversedMap<K, V>(private val original:Map<K, V>):AbstractMap<V, K>(){
    override val entries:Set<Map.Entry<V, K>>
        get()=original.entries.map{(key, value)-> java.util.AbstractMap.SimpleEntry(value, key)}.toSet()
}
fun main(){
    val original:Map<String, Int> =mapOf<String, Int>("one" to 1, "two" to 2, "three" to 3)
    val reversed:ReversedMap<String, Int> =ReversedMap<String, Int>(original=original)
    println("original: $original")
    println("reversed: $reversed")
    println("size: ${reversed.size}")
    println("get(2): ${reversed[2]}")
    println("get(4): ${reversed[4]}")
    println("keys: ${reversed.keys}")
    println("values: ${reversed.values}")
    println("contains key 1: ${reversed.containsKey(key=1)}")
    println("contains value \"two\": ${reversed.containsValue(value="two")}")
}