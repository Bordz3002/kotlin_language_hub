# `AbstractMutableMap`
`AbstractMutableMap<K, V>` is a skeletal implementation of the `MutableMap` interface.  
It provides default implementations for most `MutableMap` methods, so you only need to implement one essential member: `entries`  
Think of it as a starter template for building your own mutable (changeable) key-value map.  
## Why does it exist
Kotlin has two separate hierarchies for maps:  

| Hierarchy | Purpose |
| --------- | ------- |
| `AbstractMap` | For read-only maps     |
| `AbstractMutableMap` | For mutable maps (can add/remove/update) |

The Kotlin docs say: *"To make the creation of the new implementations easier, us the skeletal implementations of collection interfaces from the standard library: `AbstractCollection`, `AbstractList`, `AbstractSet`, `AbstractMap`, and their mutable counterparts"*  
Without `AbstractMutableMap`, you'd have to implement every single method in the `MutableMap` interface. With it, you get most of them for free. 
## What you must implement
According to the Kotlin source code, `AbstractMutableMap` requires you to implement this abstract member:
1. `entries` - a `MutableSet<MutableMap.MutableEntry<K, V>>`  
Everything else is inherited

## What is provides for free
`AbstractMutableMap` implements the following `MutableMap` methods for you:

| Method | What it does |
| ------ | ------------ |
| `size` | returns the number of entries |
| `isEmpty()` | checks if the map is empty |
| `containsKey(key)` | checks if a key exists |
| `containsValue(value)` | checks if a value exists |
| `get(key)` | returns the value for a  key |
| `put(key, value)` | adds or updates an entry |
| `remove(key)` | removes an entry |
| `putAll(from)` | adds all entries from another map |
| `clear()` | removes all entries |
| `keys` | returns a mutable set of all keys |
| `values` | returns a mutable collection of all values |
| `equals` | compares with another map |
| `hashCode()` | returns a hash code |
| `toString()` | returns a string representation |

## Key Rules
| Rule | Explanation |
| ---- | ----------- |
| Must implement `entries` | A `MutableSet<MutableEntry<K, V>>` |
| Mutable | supports adding, removing and updating |
| Type is `<K, V>` | keys and values are invariant |
| Not a `Collection` | map does not extend Collection |

