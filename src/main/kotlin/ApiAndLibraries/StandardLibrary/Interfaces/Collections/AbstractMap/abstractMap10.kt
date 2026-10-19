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
        "age" to 25
    ).entries)
}