//thread-safe seat reservation with timeout
class SeatReservation(private val _totalSeats:Int){
    private val _reservedSeats:MutableSet<Int> =mutableSetOf<Int>()
    private val _reservedBy:MutableMap<String, Int> =mutableMapOf<String, Int>()
    private var _reservationCount:Int=0
    @Synchronized
    fun reserve(seatNumber:Int, customerName:String):Boolean{
        if(seatNumber !in 1.._totalSeats){
            println("invalid seat number: $seatNumber")
            return false
        }
        if(seatNumber in _reservedSeats){
            println("seat $seatNumber already reserved by: ${_reservedBy[customerName]}")
            return false
        }
        _reservedSeats.add(element=seatNumber)
        _reservedBy[customerName]=seatNumber
        _reservationCount++
        println("$customerName reserved seat: ${seatNumber}")
        return true
    }
    @Synchronized
    fun cancel(seatNumber:Int, customerName:String):Boolean{
        if(seatNumber !in _reservedSeats){
            println("seat: $seatNumber is not reserved")
            return false
        }
        if(_reservedBy[customerName] !=seatNumber){
            println("$customerName did not reserve $seatNumber")
            return false
        }
        _reservedSeats.remove(element=seatNumber)
        _reservedBy.remove(key=customerName)
        println("$customerName cancelled seat $seatNumber")
        return true
    }
    @Synchronized
    fun getReservedSeats():Set<Int>{
        return _reservedSeats.toSet<Int>()
    }
    @Synchronized
    fun getReservationCount():Int{
        return _reservationCount
    }
    @Synchronized
    fun isSeatAvailable(seatNumber:Int):Boolean{
        return seatNumber in 1.._totalSeats && seatNumber !in _reservedSeats
    }
    @Synchronized
    fun getCustomerSeat(customerName:String):Int?{
        return _reservedBy[customerName]
    }
}
fun main(){
    val reservation:SeatReservation=SeatReservation(_totalSeats=10)
    val customers:List<String> =listOf("alice", "bob", "charlie", "diana", "eve")
    val threads:List<Thread> =customers.map{name:String->
        Thread{
            val seat:Int=(1..10).random()
            val success:Boolean=reservation.reserve(seatNumber=seat, customerName=name)
            if(success){
                Thread.sleep(500)
                if(name=="bob" || name=="diana"){
                    reservation.cancel(seatNumber=seat, customerName=name)
                }
            }
        }
    }
    threads.forEach{it:Thread-> it.start()}
    threads.forEach{it:Thread-> it.join()}
    println("final report")
    println("total seats: 10")
    println("reserved seats: ${reservation.getReservedSeats()}")
    println("total reservation made: ${reservation.getReservationCount()}")
    println("reservations by customer: ")
    customers.forEach{name:String->
        val seat:Int?=reservation.getCustomerSeat(customerName=name)
        println(" $name: ${seat ?:"no reservation"}")
    }
}