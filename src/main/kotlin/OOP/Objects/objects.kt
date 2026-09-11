object Farm{
    var cropCount:Int=0
    fun plant(){
        cropCount++
        println("crop planted: $cropCount")
    }
}
fun main(){
    for(i in 1..5){
        Farm.plant()
    }
}