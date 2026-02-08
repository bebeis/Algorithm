import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val arr = Array(readLine().toInt()) {StringTokenizer(readLine()).run { nextToken().toLong() to nextToken().toLong() } }

    print((1 until (1 shl arr.size)).minOf { status ->
        val selected = arr.filterIndexed { i, _ -> status and (1 shl i) != 0 }
        Math.abs(selected.fold(1L) { acc, f -> acc * f.first } - selected.sumOf { it.second })
    })
}