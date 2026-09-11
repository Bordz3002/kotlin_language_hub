data class User(val name:String, val id:Int)
val user1 = User("bobordz", 7220614)
val user2 = User("esmeringhoy", 119135)
val user3 = User("bobordz", 7220614)
fun main(){
//    printable instance
    println("user1: $user1")
//    comparing instances
    println("user1 == user2: ${user1 == user2}")
    println("user1 == user3: ${user1 == user3}")
}