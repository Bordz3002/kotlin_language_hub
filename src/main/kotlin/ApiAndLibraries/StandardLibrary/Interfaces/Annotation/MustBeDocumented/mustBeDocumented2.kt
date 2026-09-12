//combining it with retention
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class ExperimentalFeatureAnnotation
@ExperimentalFeatureAnnotation
class DroneControllerClass