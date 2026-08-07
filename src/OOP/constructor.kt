class Car(var brand:String, var model:String, var year:Int);
fun main(args:Array<String>){
    val car1=Car("porsche", "gt3rs", 2012);
    val asianCar=Car("toyota", "hilux", 2017);
    println("the car is: ${car1.brand}, ${car1.model}, ${car1.year}");
    println("the asian car is: ${asianCar.brand}, ${asianCar.model}, ${asianCar.year}");
}