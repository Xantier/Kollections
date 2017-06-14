package co.ilities

/**
 * Operates on all iterables
 */
fun operate(): Unit {
    assert(listOf(1, 2, 3, 1) == intList + 1) // [1, 2, 3, 4]
    assert(listOf(2, 3) == intList - 1) // [2, 3]

    assert(listOf(1, 2, 3, 1, 2, 3) == intList + listOf(1, 2, 3)) // [1, 2, 3, 1, 2, 3]
    assert(listOf(3) == intList - listOf(1, 2)) // [3]

    assert(mapOf("hi" to 1, "hello" to 2, "Goodbye" to 3) == aMap + Pair("Goodbye", 3)) // {hi=1, hello=2, Goodbye=3}
    assert(mapOf("hi" to 1) == aMap - "hello") // Takes in a key and removes if found

    assert(mapOf("hi" to 1, "hello" to 2, "Goodbye" to 3) == aMap + mapOf(Pair("hello", 2), Pair("Goodbye", 3))) // {hi=1, hello=2, Goodbye=3}
    assert(emptyMap<String, Int>() == aMap - listOf("hello", "hi")) // Takes in an iterable of keys and removes if found

    /**
     * For Black sheep - mutants
     */
    mutableList -= 2
    println(mutableList) // [1, 3]
    mutableList += 2
    println(mutableList) // [1, 3, 2]

    mutableMap.minusAssign("hello") // {hi=1} same as -=
    println(mutableMap) //
    mutableMap.plusAssign("Goodbye" to 3) // {hi=1, Goodbye=3} same as +=
    println(mutableMap)
}
