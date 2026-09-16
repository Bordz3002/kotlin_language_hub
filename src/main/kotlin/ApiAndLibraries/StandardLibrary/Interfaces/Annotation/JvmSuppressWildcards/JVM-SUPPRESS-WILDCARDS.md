# `@JvmSuppressWildcards`
This is essentially the counterpart to `@JvmWildcard`
### The problem it solves:   
Kotlin automatically translates some generic types into Java wildcards  
For example:  
```
Kotlin

fun showAnimals(animals:List<Animal>){}
```
may be represented to Java roughly as:
```
Java

void showAnimals(List<? extends Animal> animals){}
```
Sometimes you don't want that wildcard because your interacting with Java code that expects:  
```
List<Animal>
```
That's where:  
```
@JvmSuppressWildcards
```
comes in