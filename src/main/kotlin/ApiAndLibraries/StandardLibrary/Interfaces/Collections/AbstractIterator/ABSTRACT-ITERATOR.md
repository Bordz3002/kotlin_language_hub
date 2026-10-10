# `AbstractIterator`
`AbstractIterator` is a helper base class for building your own iterators  
It handles the tricky parts of iteration for you, so you only need to write one method: how to compute the next value  
Think of it like: **"I want to create a custom iterator. Instead of writing all the state-tracking code myself, I'll extend `AbstractIterator` and just tell it how to produce the next item."**
## Why does it exist?
The `Iterator` interface has two methods:
- `hasNext()` - is there another item?
- `next()` - give me the next item

Writing both correctly requires managing internal state (position, whether the iteration is needed, etc.) It's easy to get wrong  
`AbstractIterator` does that state management for you. You only implement:  
- `computeNext()` - produce next value, or signal the end
## What you must implement
Just one method:
```
Kotlin

override fun computeNext(){
    //If there's a next value
    setNext(value)
    
    //if iteration is done:
    done()
} 
```
Everything else - `hasNext()`, `next()` - is handled by the base class
## What is Not

| It is NOT | Explanation |
| --------- | ----------- |
| An iterator you use directly | You can't instantiate it |
| A replacement for `list.iterator()` | It's for building custom iterators |
| Something you use in daily code | Only when creating custom iteration logic |

## Key Idea
`AbstractIterator` = a base class that lets you create a custom iterator by implementing only `computeNext()`

## Simple Analogy
Imagine you're making a music playlist iterator:
- `Iterator` = the full contract: **"tell me if there's a next song, and give me the next song"**
- `AbstractIterator` = handles remembering where you are in the playlist
- You = just say **"here's the next song"** or **"we're done"**

## When would you ever use it?
Only when you need a custom iterator - like:
- Generating  numbers on the fly (fibonacci, primes)
- Reading lines from a file one by one
- Paginating through API results
- Building a custom collection with lazy iteration

For normal Kotlin code, you use `for` loops and built-in collections -you never touch `AbstractIterator`