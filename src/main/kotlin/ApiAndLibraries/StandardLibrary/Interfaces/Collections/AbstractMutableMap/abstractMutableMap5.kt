//a map that rejects duplicate values
class UniqueValueMap<K, V>:AbstractMutableMap<K, V>(){
    private val _entriesSet:MutableSet<MutableMap.MutableEntry<K, V>> =mutableSetOf<MutableMap.MutableEntry<K, V>>()
    override val entries:MutableSet<MutableMap.MutableEntry<K, V>>
        get()=_entriesSet
    override fun put(key:K, value:V):V?{
        val existingByKey:MutableMap.MutableEntry<K, V>? =_entriesSet.find{it:MutableMap.MutableEntry<K, V> ->it.key==key}
        if(existingByKey!=null){
            val oldValue:V=existingByKey.value
            existingByKey.setValue(newValue=value)
            println("updated: $key = $oldValue -> $value")
            return oldValue
        }
        val existingByValue:MutableMap.MutableEntry<K, V>? =_entriesSet.find{it:MutableMap.MutableEntry<K, V> ->it.value==value}
        if(existingByValue!=null){
            println("cannot add '$key=$value' '$value' already exists for key ${existingByValue.key}")
            return null
        }
        _entriesSet.add(SimpleEntry(key=key, value=value))
        println("added: $key=$value")
        return null
    }
    override fun remove(key:K):V?{
        val existing:MutableMap.MutableEntry<K, V>? =_entriesSet.find{it:MutableMap.MutableEntry<K, V> ->it.key==key}
        return if(existing!=null){
            val oldValue:V=existing.value
            _entriesSet.remove(element=existing)
            println("removed: $key (was: $oldValue)")
            oldValue
        }else{
            println("key not found: $key")
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
    val map:UniqueValueMap<String, Int> =UniqueValueMap<String, Int>()
    println("---adding entries---")
    val numbers:List<String> =listOf<String>("one", "two", "three")
    for(i:Int in numbers.indices){
        map[numbers[i]]=i+1
    }
    println("\n---trying to add duplicate value---")
    map["uno"]=1
    map["dos"]=2
    println("\n---contents: $map")
    println("size: ${map.size}")
    println("\n---updating existing key---")
    map["two"]=22
    println("contents: $map")
    println("\n---trying to update to duplicate value---")
    map["three"]=1
    println("contents: $map")
    println("\n---removing and adding again---")
    map.remove(key="uno")
    map["uno"]=1
    println("contents: $map")
    println("\n---final state---")
    println("size: ${map.size}")
    println("contents: $map")
    println("keys: ${map.keys}")
    println("values: ${map.values}")
}