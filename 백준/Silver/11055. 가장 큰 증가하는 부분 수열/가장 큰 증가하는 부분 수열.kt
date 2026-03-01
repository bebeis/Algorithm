/**
 * d[i]: 
 * - i가 선택되었을 때, 최대 합
 * d[i] = d[k] + a[i]
 * - k는 i보다 작지만, 가장 d[k]가 큰 원소
 */

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = StringTokenizer(readLine()).let { st -> IntArray(n) { st.nextToken().toInt() } }
    val d = IntArray(n)

    for (i in 0 until n) {
        d[i] = arr[i]
        for (j in i - 1 downTo 0) {
            if (arr[j] < arr[i]) {
                d[i] = maxOf(d[i], d[j] + arr[i])
            }
        }
    }
    print(d.max())
}