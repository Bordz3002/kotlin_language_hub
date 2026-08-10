val registeredUsernames:MutableList<String> = mutableListOf("pmnv_naval", "coco_crunch")
val registeredEmails:MutableList<String> = mutableListOf("naval@example.com", "crunch@example.com")
//registerUser() using return keyword to code execution.
fun registerUser(username:String, email:String):String{
    if(username in registeredUsernames){
        return "Username already taken. Please choose a different username"
    }
    if(email in registeredEmails){
        return "Email already registered. login with the current email or use a different email"
    }
    registeredUsernames.add(username)
    registeredEmails.add(email)
    return "User registered successfully: ${username}"
}
fun main(args:Array<String>){
    println(registerUser("coco_crunch", "crunch@example.com"))
    println(registerUser("nescafe_black", "black@example.com"))
}