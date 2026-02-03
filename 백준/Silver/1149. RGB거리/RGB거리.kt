import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val costs = Array(n) {
        val st = StringTokenizer(readLine())
        IntArray(3) { st.nextToken().toInt() }
    }

    val sum = Array(n) { IntArray(3) }

    sum[0][0] = costs[0][0]
    sum[0][1] = costs[0][1]
    sum[0][2] = costs[0][2]

    for (i in 1 until n) {
        sum[i][0] = minOf(sum[i - 1][1], sum[i - 1][2]) + costs[i][0]
        sum[i][1] = minOf(sum[i - 1][2], sum[i - 1][0]) + costs[i][1]
        sum[i][2] = minOf(sum[i - 1][0], sum[i - 1][1]) + costs[i][2]
    }

    print(minOf(sum[n - 1][0], sum[n - 1][1], sum[n - 1][2]))
}