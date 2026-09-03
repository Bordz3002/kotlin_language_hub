import java.io.IOException
fun main(){
    val primaryException=IOException("failed to read data")
    val secondaryException=NullPointerException("resource is null")

    // add the secondary exception to the primary exception
    primaryException.addSuppressed(secondaryException)

    try{
        throw primaryException
    }catch(exception:IOException){
        println("caught: ${exception.message}")
        println("suppressed exceptions:")
        exception.suppressed.forEach{println(" -${it.message}")}
    }
}