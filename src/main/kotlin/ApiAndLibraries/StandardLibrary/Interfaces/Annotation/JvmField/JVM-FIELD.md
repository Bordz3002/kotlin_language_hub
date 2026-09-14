# `@JvmField`
`@JvmField` is a Kotlin annotation for Java interoperability  
Its purpose is to tell Kotlin:  
"Expose this Kotlin property directly as a Java field instead of requiring Java to use getter/setter"
## Why is this necessary
In Kotlin, when you write"
``` 
class Farm{
    val name:String="green farm"
}
```
you think of `name` as a property: `Farm.name`  
But on the JVM, Kotlin normally represents properties using accessor methods behing the scenes

**So the simplest definition is:** `@JvmField` exposes a Kotlin as a Java field