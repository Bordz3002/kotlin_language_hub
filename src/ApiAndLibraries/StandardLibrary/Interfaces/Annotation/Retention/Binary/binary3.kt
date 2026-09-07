//java/kotlin interoperability

import kotlin.annotation.AnnotationRetention
import kotlin.annotation.Retention

@Retention(AnnotationRetention.BINARY)
annotation class JvmOverloads

//this tells the compiler to generate Java overloads
//the annotation is needed during compilation
//but not at runtime
@JvmOverloads
fun greet(name:String="world"){
    println("hello, $name")
}

//in Java you can call the ff:
//greet() and greet("kotlin")