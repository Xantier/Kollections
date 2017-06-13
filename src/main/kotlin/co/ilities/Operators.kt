package co.ilities

/**
 * Operates on all iterables
 */
fun operate(): Unit {
    assert(listOf(1, 2, 3, 1) == intList + 1)
    assert(listOf(2, 3) == intList - 1)

    assert(listOf(1, 2, 3, 1, 2, 3) == intList + listOf(1, 2, 3))
    assert(listOf(3) == intList - listOf(1, 2))

    assert(mapOf("Hello" to 1, "Hi" to 2) == aMap + Pair("Hi", 2))
    assert(emptyMap<String, Int>() == aMap - "Hello") // Takes in a key and removes if found

    assert(mapOf("Hello" to 1, "Hi" to 2) == aMap + mapOf(Pair("Hi", 2), Pair("Goodbye", 3)))
    assert(emptyMap<String, Int>() == aMap - listOf("Hello", "Hi")) // Takes in an iterable of keys and removes if found

    /**
     * For Black sheep - mutants
     */
    mutableList -= 2
    mutableList += 2

    mutableMap.minusAssign("Hello") // same as -=
    mutableMap.plusAssign("Hi" to 2) // same as +=
}
