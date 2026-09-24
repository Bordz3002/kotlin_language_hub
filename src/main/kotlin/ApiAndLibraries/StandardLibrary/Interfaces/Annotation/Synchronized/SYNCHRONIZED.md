# `@Synchronized`
`@Synchronized` is an annotation that makes a function or property thread-safe by ensuring only one thread can execute it a time  
**"Think of it like: Only one person can enter this room at a time - everyone else must wait outside"**
## Why Does this matter?
In multithreaded programs, multiple threads can access the same code, simultaneously, causing race-conditions:

| problem | what happens |
| ------- | ------------ |
| thread A | Reads a value |
| thread B | reads the same value |
| both | modify it |
| result | wrong value - one update is lost! |
`@Synchronizeed` prevents this by locking the code - only one thread can execute it at time
## What `@Synchronized` does?
| it guarantees | how |
| ------------- | --- |
| mutual exclusion | only one thread at a time |
| atomicity | compound operations are safe |
| visibility | changes are visible to all threads |

## Where you can use it?

| location | example |
| -------- | ------- |
| member function | `@Synchronized fun increment()` |
| property getter/setter | `@Synchronized get(){}` |
| companion object function | `@Synchronized fun create(){}` |
| top-level function (JVM only) | `@Synchronized fun doWork()` |

## Key Points 
1. only one thread at a time - mutual extension
2. locks on the object - `this` for member functions
3. works with any code - not just single operations
4. slight performance cost - because of locking