/**
 * d[i][j]: i * j에서 가장 큰 정사각형 크기 -> 다른 말로 하면 가장 긴 한 변의 길이
 * - arr[i - 1][j] 도 1, arr[i][j - 1]도 1, arr[i - 1][j - 1]도 1
 */

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n + 1) { IntArray(m + 1) }
    val d = Array(n + 1) { IntArray(m + 1) }
    for (i in 1..n) {
        val line = readLine()
        for (j in 1..m) {
            arr[i][j] = line[j - 1] - '0'
        }
    }

    for (i in 1..n) {
        for (j in 1..m) {
            if (arr[i][j] == 0) continue
            if (arr[i - 1][j] == 1 && arr[i][j - 1] == 1 && arr[i - 1][j - 1] == 1) {
                d[i][j] = minOf(d[i - 1][j], d[i][j - 1], d[i - 1][j - 1]) + 1
            } else {
                d[i][j] = 1
            }
        }
    }

    val length = d.maxOf { line -> line.max() }
    print(length * length)
}