package co.ilities

/**
 * Filter values in or out based on themselves or their properties
 */
fun filtering() {
    println("Filter: " + intList.filter { it > 2 }) // [3] --> Filter-in
    println("FilterKeys: " + aMap.filterKeys { it != "hello" }) // {hi=1}
    println("FilterValues: " + aMap.filterValues { it == 2 }) // {hello=2}
    println("FilterIndexed: " + intList.filterIndexed { idx, value -> idx == 2 || value == 2 }) // [2,3]
    println("FilterIndexedTo: " + intList.filterIndexedTo(mutableListOf()) { idx, value -> idx == 2 || value == 2 }) // [2,3]
    println("FilterIsInstance: " + intList.filterIsInstance<String>()) // [] --> All of them are ints

    //Inverse
    println("FilterNot: " + intList.filterNot { it > 2 }) // [1,2]
    println("FilterNotNull: " + intList.filterNotNull()) // [1,2,3]
}


/**
 * Take some amount of elements from collection
 */
fun taking() {
    println("Take: " + intList.take(2)) // [1,2]
    println("TakeWhile: " + intList.takeWhile { it < 3 }) // [1,2]
    println("TakeLast: " + intList.takeLast(2)) // [2,3]
    println("TakeLastWhile: " + intList.takeLastWhile { it < 3 }) // [] last element is already breaking this rule --> empty

    //Inverse
    println("Drop: " + intList.drop(2)) // [3]
    println("DropWhile: " + intList.dropWhile { it < 3 }) // [3]
    println("DropLast: " + intList.dropLast(2)) // [1]
    println("DropLastWhile: " + intList.dropLastWhile { it > 2 }) // [1,2]
}

/**
 * Retrieving particular elements from a collection
 */
fun getting() {
    // there are 5 of these --> component1, component2, component3, component4, component5
    println("Component: " + intList.component1()) // 1
    println("ElementAt: " + intList.elementAt(2)) // 3 // Throws IndexOutOfBounds if element index doesn't exist
    println("ElementAtOrElse: " + intList.elementAtOrElse(32132) { 4 }) // 4
    println("ElementAtOrNull: " + intList.elementAtOrNull(612)) // null

    println("Get Clumsy syntax: " + intList.get(2)) // 3
    println("Get: " + intList[2]) // 3 -> Shorthand and preferred way for the one above

    println("GetOrElse: " + intList.getOrElse(632) { 5 }) // 5
    println("GetOrNull: " + intList.getOrNull(632)) // null

    // Map only
    println("GetKey: " + aMap.getValue("hi")) // 4
    println("GetOrDefault: " + aMap.getOrDefault("HI", 4)) // 4

    // Mutable map only
    println("GetOrPut: " + mutableMap.getOrPut("HI") { 5 }) // 5
}


/**
 * Iterating over collections and searching for elements
 */
fun finding() {
    println("BinarySearch: " + intList.binarySearch(2)) // 1 // Does a binary search through the collection and returns the index of the element
    println("BinarySearchBy: " + intList.binarySearchBy(2) { if (it > 1) 3 else 1 }) // -2 // ???
    println("Find: " + intList.find { it > 1 }) // 2 first element satisfying the condition or null if not found
    println("FindLast: " + intList.findLast { it > 1 }) // 3 last element satisfying the condition or null if not found
    println("First: " + intList.first()) // 1
    println("First with predicate: " + intList.first { it > 1 }) // 2, Same as find but throws NoSuchElementException if not found
    println("FirstOrNull: " + intList.firstOrNull()) // 1
    println("FirstOrNull with predicate: " + intList.firstOrNull { it > 1 }) // 2, Same as find
    println("IndexOf: " + intList.indexOf(1)) // 0
    println("IndexOfFirst: " + intList.indexOfFirst { it > 1 }) // 1
    println("IndexOfLast: " + intList.indexOfLast { it > 1 }) // 2
    println("Last: " + intList.last()) // 3, throws NoSuchElementException
    println("Last with predicate: " + intList.last { it > 1 }) // 3, throws NoSuchElementException
    println("LastIndexOf: " + intList.lastIndexOf(2)) // 1
    println("LastOrNull: " + intList.lastOrNull()) // 3
    println("LastOrNull with predicate: " + intList.lastOrNull { it > 1 }) // 3
}

/**
 * Unions, distincts, intersections etc.
 */
fun builtInFilters() {
    println("Distinct: " + intList.distinct()) // [1,2,3]
    println("DistinctBy: " + intList.distinctBy { if (it > 1) it else 2 }) // [1,3]
    println("Intersect: " + intList.intersect(listOf(1, 2))) // [1,2]
    println("MinusElement: " + intList.minusElement(2)) // [1,3]
    println("MinusElement with collection: " + intList.minusElement(listOf(1, 2))) // [3]
    println("Single: " + listOf("One Element").single()) // "One Element", or throws
    println("SingleOrNull: " + intList.singleOrNull()) // null
    println("OrEmpty: " + intList.orEmpty()) // [1,2,3] Returns itself or an empty list if itself is null.
    println("Union: " + intList.union(listOf(4,5,6))) // [1,2,3,4,5,6]
    println(intList union listOf(4,5,6)) // [1,2,3,4,5,6] // Infix notation
}