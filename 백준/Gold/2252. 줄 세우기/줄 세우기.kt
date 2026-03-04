import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val adj = Array(n + 1) { mutableListOf<Int>() }
    val indeg = IntArray(n + 1)

    repeat(m) {
        val st = StringTokenizer(readLine())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        adj[u] += v
        indeg[v]++
    }

    val queue = ArrayDeque<Int>()
    for (i in 1..n) if (indeg[i] == 0) queue.offer(i)

    val sb = StringBuilder()
    while (queue.isNotEmpty()) {
        var cur = queue.poll()
        sb.append(cur).append(' ')

        for (nxt in adj[cur]) {
            if (--indeg[nxt] == 0) queue.offer(nxt)
        }
    }

    print(sb)
}