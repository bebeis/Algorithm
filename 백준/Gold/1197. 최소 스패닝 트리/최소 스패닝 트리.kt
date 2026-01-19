import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (v, e) = with(StringTokenizer(readLine())) {
        listOf(nextToken().toInt(), nextToken().toInt())
    }

    val edges = mutableListOf<Triple<Int, Int, Int>>()
    repeat(e) {
        with(StringTokenizer(readLine())) {
            edges.add(Triple(nextToken().toInt(), nextToken().toInt(), nextToken().toInt()))
        }
    }
    edges.sortBy { it.third }

    val p = IntArray(v + 1) { -1 }
    fun find(x: Int): Int {
        if (p[x] < 0) return x
        p[x] = find(p[x])
        return p[x]
    }

    fun union(m: Int, n: Int): Boolean {
        var x = find(m)
        var y = find(n)
        if (x == y) return false

        if (x > y) x = y.also { y = x }
        if (p[x] == p[y]) p[x]--

        p[y] = x
        return true
    }

    var cnt = 0
    var result = 0
    for (edge in edges) {
        if (cnt == v - 1) break

        if (union(edge.first, edge.second)) {
            result += edge.third
            cnt++
        }
    }

    print(result)
}
