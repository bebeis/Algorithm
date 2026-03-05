/**
 * 출발점이 하나 -> 다익스트라 가능
 */

import java.util.*

const val INF = 0x3f3f3f3f

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val adj = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    val d = IntArray(n + 1) { INF }
    val pre = IntArray(n + 1)

    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        val w = st.nextToken().toInt()

        adj[u].add(w to v)
    }

    val (start, end) = readLine().split(" ").map { it.toInt() }
    d[start] = 0
    val pq = PriorityQueue<Pair<Int, Int>>(Comparator() { p1, p2 -> p1.first.compareTo(p2.first) }) // 현재까지 거리, 다음 목적지
    pq.offer(d[start] to start)

    while (pq.isNotEmpty()) {
        val (cd, cur) = pq.poll()

        if (cd != d[cur]) continue
        for ((nl, nxt) in adj[cur]) {
            if (d[nxt] <= cd + nl) continue
            d[nxt] = cd + nl
            pre[nxt] = cur
            pq.offer(d[nxt] to nxt)
        }
    }
    println(d[end])

    val path = mutableListOf<Int>()
    var ed = end
    while (ed != start) {
        path.add(ed)
        ed = pre[ed]
    }
    path.add(ed)

    println(path.size)
    print(path.reversed().joinToString(" "))
}