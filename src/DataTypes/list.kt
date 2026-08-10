fun main(args:Array<String>){
    /*list store items in the order that they are added and allow for duplicate items
    * to create a read-only list (List), use the (listOf) function
    * to create a mutable list (MutableList), use the (mutableListOf) function*/
    /*@property{readOnlyShapes}- read-only list*/
    val readOnlyShapes = listOf("triangle", "circle", "rectangle");
    println("read-only list elements: ${readOnlyShapes}");
    /*list element access via index [] operator*/
    println("the first element in the read-only list is: ${readOnlyShapes[0]}");
    /*first() function- returns the first element in the list*/
    println("fist element: ${readOnlyShapes.first()}");
    /*last() function- returns the last element in the list*/
    println("last element: ${readOnlyShapes.last()}");
    /*count() function- returns the list size*/
    println("read-only list element count: ${readOnlyShapes.count()}");
    /*check whether a certain element exist in the list, returns boolean value*/
    println("circle" in readOnlyShapes);

    /*@property{shapes} - mutable list*/
    val shapes:MutableList<String> = mutableListOf("triangle","square", "squircle");
    println("mutable list: ${shapes}");
    /*add() function, add new element in the list*/
    shapes.add("pentagon");
    println(shapes);
    /*remove() function - removes a certain element in the list*/
    shapes.remove("triangle");
    println(shapes);

    /*@property{shapesLocked} - read-only list of shapes. also called casting*/
    val shapesLocked:List<String> = shapes;
}