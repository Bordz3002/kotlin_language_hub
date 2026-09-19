//declaring multiple exceptions
import java.io.IOException
import java.lang.SecurityException
@Throws(IOException::class, SecurityException::class)
fun readSecureFile(path:String):String{
    if(path.isEmpty()){
        throw IOException("file path cannot be empty")
    }
    if(path.contains(other="..")){
        throw SecurityException("access denied: path traversal detected")
    }
    return "secure content from: $path"
}

fun main(){
    try{
        println(readSecureFile(path="data.txt"))
    }catch(e:IOException){
        println("IO error: ${e.message}")
    }catch(e:SecurityException){
        println("security error: ${e.message}")
    }

    try{
        println(readSecureFile(path=""))
    }catch(e:IOException){
        println("IO error: ${e.message}")
    }catch(e:SecurityException){
        println("security error: ${e.message}")
    }

    try{
        println(readSecureFile(path="../secret.txt"))
    }catch(e:IOException){
        println("IO error: ${e.message}")
    }catch(e:SecurityException){
        println("security error: ${e.message}")
    }
}