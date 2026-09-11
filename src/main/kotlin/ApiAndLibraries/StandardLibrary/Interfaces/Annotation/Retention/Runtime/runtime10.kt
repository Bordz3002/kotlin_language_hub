//annotation on a property
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.PROPERTY)
annotation class DisplayName(val name:String)
class FarmerEntity{
    @DisplayName("Farmer name")
    val name:String="naval"
    @DisplayName("farm location")
    val location:String="field A"
}