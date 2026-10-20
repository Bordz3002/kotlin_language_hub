//a case-insensitive map
class CaseInsensitiveMap<V>(private val mapEntries:Set<Map.Entry<String, V>>):AbstractMap<String, V>(){
    private val lowerCaseEntries:Map<String, Map.Entry<String, V>> =mapEntries.associateBy{it.key.lowercase()}
    override val entries:Set<Map.Entry<String, V>>
        get()=mapEntries
    override fun get(key:String):V?{
        return lowerCaseEntries[key.lowercase()]?.value
    }
    override fun containsKey(key:String):Boolean{
        return lowerCaseEntries.containsKey(key=key.lowercase())
    }
}
fun main(){
    val map =CaseInsensitiveMap(mapEntries=mapOf(
        "name" to "alice",
        "age" to 25,
        "city" to "new york"
    ).entries)
    println("original keys: [name, age, city]")
    println("size: ${map.size}")
    println("get \"name\": ${map["name"]}")
    println("get \"NAME\": ${map["NAME"]}")
    println("get \"Name\": ${map["Name"]}")
    println("get \"age\": ${map["age"]}")
    println("get \"city\": ${map["city"]}")
    println("contains key \"name\": ${map.containsKey(key="name")}")
    println("contains key \"NAME\": ${map.containsKey(key="NAME")}")
    println("contains key \"unknown\": ${map.containsKey(key="unknown")}")
    println("keys: ${map.keys}")
    println("values: ${map.values}")
    println("contents: $map")
}