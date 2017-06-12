package co.ilities

fun foldAndReduce(): Unit {
    println("Folded")
    val folded = KollectionHolder.intList.fold(10) { accumulator, value ->
        println("accumulator: $accumulator, value: $value")
        accumulator + value
    }
    println(folded) // 10+1+2+3 = 16
    println("---")


    println("IndexFolded")
    val indexFolded = KollectionHolder.intList.foldIndexed(10) { idx, accumulator, value ->
        println("accumulator: $accumulator, value: $value")
        if (idx == 2) accumulator else accumulator + value
    }
    println(indexFolded) // 10+1+2 = 13
    println("---")


    println("RightFolded")
    val rightFolded = KollectionHolder.intList.foldRight(10) { accumulator, value ->
        println("accumulator: $accumulator, value: $value")
        accumulator + value
    }
    println(rightFolded) // 10+3+2+1 = 16
    println("---")


    println("Reduced")
    val reduced = KollectionHolder.intList.reduce { accumulator, value ->
        println("accumulator: $accumulator, value: $value")
        accumulator + value
    }
    println(reduced) // 1+2+3 = 6
    println("---")


    println("IndexReduced")
    val indexReduced = KollectionHolder.intList.reduceIndexed { idx, accumulator, value ->
        println("accumulator: $accumulator, value: $value")
        if (idx == 2) accumulator else accumulator + value
    }
    println(indexReduced) // 1+2 = 3
    println("---")


    println("RightReduced")
    val rightReduced = KollectionHolder.intList.reduceRight { accumulator, value ->
        println("accumulator: $accumulator, value: $value")
        accumulator + value
    }
    println(rightReduced) // 3+2+1 = 6
}

fun grouping() {
    val ourListGrouped = KollectionHolder.intList.groupBy { value -> value }
    println(ourListGrouped) // {1=[1], 2=[2], 3=[3]}

    val ourListGroupedWithNewValues = KollectionHolder.intList.groupBy({ it }, { it + 1 })
    println(ourListGroupedWithNewValues) // {1=[2], 2=[3], 3=[4]}


    /**
     * Group by first lambda, modify value with second lambda, dump the values to given mutable map
     */
    val mutableStringToListMap = mapOf("first" to 1, "second" to 2)
    val destinationStringListMap = mutableStringToListMap.values.groupByTo(mutableMapOf<Int, MutableList<Int>>(), { value: Int -> value }, { value -> value + 10 })
    println(destinationStringListMap) // {1=[11], 2=[12]}

    /**
     * Create a grouping by a lambda, fold using passed in lambda and given initial value, insert into given mutable destination object
     */
    val destinationIntIntMap = KollectionHolder.intList.groupingBy { it }.foldTo(mutableMapOf<Int, Int>(), 0) { accumulator, element ->
        accumulator + element
    }
    println(destinationIntIntMap) // {1=1, 2=2, 3=3}
}