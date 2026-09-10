//basic example
@Repeatable
annotation class Tag(val name:String)
@Tag("Agriculture")
@Tag("Technology")
@Tag("Automation")
class FarmSystem