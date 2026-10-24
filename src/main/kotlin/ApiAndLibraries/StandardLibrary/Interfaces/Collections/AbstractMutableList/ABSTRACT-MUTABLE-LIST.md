# `AbstractMutableList`
`AbstractMutableList<E>` is a skeletal implementation of the `MutableList` interface.  
It provides default implementations for most `MutableList` methods, so you only need to implement a few essential members  
Think of it as a starter template for building your own mutable, ordered list 
## Why does it exist?
Kotlin has two separate hierarchies for collections:  

| Hierarchy | Purpose |
| --------- | ------- |
| `AbstractList` | For read-only list |
| `AbstractMutableList` | For mutable lists (can add/remove/update) |

The Kotlin docs says: *to make the creation of new implementations easier, use the skeletal implementations of collection interfaces from the standard library: `AbstractCollection`, `AbstractList`, `AbstractSet`, `AbstractMap` and their mutable counterparts*  
Without `AbstractMutableList`, you'd have to implement every single method in the `MutableList` interface. With it, you get most of them for free.  
## What you must implement 
According to the Kotlin source code, `AbstractMutableList` requires you to implement these abstract members:  
1. `size` - the number of the elements
2. `get(index)` - returns the element at the given index
3. `add(index, element)` - inserts an element at the given index
4. `removeAt(index)` -removes the element at the given index
5. `set(index, element)` -replaces the element at the given index

Everything else is inherited
## What is provides for free
`AbstractMutableList` implements the following `MutableList` methods for you:

| Method | What it does |
| ------ | ------------ |
| `add(element` | adds to the end (calls `add(size, element)` |
| `remove(element)` | removes the first occurence |
| `addAll(elements)` | adds all elements to the end |
| `addAll(index, elements)` | inserts all elements at the index |
| `removeAll(elements)` | Removes all matching elements |
| `retainAll(elements)` | Keeps only matchhing elements |
| `clear()` | Removes all elements |
| `contains(element)` | checks if an element exists |
| `indexOf(element)` | finds the first position |
| `lastIndexOf(element)` | finds the last position |
| `iterator()` | returns a mutable iterator |
| `listIterator()` | returns a list iterator |
| `subList(from, to)` | returns a view of a portion |
| `toString()` | returns a string representation |
| `equals()` | compares with another list |
| `hashCode()` | returns a hash code |

## Key rules
| Rule | Explanation |
| ---- | ----------- |
| Must implement 5 members | `size`, `get(index)`, `add(index, element)`, `removeAt(index)`, `set(index, element)` |
| Mutable | supports adding, removing and updating |
| Ordered | elements have positions (indices) |
| Duplictates allowed | Same element can appear multiple times |

