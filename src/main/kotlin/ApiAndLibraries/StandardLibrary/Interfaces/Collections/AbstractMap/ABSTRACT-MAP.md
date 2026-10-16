# `AbstractMap`
`AbstractMap` is a starter template for building your own Map (key-value collection)  
It's an abstract class that already implements most of the boring parts of the `Map` interface -  
so you only have to write one thing yourself: the set of entries  
Think of it like:  
**"I want to make my own map. Instead of writing 15 methods, I'll extend `AbstractMap` and only provide the entries"**
## Why does it exist?
The `Map` interface has many methods:
- `size`
- `isEmpty()`
- `get(key)`
- `contains(key)`
- `containsValue(value)`
- `keys`
- `values`
- `entries`
- etc

If you implement `Map` directly, you'd have to write all of them.  
`AbstractMap` writes most of them for you - you only provide the essential 1:  
1. `entries` - the set of key-value pairs  

Everything else is inherited and works automatically  
## What is NOT

| It is NOT | Explanation |
| --------- | ----------- |
| A map you use directly | You cant't instantiate it |
| A replacement for `mapOf()` | It's a base class for building maps |
| A `Collection` | `Map` does not extend `Collection` |
| Something you use in daily code | Only library authors need it |

## Key Idea
`AbstractMap` = a partial implementation of `Map` that you can extend to build your own with minimal code
