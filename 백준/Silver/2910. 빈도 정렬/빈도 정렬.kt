import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, c) = readLine().split(" ").map { it.toInt() }
    val st = StringTokenizer(readLine())

    val list = List(n) { st.nextToken().toInt() }
    val indexMap = mutableMapOf<Int, Int>()

    list.forEachIndexed { idx, v ->
        indexMap.getOrPut(v) { idx }
    }

    val countMap = list.groupingBy { it }
        .eachCount()

    print(
        list.sortedWith(
            compareByDescending<Int> { countMap.getValue(it) }
                .thenBy { indexMap.getValue(it) }
        ).joinToString(" ")
    )
}
