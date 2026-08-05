fun main(){
    /* @typedef {var} - mutable variables
    * assigning new value/values to the same property is allowed*/
    var coffee=10;
    var multiplier=2;
    /*@example*/
    println("value before reassigning multiplier: ${coffee*multiplier}");
    /*@property {multiplier} - new value assigned*/
    multiplier*=23;
    println("value after reassigning new value to multiplier: ${coffee*multiplier}");
}