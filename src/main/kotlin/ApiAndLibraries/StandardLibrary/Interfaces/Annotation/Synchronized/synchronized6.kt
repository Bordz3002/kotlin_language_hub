//thread-safe inventory management
class Inventory{
    private val _stock:MutableMap<String, Int> =mutableMapOf<String, Int>()

    @Synchronized
    fun addProduct(product:String, quantity:Int){
        if(quantity<=0){
            println("quantity must be positive")
            return
        }
        val current:Int=_stock[product] ?:0
        _stock[product]=current+quantity
        println("added: $quantity x $product. total: ${_stock[product]}")
    }

    @Synchronized
    fun removeProduct(product:String, quantity:Int):Boolean{
        val current:Int=_stock[product] ?:0
        if(current<quantity){
            println("not enough $product available: $current, requested: $quantity")
            return false
        }
        _stock[product]=current-quantity
        println("removed $quantity x $product. remaining: ${_stock[product]}")
        return true
    }

    @Synchronized
    fun getAllStock():Map<String, Int>{
        return _stock.toMap()
    }

    @Synchronized
    fun totalItems():Int{
        return _stock.values.sum()
    }
}
fun main(){
    val inventory:Inventory=Inventory()
    val addThreads:List<Thread> =(1..3).map{i:Int->
        Thread{
            inventory.addProduct(product="product-$i", quantity=3)
            Thread.sleep(100)
        }
    }
    val removeThreads:List<Thread> =(1..3).map{i:Int->
        Thread{
            inventory.removeProduct(product="product-$i", quantity=3)
            Thread.sleep(1050)
        }
    }
    addThreads.forEach{it.start()}
    removeThreads.forEach{it.start()}
    println("final inventory")
    inventory.getAllStock().forEach{(product:String, quantity:Int)->
        println(", $product: $quantity")
    }
    println("total items: ${inventory.totalItems()}")
}