//declaring a single exception
import java.io.IOException
@Throws(IOException::class)
fun readFile(path:String):String{
    if(path.isEmpty()){
        throw IOException("file path cannot be empty")
    }
    return "file content from: $path"
}

fun main(){
    try{
        println(readFile(path="text.txt"))
        println(readFile(path=""))
    }catch(e:IOException){
        println("caught: ${e.message}")
    }
}