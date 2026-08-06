fun main(args:Array<String>){
    /*@typedef {val} - immutable properties
    * - reassigning new value to the val type property is not allowed*/
    val firstName:String="paolin mark nickson";
    val lastName:String="naval";
    val fullName:String=firstName+" "+lastName.uppercase();
    val surname:String="NAVAL";
    /*@example*/
    println("my name is $fullName");
    println(lastName.compareTo(fullName));
    println(surname.lowercase().compareTo(lastName));
//    firstName="asdjkl;f";
}