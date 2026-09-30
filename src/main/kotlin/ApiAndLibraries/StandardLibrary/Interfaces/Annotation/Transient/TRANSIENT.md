# `@Transient`
`@Transient` is an annotation that tells the JVM: "Don't save this property when serializing the object"  
**Think of it like a "skip" this sticker on a box when packing - the item stays with you, but it doesn't go into the shipment**  
## What is Serialization?
Before you understand `@Transient`, you need to understand serialization  
**Serialization** = Converting an object into a stream of bytes so it can be
- save to a file
- sent over a network
- stored in a database
- cached in memory

**Deserialization** the reverse - rebuilding the object from those bytes
````
text

object -> serialize -> bytes -> deserialize -> object
````
## What `@Transient` does?
When an object is serialized, all property are normally included. But some properties shouldn't be saved:

| Property type | Why skip it? |
| ------------- | ------------ |
| Password | security risk - don't write to disk |
| Derived data| can be recalculated later |
| File handles | can't be serialized |
| Database connection | can't be serialized |
| Cached values | temporary - not needed |
`@Transient` marks these properties so they're excluded from serialization

## The Key idea
```
kotlin

class User(
    val username:String //saved
    @Transient val password:String //not saved
)
```
when you serialize a `User`:  
- `username` is written to the byte stream
- `password` is skipped

When you deserialize:
- `username` is restored
- `password` gets its default value (or `null` if nullable)

## What `@Transient` is NOT

| it is NOT | explanation |
| --------- | ----------- |
| encryption | it doesn't hide data - it just skips it |
| deletion | the propert still exists in the object |
| a runtime feature | it only affects serialization |
| a kotlin-specific thing | its a JVM annotation |

## Where does it apply?

| context | works? |
| ------- | ------ |
| java serialization | yes |
| kotlin serialization | uses `@Transient` from `kotlinx.serialization` |
| Gson | yes (or `@Transient` keyword |
| Jackson | yes (or `@JsonIgnore` |

important: `@Transient` is from `kotlin.jvm.Transient - its a jvm annotation

