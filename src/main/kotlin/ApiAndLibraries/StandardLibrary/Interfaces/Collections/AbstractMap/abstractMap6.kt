//a transformed map (value transformation)
class TransformedMap<K, V, R>(private val original:Map<K, V>, private val transform:(V)->R):AbstractMap<K, R>(){
    override val entries:Set<Map.Entry<K, R>>
        get()=original.entries.map{(key:K, value:V)->
            object:Map.Entry<K, R>{
                override val key:K=key
                override val value:R=transform(value)
            }
        }.toSet()
}
fun main(){
    val original:Map<String, Int> =mapOf<String, Int>(
        "one" to 1,
        "two" to 2,
        "three" to 3
    )
    val transformed:TransformedMap<String, Int, Int> =TransformedMap<String, Int, Int>(original=original){it*10}
    println("original: $original")
    println("transformed: $transformed")
    println("size: ${transformed.size}")
    println("get \"two\": ${transformed["two"]}")
    println("keys: ${transformed.keys}")
    println("values: ${transformed.values}")
    println("contains value 20: ${transformed.containsValue(value=20)}")
}