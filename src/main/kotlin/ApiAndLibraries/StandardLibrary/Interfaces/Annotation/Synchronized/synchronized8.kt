//thread-safe task queue
class TaskQueue{
    private val _queue:ArrayDeque<String> =ArrayDeque<String>()
    private var _completedTasks:Int=0

    @Synchronized
    fun addTask(task:String){
        _queue.addLast(element=task)
        println("task added: $task (queue size: ${_queue.size})")
    }

    @Synchronized
    fun getTask():String?{
        if(_queue.isEmpty()){
            return null
        }
        val task:String=_queue.removeFirst()
        println("task retrieved: $task (queue size: ${_queue.size})")
        return task
    }

    @Synchronized
    fun completeTask(task:String){
        _completedTasks++
        println("task completed: $task (total completed: $_completedTasks")
    }

    @Synchronized
    fun size():Int{
        return _queue.size
    }

    @Synchronized
    fun getCompletedCount():Int{
        return _completedTasks
    }
}
fun main(){
    val taskQueue:TaskQueue=TaskQueue()
    val producerThreads:List<Thread> =(1..2).map{producerId:Int->
        Thread{
            repeat(times=5){it:Int->
                taskQueue.addTask(task="task-$producerId-$it")
                Thread.sleep(200)
            }
        }
    }
    val consumerThreads:List<Thread> =(1..2).map{consumerId:Int->
        Thread{
            repeat(times=5){it:Int->
                val task:String?=taskQueue.getTask()
                if(task!=null){
                    Thread.sleep(300)
                    taskQueue.completeTask(task=task)
                }else{
                    println("consumer: $consumerId. no tasks available")
                }
                Thread.sleep(100)
            }
        }
    }
    producerThreads.forEach{it.start()}
    consumerThreads.forEach{it.start()}
    producerThreads.forEach{it.join()}
    consumerThreads.forEach{it.join()}
    println("final report")
    println("tasks remaining in queue: ${taskQueue.size()}")
    println("tasks completed: ${taskQueue.getCompletedCount()}")
}