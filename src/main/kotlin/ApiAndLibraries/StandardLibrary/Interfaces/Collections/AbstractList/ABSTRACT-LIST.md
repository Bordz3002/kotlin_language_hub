# `AbstractList`
`AbstractList<out E>` is a skeletal implementation of the `List` interface.  
It provides default implementations for most `List` methods, so you only need to implement two essential members: `size` and `get(index)`.   
**Think of it as a starter template for building your own read-only list**  
## Why does it exist?
The Kotlin docs say: *To make use of new implementations easier, use the skeletal implementations of collection interfaces from the standard library: `AbstractCollection`, `AbstractList`, `AbstractSet`, `AbstractMap`, and their mutable counterparts*  
Without `AbstractList`, you'd have to implement every method in the `List` interface. With it, you get most of them for free.  
## What it inherits from
```
text

Iterable
    -- Collection
        --List
            --AbstractList <- We are here
```
`AbstractList<E>` extends `AbstractCollection<E>` and implements `List<E>`  
## What you must implement
You only need two members:
1. `size` - the number of elements
2. `get(index)` - returns the element at the given index.  

Everything else is inherited
## What it provides for free

| Method | What it does |
| ------ | ------------ |
| `isEmpty()` | Checks is the list is empty |
| `contains(element)` | Checks if an element exists |
| `indexOf(element)` | Finds the first position of an element |
| `lastIndexOf(element)` | Finds the last position of an element |
| `iterator()` | Returns an iterator |
| `listIterator()` | Returns a list iterator |
| `subList(from, to)` | Returns a view of a portion |
| `equals()` | Compares with another list |
| `hashCode()` | Returns a hash code |
| `toString()` | Returns a string representation |

## Key Rules

| Rule | Explanation |
| ---- | ----------- |
| Read-only | For mutable list, use `AbstractMutableList` |
| Must implement `size` | Tells how many elements |
| Must implement `get(index)` | Returns element at position |
| Index out of bounds | Throw `IndexOutOfBoundsException` |
| Covariant <out E> | Can hold subtypes |
