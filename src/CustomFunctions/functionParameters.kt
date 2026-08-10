/*single paramter
* @param{name} - String */
fun myFunction(name:String){
    println("hello ${name}, welcome to kotlin");
}
/*multiple parameters
* @param{name}-String, @param{age}-Int*/
fun myFunction2(name:String, age:Int){
    println("hello ${name}, you are ${age} years old");
}
fun myFunction3(name:String, message:String="have a wonderfull day"){
    println("${message}, ${name}")
}
fun main(args:Array<String>){
    myFunction("naval");
    myFunction2("naval", 23);
    myFunction3("cococrunch");
}