fun main(args:Array<String>){
    var counter:Int=0;
    while(counter<10){
        counter++;
        if(counter==4){continue;}
        println("${counter}")
    }
}