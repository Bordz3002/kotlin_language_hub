//bank account with transaction history
import java.io.*
class BankAccountObjects(
    val accountNumber:String,
    val accountHolder:String,
    val balance:Double,
    val transactionHistory:MutableList<String> =mutableListOf<String>(),
    @Transient var sessionPin:String="",
    @Transient var lastLoginTime:Long=0L,
    @Transient var isLoggedIn:Boolean=false
):Serializable
fun main(){
    val account:BankAccountObjects=BankAccountObjects(
        accountNumber="acc-123456",
        accountHolder="alice johnson",
        balance=5000.0,
        transactionHistory=mutableListOf(
            "deposit: +$1000",
            "withdrawal: -$200",
            "deposit: +$500"
        )
    )
    account.sessionPin="1234"
    account.lastLoginTime=System.currentTimeMillis()
    account.isLoggedIn=true
    println("---before serialization---")
    println("account: ${account.accountNumber}")
    println("holder: ${account.accountHolder}")
    println("balance: ${account.balance}")
    println("transactions: ${account.transactionHistory.size}")
    println("session PIN: ${account.sessionPin}")
    println("is logged in: ${account.isLoggedIn}")
    println("last login: ${account.lastLoginTime}")
    val file:java.io.File=File("account.ser")
    ObjectOutputStream(FileOutputStream(file)).use{it.writeObject(account)}
    val restored:BankAccountObjects=ObjectInputStream(FileInputStream(file)).use{it.readObject() as BankAccountObjects}
    println("---after deserialization---")
    println("account: ${restored.accountNumber}")
    println("holder: ${restored.accountHolder}")
    println("balance: ${restored.balance}")
    println("transactions: ${restored.transactionHistory.size}")
    println("session PIN: ${restored.sessionPin}")
    println("is logged in: ${restored.isLoggedIn}")
    println("last login: ${restored.lastLoginTime}")
}