//thread-safe ticket booking system
class TicketBooking(private val _totalSeats:Int){
    private var _availableSeats:Int=_totalSeats
    private var _bookedSeats:MutableList<String> =mutableListOf<String>()

    @Synchronized
    fun bookSeat(customerName:String):Boolean{
        if(_availableSeats<=0){
            println("no seats available for: $customerName")
            return false
        }
        _availableSeats--
        _bookedSeats.add(customerName)
        println("$customerName booked a seat. seats left: $_availableSeats")
        return true
    }

    @Synchronized
    fun cancelBooking(customerName:String):Boolean{
        if(_bookedSeats.remove(customerName)){
            _availableSeats++
            println("$customerName cancelled. seats left: $_availableSeats")
            return true
        }
        println("no booking found for: $customerName")
        return false
    }

    @Synchronized
    fun getAvailableSeats():Int{
        return _availableSeats
    }

    @Synchronized
    fun getBookedSeats():List<String>{
        return _bookedSeats.toList()
    }

    @Synchronized
    fun getTotalSeats():Int{
        return _totalSeats
    }
}
fun main(){
    val booking:TicketBooking=TicketBooking(_totalSeats=3)
    val customers:List<String> =listOf("alice", "bob", "charlie", "diana", "eve")
    val threads:List<Thread> =customers.map{name:String->
        Thread{
            val success:Boolean=booking.bookSeat(customerName=name)
            if(success){
                Thread.sleep(500)
                if(name=="bob" || name=="diana"){
                    booking.cancelBooking(customerName=name)
                }
            }
        }
    }
    threads.forEach{it.start()}
    threads.forEach{it.join()}
    println("---final report---")
    println("total seats: ${booking.getTotalSeats()}")
    println("available seats: ${booking.getAvailableSeats()}")
    println("booked seats: ${booking.getBookedSeats()}")
}