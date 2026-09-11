# What is `@Repeatable`?
`@Repeatble` is an annotation that allows the same annotation to be applied multiple times to the same declaration  
Without `@Repeatable`, an annotation normally behaves like a label that can appear only once
## For Example
```
@Tag("Agriculture")
class Farm
```
you normally cannot do this:
```
@Tag("Agriculture")
@Tage("Technology")
class Farm
```
The compiler sees two instances of the same `@Tag` annotation attached to `Farm` and rejects it