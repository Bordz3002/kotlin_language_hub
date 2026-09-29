//thread-safe vote counter
class VoteCounter{
    private val _votes:MutableMap<String, Int> =mutableMapOf<String, Int>()
    private var _totalVotes:Int=0
    @Synchronized
    fun vote(candidate:String){
        val current:Int=_votes[candidate]?:0
        _votes[candidate]=current+1
        _totalVotes++
        println("vote for $candidate. total votes: ${_votes[candidate]}")
    }
    @Synchronized
    fun getVotes(candidate:String):Int{
        return _votes[candidate]?:0
    }
    @Synchronized
    fun getAllVotes():Map<String, Int>{
        return _votes.toMap<String, Int>()
    }
    @Synchronized
    fun getTotalVotes():Int{
        return _totalVotes
    }
    @Synchronized
    fun getWinner():String?{
        return _votes.maxByOrNull{it.value}?.key
    }
    @Synchronized
    fun getResults():String{
        return _votes.entries
            .sortedByDescending{it.value}
            .joinToString(separator="\n"){" ${it.key}:${it.value} votes"}
    }
}
fun main(){
    val counter:VoteCounter=VoteCounter()
    val candidates:List<String> =listOf("alice", "bob", "charlie")
    val threads:List<Thread> =(1..6).map{voterId:Int->
        Thread{
            repeat(times=5){
                val candidate:String=candidates.random()
                counter.vote(candidate=candidate)
                Thread.sleep(50)
            }
        }
    }
    threads.forEach{it.start()}
    threads.forEach{it.join()}
    println("election results")
    println(counter.getResults())
    println("total votes: ${counter.getTotalVotes()}")
    println("winner: ${counter.getWinner()}")
}