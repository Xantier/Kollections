package co.ilities

/**
 * Operates on all iterables
 */
fun operate(): Unit {
    assert(listOf(1, 2, 3, 1) == KollectionHolder.intList + 1)
    assert(listOf(2, 3) == KollectionHolder.intList - 1)

    assert(listOf(1, 2, 3, 1, 2, 3) == KollectionHolder.intList + listOf(1, 2, 3))
    assert(listOf(3) == KollectionHolder.intList - listOf(1, 2))

    assert(mapOf("Hello" to 1, "Hi" to 2) == KollectionHolder.aMap + Pair("Hi", 2))
    assert(emptyMap<String, Int>() == KollectionHolder.aMap - "Hello") // Takes in a key and removes if found

    assert(mapOf("Hello" to 1, "Hi" to 2) == KollectionHolder.aMap + mapOf(Pair("Hi", 2), Pair("Goodbye", 3)))
    assert(emptyMap<String, Int>() == KollectionHolder.aMap - listOf("Hello", "Hi")) // Takes in an iterable of keys and removes if found

    /**
     * For Black sheep - mutants
     */
    KollectionHolder.mutableList -= 2
    KollectionHolder.mutableList += 2

    KollectionHolder.mutableMap.minusAssign("Hello") // same as -=
    KollectionHolder.mutableMap.plusAssign("Hi" to 2) // same as +=
}
