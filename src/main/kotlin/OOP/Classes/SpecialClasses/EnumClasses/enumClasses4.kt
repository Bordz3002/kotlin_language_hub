enum class UserRole(val level:Int){
    GUEST(0),
    USER(1),
    PREMIUM(2),
    ADMIN(3)
}
fun showFeatureBasedOnRole(role:UserRole){
    when{
        role.level>=3->println("admin panel unlocked")
        role.level>=2->println("premium features available")
        role.level>=1->println("user dashboard")
        else->println("please login for more features")
    }
}
fun main(){
    showFeatureBasedOnRole(UserRole.USER)
    showFeatureBasedOnRole(UserRole.ADMIN)
    showFeatureBasedOnRole(UserRole.PREMIUM)
    showFeatureBasedOnRole(UserRole.GUEST)
}