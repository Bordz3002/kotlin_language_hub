class MathHelper{
    fun double(expectNumber:Int):Int{
        return expectNumber*2
    }
    companion object{
        fun square(expectNumber:Int):Int{
            return expectNumber*expectNumber
        }
    }
}
fun main(){
    val helper=MathHelper()
    println(helper.double(23))

    //with class's companion object
    println(MathHelper.square(23))
}