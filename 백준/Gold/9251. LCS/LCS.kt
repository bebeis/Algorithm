/**
 * LCS에서의 핵심은, LCS의 부분 수열로 (i, j)를 사용하냐 안하냐에 따라 달린다.
 * 근데 이건 선택의 여지가 없다. 문제에서 주어지는거다. 따라서 d[i][j]를 "선택한 경우"로 한정지을 필요가 없다. 
 * - 범위 조건으로 쓰면 된다.
 */

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val s1 = readLine()
    val s2 = readLine()

    val d = Array(s1.length + 1) { IntArray(s2.length + 1) }
    for (i in 1..s1.length) {
        for (j in 1..s2.length) {
            if (s1[i - 1] == s2[j - 1]) d[i][j] = d[i - 1][j - 1] + 1
            else d[i][j] = maxOf(d[i][j], d[i - 1][j], d[i][j - 1])
        }
    }

    print(d[s1.length][s2.length])
}