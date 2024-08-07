package co.ilities

fun foldAndReduce() {
    println("Folded")
    val folded = intList.fold(10) { accumulator, value ->
        println("accumulator: $accumulator, value: $value")
        accumulator + value
    }
    println(folded) // 10+1+2+3 = 16
    println("---")


    println("IndexFolded")
    val indexFolded = intList.foldIndexed(10) { idx, accumulator, value ->
        println("accumulator: $accumulator, value: $value")
        if (idx == 2) accumulator else accumulator + value
    }
    println(indexFolded) // 10+1+2 = 13
    println("---")


    println("RightFolded")
    val rightFolded = intList.foldRight(10) { accumulator, value ->
        println("accumulator: $accumulator, value: $value")
        accumulator + value
    }
    println(rightFolded) // 10+3+2+1 = 16
    println("---")


    println("Reduced")
    val reduced = intList.reduce { accumulator, value ->
        println("accumulator: $accumulator, value: $value")
        accumulator + value
    }
    println(reduced) // 1+2+3 = 6
    println("---")


    println("IndexReduced")
    val indexReduced = intList.reduceIndexed { idx, accumulator, value ->
        println("accumulator: $accumulator, value: $value")
        if (idx == 2) accumulator else accumulator + value
    }
    println(indexReduced) // 1+2 = 3
    println("---")


    println("RightReduced")
    val rightReduced = intList.reduceRight { accumulator, value ->
        println("accumulator: $accumulator, value: $value")
        accumulator + value
    }
    println(rightReduced) // 3+2+1 = 6
}

fun grouping() {
    val ourListGrouped = intList.groupBy { value -> 2 }
    println(ourListGrouped) // {1=[1], 2=[2], 3=[3]}

    val ourListGroupedWithNewValues = intList.groupBy({ it }, { it + 1 })
    println(ourListGroupedWithNewValues) // {1=[2], 2=[3], 3=[4]}


    /**
     * Group by first lambda, modify value with second lambda, dump the values to given mutable map
     */
    val mutableStringToListMap = mapOf("first" to 1, "second" to 2)
    val destinationStringListMap = mutableStringToListMap.values.groupByTo(
        mutableMapOf<Int, MutableList<Int>>(),
        { value: Int -> value },
        { value -> value + 10 })
    println(destinationStringListMap) // {1=[11], 2=[12]}

    /**
     * Create a grouping by a lambda, fold using passed in lambda and given initial value, insert into given mutable destination object
     */
    val destinationIntIntMap = intList.groupingBy { it }.foldTo(mutableMapOf<Int, Int>(), 0) { accumulator, element ->
        accumulator + element
    }
    println(destinationIntIntMap) // {1=1, 2=2, 3=3}

    /**
     * Create a grouping by a lambda, aggregate each group.
     * Lambda receives all keys, nullable accumulator and the element plus a flag if value is the first on from this group.
     * If isFirst --> accumulator is null.
     */
    val aggregatedString = intList.groupingBy { "key" }.aggregate { key, accumulator: String?, element, isFirst ->
        println("accumulator: $accumulator, value: $key, element: $element, isFirst: $isFirst")
        when (accumulator) {
            null -> "$element"
            else -> accumulator + "$element"
        }
    }
    println(aggregatedString) // {key=123}

    /**
     * Create a grouping by a lambda, aggregates each group to passed in element
     * If isFirst --> accumulator is null
     */
    val aggregatedStringToMap = intList.groupingBy { "key" }
        .aggregateTo(mutableMapOf<String, String>()) { key, accumulator: String?, element, isFirst ->
            println("accumulator: $accumulator, value: $key, element: $element, isFirst: $isFirst")
            when (accumulator) {
                null -> "$element"
                else -> accumulator + "$element"
            }
        }
    println(aggregatedStringToMap) // {key=123}
}

fun aggregating() {

    val oneOrLarger = Comparator<Int> { x, y ->
        when {
            x == 1 -> 1
            y == 1 -> -1
            else -> y - x
        }
    }

    println("Count: " + intList.count()) // 3
    println("Count: " + intList.count { it == 2 }) // 1

    println("Avg: " + intList.average()) // (1+2+3)/3 = 2.0

    println("Max: " + intList.max()) // 3
    println("MaxBy: " + intList.maxBy { it * 3 }) // 3 * 3 is 9 --> 3
    println("MaxWith: " + intList.maxWith(oneOrLarger)) // 1

    println("Min: " + intList.min()) // 1
    println("MinBy: " + intList.minBy { it * 3 }) // 1 * 3 is 3 --> 1
    println("MinWith: " + intList.minWith(oneOrLarger)) // 3

    println("Sum: " + intList.sum()) // 6
    println("SumBy: " + intList.sumOf { if (it == 3) 6 else it }) // 1+2+6 = 9
    println("SumByDouble: " + intList.sumOf { it.toDouble() }) // 6.0
}
