class Item(val name:String, val price:Double, val quantity:Int)
val Item.totalValue: Double
    get()=this.price*this.quantity
val Item.inStock: Boolean
    get()=this.quantity>0
val Item.displayInfo: String
    get()="${this.name} -${this.price}"
fun main(){
    val laptop:Item=Item("laptop", 999.9, 5)
    val outOfStock:Item=Item("phone", 34.235, 0)
    println(laptop.displayInfo)
    println(laptop.totalValue)
    println(laptop.inStock)

    println(outOfStock.displayInfo)
    println(outOfStock.inStock)
}