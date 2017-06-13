package co.ilities

fun actOnListElements() {
    val listOfFunctions = listOf({ print("first ") }, { print("second ") })
    listOfFunctions.forEach { it() } // first second
    listOfFunctions.forEachIndexed { idx, fn -> if (idx == 0) fn() else print("Won't do it") } // first Won't do it
    intList.onEach { print(it) } // 123
}
