import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, p, q) = readLine().split(" ").map { it.toLong() }
    val d = mutableMapOf<Long, Long>()
    d[0] = 1L

    fun dp(cur: Long): Long {
        if (d.containsKey(cur)) {
            return d[cur] ?: -1
        }

        d[cur] = dp(cur / p) + dp(cur / q)
        return d[cur] ?: -1
    }
    print(dp(n))
}