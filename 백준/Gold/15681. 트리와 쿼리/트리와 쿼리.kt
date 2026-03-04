import java.util.*

/**
 * 쿼리 마다 탐색 -> 시간 초과
 * 한 번에 다 탐색하고 쿼리에 즉답
 */

fun main() = with(System.`in`.bufferedReader()) {
    val (n, r, q) = readLine().split(" ").map { it.toInt() }
    val adj = Array(n + 1) { mutableListOf<Int>() }
    repeat(n - 1) {
        val st = StringTokenizer(readLine())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        adj[u].add(v)
        adj[v].add(u)
    }

    val counts = IntArray(n + 1)
    val visited = BooleanArray(n + 1)
    fun countSubTree(cur: Int): Int {
        visited[cur] = true
        for (nxt in adj[cur]) {
            if (visited[nxt]) continue
            counts[cur] += countSubTree(nxt)
        }
        counts[cur]++
        return counts[cur]
    }
    countSubTree(r)

    val sb = StringBuilder()
    repeat(q) {
        sb.append(counts[readLine().toInt()]).append('\n')
    }

    print(sb)
}