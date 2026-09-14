# `@JvmStatic`
`@JvmStatic` is a Kotlin annotation used for Java interoperability  
Its job is to make a function or property inside a Kotlin `object` also appear to Java as a static member
## First, understand Kotlin `object`
Kotlin has a special construct called `object`  
```
object FarmTools{
    fun calculateYield(){
        println("calculating yield")
    }
}
```
There is only one instance of `FarmTools`  
From Kotlin, you call:
`FarmTools.calculateYield()`  
That looks similar to a Java static method, but internally Kotlin's `object` is actually implemented as a singleton object  
## Where `@JvmStatic` comes in
``` 
object FarmTools{
    @JvmStatic
    fun calculateYield(){
        println("calculating yield")
    }
}
```
Now Kotlin still lets you write: `FarmTools.calculateYield()`  
But Java can also see `calculateYield()` as a static method