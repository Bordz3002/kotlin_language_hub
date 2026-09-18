# `@Throws`
`@Throws` is an annotation that tells the Java compiler which exceptions a Kotlin function might throw. It's only for Java interoperability  
**Think of it like: "Hey Java, this function might throw these exceptions -- you need to handle them"**
## The Key Concept: Checked vs Unchecked Exceptions
To understand `@Throws`, you first need to understand the difference between Java and Kotlin when it comes to exceptions
### Java: Checked Exceptions
In Java, some exceptions are checked -- the compiler forces you to handle them:
```
Java

public String readFile(String path) throws IOException{
    //must declare "throws IOException"
    //caller MUST handle it
}
```
If you call this in Java, you must either:
- Wrap it in a `try-catch`
- Or declare `throws IOException` on your own method
### Kotlin: No Checked Exceptions
Kotlin doesn't have checked exceptions. You can throw anything, anytime, without declaring it:
```
Kotlin

fun readFile(path:String):String{
    throw IOException("file not found") // no declaration needed
}
```
This creates a problem for Java developers calling Kotlin code. They don't know what exceptions to expect. 
## How`@Throws` Solves this
`@Throws` bridges the gap. It tells the Java compiler: **"This Kotlin function can throw these exceptions"**  
```
Kotlin

@Throws(IOException::class)
fun readFile(path:String):String{
    //..
}
```
Now Java sees it as:
```
Java

public String readFile(String path)throws IOException{
    //..
}
```
## What `@Throws` Is Not
| It is NOT                     | Explanation                              |
| ----------------------------- | ---------------------------------------- |
| A Kotlin requirement          | Kotlin doesn't need it -- only Java does |
| A runtime feature             | It only affects compilation              |
| A way to catch exceptions     | It only declares what might be thrown    |
| Necessary for pure Kotlin     | Only needed for Java interop             |
## Key Points to Remember
1. `@Throws` is for Java interop -- Kotlin doesn't care
2. It declares exceptions -- tells Java what to catch
3. It doesn't change the Kotlin behavior -- Kotlin still allows anything
4. It's a bridge -- connects Kotlin exception model to Java's
5. Common in libraries -- so Java developers can use you Kotlin code safely
## The Simple Rule
**If Java code will call your Kotlin function and your function throws checked exceptions, use `@Throws`**