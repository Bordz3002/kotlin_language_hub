//validation
fun isValidUser(age:Int, isActive:Boolean, hasEmail:Boolean):Boolean{
    return (age>=8).and(isActive).and(hasEmail)
}
fun main(){
    println(isValidUser(25, true, true))
    println(isValidUser(25, false, true))
    println(isValidUser(17, true, true))
}