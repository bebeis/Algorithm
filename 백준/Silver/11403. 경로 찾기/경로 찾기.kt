import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val adj = Array(n) { StringTokenizer(readLine()).let { st -> IntArray(n) { st.nextToken().toInt() } } }

    fun dfs(start: Int) {
        val visited = BooleanArray(n)
        // visited[start] = true

        val stack = ArrayDeque<Int>()
        stack.push(start)

        while (stack.isNotEmpty()) {
            val cur = stack.pop()

            for (nxt in 0 until n) {
                if (adj[cur][nxt] == 1 && !visited[nxt]) {
                    adj[start][nxt] = 1
                    visited[nxt] = true
                    stack.push(nxt)
                }
            }
        }
    }

    for (st in 0 until n) dfs(st)
    print(adj.map { it.joinToString(" ") }.joinToString("\n"))
}