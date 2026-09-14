# `@JvmOverloads`
`@JvmOverloads` is a Kotlin annotation used for Java interoperability  
Its purpose is to tell Kotlin: **"When generating JVM code, create overload versions of this function or constructor for parameters that have default values"**
## The problem
Kotlin supports default parameters
```
fun createDrone(val name:String, val speed:Int=50)
```
Kotlin can call it either way:
```
createDrone("E88")
```
or
```
createDrone("E88", 80)
```
Java doesn't have Kotlin's default-parameter feature. So if Java needs to call this function, we can use:  
```
@JvmOverloads
fun createDron(val name:String, val speed:Int=50)
```
Kotlin creates Java-friendly overloads conceptually like:
```
createDrone(String, Int)
createDrone(String)
```
So Java can do: `createDrone("E88")` without having to provide `speed`