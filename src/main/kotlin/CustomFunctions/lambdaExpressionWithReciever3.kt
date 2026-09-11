fun main(){
    val doubled:Int.()->Unit={
        println(this*2)
    }
    100.doubled()
}