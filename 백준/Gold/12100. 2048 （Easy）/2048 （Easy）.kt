import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var board = Array(n) { StringTokenizer(readLine()).let { st -> IntArray(n) { st.nextToken().toInt() } } }

    fun mergeLine(line: IntArray): IntArray {
        val filtered = line.filter { it != 0 }
        val result = mutableListOf<Int>()
        var i = 0
        while (i < filtered.size) {
            if (i + 1 < filtered.size && filtered[i] == filtered[i + 1]) {
                result.add(filtered[i] * 2)
                i += 2
            } else {
                result.add(filtered[i])
                i++
            }
        }
        return IntArray(line.size) { if (it < result.size) result[it] else 0 }
    }

    fun rotate(b: Array<IntArray>): Array<IntArray> =
        Array(n) { i -> IntArray(n) { j -> b[n - 1 - j][i] } }

    fun move(b: Array<IntArray>, dir: Int): Array<IntArray> {
        var cur = b
        repeat(dir) { cur = rotate(cur) }
        cur = Array(n) { mergeLine(cur[it]) }

        repeat((4 - dir) % 4) { cur = rotate(cur) }
        return cur
    }

    var ans = 0
    fun dfs(b: Array<IntArray>, depth: Int) {
        if (depth == 5) {
            ans = maxOf(ans, b.maxOf { it.max() })
            return
        }
        for (dir in 0..3) {
            dfs(move(b, dir), depth + 1)
        }
    }

    dfs(board, 0)
    print(ans)
}