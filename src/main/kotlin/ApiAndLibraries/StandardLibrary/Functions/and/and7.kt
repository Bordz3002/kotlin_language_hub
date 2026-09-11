fun canAccessWebsite(age:Int, isSubscribe:Boolean, isVerified:Boolean):Boolean{
    return(age>=18).and(isSubscribe).and(isVerified)
}
fun main(){
    println(canAccessWebsite(25, true, true))
    println(canAccessWebsite(25, false, true))
    println(canAccessWebsite(17, true, true))
    println(canAccessWebsite(25, true, false))
}