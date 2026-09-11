# addSuppressed()
`addSuppressed()` is a function of the `Throwable` class that allows you to add one exception to the list of "suppressed" exceptions of another. In simpler terms, it lets you attach secondary errors to a primary error your throwing
## The Syntax
```
fun Throwable.addSuppressed(exception:Throwable)
```
- `exception` - the exception you want to add to the "suppressed" list of the `Throwable` object the function is called on. 