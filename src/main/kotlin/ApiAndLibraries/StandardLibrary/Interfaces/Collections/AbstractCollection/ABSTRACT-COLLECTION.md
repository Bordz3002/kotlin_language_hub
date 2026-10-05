# `AbstractCollection`
`AbstractCollection` is a starter template for building your own collection class  
It's an abstract class that already implements most of the boring parts of the `Collection` interface - so you only have to write a couple of methods yourself  
Think of it like: **"I want to make my own collection. Instead of writing 20 methods, I'll extend `AbstractCollection` and only write 2"**
## Why does it exist
The `Collection` interface has many methods:  
- `size`
- `isEmpty()`
- `contains()`
- `containsAll()`
- `iterator()`
- `toString()`
- etc

If you implemented `Collection` directly, you'd have to write all of them.  
`AbstractCollection` writes most of them for you - you only provide the essential 2:
1. `size`
2. `iterator()`
Everything else is inherited and works automatically

## What is NOT
| It is NOT | Explanation |
| --------- | ----------- |
| A collection you use directly | You can't instantiate it |
| A replacement for `List` or `Set` | It's a base class for building them |
| Something you use in daily code | Only library authors need it |

## Key Idea
`AbstractCollection` = a partial implementation of `Collection` that you can extend to build your own collection with minimal code  ]
## Simple Analogy
Imagine you're building a house: 
- `Collection` = blueprint listing every room you must build
- `AbstractCollection` = a pre-built house frame (walls, roof, plumbing)
- You = just add the doors and windows (`size` and `iterator()`)

## When would you ever use it
Only when you're creating a brand-new collection type from scratch - like:
- A custom read-only list
- A special set with unique rules
- A collection backed by a database of file

For normal Kotlin code, you use `listOf()`, `setOf()`, `mapOf()` - you never touch `AbstractColletion`