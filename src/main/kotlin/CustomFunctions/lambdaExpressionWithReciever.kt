fun main(){
    val action:String.() ->Unit={
        println(uppercase())
    }
    "hi am bornok".action()
}