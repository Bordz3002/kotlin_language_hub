//bank account balance monitor
class BankAccountClass{
    @Volatile
    var balance:Double=1000.0

    @Volatile
    var transactionCount:Int=0

    @Volatile
    var isClosed:Boolean=false

    fun deposit(amount:Double){
        if(this.isClosed){
            println("account closed. cannot deposit")
            return
        }
        this.balance+=amount
        this.transactionCount++
        println("deposited: $amount balance: ${this.balance}")
    }
    fun withdraw(amount:Double):Boolean{
        if(this.isClosed){
            println("account closed. cannot withdraw")
            return false
        }
        if(this.balance>=amount){
            this.balance-=amount
            this.transactionCount--
            println("withdrew: $amount balance: ${this.balance}")
            return true
        }
        println("insufficient funds. balance: ${this.balance}")
        return false
    }
    fun close(){
        this.isClosed=true
        println("account closed")
    }
}
fun main(){
    val account:BankAccountClass=BankAccountClass()
    val depositThread:Thread=Thread{
        repeat(times=3){
            account.deposit(amount=100.0)
            Thread.sleep(300)
        }
    }
    val withdrawThread:Thread=Thread{
        repeat(times=3){
            account.withdraw(amount=150.0)
            Thread.sleep(400)
        }
    }
    depositThread.start()
    withdrawThread.start()
    Thread.sleep(1200)
    account.close()
    depositThread.join()
    withdrawThread.join()
    println("final balance: ${account.balance}")
    println("total transactions: ${account.transactionCount}")
}