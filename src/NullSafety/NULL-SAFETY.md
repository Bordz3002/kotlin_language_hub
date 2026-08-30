# Null Safety
## Definition:
- Null Safety means Kotlin forces you to hande missing values (nulls) properly.
- It prevents the dreaded NullPointerException (NPE) at runtime
## Analogy
- "You cant have an empty box unless you clearly mark it"
## The Problem Null Safety Solves
- ### Without Null Safety (Java/Other Languages)
```
String name=null;
int length=name.length() //NullPointerException! CRASH!
```
- ### With Null Safety (Kotlin)
```
var name:String?=null
var length=name.length
```
## Two Types of Variables
kotlin has 2 types for every variable
- ## Non-Nullable 
    Can never be null
    ```
    Example: String
    ```
- ## Nullable
    Can be Null
    ```
  Example: String?
    ```
## The Basic Rule
- If the variable can be null, you must CHECK beore using it