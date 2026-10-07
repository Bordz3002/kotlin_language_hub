//A paginated collection
class PaginatedCollection<out E>(private val _items:List<E>, private val _pageSize:Int):AbstractCollection<E>(){
    private val _currentPage:Int=0
    private val _currentItems:List<E> =_items.drop(_currentPage*_pageSize).take(_pageSize)
    override val size:Int
        get()=_currentItems.size
    override fun iterator():Iterator<E> =_currentItems.iterator()
}
fun main(){
    val allItems:List<String> =(1..25).map{"item-$it"}
    val page:PaginatedCollection<String> =PaginatedCollection(_items=allItems, _pageSize=10)
    println("page size: ${page.size}")
    println("is empty: ${page.isEmpty()}")
    println("contains 'item-5': ${page.contains(element="item-5")}")
    println("contains 'item-15': ${page.contains(element="item-15")}")
    println("page contents: ${page}")
    for(item:String in page){
        println(" $item")
    }
}