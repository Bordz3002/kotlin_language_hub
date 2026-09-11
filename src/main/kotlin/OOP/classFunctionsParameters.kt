class Motorcycle(var brand:String, var model:String, var year:Int){
    fun drive(){println("broom brom");}
    fun speed(maxSpeed:Int){
        println("the max speed is set to: ${maxSpeed}");
    }
}
fun main(args:Array<String>){
    val hayabusa=Motorcycle("suzuki", "hayabusa", 2002);
    hayabusa.drive();
    hayabusa.speed(204);
}