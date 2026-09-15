# `@JvmWildcard`
`@JvmWildcard` controls whether Kotlin generates a Java wildcard (`? extends` / `? super`) for a generic type  
For example, Kotlin might have:   
```
List<String>
```  
While Java's representation can involve:
```
List<? extends String>
```
`@JvmWildcard` allows you to explicitly request that wildcard representation
### Why does this matter?
Kotlin and Java have different approaches to generic variance  

Kotlin:
```
List<out String>
```
Java:
```
List<? extends String>
```