val List<String>.firstOrNull:String?
    get()=if(this.isEmpty())null else this[0]
val List<String>.isNotEmptyOrNull: Boolean
    get()=this.isNotEmpty()
fun main(){
    val names:List<String> =listOf("alice","bob","charlie")
    val empty:List<String> =emptyList<String>()
    println(names.firstOrNull)
    println(names.isNotEmptyOrNull)

    println(empty.firstOrNull)
    println(empty.isNotEmptyOrNull)
}