/*@param{num1}-Int, @param{num2}-Int, @return{value}-int*/
fun addition(num1:Int, num2:Int):Int{
    return (num1+num2);
}
/*@example2*/
/*@param(expectString)-String, @return(value)-String*/
fun capitalize(expectString:String):String{
    return (expectString.uppercase());
}
fun main(args:Array<String>){
    println("123 + 3243213: ${addition(123, 3243213)}");
    println("capitalize 'bamboo': ${capitalize("bamboo")}");
}