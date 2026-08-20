class BigBen{
    companion object {
        fun getBongs(expectCounter:Int){
            repeat(expectCounter){print("bong ")}
        }
    }
}
fun main(){
    with(BigBen){
        getBongs(10)
    }
}