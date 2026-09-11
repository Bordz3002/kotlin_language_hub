// using and() in chains
fun main() {
    val a: Boolean = true
    val b: Boolean = true
    val c: Boolean = false
    val result: Boolean = a.and(b).and(c)
    println(result)

    // equivalent to:
    val equivalent:Boolean=a && b && c
    println(equivalent)
}