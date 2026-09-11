# `@Retention`
## What is `@Retention`?
- `@Retention` is a meta-annotation that specify how long an annotation should be kept (retained) in code. 
## Analogy
- "Do I need this annotation only while writting the code, or do I also need it at runtime?"
## The Three Retention Policies
`POLICY -------------DESCRIPTION--------------WHEN TO USE`  
- `SOURCE` - Annotation is only in the source code: removed during compilation - for compile-time checks only
- `BINARY` - Annotation is in the compiled class file: not available at runtime - for tools that analyze bytecodes
- `RUNTIME` - Annotation is availble in runtime via reflection - When you need to read annotations while the program runs