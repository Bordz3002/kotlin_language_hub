sealed class FarmOperation
data class Planting(val expectCrop:String):FarmOperation()
data class Spraying(val expectPesticide:String):FarmOperation()
data class Harvesting(val expectKilograms:Double):FarmOperation()
fun describeOperation(expectOperationObject:FarmOperation):String{
    when(expectOperationObject){
        is Planting->return "Planting ${expectOperationObject.expectCrop} crop"
        is Spraying->return "Spraying ${expectOperationObject.expectPesticide} pesticide to crop"
        is Harvesting->return "Harvesting crop with total of ${expectOperationObject.expectKilograms}"
    }
}
fun main(){
    val planting=Planting("scallion")
    val spraying=Spraying("spinosad")
    val harvesting=Harvesting(1000.9)
    println(describeOperation(planting))
    println(describeOperation(spraying))
    println(describeOperation(harvesting))
}