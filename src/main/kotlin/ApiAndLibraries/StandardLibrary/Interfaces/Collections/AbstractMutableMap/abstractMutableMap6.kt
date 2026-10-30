//a map that tracks modification count
class TrackedMutableMap<K, V>:AbstractMutableMap<K, V>(){
    private val  _entriesSet:MutableSet<MutableMap.MutableEntry<K, V>> =mutableSetOf<MutableMap.MutableEntry<K, V>>()
    private var _modificationCount:Int=0
    override val entries:MutableSet<MutableMap.MutableEntry<K, V>>
        get()=_entriesSet
    override fun put(key:K, value:V):V?{
        val existing:MutableMap.MutableEntry<K, V>? =_entriesSet.find{it:MutableMap.MutableEntry<K, V> ->it.key==key}
        val oldValue:V?=if(existing!=null){
            existing.setValue(newValue=value)
        }else{
            _entriesSet.add(SimpleEntry(key=key, value=value))
            null
        }
        _modificationCount++
        println("modification #$_modificationCount: put(key=$key, value=$value")
        return oldValue
    }
    override fun remove(key:K):V?{
        val existing:MutableMap.MutableEntry<K, V>? =_entriesSet.find{it:MutableMap.MutableEntry<K, V> ->it.key==key}
        return if(existing!=null){
            val oldValue:V=existing.value
            _entriesSet.remove(element=existing)
            _modificationCount++
            println("modification #$_modificationCount: remove(key=$key)")
            oldValue
        }else{
            println("key not found: $key")
            null
        }
    }
    override fun clear(){
        if(_entriesSet.isNotEmpty()){
            _modificationCount++
            println("modification #$_modificationCount: clear()")
        }
        _entriesSet.clear()
    }
    fun getModificationCount():Int =_modificationCount
    fun getStats():String ="size: ${_entriesSet.size}, modifications: $_modificationCount"
    private class SimpleEntry<K, V>(override val key:K, override var value:V):MutableMap.MutableEntry<K, V>{
        override fun setValue(newValue:V):V{
            val oldValue:V=value
            value=newValue
            return oldValue
        }
        override fun equals(other:Any?):Boolean{
            if(other !is Map.Entry<*, *>)return false
            return key==other.key && value==other.value
        }
        override fun hashCode(): Int{
            return (key?.hashCode()?:0) xor (value?.hashCode()?:0)
        }
        override fun toString():String="$key=$value"
    }
}
fun main(){
    val map:TrackedMutableMap<String, Int> =TrackedMutableMap<String, Int>()
    println("---adding entries---")
    val numbers:List<String> =listOf<String>("one", "two", "three")
    for(i:Int in numbers.indices){
        map[numbers[i]]=i+1
    }
    println("stats: ${map.getStats()}")
    println("\n---updating entry---")
    map["two"]=22
    println("stats: ${map.getStats()}")
    println("\n---removing entry---")
    map.remove(key="one")
    map.remove(key="four")
    println("stats: ${map.getStats()}")
    println("\n---using inherited methods---")
    println("contains key 'two': ${map.containsKey(key="two")}")
    println("get 'two': ${map["two"]}")
    println("keys: ${map.keys}")
    println("values: ${map.values}")
    println("\n---clear---")
    map.clear()
    println("after clear: ${map.getStats()}")
    println("\n---final state---")
    println("size: ${map.size}")
    println("modifications: ${map.getModificationCount()}")
    println("contents: Map")
}