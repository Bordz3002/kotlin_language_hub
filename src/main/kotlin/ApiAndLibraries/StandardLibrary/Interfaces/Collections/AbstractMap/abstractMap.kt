//a simple read-only map
class SimpleMap<K, out V>(private val mapEntries:Set<Map.Entry<K, V>>):AbstractMap<K, V>(){
    override val entries:Set<Map.Entry<K, V>>
        get()=mapEntries
}
fun main(){
    val map:SimpleMap<String, Int> =SimpleMap<String, Int>(mapEntries=mapOf<String, Int>(
        "one" to 1,
        "two" to 2,
        "three" to 3
    ).entries)
    println("size: ${map.size}")
    println("is empty: ${map.isEmpty()}")
    println("keys: ${map.keys}")
    println("values: ${map.values}")
    println("get(\"two\"): ${map["two"]}")
    println("contains key \"one\": ${map.containsKey(key="one")}")
    println("contains value 3: ${map.containsValue(value=3)}")
    println("contents: $map")
}