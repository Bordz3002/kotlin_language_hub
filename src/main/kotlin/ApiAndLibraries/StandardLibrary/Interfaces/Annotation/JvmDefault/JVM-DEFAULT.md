# `@JvmDefault`
`@JvmDefault` is a Kotlin/Java interoperability annotation related to default method implementations inside interfaces  
## Kotlin interfaces can contain implementations
For example:
```
Kotlin

fun start()
fun status(){
    println("device is ready")
}
```
Here:
- `start()` is abstract - implementing classes must provide it
- `status()` already has an implementation  

In Kotlin, this is completely normal  
## Why does the JVM matter?
JAva interfaces also support default methods:
```
Java

interface DeviceController{
    void start();
    default void status(){
        System.out.println("device is ready")
    }
}
```