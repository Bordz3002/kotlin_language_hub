//a map with default values
class DefaultMap<K, V>(private val mapEntries:Set<Map.Entry<K, V>>, private val defaultValue:V):AbstractMap<K, V>(){
    override val entries:Set<Map.Entry<K, V>>
        get()=mapEntries
    override fun get(key:K):V?{
        return super.get(key=key)?:defaultValue
    }
}
fun main(){
    val map:DefaultMap<String, Int> =DefaultMap<String, Int>(
        mapEntries=mapOf<String, Int>(
            "one" to 1,
            "two" to 2
        ).entries,
        defaultValue=0
    )
    println("size: ${map.size}")
    println("get \"one\": ${map["one"]}")
    println("get \"two\": ${map["two"]}")
    println("get \"three\": ${map["three"]}")
    println("get \"unknown\": ${map["unknown"]}")
    println("contains key \"three\": ${map.containsKey(key="three")}")
    println("keys: ${map.keys}")
    println("values: ${map.values}")
    println("contents: $map")
}