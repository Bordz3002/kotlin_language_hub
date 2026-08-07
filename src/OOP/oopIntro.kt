class Person{
    var name:String="";
    var health:Int=0;
    var address:String="";
}
fun main(args:Array<String>){
    val naval=Person();
    naval.name="paolin mark nickson naval";
    naval.health=85;
    naval.address="san antonio";
    println("my name is ${naval.name} residing in ${naval.address} and my health status is: ${naval.health}");
}