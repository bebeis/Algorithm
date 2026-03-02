import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, v) = readLine().split(" ").map { it.toInt() }

    val adj = Array(n + 1) { BooleanArray(n + 1) }
    repeat(m) {
        val st = StringTokenizer(readLine())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        adj[u][v] = true
        adj[v][u] = true
    }

    val sb = StringBuilder()
    var visited = BooleanArray(n + 1)
    visited[v] = true
    fun dfs(cur: Int) {
        sb.append(cur).append(' ')

        for (nxt in 1..n) {
            if (adj[cur][nxt] && !visited[nxt]) {
                visited[nxt] = true
                dfs(nxt)
            }
        }
    }
    dfs(v)
    sb.append('\n')

    visited = BooleanArray(n + 1)
    fun bfs() {
        val queue = ArrayDeque<Int>()
        visited[v] = true
        queue.offer(v)

        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            sb.append(cur).append(' ')

            for (nxt in 1..n) {
                if (adj[cur][nxt] && !visited[nxt]) {
                    visited[nxt] = true
                    queue.offer(nxt)
                }
            }
        }
    }
    bfs()

    print(sb)
}