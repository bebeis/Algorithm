import java.util.*

/**
 * 2차원 배열에서의 백트래킹 사용
 * 문제는, 단순히 배치하면 순서가 관여함
 * 이분법적으로 경우의 수로 나눠서 각 경우가 간섭되지 않도록 접근해야 함
 * 
 * n x n에 n개를 배치하려면, 각 행(열)에 반드시 1개의 퀸이 존재하게 됨
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val horizon = BooleanArray(n) // x = a
    val diagRight = BooleanArray(2 * n) // x - y = a - b + n
    val diagLeft = BooleanArray(2 * n) // x + y = a + b
    var cnt = 0

    fun bt(b: Int) {
        if (b == n) {
            cnt++
            return
        }

        for (a in 0 until n) {
            if (horizon[a]) continue
            if (diagRight[a - b + n]) continue
            if (diagLeft[a + b]) continue

            horizon[a] = true
            diagRight[a - b + n] = true
            diagLeft[a + b] = true
            bt(b + 1)

            horizon[a] = false
            diagRight[a - b + n] = false
            diagLeft[a + b] = false
        }
    }

    bt(0)

    print(cnt)
}
