package co.ilities


/**
 * Operates only on black sheep
 */

fun mutate(): Unit {
    KollectionHolder.mutableList.add(4)
    KollectionHolder.mutableList.addAll(listOf(5, 6)) // Any collection type
    KollectionHolder.mutableList.remove(1)
    KollectionHolder.mutableList.removeAll(setOf(5, 6)) // Any collection type
    KollectionHolder.mutableList.removeAll { it == 3 }

    KollectionHolder.mutableSet.add(2)
    KollectionHolder.mutableSet.addAll(listOf(5, 6)) // Any collection type
    KollectionHolder.mutableList.remove(1)
    KollectionHolder.mutableList.removeAll(listOf(1, 2)) // Any collection type
    KollectionHolder.mutableList.removeAll { it == 3 }

    KollectionHolder.mutableMap.put("goodbye", 3)
    KollectionHolder.mutableMap.getOrPut("bye bye") { 4 } // Will put Pair("bye bye", 4) since it cannot be found from the map
    KollectionHolder.mutableMap.putIfAbsent("hello", 2) // Nothing will be put
    KollectionHolder.mutableMap.putAll(mapOf("goodbye" to 3))
    KollectionHolder.mutableMap.remove("goodbye")
    KollectionHolder.mutableMap.remove("hello", 3) // Nothing will happen, Hello has value 2
}
