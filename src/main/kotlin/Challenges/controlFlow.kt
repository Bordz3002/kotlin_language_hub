fun main(){
    val soilMoisture:Double = 80.9
    val isHealthy:Boolean = true
    if(soilMoisture<30){
        println("Soil is dry")
    }else if(soilMoisture>=30&&soilMoisture<=60){
        println("Soil moisture is adequate")
    }else{
        println("Soil is wet")
    }
    if(isHealthy){
        println("Crop is healthy")
    }
}