# Is and !Is Operators
## Definition:
- 'is' checks if a variable is a certain type. 
- '!is' checks if a variable is not a certain type
## The Simplest 'is' Example:
Code:
```
fun main(){
    val something:Any="hello"
    if(something is String){
        println("yes, it is a String")
    }else{
        println("not a String")
    }
}
```
Output: 
```
yes, it is a String
```
## The Simplest '!is' Example:
Code:
```
fun main(){
    val something:Any=42
    if(someting !is String){
        println("it is NOT a String")
    }else{
        println("it is a String")
    }
}
```
Output:
```
it is NOT a String
```