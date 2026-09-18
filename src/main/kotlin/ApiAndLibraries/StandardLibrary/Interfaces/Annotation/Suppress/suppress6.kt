//suppressing at file level
@file:Suppress("UNUSED_VARIABLE") //file level warning suppression
package com.example
fun main(){
    val unused1:String="first unused" //throws - property is never used
    val unused2:String="second unused" //throws - property is never used
    println("hello")
}
fun anotherFunction(){
    val unused3:String="third unused" //throws - property is never used
    println("world")
}