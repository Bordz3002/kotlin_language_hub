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
## 
