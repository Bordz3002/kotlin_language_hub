//A paginated collection
class PaginatedCollection<out E>(private val _items:List<E>, private val _pageSize:Int):AbstractCollection<E>(){
    private val _currentPage:Int=0

}