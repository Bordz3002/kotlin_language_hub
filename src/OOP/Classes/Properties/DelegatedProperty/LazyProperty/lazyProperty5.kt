class Client(val name:String, val email:String)
fun fetchClientFromDatabase():Client{
    println("fetching client from the database...")
    Thread.sleep(1000)
    return Client("coco crunch", "crunch@example.com")
}
val currentClient:Client by lazy{
    fetchClientFromDatabase()
}
fun main(){
    println("welcome to the app")
    println("client: ${currentClient.name}")
    println("client email: ${currentClient.email}")
}