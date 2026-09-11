class Cars(var brand:String, var model:String, var year:Int){
    fun drive(sound:String){println("the $year $brand $model goes: $sound");}
}
fun main(args:Array<String>){
    val myCar=Cars("toyota", "supra mk4", 2010);
    myCar.drive("brap brap brap");
}