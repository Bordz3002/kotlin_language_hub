//shopping cart with session data
import java.io.*
class ShoppingCart(
    val cartId:String,
    val items:MutableList<String> =mutableListOf<String>(),
    val totalPrice:Double=0.0,
    @Transient var sessionToken:String="",
    @Transient var lastAccessed:Long=0L
):Serializable{}
fun main(){
    val cart:ShoppingCart=ShoppingCart(
        cartId="cart-001",
        items=mutableListOf("laptop", "mouse", "keyboard"),
        totalPrice=1299.99
    )
    cart.sessionToken="token-xyz-789"
    cart.lastAccessed=System.currentTimeMillis()
    println("---before serialization---")
    println("cart id: ${cart.cartId}")
    println("items: ${cart.items}")
    println("total: ${cart.totalPrice}")
    println("session token: ${cart.sessionToken}")
    println("last accessed: ${cart.lastAccessed}")
    val file:java.io.File=File("cart.ser")
    ObjectOutputStream(FileOutputStream(file)).use{it.writeObject(cart)}
    val restored:ShoppingCart=ObjectInputStream(FileInputStream(file)).use{it.readObject() as ShoppingCart}
    println("---after deserializing---")
    println("cart id: ${restored.cartId}")
    println("items: ${restored.items}")
    println("total: ${restored.totalPrice}")
    println("session token: ${restored.sessionToken}")
    println("last accessed: ${restored.lastAccessed}")
}