abstract class Account{
    abstract val owner: String
    abstract val balance:Double
}
class SavingsAccount(override val owner:String, override val balance:Double):Account()
fun main(){
    val account1=SavingsAccount("naval", 1.00)
    val account2=SavingsAccount("tororo", 1123423.123)
    with(account1){println("saving account: owner:$owner, balance: $balance")}
    with(account2){println("saving account: owner:$owner, balance:$balance")}
}