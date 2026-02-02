import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val a = Array(n) { IntArray(m) }
    val c = mutableListOf<Pair<Int, Int>>()

    for (i in 0 until n) {
        val st = StringTokenizer(readLine())
        for (j in 0 until m) {
            a[i][j] = st.nextToken().toInt()
            if (a[i][j] in 1..5) c.add(Pair(i, j)) 
        }
    }

    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    val dir = arrayOf(
        arrayOf(intArrayOf(0), intArrayOf(1), intArrayOf(2), intArrayOf(3)),
        arrayOf(intArrayOf(1, 3), intArrayOf(0, 2)),
        arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 0)),
        arrayOf(intArrayOf(3, 0, 1), intArrayOf(0, 1, 2), intArrayOf(1, 2, 3), intArrayOf(2, 3, 0)),
        arrayOf(intArrayOf(0, 1, 2, 3))
    )

    fun paint(b: Array<IntArray>, x: Int, y: Int, ds: IntArray) {
        for (d in ds) {
            var i = x
            var j = y
            while (true) {
                i += dx[d]; j += dy[d]
                if (i !in 0 until n || j !in 0 until m) break
                if (b[i][j] == 6) break
                if (b[i][j] == 0) b[i][j] = -1
            }
        }
    }

    var ans = 1 shl 30
    fun dfs(idx: Int, b: Array<IntArray>) {
        if (idx == c.size) {
            var z = 0
            for (i in 0 until n) for (j in 0 until m) if (b[i][j] == 0) z++
            if (z < ans) ans = z
            return
        }
        val (x, y) = c[idx]
        val t = b[x][y]
        for (ds in dir[t - 1]) {
            val nb = Array(n) { b[it].clone() }
            paint(nb, x, y, ds)
            dfs(idx + 1, nb)
        }
    }

    dfs(0, a)
    print(ans)
}
