//a map with maximum size
class BoundedMutableMap<K, V>(private val maxSize:Int):AbstractMutableMap<K, V>(){
    private val _entriesSet:MutableSet<MutableMap.MutableEntry<K, V>> =mutableSetOf<MutableMap.MutableEntry<K, V>>()
    override val entries:MutableSet<MutableMap.MutableEntry<K, V>>
        get()=_entriesSet
    override fun put(key:K, value:V):V?{
        val existing:MutableMap.MutableEntry<K, V>? =_entriesSet.find{it.key==key}
        if(existing!=null){
            return existing.setValue(newValue=value)
        }
        if(_entriesSet.size>=maxSize){
            println("cannot add '$key=$value' - map is full (max: $maxSize)")
            return null
        }
        _entriesSet.add(SimpleEntry(key=key, value=value))
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
fun main(){
    val map:BoundedMutableMap<String, Int> =BoundedMutableMap<String, Int>(maxSize=3)
    val numbers:List<String> =listOf<String>("one", "two", "three")
    println("max size: 3")
    println("\n---adding entries---")
    for(i:Int in numbers.indices){
        map[numbers[i]]=i+1
    }
    println("contents: $map")
    println("size: ${map.size}")
    println("\n---trying to add beyond limit---")
    map["four"]=4
    map["five"]=5
    println("contents: $map")
    println("\n---updating existing entry (allowed)---")
    map["two"]=22
    println("contents: $map")
    println("\n---removing and adding again---")
    map.remove(key="one")
    println("after removing 'one': $map")
    map["four"]=4
    println("after adding 'four': $map")
    println("size: ${map.size}")
}