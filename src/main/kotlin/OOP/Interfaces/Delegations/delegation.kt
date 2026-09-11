interface Worker{
    fun work()
}
class Programmer:Worker{
    override fun work(){println("writing code")}
}
class Manager(programmer:Programmer):Worker by programmer
fun main(){
    val programmer=Programmer()
    val manager=Manager(programmer)
    with(manager){
        work()
    }
}