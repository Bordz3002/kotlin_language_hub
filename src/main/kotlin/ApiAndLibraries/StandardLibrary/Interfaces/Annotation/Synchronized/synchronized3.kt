//thread-safe singleton pattern
class DatabaseConnection private constructor(){
    init{
        println("database connection created")
    }
    fun query(sql:String):String{
        return "result of: $sql"
    }
    companion object{
        private var _instance:DatabaseConnecton?=null

        @Synchronized
        fun getInstance():DatabaseConnection{
            if(_instance==null){
                _instance=DatabaseConnection
            }
        }
    }
}