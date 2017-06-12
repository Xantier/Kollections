package co.ilities

object KollectionHolder {
/**
 * Arrays
 */
val intArray: Array<Int> = arrayOf(1, 2, 3)
val copyOfArray: Array<Int> = intArray.copyOf()
val partialCopyOfArray: Array<Int> = intArray.copyOfRange(1, 2)
val sameFullArray = fun(): Array<Int> {
    partialCopyOfArray.fill(3, 2, 3)
    return partialCopyOfArray
}

/**
 * Lists
 */
val intList: List<Int> = listOf(1, 2, 3) //Or arrayListOf(1,2,3)
val emptyList: List<Int> = emptyList() // Or listOf()
val listWithNonNullElements: List<Int> = listOfNotNull(1, null, 3) // --> List(1,3)

/**
 * Sets
 */
val aSet: Set<Int> = setOf(1) // Or hashSetOf(1) / linkedSerOf(1)
val emptySet: Set<Int> = emptySet() // Or setOf() / hashSetOf() / linkedSetOf()

/**
 * Maps
 */
val aMap: Map<String, Int> = mapOf("hi" to 1, "hello" to 2) // Or mapOf(Pair("hi", 1) / hashMapOf("hi" to 1) / linkedMapOf("hi" to 1)
val emptyMap: Map<String, Int> = emptyMap() // Or mapOf()/hashMapOf()/linkedMapOf()


/**
 * Black sheep
 */
val mutableList: MutableList<Int> = mutableListOf(1, 2, 3)
val mutableSet: MutableSet<Int> = mutableSetOf(1)
var mutableMap: MutableMap<String, Int> = mutableMapOf("hi" to 1, "hello" to 2)

}