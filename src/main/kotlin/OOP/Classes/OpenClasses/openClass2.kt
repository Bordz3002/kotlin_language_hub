open class Gadget(val expectModel:String, val expectBrand:String)
class Laptop(expectModel:String, expectBrand:String, val expectCpuArchitecture:Int):Gadget(expectModel, expectBrand)
fun main(){
    val laptop=Laptop("hp", "2202", 32)
    with(laptop){
        println("${this.expectModel}-${this.expectBrand}-${this.expectCpuArchitecture}bit")
    }
}