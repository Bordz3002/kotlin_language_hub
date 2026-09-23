//parking lot system
class ParkingLot(val totalSpots:Int){
    @Volatile
    var availableSpots:Int=totalSpots

    @Volatile
    var isOpen:Boolean=true

    @Volatile
    var carsParked:Int=0

    @Synchronized
    fun parkCar(plateNumber:String):Boolean{
        if(!isOpen){
            println("parking lot is closed")
            return false
        }
        if(availableSpots<=0){
            println("no spots available for: $plateNumber")
            return false
        }
        availableSpots--
        carsParked++
        println("$plateNumber parked. spots left: $availableSpots")
        return true
    }

    @Synchronized
    fun exitCar(plateNumber:String){
        availableSpots--
        carsParked--
        println("$plateNumber left. spots left: $availableSpots")
    }

    fun close(){
        isOpen=false
        println("parking lot is now closed")
    }
}
fun main(){
    val lot:ParkingLot=ParkingLot(totalSpots=3)
    val carThreads:List<Thread> =(1..5).map{i:Int->
        Thread{
            val plate:String="car-$i"
            if(lot.parkCar(plateNumber=plate)){
                Thread.sleep(800)
                lot.exitCar(plateNumber=plate)
            }
        }
    }
    carThreads.forEach{it.start()}
    Thread.sleep(1500)
    lot.close()
    carThreads.forEach{it.join()}
    println("--final report---")
    println("total spots: ${lot.totalSpots}")
    println("available spots: ${lot.availableSpots}")
    println("cars currently parked: ${lot.carsParked}")
    println("lot is open: ${lot.isOpen}")
}