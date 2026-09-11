import kotlin.properties.Delegates
class UserSettings{
    private fun saveToPreferences(expectKey:String, expectValue:Any){
        println("saved '$expectKey' = $expectValue")
    }
    var theme:String by Delegates.observable("light"){_, oldValue, newValue->
        println("theme changed: $oldValue, $newValue")
        saveToPreferences("theme", newValue)
    }
    var notifications:Boolean by Delegates.observable(true){_, oldValue, newValue->
        println("notifications: $oldValue -> $newValue")
        saveToPreferences("notifications", newValue)
    }
}
fun main(){
    val settings:UserSettings=UserSettings()
    settings.theme="dark"
    settings.notifications=true
}