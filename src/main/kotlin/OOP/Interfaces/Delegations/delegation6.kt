interface DrawingTool{
    val color: String
    fun draw(expectShape:String)
    fun erase(expectArea:String)
    fun getToolInfo():String
}
class PenTool:DrawingTool{
    override val color:String="black"
    override fun draw(expectShape:String){
        println("drawing $expectShape using a pen in color $color")
    }
    override fun erase(expectArea:String){
        println("erasing $expectArea using pen tool")
    }
    override fun getToolInfo():String{
        return "PenTool (color=$color)"
    }
}
class Canvas(expectTool:PenTool):DrawingTool by expectTool{
    override val color:String="orange"
}
fun main(){
    val penTool=PenTool()
    val canvas=Canvas(penTool)
    with(canvas){
        println("color is $color") //note that the color property has been overridden by the canvas class
        draw("turtle")
    }
}