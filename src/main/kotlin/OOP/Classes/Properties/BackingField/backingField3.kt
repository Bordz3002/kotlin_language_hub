class BankAccount{
    var balance:Double=0.0
        set(value){
            if(value<0){
                println("cannot set a negative balance")
            }else{
                println("balance changed: $field -> $value")
                field=value
            }
        }
}
fun main(){
    val account=BankAccount()
    account.balance=100.0
    account.balance=23.0
    account.balance=-3123.3
    account.balance=632.8
}