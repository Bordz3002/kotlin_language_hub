//@Throws on top-level functions
import java.io.IOException
@Throws(IOException::class)
fun validateAge(age:Int):Int{
    if(age<0){
        throw IOException("age cannot be negative")
    }
    if(age>150){
        throw IOException("age cannot be over 150")
    }
    return age
}

fun main(){
    try{
        println("vaild age: ${validateAge(age=25)}")
    }catch(e:IOException){
        println("IO error: ${e.message}")
    }

    try{
        println("valid age: ${validateAge(age=-5)}")
    }catch(e:IOException){
        println("IO error: ${e.message}")
    }

    try{
        println("valid age: ${validateAge(age=200)}")
    }catch(e:IOException){
        println("IO error: ${e.message}")
    }
}