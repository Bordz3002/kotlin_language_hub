fun main(args:Array<String>){
    /*sets are unordered and only store unique items
    * to create a read-only set (Set), use the setOf function
    * to create a mutable set (mutableSet), use the (mutableSetOf) function
    * sets are unordered which make the elements inaccessible via index [] operator*/
    val readOnlyColors:Set<String> = setOf("black", "white", "yellow");
    println("readOnlyColors: ${readOnlyColors}");
    /*count() function returns the size of the set*/
    println("readOnlyColors has ${readOnlyColors.count()} items");
    /*check whether a certain element is present in the set via (in). returns boolean value*/
    println("yellow" in readOnlyColors);

    val mutableColors:MutableSet<String> = mutableSetOf("orange", "blue", "indigo");
    println("mutableColors: ${mutableColors}");
    /*add() function- add new element in a mutable set*/
    mutableColors.add("purple");
    println("upadted mutableColors set after add(): ${mutableColors}");
    /*remove() function- removes a certain element in a mutable set*/
    mutableColors.remove("orange");
    println("updated mutableColors set after remove(): ${mutableColors}");

    /*mutabelColors set casted to mutableColorsLock(read-only)*/
    val mutableColorsLocked:Set<String> = mutableColors;
    println("casted set mutableColors: ${mutableColorsLocked}");
}