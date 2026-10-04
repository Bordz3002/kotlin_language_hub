# `@JvmRecord`
`@JvmRecord` tells the Kotlin to compile a Kotlin data class as a Java `record` instead of a normal Java class  
So Java code sees it as a native Java record, not just a Kotlin class with getters  
## Why does this matter?
Java records (introduced in Java 16) are:  
- immutable data holders
- automatically get `equals()`, `hashCode()`, `toString()`
- have a compact, native syntax 

If your writing Kotlin for Java 16+ consumers, `@JvmRecord` makes your data class look and behave like a real Java record  
## Where can you use it?
Only on:
```
Kotlin

@JvmRecord
data class Point(val x:Int, val y:Int)
```
- data classes only
- NOT regular classes
- NOT non-data classes

## Rules you must follow

| Rule | Why |
| ---- | --- |
| Must be a data class | Records are data carriers |
| JVM target 16+ | Records dont exist before Java 16 |
| All properties must be `val` | Records are immutable |
| No extra properties outside constructor | Records only have record components |
| No custom `equal` / `hashCode` | Records generate them |

## Key Points to remember
1. JVM-only annotation - not for Kotlin / Native or JS
2. Java 16+ required - won't work on older JVMs
3. Data classes only - must be `data class`
4. Immutable only - all properties must be `val`
5. Java interop feature - mainly for library authors

## When to use it
- You're writing a library used from Java 16+
- You want Java devs to see a real `record`
- Your class is a simple immutable data holer
- [NOT] You're only writing Kotlin
- [NOT] You need mutable properties
- [NOT] You're targeting older Java version
 