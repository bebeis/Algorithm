import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val (n, k) = readLine().split(" ").map { it.toInt() }
        val times = StringTokenizer(readLine()).let { st -> IntArray(n) { st.nextToken().toInt() } }
        val d = IntArray(n + 1) { -1 }
        val adj = Array(n + 1) { mutableListOf<Int>() }
        repeat(k) {
            val st = StringTokenizer(readLine())
            val u = st.nextToken().toInt()
            val v = st.nextToken().toInt()
            adj[v].add(u)
        }
        val end = readLine().toInt()

        fun dp(cur: Int): Int {
            if (d[cur] != -1) return d[cur]
            
            var max = 0
            for (nxt in adj[cur]) {
                max = maxOf(max, dp(nxt))
            }

            d[cur] = max + times[cur - 1]
            return d[cur]
        }

        println(dp(end))
    }
}