val greeting:String by lazy{
    println("computing greeting...")
    "hello lord"
}
fun main(){
    println("before accessing")
    println(greeting) //first access: computes and caches
    println(greeting) //second access: use/return cached value
}