fun loadPreferences():Map<String,String>{
    println("loading preferences from a file...")
    Thread.sleep(1000)
    return mapOf("theme" to "dark","language" to "en")
}
val preferences:Map<String,String> by lazy{
    loadPreferences()
}
fun main(){
    println("app started")
    println("theme: ${preferences["theme"]}") //first access: loads from file
    println("language: ${preferences["language"]}") //second access: uses cached value
}