//annotation only for functions

//define annotation that can only be used on functions
@Target(AnnotationTarget.FUNCTION)
annotation class LogExecution

class Calculator{
    //correct: used on a function
    @LogExecution
    fun add(a:Int, b:Int):Int{return a+b}

    //incorrect: used on a class
    //@LogExecution
    //class InnerClass{}
}
