fun main(){
    val cropGrade:Char ='B'
    val status:String =when(cropGrade){
        'A' ->"Excellent Crop"
        'B' ->"Good crop"
        'C' ->"Average crop"
        'D' ->"Poor crop"
        else ->"Invalid grade"
    }
    println("status: $status")
}