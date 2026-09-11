abstract class Product(val name:String, var price:Double){
    abstract val category:String
    fun productInfo():String{
        return "Product: $name, Category: $category, Price: $price"
    }
}
class Electronic(name:String, price:Double, val warranty:Int):Product(name, price){
    override val category="Electronic"
}
fun main(){
    val laptop=Electronic("laptop", 132.0,2)
    println(laptop.productInfo())
}