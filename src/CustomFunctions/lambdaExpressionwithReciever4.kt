fun main(){
    val showListItems:List<String>.()->Unit={
        for(element in this){
            print("$element ")
        }
    }
    val words:List<String> =listOf("lost","soul","rich","and","blind")
    words.showListItems()
}