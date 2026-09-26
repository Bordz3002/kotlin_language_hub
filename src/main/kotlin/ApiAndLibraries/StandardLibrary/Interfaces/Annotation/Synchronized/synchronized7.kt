//thread-safe cache
class SimpleCache{
    private val _cache:MutableMap<String, String> =mutableMapOf<String, String>()
    private var _hits:Int=0
    private var _misses:Int=0

    @Synchronized
    fun get(key:String):String?{
        val value:String?=_cache[key]
        if(value!=null) {
            _hits++
            println("cache hit: $key")
        }else{
            _misses++
            println("cache miss: $key")
        }
        return value
    }

    @Synchronized
    fun put(key:String, value:String){
        _cache[key]=value
        println("cached: $key = $value")
    }

    @Synchronized
    fun remove(key:String){
        _cache.remove(key)
        println("removed: $key")
    }

    @Synchronized
    fun clear(){
        _cache.clear()
        _hits=0
        _misses=0
        println("cache cleared")
    }

    @Synchronized
    fun size():Int{
        return _cache.size
    }

    @Synchronized
    fun stats():String{
        return "hits: $_hits, misses: $_misses, size: ${size()}"
    }
}
fun main(){
    val cache:SimpleCache=SimpleCache()
    val threads:List<Thread> =(1..5).map{i:Int->
        Thread{
            val key:String="key-${i%3}"
            val value:String="value-$i"
            cache.put(key=key, value=value)
            Thread.sleep(100)
            val result:String?=cache.get(key=key)
            println("thread $i got: $result")
            Thread.sleep(100)
        }
    }
    threads.forEach{it.start()}
    threads.forEach{it.join()}
    println("cache stats")
    println(cache.stats())
    println("cache size: ${cache.size()}")
}