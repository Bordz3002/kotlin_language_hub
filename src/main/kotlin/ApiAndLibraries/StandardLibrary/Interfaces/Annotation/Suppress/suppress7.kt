//suppressing redundant visibility modifier
@Suppress("REDUNDANT_VISIBILITY_MODIFIER") //warning suppression
public class Self{ //throws - redundant 'public' modifier
    public fun myFunction(){ //throws - redundant 'public' modifier
        println("hello from myFunction")
    }
}
fun main(){
    val obj=Self()
    obj.myFunction()
}
