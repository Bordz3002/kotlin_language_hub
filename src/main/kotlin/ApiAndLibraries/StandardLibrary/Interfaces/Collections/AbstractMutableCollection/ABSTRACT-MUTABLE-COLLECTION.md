# `AbstractMutableCollection`
`AbstractMutableCollection` is a starter template for building your own mutable (changeable) collection.   
It's an abstract class that already implements most of the boring parts of the `MutableCollection` interface - so you only have to write a few methods yourself.  
Think of it like: **I want to make my own collection that supports adding and removing items. Instead of writing 20 methods, I'll extend `AbstractMutableCollection` and only write the essentials**
## Why does it exist?
Kotlin has two separate hierarchies for collections:  

| Hierarchy | Purpose |
| --------- | ------- |
| `AbstractCollection` | For read-only collections (can't add/remove) |
| `AbstractMutableCollection` | For mutable collections (can add/remove |

The Kotlin designers created this split because Java `AbstractCollection` had a problem: its mutation methods (like: `add`, `remove`) weren't abstract -  they just threw exceptions. This meant you could forget to override them and only find out at runtime  
`AbstractMutableCollection` fixes this by making those mutation methods - forcing you to implement them deliberately 

## What is NOT
| It is NOT | Explanation |
| --------- | ----------- |
| A collection you use direclty | You can't instantiate it |
| A replacement for `mutableListOf()` | It's a base class for building collections |
| Something you use in daily code | Only library authors need it |

## Key Idea
`AbstractMutableCollections` = a partial implementation of `MutableCollection` that you can extend you build you own mutable collection with minimal code.   

## Simple Analogy
Imagine you're building a custom box that can hold items:  
- `MutableCollection` = blueprint: "you need a size, an iterator, and a way to add/remove"
- `AbstractMutableCollection` = a pre-built frame with the most machinery already installed
- You = just add the specific parts for adding and removing items

## Key Points to Remember
1. It's abstract - you can't create an instance directly
2. You must implement `size`, `iterator()`, and `add(elements)` - the essentials
3. Everything else is free - `isEmpty()`, `contains()`, `addAll()`, `remove()`, etc
4. Mutable - it implement `MutableCollection`
5. It's for library authors - not everyday Kotlin code 