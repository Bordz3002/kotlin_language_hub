# @Target (meta-annotation)
## What is it?
`@Target` is a meta-annotation. This means its an annotation used on other annotation to specify where those annotation can be placed
# Analogy
"Think of it as an 'instruction manual' for your custom annotation, telling the compiler: 'This annotation can only be used here, here and here'"
## How to define it
```
@Target(AnnotationTarget.CLASS, AnnotationTarget.Function)
annotation class MyCustomAnnotation
```
This code means:
- `MyCustomAnnotation` is a custom annotation
- because its annotated with `@Target`, it can be only used on classes and functions
## Parameters
`@Target` accepts one or more `AnnotationTarget` enum values. Common targets include:  
`Target(AnnotationTarget)  ----------> Where it can be used`
- `CLASS` - classes, interfaces, objects  
- `FUNCTION` - functions  
- `PROPERTY` - properties  
- `FIELD` - fields (the backing field of a property)  
- `VALUE_PARAMETER` - function or constructor parameters 
- `CONSTRUCTOR` - constructors  
- `TYPE_PARAMETER` - generic type parameters
- 