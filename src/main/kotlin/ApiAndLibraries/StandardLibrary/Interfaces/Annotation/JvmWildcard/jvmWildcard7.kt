//function parameters
open class ParentObject(val name:String)
class ChildObject(name:String):ParentObject(name)
fun processObjects(processor:(@JvmWildcard ParentObject)->Unit){
    processor(ParentObject("generic object"))
}
fun main() {
    val childProcessor:(ParentObject)->Unit={obj:ParentObject->
        println("processing ${obj.name}")
    }
    processObjects(childProcessor)
}