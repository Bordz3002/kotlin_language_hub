//a simple mutable map
class SimpleMutableMap<K, V>:AbstractMutableMap<K, V>(){
    private val _entriesSet:MutableSet<MutableMap.MutableEntry<K, V>> =mutableSetOf<MutableMap.MutableEntry<K, V>>()
    override val entries:MutableSet<MutableMap.MutableEntry<K, V>>
        get()=_entriesSet
    override fun put(key:K, value:V):V?{
        val existing:MutableMap.MutableEntry<K, V>? =_entriesSet.find{it.key==key}
        val old:V? =existing?.value
        if(existing!=null){
            existing.setValue(newValue=value)
        }else{
            _entriesSet.add(element=SimpleEntry(key=key, value=value))
        }
        return old
    }
    private class SimpleEntry<K, V>(override val key:K, override var value:V):MutableMap.MutableEntry<K, V>{
        override fun setValue(newValue:V):V{
            val old:V=value
            value=newValue
            return old
        }
    }
}
fun main(){
    val map:SimpleMutableMap<String, Int> =SimpleMutableMap<String, Int>()
    val numbers:List<String> =listOf<String>("one", "two", "three")
    println("size: ${map.size}")
    println("is empty: ${map.isEmpty()}")
    println("\n---putting entries---")
    for(i:Int in numbers.indices){
        println("put(key=\"${numbers[i]}\", value=${i+1}) returned: ${map.put(key=numbers[i], value=i+1)}")
    }
    println("\n---contents: $map")
    println("size: ${map.size}")
    println("get(\"two\"): ${map["two"]}")
    println("get(\"four\"): ${map["four"]}")
    println("\n---updating entry---")
    println("put(key=\"two\", value=22) returned: ${map.put(key="two", value=22)}")
    println("contents: $map")
    println("\n---removing an entry---")
    println("remove(\"one\") returned: ${map.remove(key="one")}")
    println("contents: $map")
    println("size: ${map.size}")
    println("\nkeys: ${map.keys}")
    println("values: ${map.values}")
    println("contains key \"two\": ${map.containsKey(key="two")}")
    println("contains value 22: ${map.containsValue(value=22)}")
}