package co.ilities


/**
 * Operates only on black sheep
 */

fun mutating(): Unit {
    mutableList.add(4)
    mutableList.addAll(listOf(5, 6)) // Any collection type
    mutableList.remove(1)
    mutableList.removeAll(setOf(5, 6)) // Any collection type
    mutableList.removeAll { it == 3 }

    mutableSet.add(2)
    mutableSet.addAll(listOf(5, 6)) // Any collection type
    mutableList.remove(1)
    mutableList.removeAll(listOf(1, 2)) // Any collection type
    mutableList.removeAll { it == 3 }

    mutableMap.put("goodbye", 3)
    mutableMap.getOrPut("bye bye") { 4 } // Will put Pair("bye bye", 4) since it cannot be found from the map
    mutableMap.putIfAbsent("hello", 2) // Nothing will be put
    mutableMap.putAll(mapOf("goodbye" to 3))
    mutableMap.remove("goodbye")
    mutableMap.remove("hello", 3) // Nothing will happen, Hello has value 2
}
