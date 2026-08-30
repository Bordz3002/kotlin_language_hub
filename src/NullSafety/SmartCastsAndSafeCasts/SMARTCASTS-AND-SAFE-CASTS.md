# Smart Casts and Safe Casts
## Definition:
- Smart Casting means Kotlin automatically remembers that you've checked a variable's type and treats it as that type inside the check block
## Analogy
- "Once you check it's specific type, Kotlin remembers so you dont have to cast it again"
## The Problem Smart Casts Solve
- ### Without Smart Casts (JAVA)
```
Object obj="hello";
if(obj instance of String){
    String str=(String) obj; //must manually cast
    System.out.println(str.length())
}
```
- ### With Smart Casts (KOTLIN)
```
val obj:Any="helo"
i(obj is String){
    println(obj.length)
}
```
Kotlin knows: "I checked its a String, so obj is a String inside this block"