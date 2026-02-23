import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    StringTokenizer(readLine()).let { st -> IntArray(n) { st.nextToken().toInt() } }.sortedArray()
        .mapIndexed { i, v -> (n - i) * v }
        .sum()
        .let(::print)
}