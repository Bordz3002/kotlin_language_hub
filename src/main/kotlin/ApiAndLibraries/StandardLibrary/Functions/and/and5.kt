//access control
fun main(){
    val user:Map<String, Boolean> =mapOf("isAdmin" to true, "isActive" to true, "hasPermission" to true)
    val isAdmin=user["isAdmin"] as Boolean
    val isActive=user["isActive"] as Boolean
    val hasPermission=user["hasPermission"] as Boolean
    val canAccess=isAdmin.and(isActive).and(hasPermission)
    println("access granted: $canAccess")
    val user2:Map<String, Boolean> =mapOf("isAdmin" to false, "isActive" to true, "hasPermission" to true)
    val isAdmin2=user2["isAdmin"] as Boolean
    val isActive2=user2["isActive"] as Boolean
    val hasPermission2=user2["hasPermission"] as Boolean
    val canAccess2=isAdmin2.and(isActive2).and(hasPermission2)
    println("access granted: $canAccess2")
}