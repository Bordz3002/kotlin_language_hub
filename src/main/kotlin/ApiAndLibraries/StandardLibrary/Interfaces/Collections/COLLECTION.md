# `Collection`
`Collection<T>` is the foundation interface for all read-only collections in Kotlin. It defines what it means to be a **"group of items you can look at"**  
Think of it as the "parent" of both `List` and `Set`. It doesn't care about order or uniqueness - it just that it's a bunch of items you can inspect.  
## What in inherits from
`Collection<T>` extends `Iterable<T>`, which gives it the ability to be iterated over (looped through)
## What it provides
The `Collection` interface defines the most basic, common operations:

| Operation | Purpose |
| --------- | ------- |
|`size` | How many items are in the collection |
| `isEmpty()` | Whether it's empty |
| `contains(element)` | Whether a specific item exist |
| `containsAll(elements)` | Wether all specifies items exist |
| `iterator()` | For looping through items |

## Key Distinction: `Collection` vs `MutableCollection

| Interface | What it can do |
| --------- | -------------- |
| `Collection<T>` | Read-only access (size, contains, iterate) |
| `MutableCollection<T>` | Read + write (add, remove, clear) |

## Why `Collection` matters
`Collection` is used as a parameter type when you want a function to accept any kind of collection - whether it's a `List`, `Set`, or something else - as long as it's read-only
```
Kotlin

//this function accepts ANY collection (List, Set, etc)
fun printAll(colletion: Collection<String>){
    for(item in collection){
        println(item)
        
    }
}
```