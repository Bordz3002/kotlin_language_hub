/*@property{parentClass}-super class*/
open class ParentClass{
    val name:String="parent class";
}
/*@property{ChildClass}-sub class*/
class ChildClass:ParentClass(){
    /*@property{childFunction}-accessing the parent's class variable*/
    fun childFunction(){println("${name}");}
}
fun main(args:Array<String>){
    val obj=ChildClass();
    obj.childFunction();
}