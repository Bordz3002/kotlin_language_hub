//creates an annotation for Android permissions
@Target(AnnotationTarget.FUNCTION)
annotation class RequiresPermission(val permission:String)
class PermissionManager(){
    //correct: used on a function
    @RequiresPermission("android.permission.CAMERA")
    fun accessCamera(){
        println("accessing camera...")
    }

    //incorrect: used on a property
    //@RequiresPermission("android.permission.CAMERA")
    //val hasPermission:Boolean=false
}