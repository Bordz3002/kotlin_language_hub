class Cpu{
    var brand:String=""
    var model:String=""
    var year:Int=0
}
fun main(){
    var snapdragon=Cpu()
    with(snapdragon){
        brand="snapdragon"
        model="888"
        year=2023
        println("cpu: name-$brand model-$model year-$year")
    }
}