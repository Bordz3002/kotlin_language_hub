class Android{
    var version:Int=0;
    var name:String="";
    var year:Int=0;
}
fun main(args:Array<String>){
    /*@property{android5} - Android Object*/
    val android5=Android();
    android5.version=5;
    android5.name="lollipop";
    android5.year=2017;
    println("android: ${android5.version}, ${android5.name}, ${android5.year}");
    val android13=Android();
    android13.version=13;
    android13.name="tiramisu";
    android13.year=2023;
    println("android: ${android13.version}, ${android13.name}, ${android13.year}");
}