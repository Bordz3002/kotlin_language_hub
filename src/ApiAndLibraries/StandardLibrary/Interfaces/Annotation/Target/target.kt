//define an annotation that can only be used on classes and functions
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class MyCustomAnnotation

//correct usage: on a class
@MyCustomAnnotation
class MyClass

//correct usage: on a function
@MyCustomAnnotation
fun customFunction(){}

//incorrect usage: on a property (compiler error)
//@MyCustomAnnotation
//val property="hello"