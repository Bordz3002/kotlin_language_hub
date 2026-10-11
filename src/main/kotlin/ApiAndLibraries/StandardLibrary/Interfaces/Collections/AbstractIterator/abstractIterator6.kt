//A range iterator with step
class StepIterator(
    private val start:Int,
    private val end:Int,
    private val step:Int
):AbstractIterator<Int>(){
    private var _current:Int=start
    override fun computeNext(){
        if(step>0&&_current>end){
            done()
        }else if(step<0&&_current<end){
            done()
        }else if(step==0){
            done()
        }else{
            setNext(value=_current)
            _current+=step
        }
    }
}
fun main(){
    println("----step 2 (0 to 10)----")
    val evenNumbers:StepIterator=StepIterator(start=0, end=10, step=2)
    while(evenNumbers.hasNext()){
        println(evenNumbers.next())
    }
    println("\n ----step 3 (0 to 15) ----")
    val threes:StepIterator=StepIterator(start=0, end=15, step=3)
    while(threes.hasNext()){
        println(threes.next())
    }
    println("\n ----step -2 (10 to 0)----")
    val countdown:StepIterator=StepIterator(start=10, end=0, step=-2)
    while(countdown.hasNext()){
        println(countdown.next())
    }
}