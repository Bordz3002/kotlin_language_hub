//testing annotation

@Target(AnnotationTarget.FUNCTION)
annotation class Test(val description:String="no description")

@Target(AnnotationTarget.CLASS)
annotation class TestSuite

//correct: used on a class
@TestSuite
class MyTests(){
    //correct: used on a function
    @Test("this test checks addition")
    fun testAddition(){
        println("testing addition")
    }

    //correct: used on a function
    @Test
    fun testSubtraction(){
        println("testing subtraction")
    }
}