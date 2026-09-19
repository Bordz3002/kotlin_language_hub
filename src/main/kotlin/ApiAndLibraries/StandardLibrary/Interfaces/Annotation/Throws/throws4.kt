//@Throws on Property Getters and Setters
import java.io.IOException
class UserProfile{
    private var _name:String=""
    var name:String
        @Throws(IOException::class)
        get(){
            if(_name.isEmpty()){
                throw IOException("name is not set")
            }
            return _name
        }
        @Throws(IOException::class)
        set(value:String){
            if(value.isEmpty()){
                throw IOException("name cannot be empty")
            }
            _name=value
        }
}

fun main(){
    val profile:UserProfile=UserProfile()
    try {
        profile.name = "alice"
        println("name set:${profile.name}")
    }catch(e:IOException){
        println("IO error: ${e.message}")
    }

    try{
        profile.name=""
        println("name set: ${profile.name}")
    }catch(e:IOException){
        println("IO error: ${e.message}")
    }

    val emptyProfile:UserProfile=UserProfile()
    try{
        println(emptyProfile.name)
    }catch(e:IOException){
        println("IO error: ${e.message}")
    }
}