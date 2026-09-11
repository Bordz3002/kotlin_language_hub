class Contact{
    var phone:String=""
        set(value){
            field=value.filter{it.isDigit()}
        }
}
fun main(){
    val contact=Contact()
    contact.phone="(123) 456-7890"
    println(contact.phone)
    contact.phone="+63 995-1234-256"
    println(contact.phone)
}