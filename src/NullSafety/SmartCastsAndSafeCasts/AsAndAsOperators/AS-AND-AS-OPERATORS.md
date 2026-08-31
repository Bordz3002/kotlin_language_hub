# As and As? Operators
## Definition:
These **Operators** are used to convert a variable from one type to another
- `as` : "Convert this type to that type, or crash if you cant"
- `as?` : "Try to convert this type to that type, but give me a `null` if you cant"
## Analogy:
- `as`: "Force to fit, no matter what"
- `as?`: "Try to fit, but its okay if its doesnt"
## The Simplest `as` Example
```
fun main(){
    val something:Any="hello"
    val str:String=something as String //cast to String
    println(str.length) //5
    println(str.uppercase()) //HELLO
}
```
## The Simplest `as?` Example
```
fun main(){
    val something:Any="hello"
    val str:String?=something as? String //safe cast
    println(str?.length) //5
}
```
## The Difference: `as` vs `as?`
Using `as` (Unsafe - Can Crash)
```
fun main(){
    val someting:Any=42 //variable is an Int type not a String type
    val str:String=something as String  //ClassCastException Error
    println(str)
}
```
Crash!, Kotlin throws a `ClassCastException` because 42 cant be a String

Using `as?` (Safe - Returns Null)
```
fun main(){
    val something:Any=42 //variable is an Int type and not a String type
    val str:String?=something as? String //returns null (no crash!)
    println(str) //null
}
```