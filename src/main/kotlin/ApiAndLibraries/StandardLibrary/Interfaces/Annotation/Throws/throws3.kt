//@Throws on constructor
import java.io.IOException
class FileReader @Throws(IOException::class) constructor(path:String){
    val content: String
    init{
        if(path.isEmpty()){
            throw IOException("path cannot be empty")
        }
        content="content of $path"
    }
}

fun main(){
    try{
        val reader:FileReader=FileReader(path="data.txt")
        println(reader.content)
    }catch(e:IOException){
        println("IO error; ${e.message}")
    }

    try{
        val reader:FileReader=FileReader(path="")
        println(reader.content)
    }catch(e:IOException){
        println("IO error: ${e.message}")
    }
}