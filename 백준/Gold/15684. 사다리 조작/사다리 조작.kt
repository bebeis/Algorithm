import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, h) = readLine().split(" ").map { it.toInt() }

    val lines = Array(h + 1) { BooleanArray(n + 1) }

    repeat(m) {
        val st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        lines[a][b] = true
    }

    fun ladderGame(start: Int): Int {
        var cx = 1
        var cy = start

        while (cx <= h) {
            if (cy <= n - 1 && lines[cx][cy]) cy++
            else if (cy > 1 && lines[cx][cy - 1]) cy--
            cx++
        }
        return cy
    }

    fun satisfied(): Boolean {
        for (i in 1..n) {
            if (ladderGame(i) != i) return false
        }
        return true
    }

    var answer = -1

    fun dfs(cnt: Int, limit: Int, startRow: Int, startCol: Int): Boolean {
        if (cnt == limit) {
            return satisfied()
        }

        for (i in startRow..h) {
            for (j in 1..n - 1) {

                if (lines[i][j]) continue
                if (j > 1 && lines[i][j - 1]) continue
                if (j < n - 1 && lines[i][j + 1]) continue

                lines[i][j] = true
                if (dfs(cnt + 1, limit, i, j)) return true
                lines[i][j] = false
            }
        }
        return false
    }

    for (limit in 0..3) {
        if (dfs(0, limit, 1, 1)) {
            answer = limit
            break
        }
    }

    println(answer)
}