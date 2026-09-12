# What is `@MustBeDocumented`
`@MustBeDocumented` is a Kotlin annotation used to tell the documentation generator
## Analogy
"When you generate documentation for this code, include this annotation as part of the documented API"  
It is itself annotation that you place on your custom annotations
## Basic Structure
```
@MustBeDocumented
annotation class Important
```
Here: `@MustBeDocumented` - does not mean that `Important` will automatically generate documentation.  
Instead, it says that if `Important` is used on something that appears in generated documentation, the annotation usage should also be documented