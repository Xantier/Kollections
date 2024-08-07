package co.ilities

fun transformers() {
    println("Associate: " + intList.associateBy { Pair(it.toString(), it) }) // {1=1, 2=2, 3=3}

    println("Map: " + intList.map { it + 1 }) // [2,3,4]
    println("MapNotNull: " + intList.mapNotNull { null }) // []
    println("MapIndexed: " + intList.mapIndexed { idx, value -> if (idx == 0) value + 1 else value + 2 }) // [2,4,5]
    println("MapIndexedNotNull: " + intList.mapIndexedNotNull { idx, value -> if (idx == 0) null else value + 2 }) // [4,5]

    //For maps
    println("MapKeys: " + aMap.mapKeys { pair -> pair.key + ", mate" }) // {hi, mate=1, hello, mate=}
    println("MapValues: " + aMap.mapValues { pair -> pair.value + 2 }) // {hi=3, hello=4}

    println("Reversed: " + intList.reversed()) // [3,2,1]
    println("Partition: " + intList.partition { it > 2 }) // Pair([3], [1,2])
    println("Slice: " + intList.slice(1..2)) // [2,3]
    println("Sorted: " + intList.sorted()) // [1,2,3]
    println("SortedByDescending: " + intList.sortedByDescending { it }) // [3,2,1]
    println("SortedWith: " + intList.sortedWith(Comparator<Int> { x, y ->
        when {
            x == 2 -> 1
            y == 2 -> -1
            else   -> y - x
        }
    })) // [3,1,2]

    println("PlusElement: " + intList.plusElement(4)) // [1,2,3,4]

    println("Flatten: " + listOf(intList, aSet).flatten()) // [2,3,4,1]
    println("FlatMap with just return: " + listOf(intList, aSet).flatMap { it }) // [2,3,4,1]
    println("FlatMap with transform: " + listOf(intList, aSet).flatMap { iterable: Iterable<Int> ->
        iterable.map { it + 1 }
    }) // [2,3,4,2]

    println("Zip: " + listOf(3, 4).zip(intList)) // [(3,1), (4,2)]
    println("Zip with predicate: " + listOf(3, 4).zip(intList) { firstElem, secondElem -> Pair(firstElem - 2, secondElem + 2) }) // [(1,3), (2,4)]
    println("Unzip: " + listOf(Pair("hi", 1), Pair("hello", 2)).unzip()) // Pair([hi, hello], [1,2])
}
