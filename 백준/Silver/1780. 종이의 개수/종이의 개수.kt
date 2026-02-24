import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val board = Array(n) { StringTokenizer(readLine()).let { st -> IntArray(n) { st.nextToken().toInt() } } }
    val results = IntArray(3)

    fun rec(sx: Int, sy: Int, length: Int) {
        val base = board[sx][sy]
        var isPaper = true
        for (cx in sx until sx + length) {
            for (cy in sy until sy + length) {
                if (board[cx][cy] != base) {
                    isPaper = false
                    break
                }
            }
            if (!isPaper) break
        }

        if (isPaper) {
            results[base + 1]++
            return
        }

        val nl = length / 3
        rec(sx, sy, nl)
        rec(sx + nl, sy, nl)
        rec(sx + 2 * nl, sy, nl)
        rec(sx, sy + nl, nl)
        rec(sx + nl, sy + nl, nl)
        rec(sx + 2 * nl, sy + nl, nl)
        rec(sx, sy + 2 * nl, nl)
        rec(sx + nl, sy + 2 * nl, nl)
        rec(sx + 2 * nl, sy + 2 * nl, nl)
    }

    rec(0, 0, n)
    print(results.joinToString("\n"))
}