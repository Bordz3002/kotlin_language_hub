//a map with default values and mutable operations
class DefaultMutableMap<K, V>(private val defaultValue:V):AbstractMutableMap<K, V>(){
    private val _entriesSet:MutableSet<MutableMap.MutableEntry<K, V>> =mutableSetOf<MutableMap.MutableEntry<K, V>>()
    override val entries:MutableSet<MutableMap.MutableEntry<K, V>>
        get()=_entriesSet
    override fun put(key:K, value:V):V?{
        val existing:MutableMap.MutableEntry<K, V>? =_entriesSet.find{it:MutableMap.MutableEntry<K, V> ->it.key==key}
        return if(existing!=null){
            existing.setValue(newValue=value)
        }else{
            _entriesSet.add(SimpleEntry(key=key, value=value))
            null
        }
    }
    override fun get(key:K):V?{
        return super.get(key=key)?:defaultValue
    }
    override fun remove(key:K):V?{
        val existing:MutableMap.MutableEntry<K, V>? =_entriesSet.find{it:MutableMap.MutableEntry<K, V> ->it.key==key}
        return if(existing!=null){
            val oldValue:V=existing.value
            _entriesSet.remove(element=existing)
            oldValue
        }else{
            null
        }
    }
    private class SimpleEntry<K, V>(override val key:K, override var value:V):MutableMap.MutableEntry<K, V>{
        override fun setValue(newValue:V):V{
            val old:V=value
            value=newValue
            return old
        }
        override fun equals(other:Any?):Boolean{
            if(other !is Map.Entry<*, *>) return false
            return key==other.key && value==other.value
        }
        override fun hashCode():Int{
            return (key?.hashCode()?:0) xor (value?.hashCode()?:0)
        }
        override fun toString():String="$key=$value"
    }
}
fun main(){
    val map:DefaultMutableMap<String, Int> =DefaultMutableMap<String, Int>(defaultValue=0)
    val numbers:List<String> =listOf<String>("one", "two", "three")
    println("---adding entries---")
    for(i:Int in numbers.indices){
        map[numbers[i]]=i+1
    }
    println("contents: $map")
    println("size: ${map.size}")
    println("\n---getting values (with default)---")
    println("get(\"one\"): ${map["one"]}")
    println("get(\"two\"): ${map["two"]}")
    println("get(\"four\"): ${map["four"]}")
    println("get(\"unknown\"): ${map["unknown"]}")
    println("\n---updating entry---")
    map["two"]=22
    println("contents: $map")
    println("\n---removing entry---")
    println("remove(\"one\"): ${map.remove(key="one")}")
    println("remove(\"four\"): ${map.remove(key="four")}")
    println("contents: $map")
    println("\n---adding after removing---")
    map["four"]=4
    println("contents: $map")
    println("\n---using inherited methods---")
    println("contains key \"two\": ${map.containsKey(key="two")}")
    println("contains key \"four\": ${map.containsKey(key="four")}")
    println("keys: ${map.keys}")
    println("values: ${map.values}")
    println("\n---final state---")
    println("size: ${map.size}")
    println("contents: $map")
}