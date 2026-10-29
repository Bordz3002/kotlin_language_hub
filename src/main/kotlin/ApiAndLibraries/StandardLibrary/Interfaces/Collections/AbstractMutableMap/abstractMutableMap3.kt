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