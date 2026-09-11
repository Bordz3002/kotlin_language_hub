fun main(){
    val crops:MutableList<String> = mutableListOf("Scallions", "Rice", "Corn", "Tomato", "Eggplant")
    println("crops: $crops");
    println("Number of crops: ${crops.size}")
    println("Fist crop: ${crops[0]}")
    crops.add("lemon")
    crops.remove("Tomato")
    println("Final crop list: $crops")
}