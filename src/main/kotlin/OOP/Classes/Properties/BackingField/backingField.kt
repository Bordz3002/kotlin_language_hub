//Backing Field - the actual storage location where the value lives
class Address{
    var name:String=""
        set(value){
            println("trying to set name to:$value")
            println("before field:$field")
            field=value
            println("after field:${field}")
        }
}
fun main(){
    val address=Address()
    address.name="san antonio"
    println("final address:${address.name}")
}