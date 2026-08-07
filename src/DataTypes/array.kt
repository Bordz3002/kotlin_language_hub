fun main(args:Array<String>){
    /*@example1 p- */
    val carBrands=arrayOf("porsche", "bmw", "toyota", "ford");
    println("first car in the car brands is: ${carBrands[0]}");
    /*@example2- change an array element*/
    var phoneBrands=arrayOf("samsung","realme", "iphone");
    for(brand in phoneBrands){println(brand)}
    /*@property {phoneBrands[1]}- assigned a new value "xiaomie"*/
    phoneBrands[1]="xiaomie";
    for(brand in phoneBrands){println(brand)};
    /*@example3-array size property*/
    val energyDrinks=arrayOf("cobra", "redbull", "sting");
    println("energyDrinks array size is: ${energyDrinks.size}");
    /*@example4 - check if an element exists in an array*/
    val colors=arrayOf("orange", "yellow", "blue", "pink");
    if("black" in colors){
        println("black element exists in the colors array");
    }else{
        println("black element does not exist in the colors array");
    }
    /*@example4 - looping through an array*/;
    /*for*/
    val directions=arrayOf("north", "south", "east", "west");
    for(direction in directions){print("${direction}, ")}
    /*for with ranges: '..' */
    for(numbers in 1..20){
        println(numbers);
    }
    /*for with break*/
    for(char in 'a'..'z'){
        if(char=='d'){println("element: ${char} is reached!"); break;}
        println("${char}");
    }
}