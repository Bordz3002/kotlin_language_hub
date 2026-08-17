fun main(){
    val greeting:String.()->Unit={
        println("Hello $this, welcome to kotlin")
    }
    "totoro".greeting()
}