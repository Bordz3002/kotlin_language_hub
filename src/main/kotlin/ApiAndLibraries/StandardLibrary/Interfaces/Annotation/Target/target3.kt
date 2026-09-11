//annotation only for properties

//define an annotation that can be only be used on properties
@Target(AnnotationTarget.PROPERTY)
annotation class JsonIgnore

class Something{
    //correct: used on a property
    @JsonIgnore
    val password:String="secret"

    //incorrect: cant be used on a function
    //@JsonIgnore
    //fun getPassword(){}
}