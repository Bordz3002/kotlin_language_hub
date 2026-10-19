//a map with default values from a function
class DefaultByFunctionMap<K, V>(private val mapEntries:Set<Map.Entry<K, V>>, private val defaultValueProvider:(K)->V):AbstractMap<K, V>(){
    override val entries:Set<Map.Entry<K, V>>
        get()=mapEntries
    override fun get(key:K):V?{
        return super.get(key)?:defaultValueProvider(key)
    }
}
fun main(){
    val map:DefaultByFunctionMap<String, Int> =DefaultByFunctionMap<String, Int>(mapEntries=mapOf<String, Int>("one" to 1, "two" to 2).entries, defaultValueProvider={key:String->key.length})
    println("size: ${map.size}")
    println("get \"one\": ${map["one"]}")
    println("get \"two\": ${map["two"]}")
    println("get \"three\": ${map["three"]}")
    println("get \"hello\": ${map["hello"]}")
    println("contains key \"three\": ${map.containsKey(key="three")}")
    println("keys: ${map.keys}")
    println("values: ${map.values}")
    println("contents: $map")
}