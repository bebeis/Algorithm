/**
 * 물건이 1개만 존재함
 * 따라서 낮은 무게에서의 선택이 미래에 영향을 줄 수 있음
 * 이전 물건의 선택이 미래에 영향을 주지 않도록 해야 함
 * d[w][v] = 해당 물건 선택하지 않은 경우 vs 선택한 경우
 * d[id][w] = d[id - 1][w] | d[id - 1][w - weights[id]] + values[id]
 */

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val weights = IntArray(n + 1)
    val values = IntArray(n + 1)
    val d = Array(n + 1) { IntArray(k + 1) }

    repeat(n) {
        val st = StringTokenizer(readLine())
        weights[it + 1] = st.nextToken().toInt()
        values[it + 1] = st.nextToken().toInt()
    }

    for (id in 1..n) {
        for (w in 1..k) {
            d[id][w] = d[id - 1][w]
            if (w - weights[id] >= 0) d[id][w] = maxOf(d[id][w], d[id - 1][w - weights[id]] + values[id])
        }
    }

    println(d[n][k])
}