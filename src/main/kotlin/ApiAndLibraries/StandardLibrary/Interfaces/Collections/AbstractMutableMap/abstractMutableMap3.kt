//a map that logs all operations
class LoggingMutableMap<K, V>(private val name:String):AbstractMutableMap<K, V>(){
    private val _entriesSet:MutableSet<MutableMap.MutableEntry<K, V>> =mutableSetOf<MutableMap.MutableEntry<K, V>>()
    override val entries:MutableSet<MutableMap.MutableEntry<K, V>>
        get()=_entriesSet
    override fun put(key:K, value:V):V?{
        val existing:MutableMap.MutableEntry<K, V>? =_entriesSet.find{it.key==key}
        if(existing!=null){
            val oldValue:V=existing.value
            existing.setValue(newValue=value)
            println("[$name] updated: $key = $oldValue -> $value")
            return oldValue
        }
        _entriesSet.add(SimpleEntry(key=key, value=value))
        println("[$name] added: $key=$value (size: ${_entriesSet.size}")
        return null
    }
    override fun remove(key:K):V?{
        val existing:MutableMap.MutableEntry<K, V>? =_entriesSet.find{it:MutableMap.MutableEntry<K, V> ->it.key==key}
        if(existing!=null){
            val oldValue:V=existing.value
            _entriesSet.remove(element=existing)
            println("[$name] removed: $key (was: $oldValue, size: ${_entriesSet.size}")
            return oldValue
        }
        println("[$name] Key not found: $key")
        return null
    }
    override fun get(key:K):V?{
        val value:V?=super.get(key=key)
        println("[$name] get(\"$key\") -> $value")
        return value
    }
    override fun clear(){
        println("[$name] clearing ${_entriesSet.size} entries")
        _entriesSet.clear()
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
    val map:LoggingMutableMap<String, Int> =LoggingMutableMap<String, Int>(name="Scores")
    println("---adding entries---")
    map["alice"]=100
    map["bob"]=85
    map["charlie"]=92
    println("\n---getting value---")
    println("alice: ${map["alice"]}")
    println("dave: ${map["dave"]}")
    println("\n---updating entry---")
    map["bob"]=90
    println("\n---removing entry---")
    map.remove(key="charlie")
    map.remove(key="eve")
    println("\n---using inherited methods---")
    println("contains key 'alice': ${map.containsKey(key="alice")}")
    println("keys: ${map.keys}")
    println("values: ${map.values}")
    println("\n---clearing---")
    map.clear()
    println("\n---final state---")
    println("size: ${map.size}")
    println("is empty: ${map.isEmpty()}")
    println("contents: $map")
}