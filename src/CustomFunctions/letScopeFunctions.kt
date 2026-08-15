val name:String="naval"
val number:Int=20
val crop:String="Scallion"
val price:Int=100
val discountedPrice:Int=price.let{it -20}
fun main(){
    name.let{println(it)}
    number.let{println(number*2)}
    crop.let{println("I am growing $it")}
    println("discounted price: $discountedPrice")
}