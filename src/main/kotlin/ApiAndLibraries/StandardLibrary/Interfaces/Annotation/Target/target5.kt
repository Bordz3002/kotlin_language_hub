//all possible targets

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FIELD)
annotation class AllPurposeAnnotation
@AllPurposeAnnotation
class SomeClass{
    @AllPurposeAnnotation
    val myProperty:String="hello"
    @AllPurposeAnnotation
    fun myFunction(@AllPurposeAnnotation param:String){
        println(param)
    }
}