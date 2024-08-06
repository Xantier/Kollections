package co.ilities

fun checks() {
    println("All: " + intList.all { it < 4 }) // True, all of them are less than 4
    println("Any: " + intList.any()) // True, collection has elements
    println("Any with predicate: " + intList.any { it > 4 }) // False, none of them are more than 4
    println("Contains: " + intList.contains(3)) // True
    println("Contains: " + (3 in intList)) // True
    println("ContainsAll: " + intList.containsAll(listOf(2, 3, 4))) // False
    println("Map Contains: " + aMap.contains("Hello")) // False, it's "hello"
    println("Map Contains: " + "Hello" in aMap) // False, it's "hello"
    println("Map Contains Key: " + aMap.containsKey("Hello")) // Same as above
    println("Map Contains Value: " + aMap.containsValue(2)) // True
    println("None: " + intList.none()) // False, there are elements on the list
    println("None with predicate: " + intList.none { it > 5 }) // True, none of them are larger than 5
    println("IsEmpty: " + intList.isEmpty()) // False
    println("IsNotEmpty: " + intList.isNotEmpty()) // True
}
