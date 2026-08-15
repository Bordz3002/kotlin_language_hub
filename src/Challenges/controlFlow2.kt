fun main(){
    val soilMoisture:Double = 80.9
    val isHealthy:Boolean = true
    val daysGrowing:Int = 60
    if(soilMoisture<30){
        println("Soil is dry")
    }else if(soilMoisture>=30 && soilMoisture<=60){
        println("Soil moisture is adequate")
    }else{
        println("Soil is wet")
    }
    if(daysGrowing>=60 && isHealthy){
        println("Crop is ready for harvest")
    }else{
        println("Crop is not ready for harvest")
    }
}