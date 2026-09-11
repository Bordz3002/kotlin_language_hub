class Database{
    fun connect(){
        println("connecting to database...")
    }
    fun query(sql:String):String{
        return "results from: $sql"
    }
}
val database:Database by lazy{
    println("creating database instance")
    Database().also {it.connect()}
}
fun main(){
    println("app started")
    println(database.query("SELECT * from users"))
    println(database.query("SELECT * from products"))
}