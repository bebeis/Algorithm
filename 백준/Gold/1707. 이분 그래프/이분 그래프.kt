import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val (v, e) = readLine().split(" ").map { it.toInt() }
        val adj = Array(v + 1) { mutableListOf<Int>() }

        repeat(e) {
            val st = StringTokenizer(readLine())
            val a = st.nextToken().toInt()
            val b = st.nextToken().toInt()
            adj[a].add(b)
            adj[b].add(a)
        }

        val tags = IntArray(v + 1) // -1: 왼쪽, 0: 미정, 1: 오른쪽
        var resultFlag = true
        for (st in 1..v) {
            if (tags[st] != 0) continue

            tags[st] = -1
            val queue = ArrayDeque<Int>()
            queue.offer(st)
            while (queue.isNotEmpty()) {
                val cur = queue.poll()

                for (nxt in adj.get(cur)) {
                    if (tags[nxt] != 0 && tags[nxt] == tags[cur]) {
                        resultFlag = false
                        break
                    }

                    if (tags[nxt] == 0) {
                        tags[nxt] = -1 * tags[cur]
                        queue.offer(nxt)
                    }
                }

                if (!resultFlag) break
            }

            if (!resultFlag) break
        }

        println((if (resultFlag) "YES" else "NO"))
    }
}