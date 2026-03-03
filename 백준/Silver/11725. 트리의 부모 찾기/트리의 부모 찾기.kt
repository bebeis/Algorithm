import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val p = IntArray(n + 1)
    val adj = Array(n + 1) { mutableListOf<Int>() }

    repeat(n - 1) {
        val st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        adj[a].add(b)
        adj[b].add(a)
    }

    fun dfs(cur: Int) {
        for (nxt in adj[cur]) {
            if (nxt == p[cur]) continue
            p[nxt] = cur
            dfs(nxt)
        }
    }

    dfs(1)

    print(p.drop(2).joinToString("\n"))
}