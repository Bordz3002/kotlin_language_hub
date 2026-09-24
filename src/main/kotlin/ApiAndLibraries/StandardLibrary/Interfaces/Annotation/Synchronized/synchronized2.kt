//thread-safe bank account
class BankAccountObject{
    private var _balance:Double=1000.0
    private var _transactionCount:Int=0

    @Synchronized
    fun deposit(amount:Double){
        if(amount<=0){
            println("deposit amount must be positive")
            return
        }
        _balance+=amount
        _transactionCount++
        println("deposited: $amount balance: $_balance")
    }

    @Synchronized
    fun withdraw(amount:Double):Boolean{
        if(amount<=0){
            println("withdrawal amount must be positive")
            return false
        }
        if(_balance>=amount){
            _balance-=amount
            _transactionCount++
            println("withdrew: $amount balance: $_balance")
            return true
        }
        println("insufficient funds! balance: $_balance")
        return false
    }

    @Synchronized
    fun getBalance():Double{
        return _balance
    }

    @Synchronized
    fun getTransactionCount():Int{
        return _transactionCount
    }
}
fun main(){
    val account:BankAccountObject=BankAccountObject()
    val depositThread:Thread=Thread{
        repeat(times=5){
            account.deposit(amount=100.0)
            Thread.sleep(100)
        }
    }
    val withdrawThread:Thread=Thread{
        repeat(times=5){
            account.withdraw(amount=150.0)
            Thread.sleep(150)
        }
    }
    depositThread.start()
    withdrawThread.start()
    depositThread.join()
    depositThread.join()
    println("---final report--")
}