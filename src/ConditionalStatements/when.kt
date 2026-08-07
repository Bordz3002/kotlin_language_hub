fun main(args:Array<String>){
    /*@example1*/
    val day:Int=4;
    val result:String= when(day){
        1->"monday"
        2->"tuesday"
        3->"wednesday"
        4->"thursday"
        5->"friday"
        6->"sunday"
        7->"saturday"
        else->"invalid day"
    }
    println("the day is: ${result}");
}