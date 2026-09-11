# The Challenge with Nulls in Collections
Collections often contains `null` values or operations that might fail and return `null`. Kotlin provides specific functions to handle these situations safely and concisely
## 1. Filtering Null Values
- filterNotNull()  
Removes all 'null' elements from a collection  
`! Please refer to the example codes @filterNotNull.kt`
- listOfNotNull()  
Creates a list while ignoring `null` values at creation time  
`! Please refer to the example code @listOfNotNull.kt`  
## 2. Finding Values That May Not Exist
These functions returns `null` if nothing matches  
- `maxOrNull()` - finds the highest value, or `null` if empty
- `minOrNull()` - finds the lowest value, or `null` if empty
- `singleOrNull()` - finds the single item matching a condition, or `null` if none or multiple  
`! Please refer to the example codes`
## Transforming Collections with Nulls
- `mapNotNull()` - transforms each element and filters out `null` results