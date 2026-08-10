fun main(args:Array<String>){
    /*@example1*/
    val day:Int=4
    /*when as expression with a subject*/
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
    println("the day is: ${result}")
    /*example2*/
    val obj="hello"
    when(obj){
        "1"->println("obj is: 1")
        "hello"->println("obj is: ${obj}")
        else->println("unknown")
    }
//when expression without a subject
    val trafficLightState:String="red"
    val trafficAction=when{
        trafficLightState=="green"->"go"
        trafficLightState=="yellow"->"slow down"
        trafficLightState=="red"->"stop"
        else->"malfunction"
    }
    println("trafficAction: ${trafficAction}");
}