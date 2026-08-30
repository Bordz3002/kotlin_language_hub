import kotlin.properties.Delegates
class Thermostat{
    var temperature: Int by Delegates.observable(20){_, old, new->
        if(new>25){
            println("warning: temperature too high. ($old, $new)")
        }else if(new<10){
            println("warning: temperature too low. ($old, $new)")
        }else{
            println("temperature: OK. ($old, $new)")
        }
    }
}
fun main(){
    val thermo:Thermostat=Thermostat()
    thermo.temperature=22
    thermo.temperature=27
    thermo.temperature=-5

}