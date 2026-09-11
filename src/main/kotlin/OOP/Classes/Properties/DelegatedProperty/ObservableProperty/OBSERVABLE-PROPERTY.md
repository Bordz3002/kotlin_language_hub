# Observable Property
## Definiton:
- An Observable property watches for changes and runs code every time the value changes
## Anatomy
- "Every time the value changes, do something"
## Simple Example:
```
import kotlin.properties.Delegates
var score: Int by Delegates.observable(0){
    property, oldValue, newValue -> println("score changed: $oldValue -> newValue")
}
fun main(){
    score=10 //prints: score changed: 0 -> 10
    score=25 //prints: score changed: 10 -> 25
    score=10 //prints: score changes: 25 -> 10
}
```