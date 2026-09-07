//use case: framework analysis at build time\

import kotlin.annotation.AnnotationRetention
import kotlin.annotation.Retention
import java.awt.Button

@Retention(AnnotationRetention.BINARY)
annotation class BindView(val id:Int)

class MainActivity(){
    @BindView(101)
    lateinit var button:Button
}

//a build time tool scans the class file
//and generates binding code
//but the annotation is not needed at runtime