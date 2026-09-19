//@Throws on Interface Methods
import java.io.IOException
interface DataSource{
    @Throws(IOException::class)
    fun loadData():String

    @Throws(IOException::class)
    fun saveData(data:String)
}
class FileDataSource:DataSource{
    private var _data:String=""
    override fun loadData():String{
        if(this._data.isEmpty()){
            throw IOException("no data to load")
        }
        return this._data
    }
    override fun saveData(data:String){
        if(data.isEmpty()){
            throw IOException("cannot save empty data")
        }
        this._data=data
    }
}
fun main(){
    val source:FileDataSource=FileDataSource()
    try{
        source.saveData(data="hello kotlin")
        println("saved: ${source.loadData()}")
    }catch(e:IOException){
        println("IO error: ${e.message}")
    }

    try{
        source.saveData(data="")
    }catch(e:IOException){
        println("IO error: ${e.message}")
    }
}