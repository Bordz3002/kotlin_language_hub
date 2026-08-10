fun main(args:Array<String>){
    /*maps store items as key-value pairs
    * you can access the value by referencing the key
    * to create a read-only map (Map), use the (mapOf) function
    * to create a mutable map (MutableMap), use the {mutableMapOf) function*/
    val readOnlyFruitMenu:Map<String, Int> = mapOf("coconut" to 58, "guava" to 20, "lemon" to 76);
    println("readOnlyFruitMenu: ${readOnlyFruitMenu}");
    /*indexed access operator with key reference*/
    println("the value of lemon is: ${readOnlyFruitMenu["lemon"]}");

    val mutableMotorcycleMenu:MutableMap<String,Int> = mutableMapOf("click" to 85000, "aerox" to 123000, "mio m3" to 60000);
    println("mutableMotorcycleMenu: ${mutableMotorcycleMenu}");
}