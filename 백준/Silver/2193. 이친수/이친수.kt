/**
 * 구하고자 하는 것: 자리 수에 따른 이친수의 개수
 * n 자리 수의 이친수 :
 *   n-1 자리가 0으로 끝남 -> n자리는 아무거나 ㄱㅊ
 *   n-1 자리가 1으로 끝남 -> n자리는 무조건 0
 * d[n][0]: n번째 자리가 0으로 끝나는 경우
 * d[n][1]: n번째 자리가 1로 끝나는 경우
 */

import java.io.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val d = Array(n + 1) { LongArray(2) }

    d[1][0] = 0
    d[1][1] = 1
    for (i in 2..n) {
        d[i][1] = d[i - 1][0]
        d[i][0] = d[i - 1][0] + d[i - 1][1]
    }

    print(d[n][0] + d[n][1])
}