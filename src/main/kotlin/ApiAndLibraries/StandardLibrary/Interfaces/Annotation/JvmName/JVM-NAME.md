# `@JvmName`
`@JvmName` is another Kotlin - Java interoperability annotation, but this time it controls the name that Kotlin generates for the JVM/Java side. 
## What problems does it solve?
Suppose you have:   
```
fun calculate(){
    println("kotlin function")
}
```
By default, Java sees the generated method as: `calculate()`  
But you can tell Kotlin to give the JVM method a different name:  
```
@JvmName("calculateYield")
fun calculate(){
    println("kotlin function")
}
```
From Kotlin, you still write: `calculate()`  
While Java can see: `calculateYield()`
### The simplest definition: **`@JvmName` lets you specify the name that a Kotlin declaration should have on the JVM/Java side**