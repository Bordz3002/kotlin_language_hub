fun main(args:Array<String>){
    /*maps store items as key-value pairs
    * you can access the value by referencing the key
    * to create a read-only map (Map), use the (mapOf) function
    * to create a mutable map (MutableMap), use the {mutableMapOf) function*/
    val readOnlyFruitMenu:Map<String, Int> = mapOf("coconut" to 58, "guava" to 20, "lemon" to 76);
    println("readOnlyFruitMenu: ${readOnlyFruitMenu}");
    /*indexed access operator with key reference*/
    println("the value of lemon is: ${readOnlyFruitMenu["lemon"]}")
    /*count() function- return the Map size*/
    println("readOnlyFruitMenu has: ${readOnlyFruitMenu.count()} items")
    /*containsKey() function- takes a key parameter and returns boolean value of whether a certain key exists in the Map*/
    println(readOnlyFruitMenu.containsKey("guava"))
    /* .keys property returns the keys in a Map*/
    println("readOnlyFruitMenu keys: ${readOnlyFruitMenu.keys}")
    /* .values property- returns the values only in the Map*/
    println("readOnlyFruitMenu values: ${readOnlyFruitMenu.values}")
    /* use the (in) operator to check if a certain key exists in the Map*/
    println("does the readOnlyFruitMenu have a key of coconut?: ${"coconut" in readOnlyFruitMenu.keys}")
    /*in operator without the keys property*/
    println("does the readOnlyFruitMenu have a key of coconut?: ${"coconut" in readOnlyFruitMenu}")
    /*check if a certain value exists in the Map*/
    println(76 in readOnlyFruitMenu.values);

    val mutableMotorcycleMenu:MutableMap<String,Int> = mutableMapOf("click" to 85000, "aerox" to 123000, "mio m3" to 60000);
    println("mutableMotorcycleMenu: ${mutableMotorcycleMenu}");
    /*use the indexed access operator [] to add new items to a mutable map*/
    mutableMotorcycleMenu["adv150"]=160000;
    println("mutableMotorcycleMenu after adding: ${mutableMotorcycleMenu}");
    /*remove() function- takes a key parameter to be removed from the map*/
    mutableMotorcycleMenu.remove("click");
    println("mutableMotorcycleMenu after removing: ${mutableMotorcycleMenu}")

    /*@property{mutableMotorcycleMenuLocked} - casted Map of mutableMotorcycleMenu*/
    val mutableMotorcycleMenuLocked:Map<String, Int> = mutableMotorcycleMenu;
    println("mutableMotorcycleMenuLocked: ${mutableMotorcycleMenuLocked}");
}