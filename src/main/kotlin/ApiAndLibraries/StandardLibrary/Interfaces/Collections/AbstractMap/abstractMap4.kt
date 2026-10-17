//a map with computed values
class ComputedMap<K, V>(override val keys:Set<K>, private val compute:(K)->V):AbstractMap<K, V>(){
    override val entries:Set<Map.Entry<K, V>>
        get()=keys.map{key:K->
            object:Map.Entry<K, V>{
                override val key:K=key
                override val value:V=compute(key)
            }
        }.toSet()
}
fun main(){
    val map:ComputedMap<String, Int> =ComputedMap<String, Int>(keys=setOf<String>("apple", "banana", "cherry")){fruit:String->fruit.length}
    println("size; ${map.size}")
    println("get \"apple\": ${map["apple"]}")
    println("get \"banana\": ${map["banana"]}")
    println("get \"cherry\": ${map["cherry"]}")
    println("get \"mango\": ${map["mango"]}")
    println("keys: ${map.keys}")
    println("values: ${map.values}")
    println("contents: $map")
}