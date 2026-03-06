/**
 * 대나무를 먹고 자리를 옮기면 그 옮긴 지역에 그 전 지역보다 대나무가 많이 있어야 한다.
 * 목표: "판다가 최대한 많은 칸을 방문할 때 칸수"
 * - 처음에 어디에 배치할 건지
 * - 어디로 이동시킬 건지
 */

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array(n) { StringTokenizer(readLine()).let { st -> IntArray(n) { st.nextToken().toInt() } } }
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    val d = Array(n) { IntArray(n) { -1 } } // d[i][j] = (i, j)에서 이동할 수 있는 최대 칸 수

    fun dp(cx: Int, cy: Int): Int {
        if (d[cx][cy] != -1) return d[cx][cy]

        var max = 0
        for (dir in 0 until 4) {
            val nx = cx + dx[dir]
            val ny = cy + dy[dir]

            if (nx !in 0..n-1 || ny !in 0..n-1) continue
            if (arr[nx][ny] <= arr[cx][cy]) continue
            max = maxOf(max, dp(nx, ny))
        }

        d[cx][cy] = max + 1
        return d[cx][cy]
    }

    var max = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            max = maxOf(max, dp(i, j))
        }
    }

    print(max)
}