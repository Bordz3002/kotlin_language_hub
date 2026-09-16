//seeing the java wildcard
fun printNames(names:List<@JvmWildcard String>){
    for(name in names){
        println(name)
    }
}