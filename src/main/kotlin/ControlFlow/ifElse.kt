/* if(condition){block} */
fun main(args:Array<String>){
    /*@example1*/
    val num1:Byte=10;
    val num2:Byte=20;
    if(num1>num2){
        println("$num1 is greater than $num2");
    }else{
        println("$num2 is greater than $num1");
    }
    /*one liner example. Kotlin does not have ternary operation*/
    println(if(num1>num2)num1 else num2);
    /*@example2*/
    val time:Byte=20;
    val greeting:String=if(time<18){"good day"}else{"good evening"};
    println("message: $greeting");
}